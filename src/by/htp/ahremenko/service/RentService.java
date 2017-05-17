package by.htp.ahremenko.service;

import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCarEco;
import by.htp.ahremenko.service.exception.ServiceException;

public interface RentService {
	void addNewCar(RentCar car) throws ServiceException;
	void addNewCar(RentCarEco car) throws ServiceException;
	void deleteCar(Integer id) throws ServiceException;
	void bookCar(Integer id) throws ServiceException;
	void unbookCar(Integer id) throws ServiceException;

}
