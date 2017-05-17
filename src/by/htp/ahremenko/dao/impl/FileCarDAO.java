package by.htp.ahremenko.dao.impl;

import java.io.IOException;
import java.util.List;

import by.htp.ahremenko.bean.Car;
import by.htp.ahremenko.bean.Car.CarFields;
import by.htp.ahremenko.bean.RentCar;
import by.htp.ahremenko.bean.RentCarEco;
import by.htp.ahremenko.dao.CarDAO;
import by.htp.ahremenko.dao.exception.DAOException;

public class FileCarDAO implements CarDAO {
		
	@Override
	public void addNewCar(RentCar car) throws DAOException {
		// write new record to file
		try {
			List<Car> allCars = ListCarLogic.getListCar();
			if ( !allCars.contains(car)) { 
				FileRW.addLine(FileRW.getCarFilePath(),  car.toString() );
			} else {
				FileRW.writeLog("Duplicates found: " + car.toString() + " - skipped!");
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void addNewCar(RentCarEco car) throws DAOException {
		// write new record to file
		try {
			List<Car> allCars = ListCarLogic.getListCar();
			if ( !allCars.contains(car)) { 
				FileRW.addLine(FileRW.getCarFilePath(),  car.toString() );
			} else {
				FileRW.writeLog("Duplicates found: " + car.toString() + " - skipped!");
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
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
	public String listCar() throws DAOException {
		// get all cars from file
		StringBuilder sb = new StringBuilder();
		
		try {
			List<Car> allCars = ListCarLogic.getListCar();
			for ( Car c : allCars ) {
				sb.append(c.toString());
				sb.append('\n');
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		return sb.toString();
	}
	
	@Override
	public void deleteCar(Integer id) throws DAOException {
		// update state of enabled/disabled
		try {
		   List<Car> allCars = ListCarLogic.getListCar();
		   List<Car> carsForDeleting = ListCarLogic.getCarListByOneField(allCars, id.toString(), CarFields.ID);
   		   for(int i=0;i<carsForDeleting.size();i++) {
				FileRW.deleteLine(FileRW.getCarFilePath(),  carsForDeleting.get(i).toString() );
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	@Override
	public String findCar(String searchingFields, String searchingValues) throws DAOException {
		StringBuilder sb = new StringBuilder();
		try {
			List<Car> allCars = ListCarLogic.getListCar();
  	        List<Car> foundedCars = ListCarLogic.getCarListByOneField(allCars, searchingValues, CarFields.valueOf(searchingFields.toUpperCase()));			
			for ( Car c : foundedCars ) {
				sb.append(c.toString());
				sb.append('\n');
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		return sb.toString();		
	}
	
	
}
