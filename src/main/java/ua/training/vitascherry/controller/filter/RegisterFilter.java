package ua.training.vitascherry.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class RegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Registration filter was initialized!");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("Processing Registration doFilter()...");
        System.out.println("--------------- User data ---------------");
        System.out.println("firstName: " + req.getParameter("firstName"));
        System.out.println("lastName: " + req.getParameter("lastName"));
        System.out.println("patronymic: " + req.getParameter("patronymic"));
        System.out.println("email: " + req.getParameter("email"));
        System.out.println("password: " + req.getParameter("password"));
        System.out.println("confirm: " + req.getParameter("confirm"));
        // TODO
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Registration filter was destroyed!");
    }
}
