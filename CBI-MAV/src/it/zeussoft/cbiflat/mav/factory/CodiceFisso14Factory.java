package it.zeussoft.cbiflat.mav.factory;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.zeussoft.cbiflat.mav.beans.CodiceFisso14;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;
import it.zeussoft.cbiflat.mav.consts.Constants;
import it.zeussoft.cbiflat.mav.utils.CleanImport;

public class CodiceFisso14Factory {
	
	public BigDecimal populateCodiceFisso(CodiceFisso14 codiceFisso14, ExcelFixedFormat row, int progressivo, BigDecimal tot) {
		//approssimazione a 2 cifre decimali per l'importo delle richieste
		int decimalPlace = 2;
		//prendo l'importo dall'excel
		BigDecimal importRata =  new BigDecimal(row.getRata());
		//arrottondamento, perchè due volte?
		importRata.setScale(decimalPlace, BigDecimal.ROUND_HALF_EVEN);
		tot.setScale(decimalPlace, BigDecimal.ROUND_HALF_EVEN);
		tot = tot.add(importRata);
		tot.setScale(decimalPlace, BigDecimal.ROUND_HALF_EVEN);
		
		codiceFisso14.setProgressivo(Integer.toString(progressivo));
		SimpleDateFormat simple2 = new SimpleDateFormat("dd/MM/yyyy");
		Date scadenza = null;
		try{
			scadenza = simple2.parse(row.getScadenza());
		}catch(Exception e){
			//inserire log dell'errore di parsing 
			e.printStackTrace();
		}
		codiceFisso14.setDataScadenza(Constants.simple.format(scadenza));
		codiceFisso14.setCausale(Constants.CAUSALE_RICHIESTA_MAV_CBI);
		codiceFisso14.setSegno("-");
		codiceFisso14.setAbiCreditore(row.getIban().substring(5,10));
		codiceFisso14.setCabAssuntrice(row.getIban().substring(10,15));
		//il conto di accrerdito non va preso dall'IBAN perchè non è del debitore ma attenzione che non è 
		//dello stesso formato di quello che si troverebbe nell'iban del creditore
		codiceFisso14.setContoAccredito(row.getConto()); 
				//row.getIban().substring(15,27));
		//viene assegnato dalla banca al creditore
		codiceFisso14.setCodiceSia(row.getCodSia());
		//codiceFisso14.setCodiceDebitore();
		//importd.setScale(decimalPlace, BigDecimal.ROUND_UP);
		//importo arrotondato a due cifre decimali
		codiceFisso14.setImporto(CleanImport.cleanImport(NumberFormat.getCurrencyInstance().format(importRata)));
		System.out.println(CleanImport.cleanImport(NumberFormat.getCurrencyInstance().format(importRata)));

		return tot;
	}

	
	
}
