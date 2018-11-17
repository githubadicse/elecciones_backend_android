package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agrupacion database table.
 * 
 */
@Entity
@NamedQuery(name="Agrupacion.findAll", query="SELECT a FROM Agrupacion a")
public class Agrupacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idagrupacion;

	private String dscagrupacion;

	@Column(name="foto_base64")
	private String fotoBase64;

	private String logo;

	//bi-directional many-to-one association to Candidato
	@OneToMany(mappedBy="agrupacion")
	private List<Candidato> candidatos;

	public Agrupacion() {
	}

	public Integer getIdagrupacion() {
		return this.idagrupacion;
	}

	public void setIdagrupacion(Integer idagrupacion) {
		this.idagrupacion = idagrupacion;
	}

	public String getDscagrupacion() {
		return this.dscagrupacion;
	}

	public void setDscagrupacion(String dscagrupacion) {
		this.dscagrupacion = dscagrupacion;
	}

	public String getFotoBase64() {
		return this.fotoBase64;
	}

	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Candidato> getCandidatos() {
		return this.candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public Candidato addCandidato(Candidato candidato) {
		getCandidatos().add(candidato);
		candidato.setAgrupacion(this);

		return candidato;
	}

	public Candidato removeCandidato(Candidato candidato) {
		getCandidatos().remove(candidato);
		candidato.setAgrupacion(null);

		return candidato;
	}

}