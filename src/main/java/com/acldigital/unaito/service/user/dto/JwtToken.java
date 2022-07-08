package com.acldigital.unaito.service.user.dto;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.acldigital.unaito.service.user.constants.JwtConstantsEnum;
import com.acldigital.unaito.service.user.exception.InvalidJwtTokenException;
import com.acldigital.unaito.service.user.exception.InvalidUserException;
import com.acldigital.unaito.service.user.exception.TokenMissingException;
import com.acldigital.unaito.service.user.exception.UserIdMissingException;
import com.acldigital.unaito.service.user.exception.UsersNotMatchingException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JwtToken {

	private String subject;
	private String sessionId;
	private List<?> roles;
	private List<?> permission;
	private String token;
	private String issuer;
	private String audience;
	private Date expiry;
	private Date issuedAt;
	private Date notBefore;

	public JwtToken(String token, String secretKey) throws InvalidJwtTokenException {
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		} catch (JwtException | IllegalArgumentException e) {
			throw new InvalidJwtTokenException("Invalid JWT token", HttpStatus.FORBIDDEN.value());
		}
		this.subject = claims.getSubject();
		this.token = token;
		this.roles = (List<?>) claims.get(JwtConstantsEnum.KEY_AUTH.getValue());
		this.sessionId = (String) claims.get(JwtConstantsEnum.KEY_SESSION_ID.getValue());
		this.expiry = claims.getExpiration();
	}

	public String getSubject() {
		return subject;
	}

	public String getSessionId() {
		return sessionId;
	}

	public List<?> getRoles() {
		return roles;
	}

	public List<?> getPermission() {
		return permission;
	}

	public String getToken() {
		return token;
	}

	public String getIssuer() {
		return issuer;
	}

	public String getAudience() {
		return audience;
	}

	public Date getExpiry() {
		return expiry;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public Date getNotBefore() {
		return notBefore;
	}

	public void validateUser(String userToBeValidated) throws InvalidUserException {
		if (userToBeValidated == null) {
			throw new UserIdMissingException("User id is missing in the token", HttpStatus.UNAUTHORIZED.value());
		}
		if (subject == null) {
			throw new TokenMissingException("JWT token is missing", HttpStatus.NO_CONTENT.value());
		}
		if (!subject.equals(userToBeValidated)) {
			throw new UsersNotMatchingException("JWT token user id and requested user id not matching",
					HttpStatus.UNAUTHORIZED.value());
		}
	}
}
