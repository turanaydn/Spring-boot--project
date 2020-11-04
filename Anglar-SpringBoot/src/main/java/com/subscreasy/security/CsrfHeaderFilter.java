package com.subscreasy.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;


import io.jsonwebtoken.ExpiredJwtException;
@Component
public class CsrfHeaderFilter extends OncePerRequestFilter {
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		CsrfToken csrf = (CsrfToken) request
				.getAttribute(CsrfToken.class.getName());
		if (csrf != null) {
			Cookie cookie = new Cookie("XSRF-TOKEN",
					csrf.getToken());
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		filterChain.doFilter(request, response);
	}
	
	
};
	
	
	

	
	
	
	

