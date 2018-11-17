package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idmenu;

	private String controller;

	private String dscmenu;

	private String icon;

	private Integer leaf;

	private String modulo;

	private Integer orden;

	private String viewprincipal;

	//bi-directional many-to-one association to Perfilesdetalle
	@OneToMany(mappedBy="menu")
	private List<Perfilesdetalle> perfilesdetalles;

	public Menu() {
	}

	public String getIdmenu() {
		return this.idmenu;
	}

	public void setIdmenu(String idmenu) {
		this.idmenu = idmenu;
	}

	public String getController() {
		return this.controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getDscmenu() {
		return this.dscmenu;
	}

	public void setDscmenu(String dscmenu) {
		this.dscmenu = dscmenu;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getLeaf() {
		return this.leaf;
	}

	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getViewprincipal() {
		return this.viewprincipal;
	}

	public void setViewprincipal(String viewprincipal) {
		this.viewprincipal = viewprincipal;
	}

	public List<Perfilesdetalle> getPerfilesdetalles() {
		return this.perfilesdetalles;
	}

	public void setPerfilesdetalles(List<Perfilesdetalle> perfilesdetalles) {
		this.perfilesdetalles = perfilesdetalles;
	}

	public Perfilesdetalle addPerfilesdetalle(Perfilesdetalle perfilesdetalle) {
		getPerfilesdetalles().add(perfilesdetalle);
		perfilesdetalle.setMenu(this);

		return perfilesdetalle;
	}

	public Perfilesdetalle removePerfilesdetalle(Perfilesdetalle perfilesdetalle) {
		getPerfilesdetalles().remove(perfilesdetalle);
		perfilesdetalle.setMenu(null);

		return perfilesdetalle;
	}

}