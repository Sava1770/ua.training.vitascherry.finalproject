package ua.training.vitascherry.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class SignInFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Authentication filter was initialized!");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("Processing Authentication doFilter()...");
        System.out.println("--------------- User data ---------------");
        System.out.println("email: " + req.getParameter("email"));
        System.out.println("password: " + req.getParameter("password"));
        // TODO
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Authentication filter was destroyed!");
    }
}
