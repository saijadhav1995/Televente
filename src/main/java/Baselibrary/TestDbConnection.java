package Baselibrary;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import webBase.BasePage;
import webBase.DataBase;


public class TestDbConnection extends DataBase {

	
	@Test
	public void selectDBdata(String query) throws ClassNotFoundException, SQLException{
		
		DataBase dataBase = new DataBase();
		ResultSet data = dataBase.getData(query);
		System.out.println(data);
		while(data.next()){
			System.out.println(data.getString(1)+"| "+data.getString(2)+"| "+data.getString(3)+"| "+data.getString(4)
			+" "+data.getString(5)+"| "+data.getString(6)+"| "+data.getString(7)+"| "+data.getString(8));
		}
		
		
		/*
		if(textData.contains(data.getString(1))){
			
		}
		*/
	}
	
	
	/*public void insertDBdata() throws ClassNotFoundException, SQLException{
		String query = "insert into usr values('56','1','QA','jadhav123','sai@gmail.com','Y','A1233456','2020-04-07 06:33:22')";
		DataBase dataBase = new DataBase();
		dataBase.insertData(query);	
	}*/
	
	/*@Test
	public void updateDBdata() throws ClassNotFoundException, SQLException{
		String query = "update usr set usr_firstname='56777' where usr_id='23'";
		DataBase dataBase = new DataBase();
		dataBase.updateData(query);
		
	}*/

}
	

