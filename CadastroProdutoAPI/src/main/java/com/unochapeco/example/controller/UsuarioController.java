package com.unochapeco.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unochapeco.example.dto.LoginDTO;
import com.unochapeco.example.dto.UsuarioDTO;
import com.unochapeco.example.exception.BusinessException;
import com.unochapeco.example.model.Usuario;
import com.unochapeco.example.service.TokenService;
import com.unochapeco.example.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends AbstractController<Usuario, UsuarioDTO>{

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDTO login) {
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authenticationToken);
			Usuario usuario = (Usuario)authenticate.getPrincipal();
			return tokenService.gerarToken(usuario);
		} catch (Exception e) {
			throw new BusinessException("Ocorreu um erro ao realizar login", e);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		
		List<Usuario> allUsers = usuarioService.findAll();
		List<UsuarioDTO> listaDTO = convertToDTO(allUsers, UsuarioDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(listaDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
		
		Optional<Usuario> usuario = usuarioService.findById(id);
		UsuarioDTO usuarioDTO = convertToDTO(usuario, UsuarioDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
		
		Usuario usuario = convertToEntity(usuarioDTO, Usuario.class);
		usuarioService.save(usuario);
		usuarioDTO = convertToDTO(usuario, UsuarioDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
	}

	@PutMapping
	public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioDTO) {
		
		Usuario usuario = convertToEntity(usuarioDTO, Usuario.class);
		usuarioService.save(usuario);
		return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
