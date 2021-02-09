package com.perko.denys.exchangeauthenticationservice.filters;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perko.denys.exchangeauthenticationservice.models.UsernamePasswordAuthenticationFilterModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private static final String AUTHORIZATION_HEADER = "Authorization";
	
	private static final String BEARER = "Bearer ";
	
	private AuthenticationManager authenticationManager;
	
	private String secretKey;
	
	public JwtUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager, String secretKey) {
		this.authenticationManager = authenticationManager;
		this.secretKey = secretKey;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
												HttpServletResponse response) throws AuthenticationException {
		try {
			UsernamePasswordAuthenticationFilterModel authenticationRequest = new ObjectMapper()
					.readValue(request.getInputStream(), UsernamePasswordAuthenticationFilterModel.class);
			Authentication authentication = new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(),
					authenticationRequest.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authentication);
			return authenticate;
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response, FilterChain chain,
											Authentication authResult) throws IOException, ServletException {
		String username = ((User) authResult.getPrincipal()).getUsername();
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(2L)))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
		response.addHeader(AUTHORIZATION_HEADER, BEARER + token);
		//refreshToken(response, token);
	}
	
	private void refreshToken(HttpServletResponse response, String token) {
	   Cookie refreshTokenCookie = new Cookie(AUTHORIZATION_HEADER, token);
	   refreshTokenCookie.setHttpOnly(true);
	   //refreshTokenCookie.setSecure(true); //only allows HTTPS
	   refreshTokenCookie.setPath("/");
	   //refreshTokenCookie.setDomain("com"); //restrict domain
	   response.addCookie(refreshTokenCookie);
	}
}
