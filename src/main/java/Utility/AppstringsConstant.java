package Utility;



public class AppstringsConstant {
	
	
	//Televente URL
	public final static String URL="https://uat.websso.saint-gobain.com"
			+ "/cas/login?service=https%3A%2F%2Ftelevente.mutlp.test.pointp.saint-gobain.net%2Flogin";
	
	public final static String Ranking_URL="https://televente.mutlp.test.pointp.saint-gobain.net/showTelevente"
			+ "/eyJpdiI6ImFTSVlUWEs5dnhCRHA0MG1qWjJGRWc9PSIsInZhbHVlIjoiNjQ5cGlhaDlHYk9hZ0Nvd2pPdXVVUT09IiwibWFjIjoiNTk4ZDdmZDdjMzBiNTg2N2Y1ODc5OTgzNjc1MDk5MWFkYzQ2OGJkNDYwYzAyMjY0N2ZkMjNhOTdkYzBhOTFmMiJ9";
	
	// select Browser
	public final static String select_Browser="chrome";
	
	// select region
	public final static String select_region_id="14";
	
	//Page Header
		public final static String  PAGETITLE = "Télévente";
		
	//select creation Start & end month / date
 		public final static String  Start_month = "avril 2020";
 		public final static String  Start_date = "30";
 		
 		public final static String  End_month = "avril 2020";
 		public final static String  End_date = "30";
 		
 		
 	// month & date XPATHS
 		public final static String  month_xpath ="//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']/div[1]/table/thead/tr[2]/th[2]";
 		public final static String  Start_date_xpath ="//div[@class='datepicker-days']/table/tbody/tr[2]/td[1]";
 		public final static String  end_date_xpath ="//div[@class='datepicker-days']/table/tbody/tr[3]/td[1]";
 	 	
 		public final static String  Today_date_xpath ="//div[@class='datepicker-days']/table/tbody//tr/td[@class='today day']";
 		
 		public final static String  arrow_xpath ="/html/body/div[5]/div[1]/table/thead/tr[2]/th[3]";
		
	// objectiveF amount & daily objective amount
 		
 		public final static String  objectiveF ="120";
 		public final static String  dailyAmount ="20";
 		
 		
 		
 		
 		//login credentials for Admin	
			public final static String  Admin_SGID = "S4333164";
			public final static String  Admin_password = "sg!t@2020";

		//login credentials for Configurator 	
			public final static String  conf_SGID = "P8099488";
			public final static String  conf_password = "P@ssword@2020";

		//login credentials for Reader 	
			public final static String  Reader_SGID = "S4208983";
			public final static String  Reader_password = "SNK!T@2020";
		

		//login credentials for InvalidUser 	
			public final static String  invalidUser_SGID = "S4208983";
			public final static String  invalidUser_password = "SNK!T@2020";
			

	//televente creation success Message
			
	public final static String success_Message="Télévente créée avec succés";
			
			
	
	
	
	//Logout
	public final static  String LOGOUTPAGEHEADER = "LOGIN PAGE";
	public final static  String INVALIDLOGINMSG = "SSO_002: The Saint-Gobain Identifier or the password is incorrect.";
	
	//Excel
	public static final String EXCELFILEPATH = "/Users/admin/WEB/TEST/";
	public static final String EXCELFILENAME= "Test_Data.xlsx";
	public static final String EXCELLOGINSHEET= "Login";
	
	
	
	
	
}
