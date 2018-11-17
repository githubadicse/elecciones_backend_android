package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@NamedQuery(name="Nivel.findAll", query="SELECT n FROM Nivel n")
public class Nivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idnivel;

	private String dscnivel;

	//bi-directional many-to-one association to Plantilla001
	@OneToMany(mappedBy="nivel")
	private List<Plantilla001> plantilla001s;

	public Nivel() {
	}

	public Integer getIdnivel() {
		return this.idnivel;
	}

	public void setIdnivel(Integer idnivel) {
		this.idnivel = idnivel;
	}

	public String getDscnivel() {
		return this.dscnivel;
	}

	public void setDscnivel(String dscnivel) {
		this.dscnivel = dscnivel;
	}

	public List<Plantilla001> getPlantilla001s() {
		return this.plantilla001s;
	}

	public void setPlantilla001s(List<Plantilla001> plantilla001s) {
		this.plantilla001s = plantilla001s;
	}

	public Plantilla001 addPlantilla001(Plantilla001 plantilla001) {
		getPlantilla001s().add(plantilla001);
		plantilla001.setNivel(this);

		return plantilla001;
	}

	public Plantilla001 removePlantilla001(Plantilla001 plantilla001) {
		getPlantilla001s().remove(plantilla001);
		plantilla001.setNivel(null);

		return plantilla001;
	}

}