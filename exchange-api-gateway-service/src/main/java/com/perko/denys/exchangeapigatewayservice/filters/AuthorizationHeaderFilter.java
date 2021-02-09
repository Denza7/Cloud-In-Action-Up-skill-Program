package com.perko.denys.exchangeapigatewayservice.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.google.common.net.HttpHeaders;

import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	
	private static final String BEARER = "Bearer ";
	
	@Autowired
	private Environment environment;

	public AuthorizationHeaderFilter() {
		super(Config.class);
	}
	
	public static class Config {
		
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			
			ServerHttpRequest request = exchange.getRequest();
			if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
				return onError(exchange, HttpStatus.UNAUTHORIZED);
			}
			
			String authorizationHeader = request.getHeaders().get(AUTHORIZATION_HEADER).get(0);
			String jwt = authorizationHeader.replace(BEARER, "");
			
			if (!isValidToken(jwt)) {
				return onError(exchange, HttpStatus.UNAUTHORIZED);
			}
			
			return chain.filter(exchange);
		};
	}

	private Mono<Void> onError(ServerWebExchange exchange, HttpStatus unauthorized) {
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(unauthorized);
		return response.setComplete();
	}
	
	private boolean isValidToken(String jwt) {
		String subject = null;
		try {
			subject = Jwts.parser().setSigningKey(environment.getProperty("token.secret"))
					.parseClaimsJws(jwt)
					.getBody()
					.getSubject();
		} catch (Exception e) {
			return false;
		}
		return subject != null ? true : false;
	}
	
}
