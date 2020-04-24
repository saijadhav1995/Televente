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
	
	
	
	
	
	
    
    
    
	public static final String BillingSynthesis_Query="SELECT COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,ROUND(SUM(odr.ORD_LINE_AMNT),2) AS orders_turnover,\r\n" + 
			"ROUND((SUM(mrg.MRG_INV_TOV_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2) AS matching_rate,\r\n" + 
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
	
	
	public static final String SellViewOfSector_Query="SELECT  MAX(sec.SEC_CD) AS SEC_CD,MAX(sec.SEC_LB) AS SEC_LB,COUNT(DISTINCT odr.ORD_CD,odr.ORD_AGE_ID) AS total_orders,\r\n" + 
			"ROUND(SUM(odr.ORD_LINE_AMNT),2) AS orders_turnover,ROUND((SUM(mrg.MRG_INV_TOV_AMNT)/SUM(odr.ORD_LINE_AMNT)*100),2) AS matching_rate,\r\n" + 
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
			"WHERE mrg2.mrg_tlvt_id = 243  GROUP BY mrg2.MRG_DN_SEC_ID) AS merger_art ON `merger_art`.`MRG_DN_SEC_ID` = `sec`.`SEC_ID`\r\n" + 
			"WHERE `tlvt`.`TLVT_ID` = '243'  GROUP BY `sec`.`SEC_ID` ORDER BY `sec`.`SEC_CD` ASC, `sec`.`SEC_LB` ASC";
	
}
