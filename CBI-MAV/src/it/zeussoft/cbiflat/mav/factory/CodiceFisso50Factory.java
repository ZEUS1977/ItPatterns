package it.zeussoft.cbiflat.mav.factory;

import it.zeussoft.cbiflat.mav.beans.CodiceFisso50;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;

public class CodiceFisso50Factory {
	
	public void populateCodiceFisso(CodiceFisso50 cf50, ExcelFixedFormat row, int progressivo){
		
		cf50.setProgressivo(Integer.toString(progressivo));
		String descrizioneDebito = row.getCausale();
		if(descrizioneDebito.length() > 0  && descrizioneDebito.length() > 40)
			cf50.setPrimoSegmentoF(descrizioneDebito.substring(0,40));
		else if(descrizioneDebito.length() > 0 && descrizioneDebito.length() < 40)					
			cf50.setPrimoSegmentoF(descrizioneDebito.substring(0,descrizioneDebito.length()));
		if(descrizioneDebito.length() > 40  && descrizioneDebito.length() > 80)
			cf50.setSecondoSegmentoF(descrizioneDebito.substring(30,80));
		else if(descrizioneDebito.length() > 40 && descrizioneDebito.length() < 80)					
			cf50.setSecondoSegmentoF(descrizioneDebito.substring(30,descrizioneDebito.length()));
		
	}
}
