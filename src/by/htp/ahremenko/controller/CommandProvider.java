package by.htp.ahremenko.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.ahremenko.controller.command.Command;
import by.htp.ahremenko.controller.command.CommandName;
import by.htp.ahremenko.controller.command.impl.*;
import by.htp.ahremenko.controller.exception.LogicException;
//import by.htp.ahremenko.controller.command.impl.AddNewCar;
//import by.htp.ahremenko.controller.command.impl.DeleteCar;
//import by.htp.ahremenko.controller.command.impl.ListCar;
//import by.htp.ahremenko.controller.command.impl.FindCar;
import by.htp.ahremenko.dao.impl.FileRW;;

public class CommandProvider {
	private final Map<CommandName, Command> commandList = new HashMap<>();
	
	CommandProvider() {
		commandList.put(CommandName.ADDCAR, new AddNewCar());
		commandList.put(CommandName.DELCAR, new DeleteCar());
		//commandList.put(CommandName.LISTCAR, new ListCar());
		commandList.put(CommandName.FINDCAR, new FindCar());
		commandList.put(CommandName.UPDCAR, new UpdateCar());
		commandList.put(CommandName.GETCAR, new GetCarById());
	}
	
	Command getCommand (String usersCommand) throws LogicException {
		CommandName commandName = null;
		Command command = null;
		
		try {
			commandName = CommandName.valueOf(usersCommand.toUpperCase());
			command = commandList.get(commandName);
		} catch (IllegalArgumentException e) {
			//FileRW.writeLog("Unknown command: " + usersCommand.toUpperCase());
			throw new LogicException("Unknown command: " + usersCommand.toUpperCase() );
			//command = commandList.get(CommandName.WRONG_COMMAND);
		}
		return command;
	}
	
}
