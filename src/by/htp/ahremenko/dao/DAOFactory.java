package by.htp.ahremenko.dao;

import by.htp.ahremenko.dao.impl.FileCarDAO;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	
	private final CarDAO fileCar = new FileCarDAO();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
	public CarDAO getCarDAO() {
		return fileCar;
	}
	
}
