package ua.training.vitascherry.controller.filter;

import ua.training.vitascherry.controller.util.TokenPosition;
import ua.training.vitascherry.model.entity.Role;
import ua.training.vitascherry.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;
import static ua.training.vitascherry.controller.util.View.ERROR_403_PAGE;

public class AuthorizationFilter implements Filter {

    private final Map<String, Role[]> specialPermissions = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        specialPermissions.put("students", new Role[]{Role.ADMIN});
        specialPermissions.put("student", new Role[]{Role.ADMIN, Role.STUDENT});
        specialPermissions.put("progress", new Role[]{Role.ADMIN});
        specialPermissions.put("topics", new Role[]{Role.ADMIN, Role.STUDENT});
        specialPermissions.put("topic", new Role[]{Role.ADMIN, Role.STUDENT});
        specialPermissions.put("quizzes", new Role[]{Role.ADMIN, Role.STUDENT});
        specialPermissions.put("quiz", new Role[]{Role.ADMIN, Role.STUDENT});
        specialPermissions.put("result", new Role[]{Role.ADMIN, Role.STUDENT});
        specialPermissions.put("signout", new Role[]{Role.ADMIN, Role.STUDENT});
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("\nProcessing Authorization doFilter()...");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        System.out.println("Extracting token...");
        String token = extractToken(request.getRequestURI(), TokenPosition.COMMAND);
        System.out.println("Token: " + token);
        Role[] permissions = specialPermissions.get(token);
        System.out.println("Permissions: " + Arrays.toString(permissions));
        if (permissions != null) {
            Role role = null;
            User user = (User) request.getSession().getAttribute("user");
            System.out.println("User: " + user);
            if (user != null) {
                role = user.getRole();
            }
            if (role == null) {
                response.sendRedirect("/signin");
                return;
            } else if (!Arrays.asList(permissions).contains(role)) {
                request.getRequestDispatcher(ERROR_403_PAGE).forward(request, response);
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {}
}
