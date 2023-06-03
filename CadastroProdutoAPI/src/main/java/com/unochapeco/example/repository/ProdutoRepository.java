package com.unochapeco.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unochapeco.example.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
