package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ExcelConfig {
	

XSSFWorkbook wb;
XSSFSheet sheet;

	public ExcelConfig(String filepath) throws Exception {
		
		File src =new File(filepath);
		
		FileInputStream str =new FileInputStream(src);
		
		 wb =new XSSFWorkbook(str);

		 	
		 
	}
public String getData(int sheetno,int row,int col) {
	
	sheet=wb.getSheetAt(0);
	
	String data=sheet.getRow(row).getCell(col).getStringCellValue();
	
	return data;
	}
public int getRowCount(int sheetIndex ) {
	
int row =wb.getSheetAt(sheetIndex).getLastRowNum();
	
row=row+1;
return row;
}


}


