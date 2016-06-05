package it.zeussoft.cbiflat.mav.factory;

import it.zeussoft.cbiflat.mav.beans.CodaEF;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;
import it.zeussoft.cbiflat.mav.consts.Constants;
import it.zeussoft.cbiflat.mav.utils.CleanImport;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class CodaEFFactory {
	
	public void populateCodiceFisso(CodaEF codaEF, ExcelFixedFormat rowZero, int progressivo, BigDecimal tot){
		
		codaEF.setDataCreazione(Constants.TODAY);
		codaEF.setCodiceDivisa(Constants.CODICE_DIVISA);
		codaEF.setMittenteSia(rowZero.getCodSia());
		codaEF.setNomeSupporto( rowZero.getCreditore());
		codaEF.setRiceventeABI(rowZero.getIban().substring(5,10));
		codaEF.setTotRecord(Integer.toString(progressivo*7+2));
		codaEF.setNumeroDisposizioni(Integer.toString(progressivo));
		codaEF.setTotImportiNegativi(CleanImport.cleanImport(NumberFormat.getCurrencyInstance().format(tot)));
		
	}
}
