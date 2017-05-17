package by.htp.ahremenko.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCarEco;
import by.htp.ahremenko.bean.Car;
import by.htp.ahremenko.bean.Car.CarCase;
import by.htp.ahremenko.bean.Car.CarFields;

public class ListCarLogic {

	public static List<RentCarEco> getListCar() throws IOException {
		// get ArrayList of RentCarEco
		
		List<RentCarEco> carList = new ArrayList<>();
		String fileContent = FileRW.readFile(FileRW.getCarFilePath());
        String readedLine = fileContent.substring(0, fileContent.indexOf('\n'));
        Scanner scanner = null;
        int fieldCounter = 0;		

        while ( !readedLine.equals("") ) {
        	RentCarEco carFromFile = new RentCarEco();
            scanner = new Scanner(readedLine);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                try {
                if ( (fieldCounter == 0) && (!data.equals("")))
                	carFromFile.setId(Integer.parseInt(data));
                else if ( (fieldCounter == 1) && (!data.equals("")))
                	carFromFile.setModel(data);
                else if ( (fieldCounter == 2) && (!data.equals("")))
                	carFromFile.setModelType(data);
                else if ( (fieldCounter == 3) && (!data.equals("")))
                	carFromFile.setCarCase( CarCase.valueOf(data.toUpperCase()));
                else if ( (fieldCounter == 4) && (!data.equals("")))
                	carFromFile.setYearManufactured(Integer.parseInt(data));
                else if ( (fieldCounter == 5) && (!data.equals("")))
                	carFromFile.setRentPricePerDay(Float.parseFloat(data));
                else if ( (fieldCounter == 6) && (!data.equals("")))
              		carFromFile.setMaxDistance(Integer.parseInt(data));
                else
                	FileRW.writeLog("Extra data: " + data);
                    //System.out.println("Extra data: " + data);
                } catch (NumberFormatException e) {
                }
                fieldCounter++;
            }
            if ( carFromFile.getId() > -1 && carFromFile.getMaxDistance() > -1) {
            	carList.add(carFromFile);
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
	
	public static List<RentCarEco> getCarListByOneField (List<RentCarEco> carList, String searchingString, CarFields searchingField) {
		List<RentCarEco> carListFound = new ArrayList<>();
		
		for(int i=0;i<carList.size();i++) {
			if (carList.get(i).searchByField(searchingString, searchingField)  ) {
				carListFound.add(carList.get(i));
			}
		}
		return carListFound;
	}	
	
}
