package ua.training.vitascherry.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInRegisterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        if (httpReq.getSession().getAttribute("user") != null) {
            httpResp.sendRedirect("/");
            return;
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {}
}
