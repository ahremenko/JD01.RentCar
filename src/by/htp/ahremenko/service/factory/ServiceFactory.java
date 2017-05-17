package by.htp.ahremenko.service.factory;

import by.htp.ahremenko.service.RentService;
import by.htp.ahremenko.service.impl.RentServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final RentService rentService = new RentServiceImpl();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public RentService getRentService() {
		return rentService;
	}
	
}
