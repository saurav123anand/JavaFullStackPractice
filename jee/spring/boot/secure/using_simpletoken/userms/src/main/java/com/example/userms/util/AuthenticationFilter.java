package com.example.userms.util;


import com.example.userms.dto.UserDetails;
import com.example.userms.exception.InvalidTokenException;
import com.example.userms.exception.UserNotFoundException;
import com.example.userms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationFilter implements Filter {
    @Autowired
    private IUserService service;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest) request;
        HttpServletResponse httpResponse=(HttpServletResponse) response;
        String token=httpRequest.getHeader("token");
        try {
            UserDetails user=service.authenticateByToken(token);
            httpRequest.setAttribute("username",user.getUsername());
            filterChain.doFilter(httpRequest,httpResponse);
        } catch (InvalidTokenException|UserNotFoundException e) {
            PrintWriter writer=httpResponse.getWriter();
            writer.write(e.getMessage());
            int statusCode= HttpStatus.UNAUTHORIZED.value();
            httpResponse.setStatus(statusCode);
        }
    }
}
