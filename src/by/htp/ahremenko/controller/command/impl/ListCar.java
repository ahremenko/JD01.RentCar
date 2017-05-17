package by.htp.ahremenko.controller.command.impl;

import by.htp.ahremenko.controller.command.Command;
import by.htp.ahremenko.dao.impl.FileRW;
import by.htp.ahremenko.service.RentService;
import by.htp.ahremenko.service.exception.ServiceException;
import by.htp.ahremenko.service.factory.ServiceFactory;

public class ListCar implements Command {

	@Override
	public String execute( String request ) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        RentService rentService = serviceFactory.getRentService();
        String response = "";
        
  		try {
  			    response = rentService.listCar();
   		} catch (ServiceException e) {
    			FileRW.writeLog(e.getMessage());
   		}
        
        return response;    
	}
	
}
