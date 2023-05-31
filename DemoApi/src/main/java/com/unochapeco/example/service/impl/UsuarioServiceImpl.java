package com.unochapeco.example.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unochapeco.example.model.Usuario;
import com.unochapeco.example.repository.UsuarioRepository;
import com.unochapeco.example.service.UsuarioService;

/**
 * 
 * @author Luan Knebel
 * @date 30/05/2023
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder PasswordEncoder;
	
	@Override
	public Usuario save(Usuario usuario) {
		encodePassword(usuario);
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long idUsuario) {
		return usuarioRepository.findById(idUsuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		
		Usuario usuarioBanco = findById(usuario.getId()).orElseThrow(() -> new RuntimeException("Usuario nao encontrado para atualizacao"));
		
		if(isSenhaAlterada(usuario, usuarioBanco)) {
			encodePassword(usuario);
		}
		return usuarioRepository.save(usuario);
	}

	@Override
	public void delete(Long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}
	
	private boolean isSenhaAlterada(Usuario usuario, Usuario usuarioBanco) {
		return Objects.nonNull(usuario.getPassword()) && !Objects.equals(usuario.getPassword(), usuarioBanco.getPassword());
	}

	private void encodePassword(Usuario usuario) {
		usuario.setPassword(PasswordEncoder.encode(usuario.getPassword()));
	}
	
}
