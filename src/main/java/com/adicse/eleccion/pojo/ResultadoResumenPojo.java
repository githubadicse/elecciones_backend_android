package com.adicse.eleccion.pojo;

public class ResultadoResumenPojo {
	
	public Integer orden;
	public Integer idVoto;
	public String agrupacion;
	public String candidato;
	
	public long cntNumeroDeMesa;
	public long numeroDeVotantes;
	
	//El ausentismo se calcula en base a las mesas contabilizadas, proyectado menos registrado
	public long numeroDeAusentismo;
	
	public String nombreCentroDeVotacion;
	public String idCentroDeVotacion;
	
	
	public Integer idistrito;
	public String dscdistrito;
	
	public String idprovincia;
	public String dscprovincia;
	
	public String iddepartamento;
	public String dscdepartamento;
	
	public long voto;
	
	
	public long _totalVotantesDepartamento;
	public long _totalVotantesProvincia;
	public long _totalVotantesDistrito;
	public long _totalVotantesCentroDeVotacion;
	
	public long _cntMesasDepartamento;
	public long _cntMesasProvincia;
	public long _cntMesasDistrito;
	public long _cntMesasCentroDeVotacion;
	
	public ResultadoResumenPojo() {
		
	}
	
	
	public ResultadoResumenPojo(
			Integer orden,
			String agrupacion, 
			long cntNumeroMesa,
			long numeroDeVotantes, 
			String dscdepartamento,
			long voto,
			long _totalVotantesDepartamento,
			long _totalVotantesProvincia,
			long _totalVotantesDistrito,
			long _totalVotantesCentroDeVotacion,
			
			long _cntMesasDepartamento,
			long _cntMesasProvincia,
			long _cntMesasDistrito,
			long _cntMesasCentroDeVotacion,
			long numeroDeAusentismo
			) {
		super();

		this.orden = orden;
		this.agrupacion = agrupacion;
		this.cntNumeroDeMesa = cntNumeroMesa;
		this.numeroDeVotantes = numeroDeVotantes;
		this.dscdepartamento = dscdepartamento;
		this.voto = voto;

		this._totalVotantesDepartamento = _totalVotantesDepartamento;
		this._totalVotantesProvincia = _totalVotantesProvincia;
		this._totalVotantesDistrito = _totalVotantesDistrito;
		this._totalVotantesCentroDeVotacion = _totalVotantesCentroDeVotacion;
		
		this._cntMesasDepartamento = _cntMesasDepartamento;
		this._cntMesasProvincia = _cntMesasProvincia;
		this._cntMesasDistrito = _cntMesasDistrito;
		this._cntMesasCentroDeVotacion = _cntMesasCentroDeVotacion;
		this.numeroDeAusentismo = numeroDeAusentismo;
		
	}
	

	//Nivel de provincia
	public ResultadoResumenPojo(
			Integer orden,
			String agrupacion, 
			long cntNumeroMesa,
			long numeroDeVotantes, 
			String dscdepartamento,
			String dscprovincia,
			long voto,
			long _totalVotantesDepartamento,
			long _totalVotantesProvincia,
			long _totalVotantesDistrito,
			long _totalVotantesCentroDeVotacion,
			
			long _cntMesasDepartamento,
			long _cntMesasProvincia,
			long _cntMesasDistrito,
			long _cntMesasCentroDeVotacion,
			long numeroDeAusentismo
			) {
		super();

		this.orden = orden;
		this.agrupacion = agrupacion;
		this.cntNumeroDeMesa = cntNumeroMesa;
		this.numeroDeVotantes = numeroDeVotantes;
		this.dscdepartamento = dscdepartamento;
		this.dscprovincia = dscprovincia;
		this.voto = voto;

		this._totalVotantesDepartamento = _totalVotantesDepartamento;
		this._totalVotantesProvincia = _totalVotantesProvincia;
		this._totalVotantesDistrito = _totalVotantesDistrito;
		this._totalVotantesCentroDeVotacion = _totalVotantesCentroDeVotacion;
		
		this._cntMesasDepartamento = _cntMesasDepartamento;
		this._cntMesasProvincia = _cntMesasProvincia;
		this._cntMesasDistrito = _cntMesasDistrito;
		this._cntMesasCentroDeVotacion = _cntMesasCentroDeVotacion;
		this.numeroDeAusentismo = numeroDeAusentismo;
		
	}	
	
	//Nivel de Distrito
	public ResultadoResumenPojo(
			Integer orden,
			String agrupacion, 
			long cntNumeroMesa,
			long numeroDeVotantes, 
			String dscdepartamento,
			String dscprovincia,
			String dscdistrito,
			long voto,
			long _totalVotantesDepartamento,
			long _totalVotantesProvincia,
			long _totalVotantesDistrito,
			long _totalVotantesCentroDeVotacion,
			
			long _cntMesasDepartamento,
			long _cntMesasProvincia,
			long _cntMesasDistrito,
			long _cntMesasCentroDeVotacion	,
			long numeroDeAusentismo
			) {
		super();

		this.orden = orden;
		this.agrupacion = agrupacion;
		this.cntNumeroDeMesa = cntNumeroMesa;
		this.numeroDeVotantes = numeroDeVotantes;
		this.dscdepartamento = dscdepartamento;
		this.dscprovincia = dscprovincia;
		this.dscdistrito = dscdistrito;
		this.voto = voto;

		this._totalVotantesDepartamento = _totalVotantesDepartamento;
		this._totalVotantesProvincia = _totalVotantesProvincia;
		this._totalVotantesDistrito = _totalVotantesDistrito;
		this._totalVotantesCentroDeVotacion = _totalVotantesCentroDeVotacion;
		
		this._cntMesasDepartamento = _cntMesasDepartamento;
		this._cntMesasProvincia = _cntMesasProvincia;
		this._cntMesasDistrito = _cntMesasDistrito;
		this._cntMesasCentroDeVotacion = _cntMesasCentroDeVotacion;
		this.numeroDeAusentismo = numeroDeAusentismo;
		
	}		
	
	
	//Nivel de centro de votacion
	public ResultadoResumenPojo(
			Integer orden,
			String agrupacion, 
			long cntNumeroMesa,
			long numeroDeVotantes, 
			String dscdepartamento,
			String dscprovincia,
			String dscdistrito,
			String nombreCentroDeVotacion,
			long voto,
			long _totalVotantesDepartamento,
			long _totalVotantesProvincia,
			long _totalVotantesDistrito,
			long _totalVotantesCentroDeVotacion,
			
			long _cntMesasDepartamento,
			long _cntMesasProvincia,
			long _cntMesasDistrito,
			long _cntMesasCentroDeVotacion		,
			long numeroDeAusentismo
			) {
		super();

		this.orden = orden;
		this.agrupacion = agrupacion;
		this.cntNumeroDeMesa = cntNumeroMesa;
		this.numeroDeVotantes = numeroDeVotantes;
		this.dscdepartamento = dscdepartamento;
		this.dscprovincia = dscprovincia;
		this.dscdistrito = dscdistrito;
		this.nombreCentroDeVotacion = nombreCentroDeVotacion;
		
		this.voto = voto;

		this._totalVotantesDepartamento = _totalVotantesDepartamento;
		this._totalVotantesProvincia = _totalVotantesProvincia;
		this._totalVotantesDistrito = _totalVotantesDistrito;
		this._totalVotantesCentroDeVotacion = _totalVotantesCentroDeVotacion;
		
		this._cntMesasDepartamento = _cntMesasDepartamento;
		this._cntMesasProvincia = _cntMesasProvincia;
		this._cntMesasDistrito = _cntMesasDistrito;
		this._cntMesasCentroDeVotacion = _cntMesasCentroDeVotacion;
		this.numeroDeAusentismo = numeroDeAusentismo;
		
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


	public long getNumeroDeVotantes() {
		return numeroDeVotantes;
	}

	public void setNumeroDeVotantes(long numeroDeVotantes) {
		this.numeroDeVotantes = numeroDeVotantes;
	}


	public Integer getIdistrito() {
		return idistrito;
	}

	public void setIdistrito(Integer idistrito) {
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

	public long getVoto() {
		return voto;
	}

	public void setVoto(long voto) {
		this.voto = voto;
	}

	public long getCntNumeroDeMesa() {
		return cntNumeroDeMesa;
	}

	public void setCntNumeroDeMesa(long cntNumeroDeMesa) {
		this.cntNumeroDeMesa = cntNumeroDeMesa;
	}

	public long get_totalVotantesDepartamento() {
		return _totalVotantesDepartamento;
	}

	public void set_totalVotantesDepartamento(long _totalVotantesDepartamento) {
		this._totalVotantesDepartamento = _totalVotantesDepartamento;
	}

	public long get_totalVotantesProvincia() {
		return _totalVotantesProvincia;
	}

	public void set_totalVotantesProvincia(long _totalVotantesProvincia) {
		this._totalVotantesProvincia = _totalVotantesProvincia;
	}

	public long get_totalVotantesDistrito() {
		return _totalVotantesDistrito;
	}

	public void set_totalVotantesDistrito(long _totalVotantesDistrito) {
		this._totalVotantesDistrito = _totalVotantesDistrito;
	}

	public long get_totalVotantesCentroDeVotacion() {
		return _totalVotantesCentroDeVotacion;
	}

	public void set_totalVotantesCentroDeVotacion(long _totalVotantesCentroDeVotacion) {
		this._totalVotantesCentroDeVotacion = _totalVotantesCentroDeVotacion;
	}

	public long get_cntMesasDepartamento() {
		return _cntMesasDepartamento;
	}

	public void set_cntMesasDepartamento(long _cntMesasDepartamento) {
		this._cntMesasDepartamento = _cntMesasDepartamento;
	}

	public long get_cntMesasProvincia() {
		return _cntMesasProvincia;
	}

	public void set_cntMesasProvincia(long _cntMesasProvincia) {
		this._cntMesasProvincia = _cntMesasProvincia;
	}

	public long get_cntMesasDistrito() {
		return _cntMesasDistrito;
	}

	public void set_cntMesasDistrito(long _cntMesasDistrito) {
		this._cntMesasDistrito = _cntMesasDistrito;
	}

	public long get_cntMesasCentroDeVotacion() {
		return _cntMesasCentroDeVotacion;
	}

	public void set_cntMesasCentroDeVotacion(long _cntMesasCentroDeVotacion) {
		this._cntMesasCentroDeVotacion = _cntMesasCentroDeVotacion;
	}




	public String getNombreCentroDeVotacion() {
		return nombreCentroDeVotacion;
	}


	public void setNombreCentroDeVotacion(String nombreCentroDeVotacion) {
		this.nombreCentroDeVotacion = nombreCentroDeVotacion;
	}


	public String getIdCentroDeVotacion() {
		return idCentroDeVotacion;
	}


	public void setIdCentroDeVotacion(String idCentroDeVotacion) {
		this.idCentroDeVotacion = idCentroDeVotacion;
	}


	public long getNumeroDeAusentismo() {
		return numeroDeAusentismo;
	}


	public void setNumeroDeAusentismo(long numeroDeAusentismo) {
		this.numeroDeAusentismo = numeroDeAusentismo;
	}	
	
	
	
	
	

}
