
package com.acldigital.unaito.service.utils;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.acldigital.unaito.service.security.constants.SecurityConstantsEnum;
import com.acldigital.unaito.service.user.constants.ConfigProperties;
import com.acldigital.unaito.service.user.constants.JwtConstantsEnum;
import com.acldigital.unaito.service.user.dto.JwtLoggedInDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private ConfigProperties configProperties;

	private String encodedSecretKey;

	@PostConstruct
	protected void init() {
		encodedSecretKey = Base64.getEncoder().encodeToString(configProperties.getUserServiceSecretKey().getBytes());
	}

	public JwtLoggedInDetails generateToken(String username) {
		String sessionId = httpSession.getId();
		String jwtType = SecurityConstantsEnum.NEW.getValue();
		Date issuedAt = new Date(System.currentTimeMillis());
		Date expiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);

		Map<String, Object> claims = new HashMap<>();
		claims.put(SecurityConstantsEnum.JSESSIONID.getValue(), sessionId);

		String jwt = createToken(claims, username, issuedAt, expiration);

		return new JwtLoggedInDetails(sessionId, jwtType, jwt, issuedAt.toInstant(), expiration.toInstant());
	}

	public String createToken(Map<String, Object> claims, String userName, Date issuedAt, Date expiration) {
		String subject = userName;

		String issuer = configProperties.getServiceName();
		String audiance = configProperties.getJwtAudience();
		String jwtId = UUID.randomUUID().toString();
		Date notBefore = new Date(System.currentTimeMillis());

		String token = Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(issuedAt)
				.setExpiration(expiration).setIssuer(issuer).setAudience(audiance).setId(jwtId).setNotBefore(notBefore)
				.signWith(SignatureAlgorithm.HS512, configProperties.getUserServiceSecretKey()).compact();
		System.out.println("generated token is :: " + JwtConstantsEnum.BEARER.getValue() + " " + token);
		return JwtConstantsEnum.BEARER.getValue() + " " + token;
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(configProperties.getUserServiceSecretKey()).parseClaimsJws(token).getBody();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
}
