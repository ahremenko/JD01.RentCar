package by.htp.ahremenko.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCar.FuelType;
import by.htp.ahremenko.bean.RentCar.TransmissionType;
import by.htp.ahremenko.bean.RentCarEco;
import by.htp.ahremenko.bean.Car;
import by.htp.ahremenko.bean.Car.CarCase;
import by.htp.ahremenko.bean.Car.CarFields;

public class ListCarLogic {

	public static List<Car> getListCar() throws IOException {
		
		List<Car> carList = new ArrayList<>();
		String fileContent = FileRW.readFile(FileRW.getCarFilePath());
        String readedLine = "";
        
        if (fileContent.indexOf('\n')>0) {
        	readedLine =  fileContent.substring(0, fileContent.indexOf('\n'));
        }	
        
        Scanner scanner = null;
        
        int fieldCounter = 0;		

        while ( !readedLine.equals("") ) {
            Integer i = -1;
            String m = "";
            String mt = "";
            Integer y = 1900;
            CarCase c = CarCase.ND;
            Float p = 0f;
            Integer md = 0;
            RentCar.TransmissionType t = null;
            RentCar.FuelType f = null;
            scanner = new Scanner(readedLine);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                try {
                if ( (fieldCounter == 0) && (!data.equals("")))
                	i = Integer.parseInt(data);
                else if ( (fieldCounter == 1) && (!data.equals("")))
                	m = data;
                else if ( (fieldCounter == 2) && (!data.equals("")))
                	mt = data;
                else if ( (fieldCounter == 3) && (!data.equals("")))
                	c = CarCase.valueOf(data.toUpperCase());
                else if ( (fieldCounter == 4) && (!data.equals("")))
                	y = Integer.parseInt(data);
                else if ( (fieldCounter == 5) && (!data.equals("")))
                	p = Float.parseFloat(data);
                
                else if ( (fieldCounter == 6) && (!data.equals(""))) {
                		try {
                			md = Integer.parseInt(data);
                		} catch (NumberFormatException e) {
                			t = TransmissionType.valueOf(data);	
                		}
                }	 
                else if ( (fieldCounter == 7) && (!data.equals("")))
                	f = FuelType.valueOf(data); 
                } catch (NumberFormatException e) {
                }
                fieldCounter++;
            }
            if ( i > -1) {
            	if ( md > 0) {
            		RentCarEco rentCarEcoFromFile = new RentCarEco(i, m, mt, c, y, p, md);  
            		carList.add(rentCarEcoFromFile);
            	} 
            	if ( t != null || f != null ) {
            		RentCar rentCarFromFile = new RentCar(i, m, mt, c, y, p, t, f); 
            		carList.add(rentCarFromFile);
            	}
            }	
            fieldCounter = 0;
            if (fileContent.contains("\n")) {
            	fileContent = fileContent.substring(fileContent.indexOf('\n')+1);
            	if (fileContent.contains("\n")) {
                  readedLine = fileContent.substring(0, fileContent.indexOf('\n'));
            	} else {
              	  readedLine = fileContent;	
            	}
            } else {
            	readedLine = "";
            }
        }
		return carList;
	}
	
	public static List<Car> getCarListByOneField (List<Car> carList, String searchingString, CarFields searchingField) {
		List<Car> carListFound = new ArrayList<>();
		
		for(int i=0;i<carList.size();i++) {
			if (carList.get(i).searchByField(searchingString, searchingField)  ) {
				carListFound.add(carList.get(i));
			}
		}
		return carListFound;
	}	
	
}
