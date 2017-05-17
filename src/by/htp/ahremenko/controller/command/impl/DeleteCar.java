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

public class DeleteCar implements Command {

	@Override
	public String execute(String request) {
		Scanner scanner = null;
		Integer i = 1;
		
		Integer id = -1; 
		
		//check command line and parse it
		scanner = new Scanner(request);
        scanner.useDelimiter(" ");
        while (scanner.hasNext()) {
            String data = scanner.next();
            if (i == 1)
            	id = Integer.parseInt(data);
            else
                System.out.println("Лишние данные: " + data);
            i++;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        RentService rentService = serviceFactory.getRentService();
        
  		try {
    			rentService.deleteCar( id );
   		} catch (ServiceException e) {
    			FileRW.writeLog(e.getMessage());
   		}
        
        return "Car # " + id + " was deleted succesfull.";    
	}

	
}
