package it.zeussoft.cbiflat.mav.excelreader;



import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;

public class BeansPopulator {
	
	
	
	public static void main(String args){
		 Map<Integer,List<Object>> dataHolder = null;
		excelBeansPopulate("C:\\Users\\ulisse\\workspace\\CBI-MAV\\doc\\FILE MAV AIUOLA - 12.xls", dataHolder);	
	}
	
	public static Vector<ExcelFixedFormat> excelBeansPopulate(String file,  Map<Integer,List<Object>> input){
		
		Map<Integer,List<Object>> dataHolder = null;
		
		try{
			dataHolder = ExcelFileReader.readExcel(file);
		}catch (Exception e) {
			e.printStackTrace();
		}
		Vector<ExcelFixedFormat> rows = new Vector<ExcelFixedFormat>();
		Iterator<List<Object>> it = dataHolder.values().iterator();
		while(it.hasNext()) {
			List<Object> cellStoreVector = (List<Object>) it.next();
			ExcelFixedFormat row = new ExcelFixedFormat();
			Iterator<Object> itCell = cellStoreVector.iterator();
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
