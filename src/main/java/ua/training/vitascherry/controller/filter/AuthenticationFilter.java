package ua.training.vitascherry.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("\nProcessing Authentication doFilter()...");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getSession().getAttribute("user") != null) {
            System.out.println("Redirecting to home page...");
            response.sendRedirect("/");
            return;
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {}
}
