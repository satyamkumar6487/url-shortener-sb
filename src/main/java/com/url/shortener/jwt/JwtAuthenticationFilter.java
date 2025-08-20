package com.url.shortener.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter   extends OncePerRequestFilter {
    @Autowired
private JwtUtils jwtTokenProvider;

    @Autowired
    private UserDetailsService  userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try{


String jwt = jwtTokenProvider.getJwtFromHeader(request);

if(jwt != null && jwtTokenProvider.validateToken(jwt)){
    String username = jwtTokenProvider.getUserNameFromJwtToken(jwt);

    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

    if (userDetails != null){
        UsernamePasswordAuthenticationToken authetication  = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authetication);

    }
}


        } catch (Exception e) {
e.printStackTrace();
        }

        filterChain.doFilter(request, response);


    }
}
