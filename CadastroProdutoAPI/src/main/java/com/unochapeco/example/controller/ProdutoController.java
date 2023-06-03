package com.unochapeco.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unochapeco.example.dto.ProdutoDTO;
import com.unochapeco.example.model.Produto;
import com.unochapeco.example.service.CRUDService;
import com.unochapeco.example.service.ProdutoService;

@RestController
@RequestMapping("produto")
public class ProdutoController extends AbstractController<Produto, ProdutoDTO>{

	@Autowired
	private ProdutoService produtoService;

	@Override
	public Class<Produto> getModelClass() {
		return Produto.class;
	}

	@Override
	public Class<ProdutoDTO> getDTOClass() {
		return ProdutoDTO.class;
	}

	@Override
	public CRUDService<Produto> getService() {
		return produtoService;
	}
	
}
