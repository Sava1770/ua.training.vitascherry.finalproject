package ua.training.vitascherry.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Authorization filter was initialized!");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("Processing Authorization doFilter()...");
        // TODO
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Authorization filter was destroyed!");
    }
}
