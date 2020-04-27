package Utility;

import java.util.ArrayList;

public class BillingRelatedQueries {

	
	public static final String Billing_page_Url="https://televente.mutlp.test.pointp.saint-gobain.net/"
			+ "televenteBilling/eyJpdiI6IldNUUxhYWJtclJhY25HMVVqZnQ5YWc9PSIsInZhbHVlIjoiSzVKeklVSmNqeUtNbG9uY0s1Z041dz09IiwibWFjIjoiMTliZmUxOTg3MDY4NzQ5MmZmZj"
			+ "E1MWZmZTQwZTBmYTY0N2I2YmExNzg5MWNhMTQxNWQ5ZDdjNWZlYjQ5NWMwYiJ9";
	
	
	public static final String televente_name="Suivi Facturation-Pascale - TLV du 2 au 31/1 - remontée en double";
	
	public static final String sector_id ="321";
	
	public static final String SellManager_id="1431";
	
	public static final  String Sellers_id="4822";
	
	public static final String site_id="18";
	
	public static final String agency_id="2756";
	
	
	
	
	
	
	
	
	
	
	
    
    
    
	public static final String BillingSynthesis_Query="SELECT ROUND((SUM(mrg.MRG_INV_TOV_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2) AS matching_rate, \r\n" + 
			"COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
			"ROUND(SUM(odr.ORD_LINE_AMNT),2) AS orders_turnover,\r\n" + 
			"COUNT(DISTINCT mrg.MRG_ORD_CD,mrg.MRG_DN_AGE_ID) AS order_with_invoices,\r\n" + 
			"ROUND(SUM(mrg.MRG_INV_TOV_AMNT),2) AS order_with_invoices_turnover,MAX(merger_art.articles_invoices_turnover) \r\n" + 
			"AS articles_invoices_turnover,MAX(merger_art.articles_invoices_margin) AS articles_invoices_margin,\r\n" + 
			"MAX(merger_art.articles_invoices_margin_perc) AS articles_invoices_margin_perc,\r\n" + 
			"MAX(merger_art.MRG_TLVT_ID) AS MRG_TLVT_ID FROM `Orders` AS `odr`\r\n" + 
			"INNER JOIN `TELEVENTE` AS `tlvt` ON `tlvt`.`TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"LEFT JOIN `merger` AS `mrg` ON `mrg`.`MRG_TLVT_ID` = `odr`.`ORD_TLVT_ID` AND\r\n" + 
			" `mrg`.`MRG_ORD_CD` = `odr`.`ORD_CD` AND `mrg`.`MRG_ORD_LINE` = `odr`.`ORD_LINE`\r\n" + 
			" AND `mrg`.`MRG_DN_AGE_ID` = `odr`.`ORD_AGE_ID`\r\n" + 
			"LEFT JOIN (SELECT MAX(mrg2.MRG_TLVT_ID) AS MRG_TLVT_ID, ROUND(SUM(mrg2.MRG_INV_TOV_AMNT),2) AS articles_invoices_turnover,\r\n" + 
			"ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT)),2) AS articles_invoices_margin,\r\n" + 
			"ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT))*100,2) AS articles_invoices_margin_perc\r\n" + 
			"FROM merger AS mrg2\r\n" + 
			"INNER JOIN tlvt_article AS tar ON tar.TAR_TLVT_ID = mrg2.MRG_TLVT_ID AND tar.TAR_ART_ID = mrg2.MRG_ART_ID\r\n" + 
			"WHERE mrg2.mrg_tlvt_id ='243') AS merger_art ON `merger_art`.`MRG_TLVT_ID` = `tlvt`.`TLVT_ID`\r\n" + 
			"WHERE `tlvt`.`TLVT_ID` ='243' GROUP BY `tlvt`.`TLVT_ID` LIMIT 1";
	
	
	public static final String SellViewOfSector_Query="SELECT concat(MAX(sec.SEC_CD),'-',MAX(sec.SEC_LB)) as SectorLabel,ROUND((SUM(mrg.MRG_INV_TOV_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2) AS matching_rate,\r\n" + 
			"COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
			"ROUND(SUM(odr.ORD_LINE_AMNT),2) AS orders_turnover,\r\n" + 
			"COUNT(DISTINCT mrg.MRG_ORD_CD,mrg.MRG_DN_AGE_ID) AS order_with_invoices,\r\n" + 
			"ROUND(SUM(mrg.MRG_INV_TOV_AMNT),2) AS order_with_invoices_turnover,MAX(merger_art.articles_invoices_turnover) AS articles_invoices_turnover,\r\n" + 
			"MAX(merger_art.articles_invoices_margin) AS articles_invoices_margin,MAX(merger_art.articles_invoices_margin_perc) AS articles_invoices_margin_perc,\r\n" + 
			"MAX(merger_art.merger_art.MRG_DN_SEC_ID) AS MRG_DN_SEC_ID\r\n" + 
			"FROM `SECTOR` AS `sec`\r\n" + 
			"INNER JOIN `Orders` AS `odr` ON `odr`.`ORD_SEC_ID` = `sec`.`SEC_ID`\r\n" + 
			"INNER JOIN `TELEVENTE` AS `tlvt` ON `tlvt`.`TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
			"LEFT JOIN `merger` AS `mrg` ON `mrg`.`MRG_TLVT_ID` = `odr`.`ORD_TLVT_ID` AND `mrg`.`MRG_ORD_CD` = `odr`.`ORD_CD` AND `mrg`.`MRG_ORD_LINE` = `odr`.`ORD_LINE` AND `mrg`.`MRG_DN_AGE_ID` = `odr`.`ORD_AGE_ID`\r\n" + 
			"LEFT JOIN (SELECT  MAX(mrg2.MRG_DN_SEC_ID) AS MRG_DN_SEC_ID,ROUND(SUM(mrg2.MRG_INV_TOV_AMNT),2) AS articles_invoices_turnover,\r\n" + 
			"ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT)),2) AS articles_invoices_margin,\r\n" + 
			"ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT))*100,2) AS articles_invoices_margin_perc\r\n" + 
			"FROM merger AS mrg2\r\n" + 
			"INNER JOIN tlvt_article AS tar ON tar.TAR_TLVT_ID = mrg2.MRG_TLVT_ID AND tar.TAR_ART_ID = mrg2.MRG_ART_ID\r\n" + 
			"WHERE mrg2.mrg_tlvt_id = 243 AND mrg2.MRG_DN_SEC_ID = '321'  GROUP BY mrg2.MRG_DN_SEC_ID) AS merger_art ON `merger_art`.`MRG_DN_SEC_ID` = `sec`.`SEC_ID`\r\n" + 
			"WHERE `tlvt`.`TLVT_ID` = '243' AND `sec`.sec_id=321  GROUP BY `sec`.`SEC_ID` ORDER BY `sec`.`SEC_CD` ASC, `sec`.`SEC_LB` ASC";
	
	
	
public static final String SellView_sellManagerRelated_Query="SELECT concat(MAX(tsm.TSM_CD),'-',MAX(tsm.tsm_name)) AS tsm_name,ROUND((SUM(mrg.MRG_INV_TOV_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2) AS matching_rate,\r\n" + 
		"COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
		"ROUND(SUM(odr.ORD_LINE_AMNT),2) AS orders_turnover,\r\n" + 
		"COUNT(DISTINCT mrg.MRG_ORD_CD,mrg.MRG_DN_AGE_ID) AS order_with_invoices,\r\n" + 
		"ROUND(SUM(mrg.MRG_INV_TOV_AMNT),2) AS order_with_invoices_turnover,\r\n" + 
		"MAX(merger_art.articles_invoices_turnover) AS articles_invoices_turnover,MAX(merger_art.articles_invoices_margin) AS articles_invoices_margin,MAX(merger_art.articles_invoices_margin_perc) AS articles_invoices_margin_perc,MAX(merger_art.MART_TSM_ID) AS MART_TSM_ID\r\n" + 
		"FROM `TLVT_SELL_MANAGER` AS `tsm`\r\n" + 
		"INNER JOIN `TLVT_SELLER` AS `tsl` ON `tsl`.`TSL_SEM_ID` = `tsm`.`TSM_ID` AND `tsl`.`TSL_TLVT_ID` = `tsm`.`TSM_TLVT_ID`\r\n" + 
		"INNER JOIN `orders` AS `odr` ON `odr`.`ORD_TSL_ID` = `tsl`.`TSL_ID` AND `odr`.`ORD_TLVT_ID` = `tsl`.`TSL_TLVT_ID` AND `odr`.`ORD_SEC_ID` = `tsm`.`TSM_SEC_ID`\r\n" + 
		"INNER JOIN `TELEVENTE` AS `tlvt` ON `tlvt`.`TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
		"LEFT JOIN `merger` AS `mrg` ON `mrg`.`MRG_TLVT_ID` = `odr`.`ORD_TLVT_ID` AND `mrg`.`MRG_ORD_CD` = `odr`.`ORD_CD` AND `mrg`.`MRG_ORD_LINE` = `odr`.`ORD_LINE` AND `mrg`.`MRG_DN_AGE_ID` = `odr`.`ORD_AGE_ID`\r\n" + 
		"LEFT JOIN (SELECT MAX(tsm2.TSM_ID) AS MART_TSM_ID,\r\n" + 
		" ROUND(SUM(mrg2.MRG_INV_TOV_AMNT),2) AS articles_invoices_turnover,\r\n" + 
		" ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT)),2) AS articles_invoices_margin,\r\n" + 
		" ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT))*100,2) AS articles_invoices_margin_perc\r\n" + 
		"FROM merger AS mrg2\r\n" + 
		"INNER JOIN tlvt_article AS tar ON tar.TAR_TLVT_ID = mrg2.MRG_TLVT_ID AND tar.TAR_ART_ID = mrg2.MRG_ART_ID\r\n" + 
		"INNER JOIN tlvt_seller AS tsl2 ON tsl2.TSL_TLVT_ID = mrg2.MRG_TLVT_ID AND tsl2.TSL_ID = mrg2.MRG_TSL_ID\r\n" + 
		"INNER JOIN tlvt_sell_manager AS tsm2 ON tsm2.TSM_TLVT_ID = tsl2.TSL_TLVT_ID AND tsm2.TSM_ID = tsl2.TSL_SEM_ID\r\n" + 
		"WHERE mrg2.mrg_tlvt_id = 243 AND mrg2.MRG_DN_SEC_ID = '321' and tsm2.tsm_id='1431'  GROUP BY tsm2.TSM_ID) AS merger_art ON `merger_art`.`MART_TSM_ID` = `tsm`.`TSM_ID`\r\n" + 
		"WHERE `tsm`.`TSM_SEC_ID` = '321' AND `tlvt`.`TLVT_ID` = '243' AND tsm.tsm_id='1431'\r\n" + 
		" GROUP BY `tsm`.`TSM_ID` ORDER BY `tsm`.`TSM_CD` ASC, `tsm`.`tsm_name` ASC";
	
	
public static final String SellView_sellersRelated_Query="SELECT concat(MAX(mrg.MRG_SEL_CD) ,'-',MAX(tsl.tsl_name)) AS tsl_name, ROUND((SUM(mrg.MRG_INV_TOV_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2) AS matching_rate,\r\n" + 
		"    COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
		"    ROUND(SUM(odr.ORD_LINE_AMNT),2) AS orders_turnover,\r\n" + 
		"    COUNT(DISTINCT mrg.MRG_ORD_CD,mrg.MRG_DN_AGE_ID) AS order_with_invoices,\r\n" + 
		"	ROUND(SUM(mrg.MRG_INV_TOV_AMNT),2) AS order_with_invoices_turnover,\r\n" + 
		"    MAX(merger_art.articles_invoices_turnover) AS articles_invoices_turnover,\r\n" + 
		"    MAX(merger_art.articles_invoices_margin) AS articles_invoices_margin,\r\n" + 
		"	MAX(merger_art.articles_invoices_margin_perc) AS articles_invoices_margin_perc,\r\n" + 
		"    MAX(merger_art.MRG_TLVT_ID) AS MRG_TLVT_ID,merger_art.MRG_DN_AGE_ID\r\n" + 
		"	FROM `tlvt_seller` AS `tsl`\r\n" + 
		"	INNER JOIN `TLVT_SELL_MANAGER` AS `tsm` ON `tsm`.`TSM_ID` = `tsl`.`TSL_SEM_ID` AND `tsm`.`TSM_TLVT_ID` = `tsl`.`TSL_TLVT_ID`\r\n" + 
		"	INNER JOIN `orders` AS `odr` ON `odr`.`ORD_TSL_ID` = `tsl`.`TSL_ID` AND `odr`.`ORD_TLVT_ID` = `tsl`.`TSL_TLVT_ID` AND `odr`.`ORD_SEC_ID` = `tsm`.`TSM_SEC_ID`\r\n" + 
		"	INNER JOIN `TELEVENTE` AS `tlvt` ON `tlvt`.`TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
		"	LEFT JOIN `merger` AS `mrg` ON `mrg`.`MRG_TLVT_ID` = `odr`.`ORD_TLVT_ID` AND `mrg`.`MRG_ORD_CD` = `odr`.`ORD_CD` AND `mrg`.`MRG_ORD_LINE` = `odr`.`ORD_LINE` AND `mrg`.`MRG_DN_AGE_ID` = `odr`.`ORD_AGE_ID`\r\n" + 
		"	LEFT JOIN (SELECT MAX(mrg2.MRG_TLVT_ID) AS MRG_TLVT_ID,mrg2.MRG_DN_AGE_ID, MAX(mrg2.MRG_TSL_ID) AS MRG_TSL_ID,\r\n" + 
		"    ROUND(SUM(mrg2.MRG_INV_TOV_AMNT),2) AS articles_invoices_turnover,\r\n" + 
		"    ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT)),2) AS articles_invoices_margin,\r\n" + 
		"    ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT))*100,2) AS articles_invoices_margin_perc\r\n" + 
		"	FROM merger AS mrg2\r\n" + 
		"	INNER JOIN tlvt_article AS tar ON tar.TAR_TLVT_ID = mrg2.MRG_TLVT_ID AND tar.TAR_ART_ID = mrg2.MRG_ART_ID\r\n" + 
		"    INNER JOIN tlvt_seller AS tsl2 ON tsl2.TSL_TLVT_ID = mrg2.MRG_TLVT_ID AND tsl2.TSL_ID = mrg2.MRG_TSL_ID\r\n" + 
		"	INNER JOIN tlvt_sell_manager AS tsm2 ON tsm2.TSM_TLVT_ID = tsl2.TSL_TLVT_ID AND tsm2.TSM_ID = tsl2.TSL_SEM_ID\r\n" + 
		"	WHERE mrg2.mrg_tlvt_id = 243 AND mrg2.MRG_DN_SEC_ID = 321 and tsm2.tsm_id='1431' GROUP BY mrg2.MRG_TSL_ID) AS merger_art ON `merger_art`.`MRG_TSL_ID` = `tsl`.`TSL_ID`\r\n" + 
		"	WHERE `tsl`.`TSL_SEM_ID` = '1431' AND `tlvt`.`TLVT_ID` = '243' AND mrg.MRG_DN_SEC_ID = 321 GROUP BY `tsl`.`TSL_ID` ORDER BY `mrg`.`MRG_SEL_CD` ASC, `tsl`.`tsl_name` ASC";	


public static final String SellView_CustomerRelated_Query="SELECT concat((mrg.MRG_CLI_CD) ,'-',MAX(mrg.MRG_CLI_LB)) AS MRG_CLI_LB,\r\n" + 
		"ROUND((SUM(mrg.MRG_INV_TOV_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2) AS matching_rate,\r\n" + 
		"COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
		"ROUND(SUM(odr.ORD_LINE_AMNT),2) AS orders_turnover,\r\n" + 
		"COUNT(DISTINCT mrg.MRG_ORD_CD,mrg.MRG_DN_AGE_ID) AS order_with_invoices,\r\n" + 
		"ROUND(SUM(mrg.MRG_INV_TOV_AMNT),2) AS order_with_invoices_turnover,\r\n" + 
		"ifnull((merger_art.articles_invoices_turnover),0.00) AS articles_invoices_turnover,\r\n" + 
		"ifnull((merger_art.articles_invoices_margin),0.00) AS articles_invoices_margin,\r\n" + 
		"ifnull((merger_art.articles_invoices_margin_perc),0.00) AS articles_invoices_margin_perc,\r\n" + 
		"MAX(merger_art.MART_MRG_CLI_CD) AS MART_MRG_CLI_CD,MAX(merger_art.MART_MRG_CLI_LB) AS MART_MRG_CLI_LB\r\n" + 
		"FROM `merger` AS `mrg`\r\n" + 
		"INNER JOIN `tlvt_seller` AS `tsl` ON `tsl`.`TSL_ID` = `mrg`.`MRG_TSL_ID` AND `tsl`.`TSL_TLVT_ID` = `mrg`.`MRG_TLVT_ID`\r\n" + 
		"INNER JOIN `TLVT_SELL_MANAGER` AS `tsm` ON `tsm`.`TSM_ID` = `tsl`.`TSL_SEM_ID` AND `tsm`.`TSM_TLVT_ID` = `tsl`.`TSL_TLVT_ID` AND `tsm`.`TSM_SEC_ID` = `mrg`.`MRG_DN_SEC_ID`\r\n" + 
		"INNER JOIN `TELEVENTE` AS `tlvt` ON `tlvt`.`TLVT_ID` = `mrg`.`MRG_TLVT_ID`\r\n" + 
		"LEFT JOIN `Orders` AS `odr` ON `mrg`.`MRG_TLVT_ID` = `odr`.`ORD_TLVT_ID` AND `mrg`.`MRG_ORD_CD` = `odr`.`ORD_CD` AND `mrg`.`MRG_ORD_LINE` = `odr`.`ORD_LINE` AND `mrg`.`MRG_DN_AGE_ID` = `odr`.`ORD_AGE_ID`\r\n" + 
		"LEFT JOIN (SELECT MAX(mrg2.MRG_TLVT_ID) AS MRG_TLVT_ID, MAX(mrg2.MRG_CLI_CD) AS MART_MRG_CLI_CD, MAX(mrg2.MRG_CLI_LB) AS MART_MRG_CLI_LB, ROUND(SUM(mrg2.MRG_INV_TOV_AMNT),2) AS articles_invoices_turnover,ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT)),2) AS articles_invoices_margin,ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT))*100,2) AS articles_invoices_margin_perc\r\n" + 
		"FROM merger AS mrg2\r\n" + 
		"INNER JOIN tlvt_article AS tar ON tar.TAR_TLVT_ID = mrg2.MRG_TLVT_ID AND tar.TAR_ART_ID = mrg2.MRG_ART_ID\r\n" + 
		"WHERE mrg2.mrg_tlvt_id = 243 AND mrg2.MRG_DN_AGE_ID = 1596 GROUP BY mrg2.MRG_CLI_CD,mrg2.MRG_CLI_LB) AS merger_art ON `merger_art`.`MART_MRG_CLI_CD` = `mrg`.`MRG_CLI_CD` AND `merger_art`.`MART_MRG_CLI_LB` = `mrg`.`MRG_CLI_LB`\r\n" + 
		"WHERE `tsl`.`TSL_ID` = '4822' AND `tlvt`.`TLVT_ID` = '243' GROUP BY `mrg`.`MRG_CLI_CD`, `mrg`.`MRG_CLI_LB` ORDER BY `mrg`.`MRG_CLI_CD` ASC, `mrg`.`MRG_CLI_LB` ASC";



public static final String GeographicViewForSite_Query="SELECT concat(MAX(sit.SIT_CD) ,'-',MAX(sit.SIT_LB)) AS SIT_LB, ROUND((SUM(mrg.MRG_INV_TOV_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2) AS matching_rate,\r\n" + 
		" COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
		" ROUND(SUM(odr.ORD_LINE_AMNT),2) AS orders_turnover,\r\n" + 
		" COUNT(DISTINCT mrg.MRG_ORD_CD,mrg.MRG_DN_AGE_ID) AS order_with_invoices,\r\n" + 
		"ROUND(SUM(mrg.MRG_INV_TOV_AMNT),2) AS order_with_invoices_turnover,\r\n" + 
		"MAX(merger_art.articles_invoices_turnover) AS articles_invoices_turnover,\r\n" + 
		"MAX(merger_art.articles_invoices_margin) AS articles_invoices_margin,\r\n" + 
		"MAX(merger_art.articles_invoices_margin_perc) AS articles_invoices_margin_perc,\r\n" + 
		"MAX(merger_art.MRG_DN_SIT_ID) AS MRG_DN_SIT_ID\r\n" + 
		"FROM `SITE` AS `sit`\r\n" + 
		"INNER JOIN `Orders` AS `odr` ON `odr`.`ORD_SIT_ID` = `sit`.`SIT_ID`\r\n" + 
		"INNER JOIN `TELEVENTE` AS `tlvt` ON `tlvt`.`TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
		"LEFT JOIN `merger` AS `mrg` ON `mrg`.`MRG_TLVT_ID` = `odr`.`ORD_TLVT_ID` AND `mrg`.`MRG_ORD_CD` = `odr`.`ORD_CD` AND `mrg`.`MRG_ORD_LINE` = `odr`.`ORD_LINE` AND `mrg`.`MRG_DN_AGE_ID` = `odr`.`ORD_AGE_ID`\r\n" + 
		"LEFT JOIN (SELECT MAX(mrg2.MRG_TLVT_ID) AS MRG_TLVT_ID, MAX(mrg2.MRG_DN_SIT_ID) AS MRG_DN_SIT_ID,ROUND(SUM(mrg2.MRG_INV_TOV_AMNT),2) AS articles_invoices_turnover,ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT)),2) AS articles_invoices_margin,ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT))*100,2) AS articles_invoices_margin_perc\r\n" + 
		"FROM merger AS mrg2\r\n" + 
		"INNER JOIN tlvt_article AS tar ON tar.TAR_TLVT_ID = mrg2.MRG_TLVT_ID AND tar.TAR_ART_ID = mrg2.MRG_ART_ID\r\n" + 
		"WHERE mrg2.mrg_tlvt_id = 243 AND mrg2.MRG_DN_SEC_ID = 321 and mrg2.mrg_dn_sit_id=18 GROUP BY mrg2.MRG_DN_SIT_ID) AS merger_art ON `merger_art`.`MRG_DN_SIT_ID` = `sit`.`SIT_ID`\r\n" + 
		"WHERE `sit`.`SIT_SEC_ID` = '321' AND `tlvt`.`TLVT_ID` = '243' and `sit`.`SIT_ID`=18 GROUP BY `sit`.`SIT_ID` ORDER BY `sit`.`SIT_CD` ASC, `sit`.`SIT_LB` ASC";

	
public static final String GeographicViewForAgency_Query="SELECT concat( MAX(age.AGE_CD) ,'-',MAX(age.AGE_LB)) AS AGE_LB,"
		+ "ROUND((SUM(mrg.MRG_INV_TOV_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2) AS matching_rate,\r\n" + 
		" COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
		" ROUND(SUM(odr.ORD_LINE_AMNT),2) AS orders_turnover,\r\n" + 
		" COUNT(DISTINCT mrg.MRG_ORD_CD,mrg.MRG_DN_AGE_ID) AS order_with_invoices,\r\n" + 
		"ROUND(SUM(mrg.MRG_INV_TOV_AMNT),2) AS order_with_invoices_turnover,\r\n" + 
		"MAX(merger_art.articles_invoices_turnover) AS articles_invoices_turnover,\r\n" + 
		"MAX(merger_art.articles_invoices_margin) AS articles_invoices_margin,\r\n" + 
		"MAX(merger_art.articles_invoices_margin_perc) AS articles_invoices_margin_perc,\r\n" + 
		"MAX(merger_art.MRG_DN_AGE_ID) AS MRG_DN_AGE_ID\r\n" + 
		"FROM `AGENCY` AS `age`\r\n" + 
		"INNER JOIN `Orders` AS `odr` ON `odr`.`ORD_AGE_ID` = `age`.`AGE_ID`\r\n" + 
		"INNER JOIN `TELEVENTE` AS `tlvt` ON `tlvt`.`TLVT_ID` = `odr`.`ORD_TLVT_ID`\r\n" + 
		"LEFT JOIN `merger` AS `mrg` ON `mrg`.`MRG_TLVT_ID` = `odr`.`ORD_TLVT_ID` \r\n" + 
		"AND `mrg`.`MRG_ORD_CD` = `odr`.`ORD_CD` AND `mrg`.`MRG_ORD_LINE` = `odr`.`ORD_LINE` AND `mrg`.`MRG_DN_AGE_ID` = `odr`.`ORD_AGE_ID`\r\n" + 
		"LEFT JOIN (SELECT MAX(mrg2.MRG_TLVT_ID) AS MRG_TLVT_ID,MAX(mrg2.MRG_DN_AGE_ID) AS MRG_DN_AGE_ID, ROUND(SUM(mrg2.MRG_INV_TOV_AMNT),2) AS articles_invoices_turnover,ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT)),2) AS articles_invoices_margin,ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT))*100,2) AS articles_invoices_margin_perc\r\n" + 
		"FROM merger AS mrg2\r\n" + 
		"INNER JOIN tlvt_article AS tar ON tar.TAR_TLVT_ID = mrg2.MRG_TLVT_ID AND tar.TAR_ART_ID = mrg2.MRG_ART_ID\r\n" + 
		"WHERE mrg2.mrg_tlvt_id = 243 AND mrg2.MRG_DN_SIT_ID = 18 and mrg2.mrg_dn_sec_id=321 GROUP BY mrg2.MRG_DN_AGE_ID) AS merger_art ON `merger_art`.`MRG_DN_AGE_ID` = `age`.`AGE_ID`\r\n" + 
		"WHERE `age`.`AGE_SIT_ID` = '18' AND `tlvt`.`TLVT_ID` = '243' and odr.ord_SEC_ID='321' GROUP BY `age`.`AGE_ID` ORDER BY `age`.`AGE_CD` ASC, `age`.`AGE_LB` ASC";

public static final String GeographicViewForCustomer_Query="SELECT concat( MAX(mrg.MRG_CLI_CD) ,'-',MAX(mrg.MRG_CLI_LB)) AS MRG_CLI_LB, ROUND((SUM(mrg.MRG_INV_TOV_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2) AS matching_rate,\r\n" + 
		" COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
		" ROUND(SUM(odr.ORD_LINE_AMNT),2) AS orders_turnover,\r\n" + 
		" COUNT(DISTINCT mrg.MRG_ORD_CD,mrg.MRG_DN_AGE_ID) AS order_with_invoices,\r\n" + 
		"ifnull(ROUND(SUM(mrg.MRG_INV_TOV_AMNT),2),0.00) AS order_with_invoices_turnover,\r\n" + 
		" MAX(merger_art.articles_invoices_turnover) AS articles_invoices_turnover,\r\n" + 
		"ifnull((merger_art.articles_invoices_margin),0.00) AS articles_invoices_margin,\r\n" + 
		"ifnull((merger_art.articles_invoices_margin_perc),0.00) AS articles_invoices_margin_perc,\r\n" + 
		"MAX(merger_art.MART_MRG_CLI_CD) AS MART_MRG_CLI_CD,MAX(merger_art.MART_MRG_CLI_LB) AS MART_MRG_CLI_LB\r\n" + 
		"FROM `merger` AS `mrg`\r\n" + 
		"INNER JOIN `Agency` AS `age` ON `age`.`AGE_ID` = `mrg`.`MRG_DN_AGE_ID`\r\n" + 
		"INNER JOIN `TELEVENTE` AS `tlvt` ON `tlvt`.`TLVT_ID` = `mrg`.`MRG_TLVT_ID`\r\n" + 
		"LEFT JOIN `Orders` AS `odr` ON `mrg`.`MRG_TLVT_ID` = `odr`.`ORD_TLVT_ID` AND `mrg`.`MRG_ORD_CD` = `odr`.`ORD_CD` AND `mrg`.`MRG_ORD_LINE` = `odr`.`ORD_LINE` AND `mrg`.`MRG_DN_AGE_ID` = `odr`.`ORD_AGE_ID`\r\n" + 
		"LEFT JOIN (SELECT MAX(mrg2.MRG_TLVT_ID) AS MRG_TLVT_ID, MAX(mrg2.MRG_CLI_CD) AS MART_MRG_CLI_CD, MAX(mrg2.MRG_CLI_LB) AS MART_MRG_CLI_LB, ROUND(SUM(mrg2.MRG_INV_TOV_AMNT),2) AS articles_invoices_turnover,ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT)),2) AS articles_invoices_margin,ROUND((SUM(mrg2.MRG_INV_TOV_AMNT)- SUM(mrg2.MRG_SCP_LINE_AMNT))*100,2) AS articles_invoices_margin_perc\r\n" + 
		"FROM merger AS mrg2\r\n" + 
		"INNER JOIN tlvt_article AS tar ON tar.TAR_TLVT_ID = mrg2.MRG_TLVT_ID AND tar.TAR_ART_ID = mrg2.MRG_ART_ID\r\n" + 
		"WHERE mrg2.mrg_tlvt_id = 243 AND mrg2.MRG_DN_AGE_ID = 2756 GROUP BY mrg2.MRG_CLI_CD,mrg2.MRG_CLI_LB) AS merger_art ON `merger_art`.`MART_MRG_CLI_CD` = `mrg`.`MRG_CLI_CD` AND `merger_art`.`MART_MRG_CLI_LB` = `mrg`.`MRG_CLI_LB`\r\n" + 
		"WHERE `age`.`AGE_ID` = '2756' AND `tlvt`.`TLVT_ID` = '243' GROUP BY `mrg`.`MRG_CLI_CD`, `mrg`.`MRG_CLI_LB` ORDER BY `mrg`.`MRG_CLI_CD` ASC, `mrg`.`MRG_CLI_LB` ASC";


}
