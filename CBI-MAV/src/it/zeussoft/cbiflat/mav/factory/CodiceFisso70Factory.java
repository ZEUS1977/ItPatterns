package it.zeussoft.cbiflat.mav.factory;

import it.zeussoft.cbiflat.mav.beans.CodiceFisso70;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;

public class CodiceFisso70Factory {
	public void populateCodiceFisso(CodiceFisso70 cf70, ExcelFixedFormat row, int progressivo){
		cf70.setProgressivo(Integer.toString(progressivo));
	}
}
