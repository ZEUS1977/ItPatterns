package it.zeussoft.cbiflat.mav.utils;

import org.apache.commons.lang3.StringUtils;

public class CleanImport {
	
	public static String cleanImport(String imp){
		
		return imp.replace(",",StringUtils.EMPTY).
					replace(".",StringUtils.EMPTY).
					replace("€",StringUtils.EMPTY).
					replace(" ",StringUtils.EMPTY);
				
	}
}
