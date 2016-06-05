package it.zeussoft.cbiflat.mav.factory;

import it.zeussoft.cbiflat.mav.beans.CodiceFisso;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;

public abstract class AbstractCodiceFissoFactory {
	
	public abstract void populateCodiceFisso(CodiceFisso codiceFisso, ExcelFixedFormat row, int progressivo);

}
