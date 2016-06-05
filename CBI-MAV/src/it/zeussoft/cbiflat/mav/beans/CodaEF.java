package it.zeussoft.cbiflat.mav.beans;

import it.zeussoft.cbiflat.mav.consts.Constants;

import org.apache.commons.lang3.StringUtils;

public class CodaEF extends FattoreTracciatoMAV{
	
	private String mittenteSia = StringUtils.EMPTY;                              
	private String riceventeABI = StringUtils.EMPTY;
	private String dataCreazione = StringUtils.EMPTY;
	private String nomeSupporto = StringUtils.EMPTY;
	private String campoADisposizione = StringUtils.EMPTY;
	private String numeroDisposizioni = StringUtils.EMPTY;
	private String totImportiNegativi = StringUtils.EMPTY;
	private String totImportiPositiviZeri = StringUtils.EMPTY;
	private String totRecord = StringUtils.EMPTY;
	private String codiceDivisa = StringUtils.EMPTY;           
	private String campoNonDisponibile = StringUtils.EMPTY;
	
	public CodaEF() {
		super();
		tipoRecord = Constants.TIPO_RECORD_EF;  
	}
	
	public String getTipoRecord() {
		return tipoRecord;
	}
	public void setTipoRecord(String tipoRecord) {
		this.tipoRecord = tipoRecord;
	}
	public String getMittenteSia() {
		return mittenteSia;
	}
	public void setMittenteSia(String mittenteSia) {
		this.mittenteSia = mittenteSia;
	}
	public String getRiceventeABI() {
		return riceventeABI;
	}
	public void setRiceventeABI(String riceventeABI) {
		this.riceventeABI = riceventeABI;
	}
	public String getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public String getNomeSupporto() {
		return nomeSupporto;
	}
	public void setNomeSupporto(String nomeSupporto) {
		this.nomeSupporto = nomeSupporto;
	}
	public String getCampoADisposizione() {
		return campoADisposizione;
	}
	public void setCampoADisposizione(String campoADisposizione) {
		this.campoADisposizione = campoADisposizione;
	}
	public String getNumeroDisposizioni() {
		return numeroDisposizioni;
	}
	public void setNumeroDisposizioni(String numeroDisposizioni) {
		this.numeroDisposizioni = numeroDisposizioni;
	}
	public String getTotImportiNegativi() {
		return totImportiNegativi;
	}
	public void setTotImportiNegativi(String totImportiNegativi) {
		this.totImportiNegativi = totImportiNegativi;
	}
	public String getTotImportiPositiviZeri() {
		return totImportiPositiviZeri;
	}
	public void setTotImportiPositiviZeri(String totImportiPositiviZeri) {
		this.totImportiPositiviZeri = totImportiPositiviZeri;
	}
	public String getTotRecord() {
		return totRecord;
	}
	public void setTotRecord(String totRecord) {
		this.totRecord = totRecord;
	}
	public String getCodiceDivisa() {
		return codiceDivisa;
	}
	public void setCodiceDivisa(String codiceDivisa) {
		this.codiceDivisa = codiceDivisa;
	}
	public String getCampoNonDisponibile() {
		return campoNonDisponibile;
	}
	public void setCampoNonDisponibile(String campoNonDisponibile) {
		this.campoNonDisponibile = campoNonDisponibile;
	}
}
