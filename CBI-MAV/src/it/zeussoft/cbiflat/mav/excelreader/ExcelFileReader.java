package it.zeussoft.cbiflat.mav.excelreader;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {

	static final Logger logger = Logger.getLogger(ExcelFileReader.class);

	public static void main(String[] args) {
		String fileName = "C:\\Users\\ulisse\\workspace\\CBI-MAV\\doc\\FILE MAV AIUOLA - 12.xls";
		Vector<Vector<HSSFCell>> dataHolder = null;
		try{
			dataHolder = readExcel(fileName);
		}catch (Exception e) {
			// TODO: handle exception
		}
		printCellDataToConsole(dataHolder);
	}

	public static Vector<Vector<HSSFCell>> readExcel(String fileName) throws Exception{
		Vector<Vector<HSSFCell>> cellVectorHolder = new Vector<Vector<HSSFCell>>();
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
					throw new Exception();
			}catch(Exception ex){
				logger.error(ex.getStackTrace());
			}
			Sheet mySheet = myWorkBook.getSheetAt(0);
		
			Iterator<Row> rowIter = mySheet.rowIterator();
			while (rowIter.hasNext()) {
				HSSFRow myRow = (HSSFRow) rowIter.next();
				Iterator<Cell> cellIter = myRow.cellIterator();
				Vector<HSSFCell> cellStoreVector = new Vector<HSSFCell>();
				while (cellIter.hasNext()) {
					HSSFCell myCell = (HSSFCell) cellIter.next();
					cellStoreVector.add(myCell);
				}
				cellVectorHolder.add(cellStoreVector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			myWorkBook.close();
			myInput.close();
		}
		return cellVectorHolder;
	}

	public static void printCellDataToConsole(Vector<Vector<HSSFCell>> dataHolder) {
		for (int i = 0; i < dataHolder.size(); i++) {
			Vector<HSSFCell> cellStoreVector = (Vector<HSSFCell>) dataHolder.elementAt(i);
			for (int j = 0; j < cellStoreVector.size(); j++) {
				HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
				String stringCellValue = myCell.toString();
				System.out.print(stringCellValue + "\t");
			}
			System.out.println();
		}
	}
}
