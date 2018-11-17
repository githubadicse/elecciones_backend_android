package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idusuario;

	private Integer activo;

	private String clave;

	private Integer idfilial;

	private String login;

	private String nombres;

	//bi-directional many-to-one association to Personero
	@OneToMany(mappedBy="usuario")
	private List<Personero> personeros;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="idperfil")
	private Perfil perfil;

	public Usuario() {
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getActivo() {
		return this.activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Integer getIdfilial() {
		return this.idfilial;
	}

	public void setIdfilial(Integer idfilial) {
		this.idfilial = idfilial;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Personero> getPersoneros() {
		return this.personeros;
	}

	public void setPersoneros(List<Personero> personeros) {
		this.personeros = personeros;
	}

	public Personero addPersonero(Personero personero) {
		getPersoneros().add(personero);
		personero.setUsuario(this);

		return personero;
	}

	public Personero removePersonero(Personero personero) {
		getPersoneros().remove(personero);
		personero.setUsuario(null);

		return personero;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}