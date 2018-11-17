package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the candidato database table.
 * 
 */
@Entity
@NamedQuery(name="Candidato.findAll", query="SELECT c FROM Candidato c")
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcandidato;

	private String foto;

	@Column(name="foto_base64")
	private String fotoBase64;

	private String nombre;

	//bi-directional many-to-one association to Agrupacion
	@ManyToOne
	@JoinColumn(name="idagrupacion")
	private Agrupacion agrupacion;

	//bi-directional many-to-one association to Plantilla002
	@OneToMany(mappedBy="candidato")
	private List<Plantilla002> plantilla002s;

	public Candidato() {
	}

	public Integer getIdcandidato() {
		return this.idcandidato;
	}

	public void setIdcandidato(Integer idcandidato) {
		this.idcandidato = idcandidato;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFotoBase64() {
		return this.fotoBase64;
	}

	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Agrupacion getAgrupacion() {
		return this.agrupacion;
	}

	public void setAgrupacion(Agrupacion agrupacion) {
		this.agrupacion = agrupacion;
	}

	public List<Plantilla002> getPlantilla002s() {
		return this.plantilla002s;
	}

	public void setPlantilla002s(List<Plantilla002> plantilla002s) {
		this.plantilla002s = plantilla002s;
	}

	public Plantilla002 addPlantilla002(Plantilla002 plantilla002) {
		getPlantilla002s().add(plantilla002);
		plantilla002.setCandidato(this);

		return plantilla002;
	}

	public Plantilla002 removePlantilla002(Plantilla002 plantilla002) {
		getPlantilla002s().remove(plantilla002);
		plantilla002.setCandidato(null);

		return plantilla002;
	}

}