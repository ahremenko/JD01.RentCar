package by.htp.ahremenko.controller.command.impl;

import java.util.Scanner;

import by.htp.ahremenko.bean.exception.FieldNotFoundException;
import by.htp.ahremenko.controller.command.Command;
import by.htp.ahremenko.controller.exception.LogicException;
import by.htp.ahremenko.dao.exception.DAOException;
import by.htp.ahremenko.dao.impl.FileRW;
import by.htp.ahremenko.service.RentService;
import by.htp.ahremenko.service.exception.ServiceException;
import by.htp.ahremenko.service.factory.ServiceFactory;

public class UpdateCar implements Command {

	@Override
	public String execute( String request ) throws LogicException {
	
	Scanner scanner = null;
	Integer id = -1;
	
	try {
		// check command line and parse it
		// gets string like "1 YEARMANUFACTURED=1999"
		scanner = new Scanner(request);
		scanner.useDelimiter(" ");
		while (scanner.hasNext()) {
			String data = scanner.next();
        	if ( data.indexOf("=")>0 ) {
        		String updatingField = data.substring(0, data.indexOf("="));
        		String newValue = data.substring(data.indexOf("=")+1);
        		ServiceFactory serviceFactory = ServiceFactory.getInstance();
        		RentService rentService = serviceFactory.getRentService();
        		//FileRW.writeLog("Start update car #" + id + " set " + updatingField + " = " + newValue );
       			rentService.updateCar( id, updatingField, newValue );
        	}else{
       			id = Integer.parseInt(data);
        	}
		} 
	}catch (NumberFormatException|ServiceException e){
		// FileRW.writeLog(e.getMessage());
		throw new LogicException(e.getMessage());
	} finally {
		scanner.close();
	}	
    return  "Car #" +id + " was updated succesfully.";
	}
	
}
