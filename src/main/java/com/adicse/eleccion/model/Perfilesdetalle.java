package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perfilesdetalle database table.
 * 
 */
@Entity
@NamedQuery(name="Perfilesdetalle.findAll", query="SELECT p FROM Perfilesdetalle p")
public class Perfilesdetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idsysperfilesdetalle;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="idmenu")
	private Menu menu;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="idperfil")
	private Perfil perfil;

	public Perfilesdetalle() {
	}

	public String getIdsysperfilesdetalle() {
		return this.idsysperfilesdetalle;
	}

	public void setIdsysperfilesdetalle(String idsysperfilesdetalle) {
		this.idsysperfilesdetalle = idsysperfilesdetalle;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}