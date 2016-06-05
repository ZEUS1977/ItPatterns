package it.zeussoft.cbiflat.mav.factory;

import org.apache.commons.lang3.StringUtils;

import it.zeussoft.cbiflat.mav.beans.CodiceFisso30;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;

public class CodiceFisso30Factory {
	
	public void populateCodiceFisso(CodiceFisso30 cf30, ExcelFixedFormat row, int progressivo){
		cf30.setProgressivo(Integer.toString(progressivo));
		String descrizioneDebitore = row.getTitolo() + " " + row.getDebitore();
		if(descrizioneDebitore.length() > 0  && descrizioneDebitore.length() > 30)
			cf30.setPrimoSegmentoF(descrizioneDebitore.substring(0,30));
		else if(descrizioneDebitore.length() > 0 && descrizioneDebitore.length() <= 30)					
			cf30.setPrimoSegmentoF(descrizioneDebitore.substring(0,descrizioneDebitore.length()));
		if(descrizioneDebitore.length() > 30  && descrizioneDebitore.length() > 60)
			cf30.setSecondoSegmentoF(descrizioneDebitore.substring(30,60));
		else if(descrizioneDebitore.length() > 30 && descrizioneDebitore.length() <= 60)					
			cf30.setSecondoSegmentoF(descrizioneDebitore.substring(30,descrizioneDebitore.length()));
	}
}
