package com.zcsoft.rc.collectors.app.components.tcp;

import java.math.BigDecimal;

public class GPSFormatUtils {

    private static BigDecimal data100 = new BigDecimal(100);
    private static BigDecimal data60 = new BigDecimal(60);

	/**
	 * 功能：BX2格式转换
	 * @param GGAData 传入待转化格式的经度或者纬度
	 * @return 转换后字符串
	 */
	public static String GGAFormat(String GGAData) {
		BigDecimal data = new BigDecimal(GGAData);
		/*
		 * ①3123.9675除以100取整得到31度，取小数得到0.239675；
   		 * ②取得的小数部分乘以100得到23.9675然后除以60得到0.399458；
         * ③将第①步取得的整数和第②取得的小数相加31 + 0.399458 = 31.399458.
		 */
		data = data.divide(data100, 6, BigDecimal.ROUND_DOWN) ;
		return GPHCDFormat (String.valueOf(data));
	}

	/**
	 * 功能：P3DU格式转换
	 * @param GPHCDData 传入待转化格式的经度或者纬度
	 * @return 转换后字符串
	 */
	public static String GPHCDFormat(String GPHCDData) {
		String[] array = GPHCDData.split("[.]");
		String D = array[0];// 得到度
		String M = array[1];//得到分
		
		/*
		 * ①31.23967541取整得到31，取小数得到0.23967541；
         * ②取得的小数部分乘以100得到23.967541然后除以60得到0.399459；
         * ③将第①步取得的整数和第②取得的小数相加31 + 0.399459 = 31.399459.
		 */
		BigDecimal d = new BigDecimal(D);
		BigDecimal m = new BigDecimal("0." + M);
		m = m.multiply(data100).divide(data60, 6, BigDecimal.ROUND_DOWN);//m * 100 / 60
		return String.valueOf(d.add(m));
	}

	public static void main(String[] args) {
		System.out.println("GGA经度:3123.9675--------->转换结果"+GGAFormat("3123.9675"));
		System.out.println("GGA纬度:4156.3343--------->转换结果"+GGAFormat("4156.3343"));
		System.out.println("GPHCD经度:31.23967541--------->转换结果"+GPHCDFormat("31.23967541"));
		System.out.println("GPHCD纬度:41.56334322--------->转换结果"+GPHCDFormat("41.56334322"));
	}
}