package com.unochapeco.example.service;

import com.unochapeco.example.model.Usuario;

public interface TokenService {

	public String gerarToken(Usuario usuario);
	
}
