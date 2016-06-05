package it.zeussoft.cbiflat.mav.factory;

import it.zeussoft.cbiflat.mav.beans.CodiceFisso51;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;

public class CodiceFisso51Factory {

	public void populateCodiceFisso(CodiceFisso51 cf51, ExcelFixedFormat row, int progressivo){
		cf51.setProgressivo(Integer.toString(progressivo));
		cf51.setNumeroDisposizione(Integer.toString(progressivo-1));
	}
}
