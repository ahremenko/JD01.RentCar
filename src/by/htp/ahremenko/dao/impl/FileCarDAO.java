package by.htp.ahremenko.dao.impl;


import java.util.List;
import by.htp.ahremenko.bean.*;
import by.htp.ahremenko.bean.exception.FieldNotFoundException;
import by.htp.ahremenko.dao.*;
import by.htp.ahremenko.dao.exception.DAOException;

public class FileCarDAO implements CarDAO {
		
	@Override
	public void addNewCar(RentCar car) throws DAOException {
		List<Car> allCars = ListCarLogic.getListCar();
		if ( !allCars.contains(car)) { 
			FileRW.addLine(FileRW.getCarFilePath(),  car.toString() );
		} else {
			FileRW.writeLog("Duplicates found: " + car.toString() + " - skipped!");
		}
	}

	@Override
	public void addNewCar(RentCarEco car) throws DAOException {
		List<Car> allCars = ListCarLogic.getListCar();
		if ( !allCars.contains(car)) { 
			FileRW.addLine(FileRW.getCarFilePath(),  car.toString() );
		} else {
			FileRW.writeLog("Duplicates found: " + car.toString() + " - skipped!");
		}
	}
	
	
	@Override
	public void deleteCar(Integer id) throws DAOException {
		List<Car> allCars = ListCarLogic.getListCar();
		   List<Car> carsForDeleting = ListCarLogic.getCarListByOneField(allCars, id.toString(), Car.CarFields.ID.toString());
   		   for(int i=0;i<carsForDeleting.size();i++) {
				FileRW.deleteLine(FileRW.getCarFilePath(),  carsForDeleting.get(i).toString() );
			}
	}

	@Override
	public String findCar(String searchingFields, String searchingValues) throws DAOException {
		StringBuilder sb = new StringBuilder();
		List<Car> allCars = ListCarLogic.getListCar();
		List<Car> foundedCars = ListCarLogic.getCarListByOneField(allCars, searchingValues, searchingFields.toUpperCase());
		if (foundedCars.size()>0) { 
			for ( Car c : foundedCars ) {
				sb.append(c.toString());
				sb.append('\n');
			}
		} else {
			sb.append("Not found anything.\n");
		}
		
		return sb.toString();		
	}
	
	@Override
	public RentCar getCar (Integer id) throws DAOException {
		RentCar foundedCar = null;
		try {
			   List<Car> allCars = ListCarLogic.getListCar();
			   List<Car> foundedCars = ListCarLogic.getCarListByOneField(allCars, id.toString(), Car.CarFields.ID.toString());
	   		   for(int i=0;i<foundedCars.size();i++) {
   			      foundedCar = (RentCar)foundedCars.get(i);
				}
			} catch (ClassCastException e) {
				
			}
		return foundedCar;
	}
	
	@Override
	public RentCarEco getCarEco (Integer id) throws DAOException {
		RentCarEco foundedCar = null;
		try {
			   List<Car> allCars = ListCarLogic.getListCar();
			   List<Car> foundedCars = ListCarLogic.getCarListByOneField(allCars, id.toString(), Car.CarFields.ID.toString());
	   		   for(int i=0;i<foundedCars.size();i++) {
	   			      foundedCar = (RentCarEco)foundedCars.get(i);
				}
			} catch (ClassCastException e) {}
		return foundedCar;
	}
	
	@Override
	public String getCarAsString (Integer id) throws DAOException {
		String foundedCarAsString = "";
		RentCar foundedCar = getCar(id);
		if (foundedCar == null) {
				RentCarEco foundedCarEco = getCarEco(id);
				foundedCarAsString = foundedCarEco.toString();
		} else {
			foundedCarAsString = foundedCar.toString();
		}
		return foundedCarAsString;
	}

	
	@Override
	public void updateCar(Integer id, String updatingField, String newValue) throws DAOException, FieldNotFoundException {
		
		
		Car foundCar = getCar(id);
		String oldCar = "";
		String newCar = "";
		
		try {
			oldCar = foundCar.toString();
			switch (Car.CarFields.valueOf(updatingField)) {
				case MODEL: { foundCar.setModel(newValue);break;}
				case MODELTYPE: { foundCar.setModelType(newValue);break;}
				case YEARMANUFACTURED: { foundCar.setYearManufactured(Integer.parseInt(newValue));break;}
				case CARCASE: {foundCar.setCarCase( Car.CarCase.valueOf(newValue));break;}
				case RENTPRICEPERDAY: {foundCar.setRentPricePerDay(Float.parseFloat(newValue));break;}
			}
			newCar = foundCar.toString();
		} catch (IllegalArgumentException e) {
			
			RentCar foundedCar = (RentCar) foundCar;
			try {
				if (foundedCar != null) {
					switch (RentCar.CarFields.valueOf(updatingField)) {
						case FUEL: {foundedCar.setFuel( RentCar.FuelType.valueOf(newValue));break;}
						case TRANSMISSION: {foundedCar.setTransmission( RentCar.TransmissionType.valueOf(newValue));break;}
					}
					newCar = foundedCar.toString();
				} else {
					RentCarEco foundedCarEco = (RentCarEco) foundCar;
					switch (RentCarEco.CarFields.valueOf(updatingField)) {
						case MAXDISTANCE: {foundedCarEco.setMaxDistance(Integer.parseInt(newValue));break;}
					}
					newCar = foundedCarEco.toString();	
				}
				
			} catch (IllegalArgumentException e1) {
				throw new DAOException("Incorrect Value! ("+ newValue + " not in List).");
			}
		}
		FileRW.updateLine( FileRW.getCarFilePath() , oldCar, newCar);
			
			/*
			RentCar foundedCar = getCar(id);
			if (foundedCar == null) {
				RentCarEco foundedCarEco = getCarEco(id);
				oldCar = foundedCarEco.toString();
				try {
					switch (RentCarEco.CarFields.valueOf(updatingField)) {
						case MAXDISTANCE: {foundedCarEco.setMaxDistance(Integer.parseInt(newValue));break;}
					}
				}  catch (IllegalArgumentException e) {
					throw new FieldNotFoundException();
				}
				
			} else {
				
			}
				
			
		}	
		
		
		
		
		
		RentCar foundedCar = getCar(id);
		
		//if ( foundedCar.searchByField(searchingString, fieldForSearch)) 
		
		
			
			if (foundedCar == null) {
				RentCarEco foundedCarEco = getCarEco(id);
				oldCar = foundedCarEco.toString();
				try {
					switch (RentCarEco.CarFields.valueOf(updatingField)) {
						case MAXDISTANCE: {foundedCarEco.setMaxDistance(Integer.parseInt(newValue));break;}
					}
				}  catch (IllegalArgumentException e) {}
				
				try {
					switch (Car.CarFields.valueOf(updatingField)) {
						case MODEL: { foundedCarEco.setModel(newValue);break;}
						case MODELTYPE: { foundedCarEco.setModelType(newValue);break;}
						case YEARMANUFACTURED: { foundedCarEco.setYearManufactured(Integer.parseInt(newValue));break;}
						case CARCASE: {foundedCarEco.setCarCase( Car.CarCase.valueOf(newValue));break;}
						case RENTPRICEPERDAY: {foundedCarEco.setRentPricePerDay(Float.parseFloat(newValue));break;}
					}
				} catch (IllegalArgumentException e) {
					throw new FieldNotFoundException();
				}	
				newCar = foundedCarEco.toString();
				
			} else {
				oldCar = foundedCar.toString();
				

				try {				
					switch (Car.CarFields.valueOf(updatingField)) {
						case MODEL: { foundedCar.setModel(newValue);break;}
						case MODELTYPE: { foundedCar.setModelType(newValue);break;}
						case YEARMANUFACTURED: { foundedCar.setYearManufactured(Integer.parseInt(newValue));break;}
						case CARCASE: {foundedCar.setCarCase( Car.CarCase.valueOf(newValue));break;}
						case RENTPRICEPERDAY: {foundedCar.setRentPricePerDay(Float.parseFloat(newValue));break;}
					}
				} catch (IllegalArgumentException e) {
					throw new FieldNotFoundException();
				}	
				newCar = foundedCar.toString();
			}*/
			
	}
	
}
