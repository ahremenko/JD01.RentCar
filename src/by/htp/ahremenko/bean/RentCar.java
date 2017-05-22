package by.htp.ahremenko.bean;

import by.htp.ahremenko.bean.Car.CarCase;
import by.htp.ahremenko.bean.RentCarEco.CarFields;
import by.htp.ahremenko.bean.exception.FieldNotFoundException;
import by.htp.ahremenko.dao.impl.FileRW;

public class RentCar extends Car {
	
	public enum TransmissionType { MT, AT, ND}
	public enum FuelType {DIESEL, GAS, BENZINE, ND}
	
	public enum CarFields {
		//ID(true), MODEL(true), MODELTYPE(false), YEARMANUFACTURED(true), CARCASE(true), RENTPRICEPERDAY(true), 
		FUEL(false), TRANSMISSION(true);
		private boolean isAsc;
		private CarFields(boolean ascend) {
			this.isAsc = ascend;
		}
		public void setAscend(boolean ascend) {
			this.isAsc = ascend;
		}
		public boolean getAscend() {
			return isAsc;
		}
	}
	
	private TransmissionType transmission;
	private FuelType fuel;
	
	public TransmissionType getTransmission() {
		return transmission;
	}
	public void setTransmission(TransmissionType transmission) {
		this.transmission = transmission;
	}
	
	public FuelType getFuel() {
		return fuel;
	}
	public void setFuel(FuelType fuel) {
		this.fuel = fuel;
	}
	public RentCar () {
		super();
	}
	
	public RentCar (Integer i, String m, String mt, CarCase c, Integer y, Float r, TransmissionType t, FuelType f) {
		super(i, m, mt, c, y, r);
		setTransmission(t);
		setFuel(f);
	}
	
	@Override
	public String toString() {
		return super.toString() + transmission + FileRW.csvDelimiter + fuel + FileRW.csvDelimiter;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carCase != other.carCase)
			return false;
		// ignore ID ! 
		/*if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;*/
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (modelType == null) {
			if (other.modelType != null)
				return false;
		} else if (!modelType.equals(other.modelType))
			return false;
		if (rentPricePerDay == null) {
			if (other.rentPricePerDay != null)
				return false;
		} else if (!rentPricePerDay.equals(other.rentPricePerDay))
			return false;
		if (yearManufactured == null) {
			if (other.yearManufactured != null)
				return false;
		} else if (!yearManufactured.equals(other.yearManufactured))
			return false;
		RentCar other1 = (RentCar) obj;
		if (transmission == null) {
			if ( other1.transmission!= null)
				return false;
		} else if (!transmission.equals(other1.transmission))
			return false;
		if (fuel == null) {
			if ( other1.fuel!= null)
				return false;
		} else if (!fuel.equals(other1.fuel))
			return false;
		
		return true;

	}
	
	/**
	 * return true if [fieldForSearch] of RentCar = [searchingString]
	 * and false in another cases 
	 */
	public boolean searchByField (String searchingString, String fieldForSearch) throws FieldNotFoundException {
		CarFields enumedField;
		try {
			enumedField = CarFields.valueOf(fieldForSearch);
		} catch (IllegalArgumentException e) {
			return super.searchByField(searchingString, fieldForSearch);
		}
		
		try {
			switch (enumedField) {
			case FUEL: return ( this.fuel == FuelType.valueOf( searchingString) );
			case TRANSMISSION: return ( this.transmission == TransmissionType.valueOf( searchingString) );
			}
		} catch (IllegalArgumentException e) {
			// if searchingString not in enum - nothing to do 
		}
		return false;
	}
	
}
