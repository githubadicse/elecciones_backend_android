package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mesa_de_votacion database table.
 * 
 */
@Entity
@Table(name="mesa_de_votacion")
@NamedQuery(name="MesaDeVotacion.findAll", query="SELECT m FROM MesaDeVotacion m")
public class MesaDeVotacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mesa_de_votacion")
	private Integer idMesaDeVotacion;

	@Column(name="flag_registrado")
	private Boolean flagRegistrado;

	@Column(name="numero_de_mesa")
	private String numeroDeMesa;

	@Column(name="numero_de_votantes")
	private Integer numeroDeVotantes;

	//bi-directional many-to-one association to CentroDeVotacion
	@ManyToOne
	@JoinColumn(name="id_centro_de_votacion")
	private CentroDeVotacion centroDeVotacion;

	//bi-directional many-to-one association to Personero
	@ManyToOne
	@JoinColumn(name="idpersonero")
	private Personero personero;

	//bi-directional many-to-one association to Voto001
	@OneToMany(mappedBy="mesaDeVotacion")
	private List<Voto001> voto001s;

	public MesaDeVotacion() {
	}

	public Integer getIdMesaDeVotacion() {
		return this.idMesaDeVotacion;
	}

	public void setIdMesaDeVotacion(Integer idMesaDeVotacion) {
		this.idMesaDeVotacion = idMesaDeVotacion;
	}

	public Boolean getFlagRegistrado() {
		return this.flagRegistrado;
	}

	public void setFlagRegistrado(Boolean flagRegistrado) {
		this.flagRegistrado = flagRegistrado;
	}

	public String getNumeroDeMesa() {
		return this.numeroDeMesa;
	}

	public void setNumeroDeMesa(String numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}

	public Integer getNumeroDeVotantes() {
		return this.numeroDeVotantes;
	}

	public void setNumeroDeVotantes(Integer numeroDeVotantes) {
		this.numeroDeVotantes = numeroDeVotantes;
	}

	public CentroDeVotacion getCentroDeVotacion() {
		return this.centroDeVotacion;
	}

	public void setCentroDeVotacion(CentroDeVotacion centroDeVotacion) {
		this.centroDeVotacion = centroDeVotacion;
	}

	public Personero getPersonero() {
		return this.personero;
	}

	public void setPersonero(Personero personero) {
		this.personero = personero;
	}

	public List<Voto001> getVoto001s() {
		return this.voto001s;
	}

	public void setVoto001s(List<Voto001> voto001s) {
		this.voto001s = voto001s;
	}

	public Voto001 addVoto001(Voto001 voto001) {
		getVoto001s().add(voto001);
		voto001.setMesaDeVotacion(this);

		return voto001;
	}

	public Voto001 removeVoto001(Voto001 voto001) {
		getVoto001s().remove(voto001);
		voto001.setMesaDeVotacion(null);

		return voto001;
	}

}