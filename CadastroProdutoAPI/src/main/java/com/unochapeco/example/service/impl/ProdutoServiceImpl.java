package com.unochapeco.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.unochapeco.example.model.Produto;
import com.unochapeco.example.repository.ProdutoRepository;
import com.unochapeco.example.service.ProdutoService;

@Service
public class ProdutoServiceImpl extends CRUDServiceImpl<Produto> implements ProdutoService  {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public JpaRepository<Produto, Long> getRepository() {
		return produtoRepository;
	}

}
