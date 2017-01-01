package it.zeussoft.cbiflat.mav.excelreader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {

	static final Logger logger = Logger.getLogger(ExcelFileReader.class);

	public static void main(String[] args) {
		String fileName = "C:\\Users\\pierg\\git\\ItPatterns\\CBI-MAV\\scambiodati\\FILE MAV AIUOLA - 12.xls";
		Map<Integer,List<Object>> dataHolder = null;
		try{
			dataHolder = readExcel(fileName);
		}catch (Exception e) {
			// TODO: handle exception
		}
		printCellDataToConsole(dataHolder);
	}

	public static Map<Integer,List<Object>> readExcel(String fileName) throws Exception{
		Map<Integer,List<Object>> rows = new HashMap<Integer,List<Object>>();
		Workbook myWorkBook = null;
		FileInputStream myInput = null;
		try {
			boolean xlsType = true;
			if(fileName.endsWith("XLS") || fileName.endsWith("xls"))
				xlsType = true;
			else
				xlsType = false;
				myInput = new FileInputStream(fileName);
			
			try{
				if(xlsType)
					myWorkBook = new HSSFWorkbook(myInput);
				else
					myWorkBook = new XSSFWorkbook(myInput);
			}catch(Exception ex){
				ex.printStackTrace();
				logger.error(ex.getStackTrace());
			}
			Sheet mySheet = myWorkBook.getSheetAt(0);
		
			Iterator<Row> rowIter = mySheet.rowIterator();
			System.out.println(mySheet.getLastRowNum());//TODO: log
			
			int num = 0;
			while (rowIter.hasNext()) {
				
				Row myRow = (Row) rowIter.next();
				if(myRow != null){
					Iterator<Cell> cellIter = myRow.cellIterator();
					List<Object> columns = new ArrayList<Object>(myRow.getLastCellNum()-myRow.getFirstCellNum()+1);
					while (cellIter.hasNext()) {
						Cell myCell = (Cell) cellIter.next();
						if(myCell.getCellType() == Cell.CELL_TYPE_STRING){
							columns.add(myCell.getStringCellValue());
						}else if(myCell.getCellType() == Cell.CELL_TYPE_NUMERIC){
							if(HSSFDateUtil.isCellDateFormatted(myCell)) { 
								columns.add(myCell.getDateCellValue());
	                        } else {
	                        	columns.add(Double.valueOf(myCell.getNumericCellValue()));
	                        }
						}
					}
					rows.put(Integer.valueOf(num++), columns);
				}
			}
		} catch (Exception e) {
 			e.printStackTrace();
		}finally{
			myWorkBook.close();
			myInput.close();
		}
		return rows;
	}

	public static void printCellDataToConsole(Map<Integer,List<Object>> rows) {
		for (int i = 0; i < rows.size(); i++) {
			List<Object> row = (List<Object>) rows.get(Integer.valueOf(i));
			if(row != null){
				for (int j = 0; j < row.size(); j++) {
					Object column = (Object) row.get(j);
					System.out.print(column + "\t");
				}
			}
			System.out.println();
		}
	}
}
