package it.zeussoft.cbiflat.mav.excelreader;



import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;

import java.util.Iterator;
import java.util.Vector;




import org.apache.poi.hssf.usermodel.HSSFCell;

public class BeansPopulator {
	
	
	
	public static void main(String args){
		Vector<Vector<HSSFCell>> dataHolder = null;
		excelBeansPopulate("C:\\Users\\ulisse\\workspace\\CBI-MAV\\doc\\FILE MAV AIUOLA - 12.xls", dataHolder);	
	}
	
	public static Vector<ExcelFixedFormat> excelBeansPopulate(String file, Vector<Vector<HSSFCell>> input){
		Vector<Vector<HSSFCell>> dataHolder = 
				ExcelFileReader.readExcel(file);
		
		Vector<ExcelFixedFormat> rows = new Vector<ExcelFixedFormat>();
		Iterator<Vector<HSSFCell>> it = dataHolder.iterator();
		while(it.hasNext()) {
			Vector<HSSFCell> cellStoreVector = (Vector<HSSFCell>) it.next();
			ExcelFixedFormat row = new ExcelFixedFormat();
			Iterator<HSSFCell> itCell = cellStoreVector.iterator();
			if(itCell.hasNext())
				row.setCreditore(itCell.next().toString());
			if(itCell.hasNext())
					row.setTitolo(itCell.next().toString());
			if(itCell.hasNext())
				row.setDebitore(itCell.next().toString());
			if(itCell.hasNext())
				row.setIndirizzo_via_civico(itCell.next().toString());
			if(itCell.hasNext())
				row.setIndirizzo_cap(itCell.next().toString());
			if(itCell.hasNext())
				row.setIndirizzo_comune(itCell.next().toString());
			if(itCell.hasNext())
				row.setIndirizzo_provincia(itCell.next().toString());	
			if(itCell.hasNext())
				row.setRata(itCell.next().toString());
			if(itCell.hasNext())
				row.setScadenza(itCell.next().toString());
			if(itCell.hasNext())
				row.setCausale(itCell.next().toString());
			if(itCell.hasNext())
				row.setIban(itCell.next().toString());
			if(itCell.hasNext())
				row.setCodSia(itCell.next().toString());
			if(itCell.hasNext())
				row.setConto(itCell.next().toString());
			
			rows.add(row);
			System.out.println(row);
		}
		
		return rows;
	}
}
