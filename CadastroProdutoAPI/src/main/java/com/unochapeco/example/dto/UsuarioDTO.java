package com.unochapeco.example.dto;

import java.time.LocalDateTime;

/**
 * 
 * @author Luan Knebel
 * @date 30/05/2023
 */
public class UsuarioDTO extends AbstractDTO{

	private Long idUsuario;
	private String login;
	private LocalDateTime data;
	
	@Override
	public Long getId() {
		return idUsuario;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
}
