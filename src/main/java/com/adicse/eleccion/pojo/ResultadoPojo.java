package com.adicse.eleccion.pojo;

public class ResultadoPojo {
	
	public Integer orden;
	public Integer idVoto;
	public String agrupacion;
	public String candidato;
	
	public String numeroDeMesa;
	public Integer numeroDeVotantes;
	public String centroDeVotacion;
	
	public String idistrito;
	public String dscdistrito;
	
	public String idprovincia;
	public String dscprovincia;
	
	public String iddepartamento;
	public String dscdepartamento;
	
	public Integer voto;
	
	
	
//	public Integer TotalMesas;
//	public Integer TotalVotos;
//	
//	public Integer TotalMesasRegistrados;
//	public Integer TotalVotosRegistrados;
	
	
	
	
	public ResultadoPojo() {

	}



	public ResultadoPojo(Integer orden, Integer idVoto, String agrupacion, String candidato, String numeroDeMesa,
			Integer numeroDeVotantes, String centroDeVotacion, String idistrito, String dscdistrito, String idprovincia,
			String dscprovincia, String iddepartamento, String dscdepartamento, Integer voto) {
		super();
		this.orden = orden;
		this.idVoto = idVoto;
		this.agrupacion = agrupacion;
		this.candidato = candidato;
		this.numeroDeMesa = numeroDeMesa;
		this.numeroDeVotantes = numeroDeVotantes;
		this.centroDeVotacion = centroDeVotacion;
		this.idistrito = idistrito;
		this.dscdistrito = dscdistrito;
		this.idprovincia = idprovincia;
		this.dscprovincia = dscprovincia;
		this.iddepartamento = iddepartamento;
		this.dscdepartamento = dscdepartamento;
		this.voto = voto;
	}



	public Integer getOrden() {
		return orden;
	}



	public void setOrden(Integer orden) {
		this.orden = orden;
	}



	public Integer getIdVoto() {
		return idVoto;
	}



	public void setIdVoto(Integer idVoto) {
		this.idVoto = idVoto;
	}



	public String getAgrupacion() {
		return agrupacion;
	}



	public void setAgrupacion(String agrupacion) {
		this.agrupacion = agrupacion;
	}



	public String getCandidato() {
		return candidato;
	}



	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}



	public String getNumeroDeMesa() {
		return numeroDeMesa;
	}



	public void setNumeroDeMesa(String numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}



	public Integer getNumeroDeVotantes() {
		return numeroDeVotantes;
	}



	public void setNumeroDeVotantes(Integer numeroDeVotantes) {
		this.numeroDeVotantes = numeroDeVotantes;
	}



	public String getCentroDeVotacion() {
		return centroDeVotacion;
	}



	public void setCentroDeVotacion(String centroDeVotacion) {
		this.centroDeVotacion = centroDeVotacion;
	}



	public String getIdistrito() {
		return idistrito;
	}



	public void setIdistrito(String idistrito) {
		this.idistrito = idistrito;
	}



	public String getDscdistrito() {
		return dscdistrito;
	}



	public void setDscdistrito(String dscdistrito) {
		this.dscdistrito = dscdistrito;
	}



	public String getIdprovincia() {
		return idprovincia;
	}



	public void setIdprovincia(String idprovincia) {
		this.idprovincia = idprovincia;
	}



	public String getDscprovincia() {
		return dscprovincia;
	}



	public void setDscprovincia(String dscprovincia) {
		this.dscprovincia = dscprovincia;
	}



	public String getIddepartamento() {
		return iddepartamento;
	}



	public void setIddepartamento(String iddepartamento) {
		this.iddepartamento = iddepartamento;
	}



	public String getDscdepartamento() {
		return dscdepartamento;
	}



	public void setDscdepartamento(String dscdepartamento) {
		this.dscdepartamento = dscdepartamento;
	}



	public Integer getVoto() {
		return voto;
	}



	public void setVoto(Integer voto) {
		this.voto = voto;
	}




}
