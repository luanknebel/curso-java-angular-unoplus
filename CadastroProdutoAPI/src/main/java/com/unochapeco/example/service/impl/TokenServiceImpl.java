package com.unochapeco.example.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.unochapeco.example.model.Usuario;
import com.unochapeco.example.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService{

	private static final String SECRET_KEY = "a1f202064e2244e6458418db6a00c346";
	
	@Override
	public String gerarToken(Usuario usuario) {

		return JWT.create()
			.withIssuer("Application")
			.withSubject(usuario.getUsername())
			.withClaim("id", usuario.getId())
			.withExpiresAt(LocalDateTime.now().plusMinutes(10).atZone(ZoneId.systemDefault()).toInstant())
			.sign(Algorithm.HMAC256(SECRET_KEY));
		
	}

	@Override
	public String getSubject(String token) {

		return JWT.require(Algorithm.HMAC256(SECRET_KEY))
				.withIssuer("Application")
				.build().verify(token).getSubject();
		
	}

}
