package by.htp.ahremenko.controller.command.impl;

import java.util.Scanner;

import by.htp.ahremenko.bean.exception.FieldNotFoundException;
import by.htp.ahremenko.controller.command.Command;
import by.htp.ahremenko.controller.exception.LogicException;
import by.htp.ahremenko.dao.impl.FileRW;
import by.htp.ahremenko.service.RentService;
import by.htp.ahremenko.service.exception.ServiceException;
import by.htp.ahremenko.service.factory.ServiceFactory;

public class DeleteCar implements Command {

	@Override
	public String execute(String request) throws LogicException {
		//check command line and parse it
		// Gets String like: "2"
		Scanner scanner = null;
		Integer i = 1;
		Integer id = -1; 
		try {
			scanner = new Scanner(request);
			scanner.useDelimiter(" ");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (i == 1)
					id = Integer.parseInt(data);
				else
					System.out.println("������ ������: " + data);
				i++;
			}

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			RentService rentService = serviceFactory.getRentService();
    		rentService.deleteCar( id );
   		} catch (ServiceException e) {
   			throw new LogicException(e.getMessage());
    		//FileRW.writeLog(e.getMessage());
   		} finally {
   			scanner.close();
   		}
        return "Car # " + id + " was deleted succesfully.";    
	}

	
}
