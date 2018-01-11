package ua.training.vitascherry.controller.filter;

import ua.training.vitascherry.controller.util.TokenPosition;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;

public class AuthorizationFilter implements Filter {

    private final Map<String, User.Role[]> specialPermissions = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        specialPermissions.put("students", new User.Role[]{User.Role.ADMIN});
        specialPermissions.put("student", new User.Role[]{User.Role.ADMIN, User.Role.STUDENT});
        specialPermissions.put("progresses", new User.Role[]{User.Role.ADMIN});
        specialPermissions.put("progress", new User.Role[]{User.Role.ADMIN, User.Role.STUDENT});
        specialPermissions.put("topics", new User.Role[]{User.Role.ADMIN, User.Role.STUDENT});
        specialPermissions.put("topic", new User.Role[]{User.Role.ADMIN, User.Role.STUDENT});
        specialPermissions.put("quizzes", new User.Role[]{User.Role.ADMIN, User.Role.STUDENT});
        specialPermissions.put("quiz", new User.Role[]{User.Role.ADMIN, User.Role.STUDENT});
        specialPermissions.put("result", new User.Role[]{User.Role.ADMIN, User.Role.STUDENT});
        specialPermissions.put("signout", new User.Role[]{User.Role.ADMIN, User.Role.STUDENT});
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        String token = extractToken(httpReq.getRequestURI(), TokenPosition.COMMAND);
        User.Role[] permissions = specialPermissions.get(token);
        if (permissions != null) {
            User.Role role = null;
            User user = (User) httpReq.getSession().getAttribute("user");
            if (user != null) {
                role = user.getRole();
            }
            if (role == null) {
                httpResp.sendRedirect("/signin");
                return;
            } else if (!Arrays.asList(permissions).contains(role)) {
                httpReq.getRequestDispatcher(Response.ERROR_403.getPage()).forward(httpReq, httpResp);
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {}
}
