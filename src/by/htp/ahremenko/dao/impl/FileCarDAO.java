package by.htp.ahremenko.dao.impl;

import java.io.IOException;
import java.util.List;

import by.htp.ahremenko.bean.Car.CarFields;
import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCarEco;
import by.htp.ahremenko.dao.CarDAO;
import by.htp.ahremenko.dao.exception.DAOException;

public class FileCarDAO implements CarDAO {
		
	@Override
	public void addNewCar(RentCar car) throws DAOException {
		// write new record to file
		FileRW.addLine(FileRW.getCarFilePath(),  car.toString() );
	}

	@Override
	public void addNewCar(RentCarEco car) throws DAOException {
		// write new record to file
		FileRW.addLine(FileRW.getCarFilePath(),  car.toString() );
	}
	
	@Override
	public void bookCar(Integer id) throws DAOException {
		// insert car into scheduler
		
	}
	
	@Override
	public void unbookCar(Integer id) throws DAOException {
		// remove car from scheduler
		
	}
	
	@Override
	public void deleteCar(Integer id) throws DAOException {
		// update state of enabled/disabled
		try {
		   List<RentCarEco> allCarEco = ListCarLogic.getListCar();
		   List<RentCarEco> carsForDeleting = ListCarLogic.getCarListByOneField(allCarEco, id.toString(), CarFields.ID);
   		   for(int i=0;i<carsForDeleting.size();i++) {
				FileRW.deleteLine(FileRW.getCarFilePath(),  carsForDeleting.get(i).toString() );
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
	
}
