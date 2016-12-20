package it.zeussoft.cbiflat.mav.factory;

import it.zeussoft.cbiflat.mav.beans.CodaEF;
import it.zeussoft.cbiflat.mav.beans.CodiceFisso14;
import it.zeussoft.cbiflat.mav.beans.CodiceFisso20;
import it.zeussoft.cbiflat.mav.beans.CodiceFisso30;
import it.zeussoft.cbiflat.mav.beans.CodiceFisso40;
import it.zeussoft.cbiflat.mav.beans.CodiceFisso50;
import it.zeussoft.cbiflat.mav.beans.CodiceFisso51;
import it.zeussoft.cbiflat.mav.beans.CodiceFisso70;
import it.zeussoft.cbiflat.mav.beans.Result;
import it.zeussoft.cbiflat.mav.beans.TestaIM;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;
import it.zeussoft.cbiflat.mav.beans.product.ProdottoTracciato;
import it.zeussoft.cbiflat.mav.beans.product.RecordCodiceFisso;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import com.blackbear.flatworm.FileCreator;
import com.blackbear.flatworm.errors.FlatwormCreatorException;

public class TracciatoFactory {
	
	public Result populateTracciato(Vector<ExcelFixedFormat> rows, ProdottoTracciato tracciato, FileCreator file){
		Logger logger = Logger.getLogger(TracciatoFactory.class);
		//la testa dall'execel ha bisogno di info che ci sono in tutte le righe dell'excel, prendo la prima
		ExcelFixedFormat rowZero = rows.get(0);
		
		TestaIMFactory fTesta = new TestaIMFactory();
		TestaIM testaIM = new TestaIM();
		fTesta.populateCodiceFisso(testaIM, rowZero);		
		tracciato.setTastaIM(testaIM);
				
		BigDecimal tot = BigDecimal.ZERO;
		int progressivo = 0;
		
		ExcelFixedFormat row =null;
		List<RecordCodiceFisso> records = new ArrayList<RecordCodiceFisso>();
		
		for(int i = 0; i < rows.size(); i++){ 
			
			CodiceFisso14Factory f14 = new CodiceFisso14Factory();
			CodiceFisso20Factory f20 = new CodiceFisso20Factory();
			CodiceFisso30Factory f30 = new CodiceFisso30Factory();
			CodiceFisso40Factory f40 = new CodiceFisso40Factory();
			CodiceFisso50Factory f50 = new CodiceFisso50Factory();
			CodiceFisso51Factory f51 = new CodiceFisso51Factory();
			CodiceFisso70Factory f70 = new CodiceFisso70Factory();
			
			CodiceFisso14 cf14 = new CodiceFisso14();
			CodiceFisso20 cf20 = new CodiceFisso20();
			CodiceFisso30 cf30 = new CodiceFisso30();
			CodiceFisso40 cf40 = new CodiceFisso40();
			CodiceFisso50 cf50 = new CodiceFisso50();
			CodiceFisso51 cf51 = new CodiceFisso51();
			CodiceFisso70 cf70 = new CodiceFisso70();
		
			row = rows.get(i);
			if(row != null && row.getScadenza() != null && row.getScadenza() != StringUtils.EMPTY) {
				logger.info(row);
				RecordCodiceFisso record = new RecordCodiceFisso(); 
				//il progressivo parte da uno ed è presente in ogni richiesta di mav
				progressivo = i+1;		
				System.out.println(i + row.toString());			
				
				tot = f14.populateCodiceFisso(cf14, row, progressivo, tot);
				logger.info(f14);
				record.setCodiceFisso14(cf14);
				
				f20.populateCodiceFisso(cf20, row, progressivo);
				logger.info(f20);
				record.setCodiceFisso20(cf20);				
				
				f30.populateCodiceFisso(cf30, row, progressivo);
				logger.info(f30);
				record.setCodiceFisso30(cf30);
				
				try{
					f40.populateCodiceFisso(cf40, row, progressivo);
					logger.info(f40);
					record.setCodiceFisso40(cf40);
				}catch(Exception e){
					//TODO VALUTARE SE GESTIRE DIFFERENTI TIPI DI ECCEZZIONI CUSTOM 
					//TODO LOGGARE o GESTIRE ECCEZIONE FATAL PER FAR CONTROLLARE L'EXCEL SEGNALANDO IL NUMERO DI RIGA
				}
				
				f50.populateCodiceFisso(cf50, row, progressivo);
				logger.info(f50);
				record.setCodiceFisso50(cf50);
				
				f51.populateCodiceFisso(cf51, row, progressivo);
				logger.info(f51);
				record.setCodiceFisso51(cf51);
				
				f70.populateCodiceFisso(cf70, row, progressivo);
				logger.info(f70);
				record.setCodiceFisso70(cf70);
				
				records.add(record);
			}	
			
			tracciato.setRecordCodiciFissiList(records);
		}
		
		CodaEF codaEF = new CodaEF();	
		CodaEFFactory fCoda = new CodaEFFactory();
		fCoda.populateCodiceFisso(codaEF, rowZero, progressivo, tot);
		tracciato.setCodaEF(codaEF);
		System.out.println(tot);
		Result res = new Result();
		res.setRows(new Integer(progressivo));
		res.setTot(String.valueOf(tot));
		return res;
	
	}
	
	public void writeTracciato(ProdottoTracciato tracciato, FileCreator file){
		
		writeRecord(file, tracciato.getTastaIM(), "testaIM", "testata");
		
		Iterator<RecordCodiceFisso> recordIterator = tracciato.getRecordCodiciFissiList().iterator();
		RecordCodiceFisso record = null;
		while(recordIterator.hasNext()){
			record = recordIterator.next();
			writeRecord(file, record.getCodiceFisso14(), "codiceFisso14Bean", "codiceFisso14");
			writeRecord(file, record.getCodiceFisso20(), "codiceFisso20Bean", "codiceFisso20");
			writeRecord(file, record.getCodiceFisso30(), "codiceFisso30Bean", "codiceFisso30");
			writeRecord(file, record.getCodiceFisso40(), "codiceFisso40Bean", "codiceFisso40");
			writeRecord(file, record.getCodiceFisso50(), "codiceFisso50Bean", "codiceFisso50");
			writeRecord(file, record.getCodiceFisso51(), "codiceFisso51Bean", "codiceFisso51");
			writeRecord(file, record.getCodiceFisso70(), "codiceFisso70Bean", "codiceFisso70");
			
		}
		writeRecord(file, tracciato.getCodaEF(), "codaEF", "coda");
	}
	
	
	public static void writeRecord(FileCreator file,  Object bean, String beanName, String recordName) {
		
		try {
			file.setBean(beanName, bean);
			file.write(recordName);
			
		}catch (FlatwormCreatorException flatwormCreatorException) {
			flatwormCreatorException.printStackTrace();
		}catch (IOException flatwormConfigurationValueError) {
			flatwormConfigurationValueError.printStackTrace();
		} finally {  
			
		}  

	}
}
