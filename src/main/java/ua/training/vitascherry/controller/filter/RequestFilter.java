package ua.training.vitascherry.controller.filter;

import ua.training.vitascherry.controller.util.RequestParameter;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        if (!RequestParameter.URI.validate(httpReq.getRequestURI())) {
            httpReq.getRequestDispatcher(Response.NOT_FOUND.getPage()).forward(httpReq, httpResp);
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {}
}
