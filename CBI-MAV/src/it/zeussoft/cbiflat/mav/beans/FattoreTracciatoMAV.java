package it.zeussoft.cbiflat.mav.beans;


import org.apache.commons.lang3.StringUtils;

public class FattoreTracciatoMAV implements FattoreInterface{

	protected String tipoRecord = StringUtils.EMPTY;
	
	public String getTipoRecord() {
		return tipoRecord;
	}

	public void setTipoRecord(String tipoRecord) {
		this.tipoRecord = tipoRecord;
	}

	
}
