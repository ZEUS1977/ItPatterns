package it.zeussoft.cbiflat.mav.beans;

import it.zeussoft.cbiflat.mav.consts.Constants;

import org.apache.commons.lang3.StringUtils;

public class CodiceFisso51 extends CodiceFisso{

	private String numeroDisposizione = StringUtils.EMPTY;
	private String codiceIdentificativoUnivoco = StringUtils.EMPTY;	
	
	public CodiceFisso51() {
		super();
		tipoRecord = Constants.TIPO_RECORD_51;
	}

	public String getNumeroDisposizione() {
		return numeroDisposizione;
	}
	public void setNumeroDisposizione(String numeroDisposizione) {
		this.numeroDisposizione = numeroDisposizione;
	}
	public String getCodiceIdentificativoUnivoco() {
		return codiceIdentificativoUnivoco;
	}
	public void setCodiceIdentificativoUnivoco(String codiceIdentificativoUnivoco) {
		this.codiceIdentificativoUnivoco = codiceIdentificativoUnivoco;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(numeroDisposizione +  Constants.SPACE +
				codiceIdentificativoUnivoco+  Constants.SPACE);
		return sb.toString();
	}
}
