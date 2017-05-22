package by.htp.ahremenko.view;

import by.htp.ahremenko.controller.Controller;
import by.htp.ahremenko.controller.exception.LogicException;

public class ViewExamples {

	public static void showExamples() throws LogicException {

		String commandLine = "";
		String response = "";
		Controller controller = new Controller();

		
		commandLine = "ADDCAR Toyota Corolla SEDAN 2012 40 MT BENZINE";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "ADDCAR TESLA Model_X ND 2017 71 510";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);
		
		commandLine = "ADDCAR HONDA Insight HATCHBACK 2014 30 AT BENZINE";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "ADDCAR VW Multivan BUS 2010 45 MT DIESEL";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "ADDCAR DODGE Dakota JEEP 2003 12 AT GAS";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);
		
		commandLine = "ADDCAR TESLA Model_S ND 2016 62 420";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "ADDCAR TESLA Model_X_Ultimate_Edition ND 2017 79 490";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);
		
		commandLine = "ADDCAR TESLA Model_S_HighLine HATCHBACK 2016 64 485";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "ADDCAR MITSUBISHI i-MiEV ND 2012 47.3 170";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);
		
		commandLine = "ADDCAR MITSUBISHI Outlander JEEP 2014 37 AT DIESEL";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);		
		/*
		commandLine = "FINDCAR";
		response = controller.executeTask(commandLine);
		System.out.println(response);
		
		commandLine = "DELCAR 1";
		response = controller.executeTask(commandLine);
		System.out.println(response);

		commandLine = "FINDCAR";
		response = controller.executeTask(commandLine);
		System.out.println(response);
		
		commandLine = "ADDCAR Toyota Corolla SEDAN 2012 40 MT BENZINE";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "FINDCAR";
		response = controller.executeTask(commandLine);
		System.out.println(response);
		
		commandLine = "UPDCAR 2 MAXDISTANCE=555";
		response = controller.executeTask(commandLine);
		System.out.println(response);

		commandLine = "FINDCAR";
		response = controller.executeTask(commandLine);
		System.out.println(response);
		*/
		/*
		commandLine = "ADDCAR Toyota Corolla SEDAN 2012 40 MT BENZINE";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "ADDCAR TESLA Model_X ND 2017 71 510";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);
		
		commandLine = "ADDCAR HONDA Insight HATCHBACK 2014 30 AT BENZINE";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "ADDCAR VW Multivan BUS 2010 45 MT DIESEL";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "ADDCAR DODGE Dakota JEEP 2003 12 AT GAS";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);
		
		commandLine = "ADDCAR TESLA Model_S ND 2016 62 420";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "ADDCAR TESLA Model_X_Ultimate_Edition ND 2017 79 490";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);
		
		commandLine = "ADDCAR TESLA Model_S_HighLine HATCHBACK 2016 64 485";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "ADDCAR MITSUBISHI i-MiEV ND 2012 47.3 170";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);
		
		commandLine = "ADDCAR MITSUBISHI Outlander JEEP 2014 37 AT DIESEL";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + " " + response);

		commandLine = "DELCAR 2";
		response = controller.executeTask(commandLine);
		System.out.println(response);
		
		commandLine = "FINDCAR MODEL=TESLA";
		response = controller.executeTask(commandLine);
		System.out.println(commandLine + ":\n" + response);
		*/
		
	}
}
