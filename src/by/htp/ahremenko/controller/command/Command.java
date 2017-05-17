package by.htp.ahremenko.controller.command;

import by.htp.ahremenko.controller.exception.LogicException;

public interface Command {
	public String execute (String request);
}
