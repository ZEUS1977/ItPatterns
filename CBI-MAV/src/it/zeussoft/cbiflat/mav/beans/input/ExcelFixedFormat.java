package it.zeussoft.cbiflat.mav.beans.input;

import it.zeussoft.cbiflat.mav.consts.Constants;

public class ExcelFixedFormat {
	
	private String creditore;
	private String titolo;	
	private String debitore;
	private String indirizzo_via_civico;
	private String indirizzo_cap;
	private String indirizzo_comune;
	private String indirizzo_provincia;
	private String rata;	
	private String scadenza; 	
	private String causale;	
	private String iban;
	private String codSia;
	private String conto;
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getIndirizzo_via_civico() {
		return indirizzo_via_civico;
	}
	public void setIndirizzo_via_civico(String indirizzo_via_civico) {
		this.indirizzo_via_civico = indirizzo_via_civico;
	}
	public String getIndirizzo_cap() {
		return indirizzo_cap;
	}
	public void setIndirizzo_cap(String indirizzo_cap) {
		this.indirizzo_cap = indirizzo_cap;
	}
	public String getIndirizzo_comune() {
		return indirizzo_comune;
	}
	public void setIndirizzo_comune(String indirizzo_comune) {
		this.indirizzo_comune = indirizzo_comune;
	}
	public String getIndirizzo_provincia() {
		return indirizzo_provincia;
	}
	public void setIndirizzo_provincia(String indirizzo_provincia) {
		this.indirizzo_provincia = indirizzo_provincia;
	}
	public String getRata() {
		return rata;
	}
	public void setRata(String rata) {
		this.rata = rata;
	}
	public String getScadenza() {
		return scadenza;
	}
	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}
	public String getCausale() {
		return causale;
	}
	public void setCausale(String causale) {
		this.causale = causale;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getCodSia() {
		return codSia;
	}
	public void setCodSia(String codSia) {
		this.codSia = codSia;
	}
	public String getCreditore() {
		return creditore;
	}
	public void setCreditore(String creditore) {
		this.creditore = creditore;
	}
	public String getDebitore() {
		return debitore;
	}
	public void setDebitore(String debitore) {
		this.debitore = debitore;
	}
	public String getConto() {
		return conto;
	}
	public void setConto(String conto) {
		this.conto = conto;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(creditore  +  Constants.SPACE +
				titolo  +  Constants.SPACE +	
				debitore  +  Constants.SPACE +
				indirizzo_via_civico  +  Constants.SPACE +
				indirizzo_cap  +  Constants.SPACE +
				indirizzo_comune  +  Constants.SPACE +
				indirizzo_provincia  +  Constants.SPACE +
				rata  +  Constants.SPACE +	
				scadenza  +  Constants.SPACE + 	
				causale  +  Constants.SPACE +	
				iban  +  Constants.SPACE +
				codSia  +  Constants.SPACE +
				conto  +  Constants.SPACE);
		return sb.toString();
	}
}
