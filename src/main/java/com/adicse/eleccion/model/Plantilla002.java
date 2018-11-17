package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plantilla002 database table.
 * 
 */
@Entity
@NamedQuery(name="Plantilla002.findAll", query="SELECT p FROM Plantilla002 p")
public class Plantilla002 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idplantilla002;

	private Integer orden;

	//bi-directional many-to-one association to Candidato
	@ManyToOne
	@JoinColumn(name="idcandidato")
	private Candidato candidato;

	//bi-directional many-to-one association to Plantilla001
	@ManyToOne
	@JoinColumn(name="idplantilla001")
	private Plantilla001 plantilla001;

	//bi-directional many-to-one association to Voto002
	@OneToMany(mappedBy="plantilla002")
	private List<Voto002> voto002s;

	public Plantilla002() {
	}

	public String getIdplantilla002() {
		return this.idplantilla002;
	}

	public void setIdplantilla002(String idplantilla002) {
		this.idplantilla002 = idplantilla002;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Candidato getCandidato() {
		return this.candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Plantilla001 getPlantilla001() {
		return this.plantilla001;
	}

	public void setPlantilla001(Plantilla001 plantilla001) {
		this.plantilla001 = plantilla001;
	}

	public List<Voto002> getVoto002s() {
		return this.voto002s;
	}

	public void setVoto002s(List<Voto002> voto002s) {
		this.voto002s = voto002s;
	}

	public Voto002 addVoto002(Voto002 voto002) {
		getVoto002s().add(voto002);
		voto002.setPlantilla002(this);

		return voto002;
	}

	public Voto002 removeVoto002(Voto002 voto002) {
		getVoto002s().remove(voto002);
		voto002.setPlantilla002(null);

		return voto002;
	}

}