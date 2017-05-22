package by.htp.ahremenko.controller.command.impl;

import java.util.Scanner;

import by.htp.ahremenko.bean.exception.FieldNotFoundException;
import by.htp.ahremenko.controller.command.Command;
import by.htp.ahremenko.controller.exception.LogicException;
import by.htp.ahremenko.dao.impl.FileRW;
import by.htp.ahremenko.service.RentService;
import by.htp.ahremenko.service.exception.ServiceException;
import by.htp.ahremenko.service.factory.ServiceFactory;

public class FindCar implements Command {

	@Override
	public String execute(String request) throws LogicException {
		//check command line and parse it
		// gets string like "YEARMANUFACTURED=1999" or "MODEL=TESLA"

		Scanner scanner = null;
		String response = "";
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		RentService rentService = serviceFactory.getRentService();
		String searchingField = ""; 
		String searchingValue = "";		
		try {
			scanner = new Scanner(request);
			scanner.useDelimiter(" ");
			if (scanner.hasNext()) {
				String data = scanner.next();
				if ( data.indexOf("=")>0 ) {
					searchingField = data.substring(0, data.indexOf("="));
					searchingValue = data.substring(data.indexOf("=")+1);
				} 
			} 
			response = rentService.findCar( searchingField, searchingValue );
   		} catch (ServiceException e) {
    		//FileRW.writeLog(e.getMessage());
   			throw new LogicException(e.getMessage());
   		} finally {                
   			scanner.close();
   		}	
        return response;    
	}
	

}
