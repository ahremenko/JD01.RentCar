package by.htp.ahremenko.dao;

import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCarEco;
import by.htp.ahremenko.dao.exception.DAOException;

public interface CarDAO {
	void addNewCar (RentCar car) throws DAOException;
	void addNewCar (RentCarEco car) throws DAOException;	
	void deleteCar (Integer id) throws DAOException;
	void bookCar (Integer id) throws DAOException;
	void unbookCar (Integer id) throws DAOException;
}
