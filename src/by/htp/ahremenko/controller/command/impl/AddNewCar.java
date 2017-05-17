package by.htp.ahremenko.controller.command.impl;

import java.io.IOException;
import java.util.Scanner;

import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCarEco;
import by.htp.ahremenko.bean.Car.CarCase;
import by.htp.ahremenko.bean.RentCar.FuelType;
import by.htp.ahremenko.bean.RentCar.TransmissionType;
import by.htp.ahremenko.controller.command.Command;
import by.htp.ahremenko.dao.impl.FileRW;
import by.htp.ahremenko.service.RentService;
import by.htp.ahremenko.service.exception.ServiceException;
import by.htp.ahremenko.service.factory.ServiceFactory;

public class AddNewCar implements Command {

	@Override
	public String execute(String request) {
		//System.out.println("AddNewCar executes: " + request);
		Scanner scanner = null;
		Integer i = 1;
		
		String m = "";  //1
		String mt = "";  //2
		CarCase cc = CarCase.ND; //3
		Integer y = 1900; //4
		Float p = 0f; //5
		TransmissionType t = TransmissionType.ND; //6
		FuelType f = FuelType.ND; //7
		Integer md = -1; //6
		
		//check command line and parse it
		scanner = new Scanner(request);
        scanner.useDelimiter(" ");
        while (scanner.hasNext()) {
            String data = scanner.next();
            if (i == 1)
            	m = data;
            else if (i == 2)
            	mt = data;
            else if (i == 3)
            	try {
            		cc = CarCase.valueOf(data.toUpperCase());
            	} catch (IllegalArgumentException e){
            		cc = CarCase.ND;
            	}	
            else if (i == 4)
            	y = Integer.parseInt(data);
            else if (i == 5)
            	p = Float.parseFloat(data);
            else if (i == 6) {
            	try {
            		t = TransmissionType.valueOf(data.toUpperCase());
            	} catch (IllegalArgumentException e){
            		t = TransmissionType.ND;
            	}
        		try {
        			md = Integer.parseInt(data);
        		} catch (NumberFormatException e){
        			md = -1;
        		}
            }	
            else if (i == 7)
            	try {
            		f = FuelType.valueOf(data.toUpperCase());
            	} catch (IllegalArgumentException e){
            		f = FuelType.ND;
            	}	
            else
                System.out.println("Лишние данные: " + data);
            i++;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        RentService rentService = serviceFactory.getRentService();
        
        try {
        	i = FileRW.getNewCarId();
        } catch (IOException e) {
        	e.getStackTrace();
        }
        if (md == -1) {
    		RentCar car = new RentCar(i, m, mt, cc, y, p, t, f);
    		try {
    			rentService.addNewCar(car);
    		} catch (ServiceException e) {
    			FileRW.writeLog(e.getMessage());
    		}
    		
        } else {
    		RentCarEco carEco = new RentCarEco(i, m, mt, cc, y, p, md );
    		try {
    			rentService.addNewCar(carEco);
    		} catch (ServiceException e) {
    			FileRW.writeLog(e.getMessage());
    		}

        }
        
        return "Car was added succesfull.";    
	}
	
	

}
