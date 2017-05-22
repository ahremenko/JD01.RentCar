package by.htp.ahremenko.bean;

import by.htp.ahremenko.bean.Car.CarCase;
import by.htp.ahremenko.bean.Car.CarFields;
import by.htp.ahremenko.bean.RentCar.FuelType;
import by.htp.ahremenko.bean.RentCar.TransmissionType;
import by.htp.ahremenko.bean.exception.FieldNotFoundException;
import by.htp.ahremenko.dao.impl.FileRW;

public class RentCarEco extends Car {
	private Integer maxDistance;

	public enum CarFields {
		//ID(true), MODEL(true), MODELTYPE(false), YEARMANUFACTURED(true), CARCASE(true), RENTPRICEPERDAY(true), 
		MAXDISTANCE(false);
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
	
	public RentCarEco () {
		super();
		setMaxDistance(-1);
	}

	public Integer getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(Integer maxDistance) {
		this.maxDistance = maxDistance;
	}
	
	public RentCarEco (Integer i, String m, String mt, CarCase c, Integer y, Float r, Integer md) {
		super(i, m, mt, c, y, r);
		setMaxDistance(md);
	}
	
	@Override
	public String toString() {
		return super.toString() + maxDistance + FileRW.csvDelimiter ;
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
		RentCarEco other1 = (RentCarEco) obj;
		if (maxDistance == null) {
			if ( other1.maxDistance!= null)
				return false;
		} else if (!maxDistance.equals(other1.maxDistance))
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
			case MAXDISTANCE: return ( this.maxDistance == Integer.parseInt(searchingString) );
			}
		} catch (NumberFormatException e) {
			// if number not Integer - nothing to do 
		}
		return false;
		
	}
	
	
}
