Feature: Televente Login functionality
	
	@Test1
	Scenario: verify SSO page 
	    When open chrome browser and start application
	    Then  page has been verified
	   
	@Test2   
	   Scenario: verify login functionality for Admin user 
	   	When verify username password and submit button
	    Given enter username "S4333164" and Password "sg!t@2020" for Admin user 
	    Then  Admin user should be login successfully 
	    
   @Test3
	   Scenario: verify login functionality for Reader user
	   Given enter username "P8099488" and Password "P@ssword@2020" for Reader user
	   Then Reader user should be login successfully as Reader Role
	    
   @Test4
	   Scenario: verify login functionality for invalid user
	    Given enter username "S4333164" and Password "sg!t@2020" for invalid user
	    Then Invalid user should be not be login 