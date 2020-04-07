package Baselibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
	
	sheet=wb.getSheetAt(0);
	
	String data=sheet.getRow(row).getCell(col).getStringCellValue();
	
	return data;
	}
//no.of total rows 
public int getRowCount(int sheetIndex ) {
	
int row =wb.getSheetAt(sheetIndex).getLastRowNum();
	
row=row+1;
return row;
}


}

