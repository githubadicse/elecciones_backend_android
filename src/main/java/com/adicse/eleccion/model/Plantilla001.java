package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plantilla001 database table.
 * 
 */
@Entity
@NamedQuery(name="Plantilla001.findAll", query="SELECT p FROM Plantilla001 p")
public class Plantilla001 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idplantilla001;

	//bi-directional many-to-one association to Nivel
	@ManyToOne
	@JoinColumn(name="idnivel")
	private Nivel nivel;

	//bi-directional many-to-one association to Plantilla002
	@OneToMany(mappedBy="plantilla001")
	private List<Plantilla002> plantilla002s;

	//bi-directional many-to-one association to Voto001
	@OneToMany(mappedBy="plantilla001")
	private List<Voto001> voto001s;

	public Plantilla001() {
	}

	public Integer getIdplantilla001() {
		return this.idplantilla001;
	}

	public void setIdplantilla001(Integer idplantilla001) {
		this.idplantilla001 = idplantilla001;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public List<Plantilla002> getPlantilla002s() {
		return this.plantilla002s;
	}

	public void setPlantilla002s(List<Plantilla002> plantilla002s) {
		this.plantilla002s = plantilla002s;
	}

	public Plantilla002 addPlantilla002(Plantilla002 plantilla002) {
		getPlantilla002s().add(plantilla002);
		plantilla002.setPlantilla001(this);

		return plantilla002;
	}

	public Plantilla002 removePlantilla002(Plantilla002 plantilla002) {
		getPlantilla002s().remove(plantilla002);
		plantilla002.setPlantilla001(null);

		return plantilla002;
	}

	public List<Voto001> getVoto001s() {
		return this.voto001s;
	}

	public void setVoto001s(List<Voto001> voto001s) {
		this.voto001s = voto001s;
	}

	public Voto001 addVoto001(Voto001 voto001) {
		getVoto001s().add(voto001);
		voto001.setPlantilla001(this);

		return voto001;
	}

	public Voto001 removeVoto001(Voto001 voto001) {
		getVoto001s().remove(voto001);
		voto001.setPlantilla001(null);

		return voto001;
	}

}