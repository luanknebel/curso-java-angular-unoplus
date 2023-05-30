package com.unochapeco.example.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * 
 * @author Luan Knebel
 * @date 30/05/2023
 */
@Entity
public class Usuario extends AbstractModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idUsuario;

	private String login;
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
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
