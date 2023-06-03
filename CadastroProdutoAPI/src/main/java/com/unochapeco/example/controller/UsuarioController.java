package com.unochapeco.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unochapeco.example.dto.LoginDTO;
import com.unochapeco.example.dto.TokenDTO;
import com.unochapeco.example.dto.UsuarioDTO;
import com.unochapeco.example.exception.BusinessException;
import com.unochapeco.example.model.Usuario;
import com.unochapeco.example.service.CRUDService;
import com.unochapeco.example.service.TokenService;
import com.unochapeco.example.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends AbstractController<Usuario, UsuarioDTO>{

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public TokenDTO login(@Valid @RequestBody LoginDTO login) {
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authenticationToken);
			Usuario usuario = (Usuario)authenticate.getPrincipal();
			String token = tokenService.gerarToken(usuario);
			return new TokenDTO(token);
		} catch (Exception e) {
			throw new BusinessException("Login ou senha incorreto!", e);
		}
	}

	@Override
	public Class<Usuario> getModelClass() {
		return Usuario.class;
	}

	@Override
	public Class<UsuarioDTO> getDTOClass() {
		return UsuarioDTO.class;
	}

	@Override
	public CRUDService<Usuario> getService() {
		return usuarioService;
	}
	

}
