package com.niit.backendc3_s1_pc_1.filter;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String authHeader = httpServletRequest.getHeader("Authorization");
        System.out.println("Auth Header "+authHeader);
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        if(authHeader==null ||!authHeader.startsWith("Bearer")){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            servletOutputStream.print("Missing or Invalid Token");
            servletOutputStream.close();
        }else{
            String jwToken = authHeader.substring(7);
            System.out.println("Jwt Token "+jwToken);
            String userName = Jwts.parser().setSigningKey("securityKey").parseClaimsJws(jwToken).getBody().getSubject();
            httpServletRequest.setAttribute("firstName",userName);
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }
}
