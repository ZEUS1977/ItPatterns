package it.zeussoft.cbiflat.mav.beans;


import org.apache.commons.lang3.StringUtils;

public class CodiceFisso extends FattoreTracciatoMAV{

	protected String progressivo = StringUtils.EMPTY;

	public String getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}
	
}
