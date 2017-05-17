package by.htp.ahremenko.service.impl;

import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCarEco;
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
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void addNewCar(RentCarEco car) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			CarDAO carDAO = daoObjectFactory.getCarDAO();
			carDAO.addNewCar(car);
		} catch ( DAOException e) {
			throw new ServiceException(e);
		}
		
	}
	
	@Override
	public void deleteCar(Integer id) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			CarDAO carDAO = daoObjectFactory.getCarDAO();
			carDAO.deleteCar(id);
		} catch ( DAOException e) {
			throw new ServiceException(e);
		}
		
	}
	@Override
	public void bookCar(Integer id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unbookCar(Integer id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}
	
	

}
