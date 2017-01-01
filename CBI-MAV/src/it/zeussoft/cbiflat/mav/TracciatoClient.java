package it.zeussoft.cbiflat.mav;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.blackbear.flatworm.FileCreator;
import com.blackbear.flatworm.errors.FlatwormCreatorException;

import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;
import it.zeussoft.cbiflat.mav.beans.product.ProdottoTracciato;
import it.zeussoft.cbiflat.mav.consts.Constants;
import it.zeussoft.cbiflat.mav.excelreader.BeansPopulator;
import it.zeussoft.cbiflat.mav.excelreader.ExcelFileReader;
import it.zeussoft.cbiflat.mav.factory.TracciatoFactory;

public class TracciatoClient {
	public static final String  CUR_DIR = System.getProperty("user.dir");

	public static final String CONF_FILE = CUR_DIR + "/resources/flatworm/cbi-mav.xml";
	public static final String OUT_FILE =  CUR_DIR + "/scambiodati/out/output.txt";
	
	public static void main(String[] args){
		String excelFilePath;
		String confFilePath;
		String outFilePath;
		
		if(args.length != 3){
			return;
		}else{
			excelFilePath = args[0];
			confFilePath = args[1];
			outFilePath = args[2];
		}
		
		 Map<Integer,List<Object>> dataHolder = null;
		try{
			dataHolder = ExcelFileReader.readExcel(excelFilePath);
		}catch (Exception e) {
			e.printStackTrace();
		}
		ExcelFileReader.printCellDataToConsole(dataHolder);
		
		
		Vector<ExcelFixedFormat> rows = BeansPopulator.excelBeansPopulate(excelFilePath,dataHolder);
		
		TracciatoFactory tf = new TracciatoFactory();
		ProdottoTracciato tracciato = new ProdottoTracciato();
		FileCreator file = null;
		file = openFile(confFilePath, outFilePath);
		
		tf.populateTracciato(rows, tracciato, file);
		tf.writeTracciato(tracciato,file);

		closeFile(file);
	}
	
	public static FileCreator openFile(String conf, String out){
		FileCreator file= null;
		try{
				file = new FileCreator(conf, out);
				file.open(); 
				file.setRecordSeperator(Constants.RECORD_SEPARATOR); 
			} catch (FlatwormCreatorException flatwormCreatorException) {
				flatwormCreatorException.printStackTrace();
			}catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		return file;
	}
	
	public static void closeFile( FileCreator file){
		try{  
			if(file != null)
				file.close();  
		} catch( Exception e ) {  
		   e.printStackTrace();  
		}  
		
	}

}
