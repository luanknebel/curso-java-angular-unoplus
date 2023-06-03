package com.unochapeco.example.service;

import java.util.List;
import java.util.Optional;

import com.unochapeco.example.model.AbstractModel;

public interface CRUDService<T extends AbstractModel> {

	public T save(T model);
	
	public List<T> findAll();
	
	public Optional<T> findById(Long id);
	
	public T update(T model);
	
	public void delete(Long id);
	
}
