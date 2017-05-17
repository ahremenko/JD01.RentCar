package by.htp.ahremenko.controller;

import by.htp.ahremenko.controller.command.Command;

public final class Controller {
	
	private final CommandProvider provider = new CommandProvider();
	
	private final char commandDelimiter = ' ';
	
	public String executeTask (String request) {
		String commandName;
		Command executingCommand;
		String commandArgs;
		String response;
		if ( request.indexOf(commandDelimiter) > 0 ) {
		    commandName = request.substring(0, request.indexOf(commandDelimiter));
		} else {
			commandName = request;	
		}
		executingCommand = provider.getCommand(commandName);
		if ( request.indexOf(commandDelimiter) > 0 ) {
		   commandArgs = request.substring(request.indexOf(commandDelimiter) + 1 );
		} else {
			commandArgs = "";
		}
		response = executingCommand.execute(commandArgs);
		return response;
		
	}
}
