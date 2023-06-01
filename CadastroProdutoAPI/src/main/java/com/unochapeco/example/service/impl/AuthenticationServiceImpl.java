package com.unochapeco.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unochapeco.example.repository.UsuarioRepository;
import com.unochapeco.example.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepository.findByLogin(username);
	}

}
