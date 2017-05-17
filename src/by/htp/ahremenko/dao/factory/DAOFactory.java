package by.htp.ahremenko.dao.factory;

import by.htp.ahremenko.dao.CarDAO;
import by.htp.ahremenko.dao.impl.FileCarDAO;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	
	private final CarDAO dataCar = new FileCarDAO();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
	public CarDAO getCarDAO() {
		return dataCar;
	}

}