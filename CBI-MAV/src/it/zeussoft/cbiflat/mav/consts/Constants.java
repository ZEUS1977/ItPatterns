package it.zeussoft.cbiflat.mav.consts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

	public static final String TIPO_RECORD_IM = "IM";
	public static final String TIPO_RECORD_EF = "EF";
	public static final String TIPO_RECORD_14 = "14";
	public static final String TIPO_RECORD_20 = "20";
	public static final String TIPO_RECORD_30 = "30";
	public static final String TIPO_RECORD_40 = "40";
	public static final String TIPO_RECORD_50 = "50";
	public static final String TIPO_RECORD_51 = "51";
	public static final String TIPO_RECORD_70 = "70";
	public static String CAUSALE_RICHIESTA_MAV_CBI = "07000";
	public static String SPACE = " ";
	public static String SPLIT_ADDRESS_SEPARATOR = "\\s+";
	public static String COUNTRY_COD = "IT";
	public static Date date = new Date();
	public static SimpleDateFormat simple = new SimpleDateFormat("ddMMyy");
	public static String TODAY = simple.format(date);
	public static String CODICE_DIVISA = "E";
	public static final String RECORD_SEPARATOR = "\n";
}
