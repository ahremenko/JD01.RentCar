package by.htp.ahremenko.controller.command;

import by.htp.ahremenko.bean.exception.FieldNotFoundException;
import by.htp.ahremenko.controller.exception.LogicException;
import by.htp.ahremenko.service.exception.ServiceException;

public interface Command {
	public String execute (String request) throws LogicException;
}
