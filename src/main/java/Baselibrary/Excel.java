package Baselibrary;

import webBase.*;

public class Excel {
	
	public static void main (String[] args) throws Exception {

	
		ExcelConfig conf=
			new ExcelConfig(System.getProperty("user.dir")+"\\Excel\\Test.xlsx");
		
		System.out.println(""+conf.getData(0, 0, 0));
		
	String abc=	System.getProperty("user.dir");
		
System.out.println(abc);
	
		int count=conf.getRowCount(0);
	
		System.out.println(count);
		
		
		int counter=0;
		
		while (count>counter) {
			
			counter=counter+1;
			System.out.println(counter);
		
		}
	

	}
	
	
}
