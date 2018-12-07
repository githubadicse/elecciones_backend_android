package com.adicse.eleccion.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the voto002 database table.
 * 
 */
@Entity
@NamedQuery(name="Voto002.findAll", query="SELECT v FROM Voto002 v")
public class Voto002 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idvoto002;

	private Integer voto;

	//bi-directional many-to-one association to Plantilla002
	@ManyToOne
	@JoinColumn(name="idplantilla002")
	private Plantilla002 plantilla002;

	//bi-directional many-to-one association to Voto001
	@ManyToOne
	@JoinColumn(name="idvoto001")
	private Voto001 voto001;

	public Voto002() {
	}

	public String getIdvoto002() {
		return this.idvoto002;
	}

	public void setIdvoto002(String idvoto002) {
		this.idvoto002 = idvoto002;
	}

	public Integer getVoto() {
		return this.voto;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}

	public Plantilla002 getPlantilla002() {
		return this.plantilla002;
	}

	public void setPlantilla002(Plantilla002 plantilla002) {
		this.plantilla002 = plantilla002;
	}

	public Voto001 getVoto001() {
		return this.voto001;
	}

	public void setVoto001(Voto001 voto001) {
		this.voto001 = voto001;
	}

}