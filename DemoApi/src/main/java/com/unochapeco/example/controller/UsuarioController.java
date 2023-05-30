package com.unochapeco.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unochapeco.example.model.Usuario;
import com.unochapeco.example.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(product));
	}

	@PutMapping
	public ResponseEntity<Usuario> update(@RequestBody Usuario product) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
