package com.farmsimple.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
@Order(1)
@Slf4j
public class PathFilter implements Filter {

    private static final String[] ALLOWED_PATHS_WITHOUT_AUTH = new String[]{
            "/",
            "/client",
            "/client/login",
            "/client/newuser",
            "/client/forgotpass"
    };
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestUrl = request.getRequestURI();
        if(requestUrl != null && "/".equals(requestUrl)) {
            response.sendRedirect("/client/login");
            return;
        }
        chain.doFilter(servletRequest, servletResponse);
    }
}
