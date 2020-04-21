package Utility;



public class RankingRelatedQueries {
	
	
	public final static String Sector_amount="122";
	public final static String Site_amount="12";
	public final static String select_sector_id="";
	public final static String select_site_id="";
	
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
	
	
}
