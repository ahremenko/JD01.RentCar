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
		
		commandName = request.substring(0, request.indexOf(commandDelimiter));
		executingCommand = provider.getCommand(commandName);
		commandArgs = request.substring(request.indexOf(commandDelimiter) + 1 );
		response = executingCommand.execute(commandArgs);
		return response;
		
	}
}
