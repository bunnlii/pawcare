package com.pawcare.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return request.getRequestURI().contains("/provider")
                ? request.getParameter("username")
                : request.getParameter("username");
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        return request.getRequestURI().contains("/provider")
                ? request.getParameter("password")
                : request.getParameter("password");
    }
}
