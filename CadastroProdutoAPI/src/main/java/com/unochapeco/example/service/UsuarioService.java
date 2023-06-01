package com.unochapeco.example.service;

import java.util.List;
import java.util.Optional;

import com.unochapeco.example.model.Usuario;

/**
 * 
 * @author Luan Knebel
 * @date 30/05/2023
 */
public interface UsuarioService {

	public Usuario save(Usuario usuario);
	
	public List<Usuario> findAll();
	
	public Optional<Usuario> findById(Long idUsuario);
	
	public Usuario update(Usuario  usuario);
	
	public void delete(Long idUsuario);
	
}
