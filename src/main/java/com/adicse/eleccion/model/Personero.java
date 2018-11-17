package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the personero database table.
 * 
 */
@Entity
@NamedQuery(name="Personero.findAll", query="SELECT p FROM Personero p")
public class Personero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idpersonero;

	private String dni;

	private String foto;

	private String nombrepersonero;

	//bi-directional many-to-one association to MesaDeVotacion
	@OneToMany(mappedBy="personero")
	private List<MesaDeVotacion> mesaDeVotacions;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Personero() {
	}

	public String getIdpersonero() {
		return this.idpersonero;
	}

	public void setIdpersonero(String idpersonero) {
		this.idpersonero = idpersonero;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombrepersonero() {
		return this.nombrepersonero;
	}

	public void setNombrepersonero(String nombrepersonero) {
		this.nombrepersonero = nombrepersonero;
	}

	public List<MesaDeVotacion> getMesaDeVotacions() {
		return this.mesaDeVotacions;
	}

	public void setMesaDeVotacions(List<MesaDeVotacion> mesaDeVotacions) {
		this.mesaDeVotacions = mesaDeVotacions;
	}

	public MesaDeVotacion addMesaDeVotacion(MesaDeVotacion mesaDeVotacion) {
		getMesaDeVotacions().add(mesaDeVotacion);
		mesaDeVotacion.setPersonero(this);

		return mesaDeVotacion;
	}

	public MesaDeVotacion removeMesaDeVotacion(MesaDeVotacion mesaDeVotacion) {
		getMesaDeVotacions().remove(mesaDeVotacion);
		mesaDeVotacion.setPersonero(null);

		return mesaDeVotacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}