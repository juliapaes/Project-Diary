package com.feevale.agenda;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Verifica autenticação para recuso estatico
        if (httpRequest.getServletPath().startsWith("/login")) {
            chain.doFilter(request, response);
            return;
        }
        if (httpRequest.getServletPath().startsWith("login")) {
            chain.doFilter(request, response);
            return;
        }
        // Verifica autenticação para recuso estatico
        if (httpRequest.getServletPath().startsWith("/") && httpRequest.getServletPath().length() == 1) {
            chain.doFilter(request, response);
            return;
        }
        if (httpRequest.getServletPath().startsWith("/index")) {
            chain.doFilter(request, response);
            return;
        }

        if (httpRequest.getContextPath().startsWith("/css")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("idUsuarioLogado") == null) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        chain.doFilter(request, response);
        // TODO Auto-generated method stub
    }

}
