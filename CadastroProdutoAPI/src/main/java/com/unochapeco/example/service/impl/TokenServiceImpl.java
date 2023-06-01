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

	@Override
	public String gerarToken(Usuario usuario) {

		return JWT.create()
			.withIssuer("Application")
			.withSubject(usuario.getUsername())
			.withClaim("id", usuario.getId())
			.withExpiresAt(LocalDateTime.now().plusMinutes(15).atZone(ZoneId.systemDefault()).toInstant())
			.sign(Algorithm.HMAC256("Secret-key"));
		
	}

	@Override
	public String getSubject(String token) {

		return JWT.require(Algorithm.HMAC256("Secret-key"))
				.withIssuer("Application")
				.build().verify(token).getSubject();
		
	}

}
