package com.unochapeco.example.dto;

import java.util.Date;

/**
 * 
 * @author Luan Knebel
 * @date 30/05/2023
 */
public class UsuarioDTO extends AbstractDTO{

	private Long idUsuario;

	private String login;
	private String password;
	private Date data;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
}
