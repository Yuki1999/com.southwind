package com.southwind.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import java.io.IOException;

@Configuration
public class CorsConfig implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Headers","X-Requested-With,Content-type");
        response.setHeader("Access-Control-Allow-Methods","OPTIONS,POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Origin","http://localhost:8030");

        if (request.getMethod().equals(HttpMethod.OPTIONS)){
            response.getWriter().println("success");
        } else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
