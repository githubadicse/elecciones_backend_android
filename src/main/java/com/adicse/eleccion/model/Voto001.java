package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the voto001 database table.
 * 
 */
@Entity
@NamedQuery(name="Voto001.findAll", query="SELECT v FROM Voto001 v")
public class Voto001 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idvoto001;

	private Timestamp alta;

	@Column(name="flag_registrado")
	private Boolean flagRegistrado;

	//bi-directional many-to-one association to MesaDeVotacion
	@ManyToOne
	@JoinColumn(name="id_mesa_de_votacion")
	private MesaDeVotacion mesaDeVotacion;

	//bi-directional many-to-one association to Plantilla001
	@ManyToOne
	@JoinColumn(name="idplantilla001")
	private Plantilla001 plantilla001;

	//bi-directional many-to-one association to Voto002
	@OneToMany(mappedBy="voto001", cascade={CascadeType.ALL})
	private List<Voto002> voto002s;

	public Voto001() {
	}

	public Integer getIdvoto001() {
		return this.idvoto001;
	}

	public void setIdvoto001(Integer idvoto001) {
		this.idvoto001 = idvoto001;
	}

	public Timestamp getAlta() {
		return this.alta;
	}

	public void setAlta(Timestamp alta) {
		this.alta = alta;
	}

	public Boolean getFlagRegistrado() {
		return this.flagRegistrado;
	}

	public void setFlagRegistrado(Boolean flagRegistrado) {
		this.flagRegistrado = flagRegistrado;
	}

	public MesaDeVotacion getMesaDeVotacion() {
		return this.mesaDeVotacion;
	}

	public void setMesaDeVotacion(MesaDeVotacion mesaDeVotacion) {
		this.mesaDeVotacion = mesaDeVotacion;
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
		voto002.setVoto001(this);

		return voto002;
	}

	public Voto002 removeVoto002(Voto002 voto002) {
		getVoto002s().remove(voto002);
		voto002.setVoto001(null);

		return voto002;
	}

}
