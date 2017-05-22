package by.htp.ahremenko.view;

import by.htp.ahremenko.controller.Controller;
import by.htp.ahremenko.controller.exception.LogicException;

public class TasksWithRentCar {
	
	public static void main(String[] args) {
		String commandLine = "";
		String response = "";
		Controller controller = new Controller();
        KeyboardInput kbd = new KeyboardInput();
        
        // examples and fill table of cars
        
        /*try {
        	ViewExamples.showExamples();
        } catch (LogicException e) {
        	System.err.println(e.getMessage());
        }*/
        
        do {
        	commandLine = kbd.enterString("Type command here >> ");
        	if (commandLine.toUpperCase().equals("EXIT")) 
        		break;
        	try {
        		response = controller.executeTask(commandLine);
        	} catch (LogicException e) {
        		System.out.println(e.getMessage());
        		response = "";
        	}
        	if (!response.equals("")) System.out.println("\n" + response);
        } while (!commandLine.toUpperCase().equals("EXIT"));  
        
        System.out.println("\nHave a nice day :)");
	}	
	
}
