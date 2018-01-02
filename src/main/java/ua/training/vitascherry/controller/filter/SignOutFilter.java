package ua.training.vitascherry.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class SignOutFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SignOut filter was initialized!");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("Processing SignOut doFilter()...");
        // TODO
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("SignOut filter was destroyed!");
    }
}
