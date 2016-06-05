package it.zeussoft.cbiflat.mav.factory;

import org.apache.commons.lang3.StringUtils;

import it.zeussoft.cbiflat.mav.beans.CodiceFisso40;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;
import it.zeussoft.cbiflat.mav.consts.Constants;

public class CodiceFisso40Factory {
	
	public void populateCodiceFisso(CodiceFisso40 cf40, ExcelFixedFormat row, int progressivo) throws Exception{
		
		cf40.setProgressivo(Integer.toString(progressivo));
		/*String [] address  = row.getIndirizzo().split(Constants.SPLIT_ADDRESS_SEPARATOR);
		String viaCivicoFrazione = StringUtils.EMPTY;
		String cap = StringUtils.EMPTY;
		String comuneProvincia = StringUtils.EMPTY;
		if(address.length == 8){
			//via alzaia naviglio grande, y cap comune provincia
			viaCivicoFrazione = address[0] + Constants.SPACE  + address[1] + Constants.SPACE + address[2] + Constants.SPACE + address[3] + Constants.SPACE + address[4];
			cap = address[5];
			comuneProvincia = address[6] + Constants.SPACE + address[7];
		}else if(address.length == 7){
			//via san xxxx y, comune cap provincia
			viaCivicoFrazione = address[0] + Constants.SPACE + address[1] + Constants.SPACE + address[2] + Constants.SPACE + address[3];
			cap = address[4];
			comuneProvincia = address[5] + Constants.SPACE + address[6];
		}else if(address.length == 6){
			//via xxxx y, comune cap provincia
			viaCivicoFrazione = address[0] + Constants.SPACE + address[1] + Constants.SPACE + address[2];
			cap = address[3];
			comuneProvincia = address[4] + Constants.SPACE + address[5];
		}else{
			throw new Exception("Indirizzo non gestito! Verificare.");
		}
		*/	
		cf40.setViaCivicoFrazione(row.getIndirizzo_via_civico());
		cf40.setCap(row.getIndirizzo_cap());
		cf40.setComuneProvincia(row.getIndirizzo_comune() + " " + row.getIndirizzo_provincia());
		cf40.setCodicePaese(Constants.COUNTRY_COD);		
	
	}
}
