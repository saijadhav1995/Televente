package Utility;



public class RankingRelatedQueries {
	
	public final static String televente_name="Pascale - TLV du 2 au 31/1 - remontée en double";
	public final static String Sector_amount="122";
	public final static String Site_amount="12";
	public final static String select_sector_id="";
	public final static String select_site_id="";
	
	// Ranking Column names 
	
		public final  static String agency="Agence";

		public final  static String speciality="Spécialité";
		
		public final static String Classement="Classement";
		
		public final static String results="Résultat";
		
		public final static String article="Article";
		
		public final static String Type="Type";
		
		public final static String ATC="ATC";
		
		public final static String Nombre_clients="Nombre clients";
		
		public final static String Nombre_commandes="Nombre commandes";
		
		public final static String Montant_MBI="Montant MBI";
		
		public final static String percentage_MBI="% MBI";
		
		public final static String CDV="Chef des Ventes";
		
		public final static String Objectif="Objectif";
		
		public final static String tax="Taux";
		
		public final static String supplier_appro="Fournisseur d'approvisionnement";
		
		public final static String supplier_producer="Nom Fournisseur Producteur";
		
		public final static String Sector="Secteur";
		
		public final static String Site="Site";
		
		
		
		
	
	
	
	public final static String 
	Ranking_Total_GlobalSythesisTabQuery="SELECT COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
			"ROUND(SUM(odr.ORD_LINE_AMNT),2) AS turnover,\r\n" + 
			"REPLACE(REPLACE(FORMAT(tlvt.TLVT_OBJ_AMNT, 2), ',', SPACE(1)), '.', ',') AS TLVT_OBJ_AMNT,\r\n" + 
			"IFNULL(ROUND((SUM(odr.ORD_LINE_AMNT)/MAX(tlvt.TLVT_OBJ_AMNT)*100),2),0) AS rate,\r\n" + 
			"MAX(DATE_FORMAT(odi_data.OEX_LAST_DT,\"%d/%m/%Y %H:%i\")) AS OEX_LAST_DT\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `TELEVENTE` AS `tlvt` ON `tlvt`.`TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"LEFT JOIN (SELECT oex.OEX_LAST_DT AS OEX_LAST_DT,MAX(oex.OEX_TLVT_ID) AS OEX_TLVT_ID\r\n" + 
			"FROM odi_execution AS oex\r\n" + 
			"INNER JOIN TELEVENTE AS tlvt ON tlvt.TLVT_ID = oex.OEX_TLVT_ID\r\n" + 
			"WHERE oex.OEX_TLVT_ID = 243 GROUP BY OEX_LAST_DT ORDER BY OEX_LAST_DT DESC LIMIT 1) AS odi_data ON `odi_data`.`OEX_TLVT_ID` = `tlvt`.`TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND `odr`.`ORD_AGE_ID` \r\n" + 
			"in(161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `tlvt`.`TLVT_ID` LIMIT 1";
	
	
	
	public final static String 
	Ranking_Day_GlobalSythesisTabQuery="SELECT COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
			"ROUND(SUM(odr.ORD_LINE_AMNT),2) AS turnover,\r\n" + 
			"IFNULL(ROUND(MAX(tlvt_dobj.DOBJ_AMNT),2),0) AS TLVT_daily_OBJ_AMNT,\r\n" + 
			"IFNULL(ROUND((SUM(odr.ORD_LINE_AMNT)/MAX(tlvt_dobj.DOBJ_AMNT)*100),2),0) AS rate,\r\n" + 
			"MAX(DATE_FORMAT(odi_data.OEX_LAST_DT,\"%d/%m/%Y %H:%i\")) AS OEX_LAST_DT\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `TELEVENTE` AS `tlvt` ON `tlvt`.`TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"left JOIN daily_objective AS tlvt_dobj ON tlvt.TLVT_ID=tlvt_dobj.DOBJ_TLVT_ID and  odr.ORD_DT= tlvt_dobj.dobj_day_dt\r\n" + 
			"LEFT JOIN (SELECT oex.OEX_LAST_DT AS OEX_LAST_DT,MAX(oex.OEX_TLVT_ID) AS OEX_TLVT_ID\r\n" + 
			"FROM odi_execution AS oex\r\n" + 
			"INNER JOIN TELEVENTE AS tlvt ON tlvt.TLVT_ID = oex.OEX_TLVT_ID\r\n" + 
			"WHERE oex.OEX_TLVT_ID = 243 GROUP BY OEX_LAST_DT ORDER BY OEX_LAST_DT DESC LIMIT 1) AS odi_data \r\n" + 
			"ON `odi_data`.`OEX_TLVT_ID` = `tlvt`.`TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' AND `odr`.`ORD_AGE_ID` \r\n" + 
			"in(161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `tlvt`.`TLVT_ID` LIMIT 1";
	
	
	public static String agency_Ranking_Query="  SELECT  CONCAT(`age`.`AGE_CD`,' - ',`age`.`AGE_LB`) As agence, ROUND(SUM(odr.ORD_LINE_AMNT),2) AS ord_line_amount\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `AGENCY` AS `age` ON `age`.`AGE_ID` = `odr`.`ORD_AGE_ID`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' AND odr.ORD_BRD_ID='186' AND `odr`.`ORD_AGE_ID` in(161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `age`.`AGE_CD`, `age`.`AGE_LB` ORDER BY `ord_line_amount` DESC";
	
	public static String Article_Ranking_Query=" (SELECT `odr`.`ORD_ART_ID`, MAX(art.ART_CD)AS ART_CD,MAX(art.ART_LB)AS ART_LB,MAX(tar.TAR_TYPE)AS TAR_TYPE,ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result, 1 AS order_by\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `ARTICLE` AS `art` ON `art`.`ART_ID` = `odr`.`ORD_ART_ID`\r\n" + 
			"INNER JOIN `TLVT_ARTICLE` AS `tar` ON `tar`.`TAR_ART_ID` = `odr`.`ORD_ART_ID` AND `tar`.`TAR_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186'\r\n" + 
			"AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215) \r\n" + 
			"GROUP BY `odr`.`ORD_ART_ID`)\r\n" + 
			"UNION ALL\r\n" + 
			"(SELECT MAX(NULL) AS ORD_ART_ID,'Non Renseigné' AS ART_CD,'Non Renseigné' AS ART_LB_NR,'' AS TAR_TYPE,ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result, 0 AS order_by\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `ARTICLE` AS `art` ON `art`.`ART_ID` = `odr`.`ORD_ART_ID`\r\n" + 
			"LEFT JOIN `TLVT_ARTICLE` AS `tar` ON `tar`.`TAR_ART_ID` = `odr`.`ORD_ART_ID` AND `tar`.`TAR_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186'\r\n" + 
			"AND TAR_ART_ID IS NULL AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215) \r\n" + 
			"GROUP BY `ART_LB_NR`) ORDER BY `order_by` DESC, `result` DESC";
	
	
	public static String RankingBySellers_Query="SELECT `odr`.`ORD_SEL_CD`,IFNULL(`tsl`.`TSL_NAME`,''), ROUND(SUM(odr.ORD_LINE_AMNT),2) AS ord_line_amount\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND  odr.ORD_DT='2020-01-8' AND odr.ORD_BRD_ID='186' AND `odr`.`ORD_AGE_ID`\r\n" + 
			"IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `odr`.`ORD_SEL_CD`, `tsl`.`TSL_NAME` ORDER BY `ord_line_amount` DESC";
	
	
	public static String RankingBySellersAndNoOFCutomers_Query=" SELECT `odr`.`ORD_SEL_CD`, `tsl`.`TSL_NAME`, ROUND(SUM(odr.ORD_LINE_AMNT),2) AS ord_line_amount,COUNT(DISTINCT odr.ORD_CLT_CD) AS total_customers\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND  odr.ORD_DT='2020-01-8' AND odr.ORD_BRD_ID='186' AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			" GROUP BY `odr`.`ORD_SEL_CD`, `tsl`.`TSL_NAME` ORDER BY `total_customers` DESC, `ord_line_amount` DESC";
	
	
	
	public static String RankingBySellersAndDistinctOrders_Query="	SELECT `odr`.`ORD_SEL_CD`, `tsl`.`TSL_NAME`, ROUND(SUM(odr.ORD_LINE_AMNT),2) AS ord_line_amount,COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders\r\n" + 
			"	FROM `Orders` AS `odr`\r\n" + 
			"	LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"	WHERE `odr`.`ORD_TLVT_ID` = '243' AND  odr.ORD_DT='2020-01-8' AND odr.ORD_BRD_ID='186' AND `odr`.`ORD_AGE_ID` IN \r\n" + 
			"	(161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"	1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"	1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			"	,2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"	 GROUP BY `odr`.`ORD_SEL_CD`, `tsl`.`TSL_NAME` ORDER BY `total_orders` DESC, `ord_line_amount` DESC";
	
	
	public static String RankingBySellers_RegionalArticles_Query=" SELECT `odr`.`ORD_SEL_CD`, `tsl`.`TSL_NAME`, ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `TLVT_ARTICLE` AS `tar` ON `tar`.`TAR_ART_ID` = `odr`.`ORD_ART_ID` AND `tar`.`TAR_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND  odr.ORD_DT='2020-01-8' AND odr.ORD_BRD_ID='186' AND `tar`.`TAR_TYPE` = 'R' AND `odr`.`ORD_AGE_ID` IN \r\n" + 
			"(161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"	1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"	1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			"	,2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			" GROUP BY `odr`.`ORD_SEL_CD`, `tsl`.`TSL_NAME` ORDER BY `result` DESC";
	
	
	
	public static String RankingBySellers_NationalArticles_Query=" SELECT `odr`.`ORD_SEL_CD`, `tsl`.`TSL_NAME`, ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `TLVT_ARTICLE` AS `tar` ON `tar`.`TAR_ART_ID` = `odr`.`ORD_ART_ID` AND `tar`.`TAR_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND  odr.ORD_DT='2020-01-8' AND odr.ORD_BRD_ID='186' AND `tar`.`TAR_TYPE` = 'N' AND `odr`.`ORD_AGE_ID` IN \r\n" + 
			"(161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"	1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"	1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			"	,2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			" GROUP BY `odr`.`ORD_SEL_CD`, `tsl`.`TSL_NAME` ORDER BY `result` DESC";
	
	
	public static String RankingBySellersMBI_Query="SELECT `odr`.`ORD_SEL_CD`,ifnull(`tsl`.`TSL_NAME`,''), ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result,"
			+ "COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS TOTAL_ORDERS,\r\n" + 
			"ROUND(SUM(odr.ORD_MARGIN_AMNT),2) AS ORD_MARGIN_AMNT,IFNULL(ROUND((SUM(odr.ORD_MARGIN_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2),0) AS ORD_MARGIN_PERCT\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186' AND `odr`.`ORD_AGE_ID` IN \r\n" + 
			"(161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `odr`.`ORD_SEL_CD`, `tsl`.`TSL_NAME` "
			+ "ORDER BY `ORD_MARGIN_AMNT` DESC, `ORD_MARGIN_PERCT` DESC, `TOTAL_ORDERS` DESC, `result` DESC";
	
	public static String rankingByManager_Query=" SELECT `tsm`.`TSM_CD`, `tsm`.`TSM_NAME`, ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result,COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
			"IFNULL(MAX(tsm.TSM_OBJ_AMNT),0.00) AS tsm_objective,IFNULL(ROUND((SUM(odr.ORD_LINE_AMNT)/MAX(tsm.TSM_OBJ_AMNT)*100),2),0) AS rate,MAX(tsm.TSM_ID) AS TSM_ID\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"INNER JOIN `TLVT_SELL_MANAGER` AS `tsm` ON `tsm`.`TSM_ID` = `tsl`.`TSL_SEM_ID` AND `tsm`.`TSM_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186' \r\n" + 
			"AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `tsm`.`TSM_CD`, `tsm`.`TSM_NAME` ORDER BY `result` DESC, `total_orders` DESC, `rate` DESC, `tsm_objective` DESC";
	
	
	public static String RankingBySupplierAppro_Query="SELECT `supp`.`SUPP_CD`, `supp`.`SUPP_NAME`, ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result, 1 order_by\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `SUPPLIER_PVD` AS `supp` ON `supp`.`SUPP_ID` = `odr`.`ORD_SUPP_ID`\r\n" + 
			"INNER JOIN `TLVT_SUPPLIER_PVD` AS `tspp` ON `tspp`.`TSpP_SUPP_ID` = `supp`.`SUPP_ID` AND `tspp`.`TSPP_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186' \r\n" + 
			"AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `supp`.`SUPP_CD`\r\n" + 
			"UNION ALL\r\n" + 
			"SELECT 'Non Renseigné' AS  SUPP_CD, 'Non Renseigné' AS SUPP_NAME_NR, ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result, 0 order_by\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `SUPPLIER_PVD` AS `supp` ON `supp`.`SUPP_ID` = `odr`.`ORD_SUPP_ID`\r\n" + 
			"LEFT JOIN `TLVT_SUPPLIER_PVD` AS `tspp` ON `tspp`.`TSPP_SUPP_ID` = `supp`.`SUPP_ID` AND `tspp`.`TSPP_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186' \r\n" + 
			"AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215) AND TSPP_SUPP_ID IS NULL\r\n" + 
			"GROUP BY SUPP_NAME_NR\r\n" + 
			"ORDER BY order_by desc,`result` DESC";
	
	public static String RankingBySupplierProducer_Query="SELECT  MAX(supl.SUPL_CD)AS SUPL_CD,MAX(supl.SUPL_NAME)AS SUPL_NAME,ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result,1 order_by\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `ARTICLE` AS `art` ON `art`.`ART_ID` = `odr`.`ORD_ART_ID`\r\n" + 
			"INNER JOIN `SUPPLIER` AS `supl` ON `supl`.`SUPL_ID` = `art`.`art_SUPL_ID`\r\n" + 
			"INNER JOIN `TLVT_SUPPLIER` AS `tsup` ON `tsup`.`TSUP_SUPL_ID` = `supl`.`SUPL_ID` AND `tsup`.`TSUP_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186' \r\n" + 
			"AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `supl`.`SUPL_ID`\r\n" + 
			"UNION ALL\r\n" + 
			"SELECT 'Non Renseigné'AS SUPL_CD,'Non Renseigné'AS SUPL_NAME_NR,ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result, 0 order_by\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `ARTICLE` AS `art` ON `art`.`ART_ID` = `odr`.`ORD_ART_ID`\r\n" + 
			"INNER JOIN `SUPPLIER` AS `supl` ON `supl`.`SUPL_ID` = `art`.`art_SUPL_ID`\r\n" + 
			"LEFT JOIN `TLVT_SUPPLIER` AS `tsup` ON `tsup`.`TSUP_SUPL_ID` = `supl`.`SUPL_ID` AND `tsup`.`TSUP_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186' \r\n" + 
			"AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215) AND TSUP_SUPL_ID IS NULL\r\n" + 
			"GROUP BY SUPL_NAME_NR\r\n" + 
			"ORDER BY order_by desc,`result` DESC";
	
	
	public static String RankingBySector_Query="SELECT `SECTOR`.`SEC_ID`, MAX(SECTOR.SEC_CD) AS SEC_CD,MAX(SECTOR.SEC_LB) AS SEC_LB,ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result,\r\n" + 
			"IFNULL(MAX(tse.TSE_OBJ_AMNT),0.00) AS sector_objective,IFNULL(ROUND((SUM(odr.ORD_LINE_AMNT)/MAX(tse.TSE_OBJ_AMNT)*100),2),0.00) AS rate\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `SECTOR` ON `SECTOR`.`SEC_ID` = `odr`.`ORD_SEC_ID`\r\n" + 
			"LEFT JOIN `TLVT_SECTOR` AS `tse` ON `tse`.`TSE_SEC_ID` = `SECTOR`.`SEC_ID` AND `tse`.`TSE_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186' \r\n" + 
			"AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `SECTOR`.`SEC_ID` ORDER BY `result` DESC";
	
	public static String RankingBySite_Query="SELECT `SITE`.`SIT_ID`, MAX(SITE.SIT_CD) AS SIT_CD,MAX(SITE.SIT_LB) AS SIT_LB,ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result,\r\n" + 
			"IFNULL(MAX(tsi.TSI_OBJ_AMNT),0.00) AS site_objective,IFNULL(ROUND((SUM(odr.ORD_LINE_AMNT)/MAX(tsi.TSI_OBJ_AMNT)*100),2),0.00) AS rate\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `SITE` ON `SITE`.`SIT_ID` = `odr`.`ORD_SIT_ID`\r\n" + 
			"LEFT JOIN `TLVT_SITE` AS `tsi` ON `tsi`.`TSI_SIT_ID` = `odr`.`ORD_SIT_ID` AND `tsi`.`TSI_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186'  \r\n" + 
			"AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `SITE`.`SIT_ID` ORDER BY `result` DESC";
	
	public static String RankingBySpeciality_Query="SELECT `spe`.`SPE_LB`, ROUND(SUM(odr.ORD_LINE_AMNT),2) AS result\r\n" + 
			"FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `SPECIALITY` AS `spe` ON `spe`.`SPE_ID` = `odr`.`ORD_SPE_ID`\r\n" + 
			"LEFT JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_ID` = `odr`.`ORD_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-8' and odr.ORD_BRD_ID='186'  \r\n" + 
			"AND `odr`.`ORD_AGE_ID` IN (161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `spe`.`SPE_LB` ORDER BY `result` DESC";
	
	
}
