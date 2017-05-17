package by.htp.ahremenko.controller.command.impl;

import java.util.Scanner;

import by.htp.ahremenko.controller.command.Command;
import by.htp.ahremenko.dao.impl.FileRW;
import by.htp.ahremenko.service.RentService;
import by.htp.ahremenko.service.exception.ServiceException;
import by.htp.ahremenko.service.factory.ServiceFactory;

public class FindCar implements Command {

	@Override
	public String execute(String request) {
		
		Scanner scanner = null;
		String response = "";
		
		//check command line and parse it
		scanner = new Scanner(request);
        scanner.useDelimiter(" ");
        while (scanner.hasNext()) {
        	
            String data = scanner.next();
            // gets string like "YEARMANUFACTURED=1999 MODEL=TESLA"
            if ( data.indexOf("=")>0 ) {
            	String searchingField = data.substring(0, data.indexOf("="));
            	String searchingValue = data.substring(data.indexOf("=")+1);
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                RentService rentService = serviceFactory.getRentService();
          		try {
          			response = rentService.findCar( searchingField, searchingValue );
           		} catch (ServiceException e) {
            		FileRW.writeLog(e.getMessage());
           		}                
            }
        }
		scanner.close();
        return response;    
	}
	

}
