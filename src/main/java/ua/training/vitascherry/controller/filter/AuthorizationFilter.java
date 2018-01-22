package ua.training.vitascherry.controller.filter;

import ua.training.vitascherry.controller.util.Token;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;

public class AuthorizationFilter implements Filter {

    private final Map<String, List<User.Role>> specialPermissions = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        List<User.Role> users = Arrays.asList(User.Role.ADMIN, User.Role.STUDENT);
        List<User.Role> adminOnly = Collections.singletonList(User.Role.ADMIN);
        specialPermissions.put("students", adminOnly);
        specialPermissions.put("student", users);
        specialPermissions.put("progresses", adminOnly);
        specialPermissions.put("progress", users);
        specialPermissions.put("topics", users);
        specialPermissions.put("topic", users);
        specialPermissions.put("quizzes", users);
        specialPermissions.put("available", users);
        specialPermissions.put("quiz", users);
        specialPermissions.put("result", users);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        String token = extractToken(httpReq.getRequestURI(), Token.COMMAND);
        List<User.Role> permissions = specialPermissions.get(token);
        if (permissions != null) {
            User user = (User) httpReq.getSession().getAttribute("user");
            if (user == null) {
                httpResp.sendRedirect(httpReq.getContextPath() + "/" + "signin");
                return;
            }
            if (!permissions.contains(user.getRole())) {
                httpReq.getRequestDispatcher(Response.FORBIDDEN.getPage()).forward(httpReq, httpResp);
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {}
}
