package by.htp.ahremenko.service;

import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCarEco;
import by.htp.ahremenko.bean.exception.FieldNotFoundException;
import by.htp.ahremenko.service.exception.ServiceException;

public interface RentService {
	void addNewCar(RentCar car) throws ServiceException;
	void addNewCar(RentCarEco car) throws ServiceException;
	void deleteCar(Integer id) throws ServiceException;
	//String listCar() throws ServiceException;
	String findCar( String searchingFields, String searchingValues ) throws ServiceException;
	void updateCar(Integer id, String updatingField, String newValue) throws ServiceException;
	String getCarAsString(Integer id) throws ServiceException;
}
