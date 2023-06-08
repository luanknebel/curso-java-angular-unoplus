package com.unochapeco.example.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unochapeco.example.exception.BusinessException;
import com.unochapeco.example.model.Usuario;
import com.unochapeco.example.repository.UsuarioRepository;
import com.unochapeco.example.service.UsuarioService;

/**
 * 
 * @author Luan Knebel
 * @date 30/05/2023
 */
@Service
public class UsuarioServiceImpl extends CRUDServiceImpl<Usuario> implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public JpaRepository<Usuario, Long> getRepository() {
		return usuarioRepository;
	}

	@Override
	public Usuario save(Usuario model) {
		encodePassword(model);
		return super.save(model);
	}

	@Override
	public Usuario update(Usuario model) {
		Usuario usuarioBanco = findById(model.getId()).orElseThrow(() -> new BusinessException("Usuario nao encontrado para atualizacao"));

		if (isSenhaAlterada(model, usuarioBanco)) {
			encodePassword(model);
		}
		return super.update(model);
	}

	private boolean isSenhaAlterada(Usuario usuario, Usuario usuarioBanco) {
		return Objects.nonNull(usuario.getPassword()) && !Objects.equals(usuario.getPassword(), usuarioBanco.getPassword());
	}

	private void encodePassword(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	}

}
