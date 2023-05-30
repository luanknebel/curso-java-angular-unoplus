package com.unochapeco.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unochapeco.example.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
