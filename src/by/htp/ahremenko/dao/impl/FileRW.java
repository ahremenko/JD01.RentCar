package by.htp.ahremenko.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import by.htp.ahremenko.dao.exception.DAOException;

public class FileRW {
	
	private static String logFilePath = "c:\\Temp\\log.txt";
	private static String carFilePath = "c:\\Temp\\car.csv";
	public static String csvDelimiter = ";";

	public static String getCarFilePath () {
		return carFilePath;
	}
	
	public static Integer getNewCarId () throws DAOException {
		// read file and return last car Id + 1
		Integer carCounter = 1;  // 
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(carFilePath));
			while ((reader.readLine()) != null) {
				carCounter++;            
			}
			reader.close();
		} catch (IOException e) {
			//can be FileNotFoundException or other
			writeLog(e.getMessage());
			throw new DAOException(e.getMessage());
		}
		return carCounter;
	}
	
	public static void addLine(String nameFile, String text) throws DAOException {
		StringBuilder sb = new StringBuilder();
		String oldFile = readFile(nameFile);
		sb.append(oldFile);
		sb.append(text);
		writeFile(nameFile, sb.toString());
		//FileRW.writeLog("String " + text + " was added.");	
	    
	}	
	
	public static void writeLog (String msg) throws DAOException {
		long sysTime = System.currentTimeMillis(); 
		String sysDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(sysTime); 
		addLine(logFilePath, sysDate + " " + msg);
	}
	
	public static String readFile(String fileName) throws DAOException {
	    StringBuilder sb = new StringBuilder();
	    File file = new File(fileName);
	    if (file.exists()) {
	    	try {
	    		BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
    			String s;
    			while ((s = in.readLine()) != null) {
    				sb.append(s);
    				sb.append("\n");
    			}
    			in.close();
			} catch (IOException e) {
				writeLog(e.getMessage());
				throw new DAOException(e.getMessage());
			}	
	    	return sb.toString();
	    } else {
	    	return "";
	    }
	}
	
	public static void writeFile(String fileName, String text) throws DAOException {
	    File file = new File(fileName);
	    try {
	        if(!file.exists()){
	            file.createNewFile();
	        }
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	        try {
	            out.println(text);
	        } finally {
	            out.close();
	        }
	    } catch (IOException e) {
			writeLog(e.getMessage());
			throw new DAOException(e.getMessage());
	    }
	}
	
	public static void deleteLine(String nameFile, String text) throws DAOException {
	    String oldFile = readFile(nameFile);
	    if (oldFile.contains(text+"\n")) {
	    	writeFile(nameFile, oldFile.replaceAll(text+"\n", ""));
	    	FileRW.writeLog("String " + text + " was deleted.");
	    } else {
	    	FileRW.writeLog("String " + text + " not found.");
	    }
	    
	}	
	
	public static void updateLine(String nameFile, String searchingString, String replacingString) throws DAOException {
	    String oldFile = readFile(nameFile);
	    if (oldFile.contains(searchingString)) {
	    	writeFile(nameFile, oldFile.replaceAll(searchingString, replacingString));
	    	FileRW.writeLog("String " + searchingString + " was replaced with " + replacingString);
	    } else {
	    	FileRW.writeLog("String " + searchingString + " not found.");
	    }

	}	
	
}
