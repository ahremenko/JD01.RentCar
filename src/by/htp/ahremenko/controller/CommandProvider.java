package by.htp.ahremenko.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.ahremenko.controller.command.Command;
import by.htp.ahremenko.controller.command.CommandName;
import by.htp.ahremenko.controller.command.impl.AddNewCar;
import by.htp.ahremenko.controller.command.impl.DeleteCar;
import by.htp.ahremenko.dao.impl.FileRW;;

public class CommandProvider {
	private final Map<CommandName, Command> commandList = new HashMap<>();
	
	CommandProvider() {
		commandList.put(CommandName.ADDCAR, new AddNewCar());
		commandList.put(CommandName.DELCAR, new DeleteCar());
	}
	
	Command getCommand (String usersCommand) {
		CommandName commandName = null;
		Command command = null;
		
		try {
			commandName = CommandName.valueOf(usersCommand.toUpperCase());
			command = commandList.get(commandName);
		} catch (IllegalArgumentException e) {
			FileRW.writeLog("Command not allowed or wrong.");
			command = commandList.get(CommandName.WRONG_COMMAND);
		}
		return command;
	}
	
}
