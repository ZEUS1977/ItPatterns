package it.zeussoft.cbiflat.mav.beans;

import it.zeussoft.cbiflat.mav.consts.Constants;

import org.apache.commons.lang3.StringUtils;

public class CodiceFisso70 extends CodiceFisso{

	private String tipoBollettino = StringUtils.EMPTY;
	private String campoADisposizione = StringUtils.EMPTY;
	private String chiaviDiControllo = StringUtils.EMPTY;
		
	public CodiceFisso70() {
		super();
		tipoRecord = Constants.TIPO_RECORD_70;
	}

	public String getTipoBollettino() {
		return tipoBollettino;
	}
	public void setTipoBollettino(String tipoBollettino) {
		this.tipoBollettino = tipoBollettino;
	}
	public String getCampoADisposizione() {
		return campoADisposizione;
	}
	public void setCampoADisposizione(String campoADisposizione) {
		this.campoADisposizione = campoADisposizione;
	}
	public String getChiaviDiControllo() {
		return chiaviDiControllo;
	}
	public void setChiaviDiControllo(String chiaviDiControllo) {
		this.chiaviDiControllo = chiaviDiControllo;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(tipoBollettino +  Constants.SPACE +
				campoADisposizione+  Constants.SPACE +
				chiaviDiControllo);
		return sb.toString();
	}
	
}
