package by.htp.ahremenko.dao;

import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCarEco;
import by.htp.ahremenko.bean.exception.FieldNotFoundException;
import by.htp.ahremenko.dao.exception.DAOException;

public interface CarDAO {
	void addNewCar (RentCar car) throws DAOException;
	void addNewCar (RentCarEco car) throws DAOException;	
	void deleteCar (Integer id) throws DAOException, FieldNotFoundException;
	String findCar (String searchingFields, String searchingValues) throws DAOException, FieldNotFoundException;
	RentCar getCar (Integer id) throws DAOException, FieldNotFoundException;
	RentCarEco getCarEco (Integer id) throws DAOException, FieldNotFoundException;
	String getCarAsString (Integer id) throws DAOException, FieldNotFoundException;
	void updateCar (Integer id, String updatingField, String newValue) throws DAOException, FieldNotFoundException;
}
