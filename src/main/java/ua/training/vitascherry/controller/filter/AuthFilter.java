package ua.training.vitascherry.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Authentication filter was initialized!");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // TODO
    }

    @Override
    public void destroy() {
        System.out.println("Authentication filter was destroyed!");
    }
}
