package it.zeussoft.cbiflat.mav.factory;

import it.zeussoft.cbiflat.mav.beans.TestaIM;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;
import it.zeussoft.cbiflat.mav.consts.Constants;

public class TestaIMFactory {

	public void populateCodiceFisso(TestaIM testaIM, ExcelFixedFormat rowZero){
		testaIM.setDataCreazione(Constants.TODAY);
		testaIM.setCodiceDivisa(Constants.CODICE_DIVISA);
		testaIM.setMittenteSia(rowZero.getCodSia());
		testaIM.setNomeSupporto(rowZero.getCreditore());
		testaIM.setRiceventeABI(rowZero.getIban().substring(5,10));
	}
}
