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
			"WHERE `odr`.`ORD_TLVT_ID` = '243' AND odr.ORD_DT='2020-01-7' AND `odr`.`ORD_AGE_ID` \r\n" + 
			"in(161,176,199,314,411,501,540,605,692,731,788,855,909,930,979,1022,\r\n" + 
			"1079,1089,1121,1284,1381,1392,1398,1463,1545,1584,1596,1624,1672,1746,\r\n" + 
			"1817,1830,1883,1979,2133,2171,2175,2212,2324,2437,2483,2561,2743,2756,2777\r\n" + 
			",2801,2865,2962,2974,3012,3032,3056,3097,3102,3249,3315,3526,3626,3705,3708,3745,3802,3851,3870,3977,4016,4098,4215)\r\n" + 
			"GROUP BY `tlvt`.`TLVT_ID` LIMIT 1";
	
	
	
	
}
