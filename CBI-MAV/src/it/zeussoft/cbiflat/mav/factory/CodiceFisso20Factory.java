package it.zeussoft.cbiflat.mav.factory;

import it.zeussoft.cbiflat.mav.beans.CodiceFisso20;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;

public class CodiceFisso20Factory {
	
	
	public void populateCodiceFisso(CodiceFisso20 cf20, ExcelFixedFormat row, int progressivo){
		
		cf20.setProgressivo(Integer.toString(progressivo));
		String descrizioneCreditore = row.getCreditore();
		//descrizioneCreditore = "1234567890123456789012345678901234567890123456789012345678901234567890123";
		if(descrizioneCreditore.length() > 0  && descrizioneCreditore.length() > 24)
			cf20.setPrimoSegmentoF(descrizioneCreditore.substring(0,24));
		else if(descrizioneCreditore.length() > 0  && descrizioneCreditore.length() <= 24)
			cf20.setPrimoSegmentoF(descrizioneCreditore.substring(0,descrizioneCreditore.length()));
		if(descrizioneCreditore.length() > 24  && descrizioneCreditore.length() > 48)
			cf20.setSecondoSegmentoF(descrizioneCreditore.substring(24,48));
		else if(descrizioneCreditore.length() > 24 && descrizioneCreditore.length() <= 48)					
			cf20.setSecondoSegmentoF(descrizioneCreditore.substring(24,descrizioneCreditore.length()));
		if(descrizioneCreditore.length() > 48 && descrizioneCreditore.length() > 72)
			cf20.setTerzoSegmentoF(descrizioneCreditore.substring(48,72));
		else if(descrizioneCreditore.length() > 48 && descrizioneCreditore.length() <= 72)
			cf20.setTerzoSegmentoF(descrizioneCreditore.substring(48,descrizioneCreditore.length()));
		if(descrizioneCreditore.length() > 72 && descrizioneCreditore.length() > 96)
			cf20.setQuartoSegmentoF(descrizioneCreditore.substring(72,96));
		else if(descrizioneCreditore.length() > 72 && descrizioneCreditore.length() <= 96)
			cf20.setQuartoSegmentoF(descrizioneCreditore.substring(72,descrizioneCreditore.length()));
	
	}
}
