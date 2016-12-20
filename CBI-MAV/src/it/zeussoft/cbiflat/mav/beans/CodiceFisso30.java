package it.zeussoft.cbiflat.mav.beans;

import it.zeussoft.cbiflat.mav.consts.Constants;

import org.apache.commons.lang3.StringUtils;

public class CodiceFisso30 extends CodiceFisso {

	private String primoSegmentoF = StringUtils.EMPTY;
	private String secondoSegmentoF = StringUtils.EMPTY;
	private String codiceFiscaleDebitore = StringUtils.EMPTY;
	
	public CodiceFisso30() {
		super();
		tipoRecord = Constants.TIPO_RECORD_30;
	}
	
	public String getPrimoSegmentoF() {
		return primoSegmentoF;
	}
	public void setPrimoSegmentoF(String primoSegmentoF) {
		this.primoSegmentoF = primoSegmentoF;
	}
	public String getSecondoSegmentoF() {
		return secondoSegmentoF;
	}
	public void setSecondoSegmentoF(String secondoSegmentoF) {
		this.secondoSegmentoF = secondoSegmentoF;
	}
	public String getCodiceFiscaleDebitore() {
		return codiceFiscaleDebitore;
	}
	public void setCodiceFiscaleDebitore(String codiceFiscaleDebitore) {
		this.codiceFiscaleDebitore = codiceFiscaleDebitore;
	}
		
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(primoSegmentoF +  Constants.SPACE +
				secondoSegmentoF +  Constants.SPACE +
				codiceFiscaleDebitore +  Constants.SPACE);
		return sb.toString();
	}
}
