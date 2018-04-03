package utilities;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadExcel {
	
	public static FileInputStream fis;
	public static HSSFWorkbook wb;
	public static HSSFSheet ws;
	public static HSSFRow   row;
	public static HSSFCell cell;
	static Map<String,String> allData = new HashMap<String,String>();

	public static void InsertExcelDataIntoMap(String datasetColNum){
		
		try {
			fis = new FileInputStream("data/RetailDemo_DataSheet.xls");
			wb = new HSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ws = wb.getSheet("datasheet");
		
		for(int i = 1; i < ws.getPhysicalNumberOfRows(); i++){
			row = ws.getRow(i);
			String key = row.getCell(0).toString();
			DataFormatter df = new DataFormatter();
			String value = df.formatCellValue(row.getCell(Integer.parseInt(datasetColNum)));
			allData.put(key, value);
		}
	}
	
	public static String GetDataFromExcel(String key){
		String value = null;
		if(allData.containsKey(key))
			value = allData.get(key);
		
		return value;
	}
}