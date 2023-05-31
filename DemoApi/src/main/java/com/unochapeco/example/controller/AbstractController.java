package com.unochapeco.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.unochapeco.example.dto.AbstractDTO;
import com.unochapeco.example.model.AbstractModel;

public class AbstractController<E extends AbstractModel, DTO extends AbstractDTO> {

	@Autowired
	private ModelMapper modelMapper;
	
	public E convertToEntity(Optional<DTO> dto, Class<E> clazz) {
		return convertToEntity(dto.orElse(null), clazz);
	}

	public DTO convertToDTO(Optional<E> entity, Class<DTO> clazz) {
		return convertToDTO(entity.orElse(null), clazz);
	}
	
	public E convertToEntity(DTO dto, Class<E> clazz) {
		return modelMapper.map(dto, clazz);
	}

	public DTO convertToDTO(E entity, Class<DTO> clazz) {
		return modelMapper.map(entity, clazz);
	}
	
	public List<E> convertToEntity(List<DTO> dtoList, Class<E> clazz) {
		List<E> arrayList = new ArrayList<>();
		dtoList.forEach(dto -> arrayList.add(convertToEntity(dto, clazz)));
		return arrayList;
	}
	
	public List<DTO> convertToDTO(List<E> entityList, Class<DTO> clazz) {
		List<DTO> arrayList = new ArrayList<>();
		entityList.forEach(entity -> arrayList.add(convertToDTO(entity, clazz)));
		return arrayList;
	}
	
}
