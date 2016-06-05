package it.zeussoft.cbiflat.mav.beans;

import it.zeussoft.cbiflat.mav.consts.Constants;

import org.apache.commons.lang3.StringUtils;

public class CodiceFisso14 extends CodiceFisso{

	private String dataScadenza = StringUtils.EMPTY;
	private String causale = StringUtils.EMPTY;
	private String importo = StringUtils.EMPTY;
	private String segno = StringUtils.EMPTY;
	private String abiCreditore = StringUtils.EMPTY;
	private String cabAssuntrice = StringUtils.EMPTY;
	private String contoAccredito = StringUtils.EMPTY;
	private String codiceSia = StringUtils.EMPTY;
	private String tipo = StringUtils.EMPTY;
	private String codiceDebitore = StringUtils.EMPTY;
	private String codiceDvisa = StringUtils.EMPTY;
	
	public CodiceFisso14() {
		super();
		tipoRecord = Constants.TIPO_RECORD_14;
	}
	
	public String getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public String getCausale() {
		return causale;
	}
	public void setCausale(String causale) {
		this.causale = causale;
	}
	public String getImporto() {
		return importo;
	}
	public void setImporto(String importo) {
		this.importo = importo;
	}
	public String getSegno() {
		return segno;
	}
	public void setSegno(String segno) {
		this.segno = segno;
	}
	public String getAbiCreditore() {
		return abiCreditore;
	}
	public void setAbiCreditore(String abiCreditore) {
		this.abiCreditore = abiCreditore;
	}
	public String getCabAssuntrice() {
		return cabAssuntrice;
	}
	public void setCabAssuntrice(String cabAssuntrice) {
		this.cabAssuntrice = cabAssuntrice;
	}
	public String getContoAccredito() {
		return contoAccredito;
	}
	public void setContoAccredito(String contoAccredito) {
		this.contoAccredito = contoAccredito;
	}
	public String getCodiceSia() {
		return codiceSia;
	}
	public void setCodiceSia(String codiceSia) {
		this.codiceSia = codiceSia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String codiceV) {
		this.tipo = codiceV;
	}
	public String getCodiceDebitore() {
		return codiceDebitore;
	}
	public void setCodiceDebitore(String codiceDebitore) {
		this.codiceDebitore = codiceDebitore;
	}
	public String getCodiceDvisa() {
		return codiceDvisa;
	}
	public void setCodiceDvisa(String codiceDvisa) {
		this.codiceDvisa = codiceDvisa;
	}	
}
