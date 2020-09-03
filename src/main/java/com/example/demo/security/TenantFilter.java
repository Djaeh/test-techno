package com.example.demo.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TenantFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String tenantID = httpRequest.getHeader("X-TenantID");
        if (tenantID == null) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.getWriter().write("X-TenantID not present in the Request Header");
            httpResponse.setStatus(400);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
