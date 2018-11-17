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

	@Column(name="local_de_votacion")
	private String localDeVotacion;

	@Column(name="numero_de_mesa")
	private String numeroDeMesa;

	@Column(name="numero_de_votantes")
	private Integer numeroDeVotantes;

	//bi-directional many-to-one association to Personero
	@ManyToOne
	@JoinColumn(name="idpersonero")
	private Personero personero;

	//bi-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="id_ubigeo")
	private Ubigeo ubigeo;

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

	public String getLocalDeVotacion() {
		return this.localDeVotacion;
	}

	public void setLocalDeVotacion(String localDeVotacion) {
		this.localDeVotacion = localDeVotacion;
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

	public Personero getPersonero() {
		return this.personero;
	}

	public void setPersonero(Personero personero) {
		this.personero = personero;
	}

	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
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