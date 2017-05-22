package by.htp.ahremenko.service.impl;

import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCarEco;
import by.htp.ahremenko.bean.exception.FieldNotFoundException;
import by.htp.ahremenko.dao.CarDAO;
import by.htp.ahremenko.dao.factory.DAOFactory;
import by.htp.ahremenko.dao.exception.DAOException;
import by.htp.ahremenko.service.RentService;
import by.htp.ahremenko.service.exception.ServiceException;

public class RentServiceImpl implements RentService{

	@Override
	public void addNewCar(RentCar car) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			CarDAO carDAO = daoObjectFactory.getCarDAO();
			carDAO.addNewCar(car);
		} catch ( DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public void addNewCar(RentCarEco car) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			CarDAO carDAO = daoObjectFactory.getCarDAO();
			carDAO.addNewCar(car);
		} catch ( DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	
	@Override
	public void deleteCar(Integer id) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			CarDAO carDAO = daoObjectFactory.getCarDAO();
			carDAO.deleteCar(id);
		} catch ( DAOException|FieldNotFoundException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	@Override
	public String findCar(String searchingFields, String searchingValues) throws ServiceException {
		String carList = "";
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			CarDAO carDAO = daoObjectFactory.getCarDAO();
			carList = carDAO.findCar(searchingFields, searchingValues);
		} catch ( DAOException|FieldNotFoundException e) {
			throw new ServiceException(e.getMessage());
		}
		return carList;
	}

	@Override
	public void updateCar(Integer id, String updatingField, String newValue) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			CarDAO carDAO = daoObjectFactory.getCarDAO();
			carDAO.updateCar(id, updatingField, newValue);
		} catch ( DAOException|FieldNotFoundException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public String getCarAsString(Integer id) throws ServiceException {
		String oneCar = "";
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			CarDAO carDAO = daoObjectFactory.getCarDAO();
			oneCar = carDAO.getCarAsString(id);
		} catch ( DAOException|FieldNotFoundException e) {
			throw new ServiceException(e.getMessage());
		}
		return oneCar;
	}	

}
