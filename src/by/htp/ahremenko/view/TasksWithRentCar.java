package by.htp.ahremenko.view;

import by.htp.ahremenko.controller.Controller;
import by.htp.ahremenko.dao.impl.FileRW;

public class TasksWithRentCar {
	
	public static void main(String[] args) {
		String commandLine = "";
		String response = "";
		
		Controller controller = new Controller();
		/*
		commandLine = "ADDCAR Toyota Corolla SEDAN 2012 40 MT BENZINE";
		response = controller.executeTask(commandLine);
		//FileRW.writeLog(response);
		System.out.println(response);

		commandLine = "ADDCAR TESLA Model_X ND 2017 71 510";
		response = controller.executeTask(commandLine);
		//FileRW.writeLog(response);
		System.out.println(response);
		
		commandLine = "ADDCAR HONDA Insight HATCHBACK 2014 30 AT BENZINE";
		response = controller.executeTask(commandLine);
		//FileRW.writeLog(response);
		System.out.println(response);

		commandLine = "ADDCAR VW Multivan BUS 2010 45 MT DIESEL";
		response = controller.executeTask(commandLine);
		//FileRW.writeLog(response);
		System.out.println(response);

		commandLine = "ADDCAR DODGE Dakota JEEP 2003 12 AT GAS";
		response = controller.executeTask(commandLine);
		//FileRW.writeLog(response);
		System.out.println(response);
		
		commandLine = "ADDCAR TESLA Model_S ND 2016 62 420";
		response = controller.executeTask(commandLine);
		//FileRW.writeLog(response);
		System.out.println(response);

		commandLine = "ADDCAR TESLA Model_X_Ultimate_Edition ND 2017 79 490";
		response = controller.executeTask(commandLine);
		//FileRW.writeLog(response);
		System.out.println(response);
		
		*/
		commandLine = "DELCAR 2";
		response = controller.executeTask(commandLine);
		//FileRW.writeLog(response);
		System.out.println(response);
		
	}	
	
}
