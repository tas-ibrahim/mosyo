package com.itas.mosyo.util;

public class AppUtil {

	public static String getFileExtension(String fileName){
		
		if(!StringUtil.isNothing(fileName)){
			
			int dotIndex = fileName.indexOf(".");
			
			return dotIndex == -1 ? "" : fileName.substring(dotIndex, fileName.length());
			
		}
		
		return ""; 
	}
	
	
}
