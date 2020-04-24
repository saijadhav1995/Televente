package webBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ExcelConfig {
	

XSSFWorkbook wb;
XSSFSheet sheet;


//to get source file
	public ExcelConfig(String filepath) throws Exception {
		
		File src =new File(filepath);
		
		FileInputStream str =new FileInputStream(src);
		
		 wb =new XSSFWorkbook(str);

		 	
		 
	}
	
// to get specific sheetno,rows & columns 	
public String getData(int sheetno,int row,int col) {
	
	DataFormatter formatter = new DataFormatter();
	
	sheet=wb.getSheetAt(sheetno);
	
	
	Cell  cell=sheet.getRow(row).getCell(col);
	
	String data = formatter.formatCellValue(cell);
	
	return data;
	}
//no.of total rows 
public int getRowCount(int sheetIndex ) {
	
int row =wb.getSheetAt(sheetIndex).getLastRowNum();
	
row=row+1;
return row;
}


}


