package by.htp.ahremenko.bean;

import by.htp.ahremenko.dao.impl.FileRW;

public abstract class Car {
	private Integer yearManufactured;
	private String model;
	private String modelType;
	private Integer id;
	private CarCase carCase;
	private Float rentPricePerDay;

	public enum CarCase { SEDAN, HATCHBACK, BUS, JEEP, ND}
	
	public enum CarFields {
		ID(true), MODEL(true), MODELTYPE(false), YEARMANUFACTURED(true), CARCASE(true), RENTPRICEPERDAY(true);
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
	
	public Car (){
		id = -1;
		model = "";
		modelType = "";
		yearManufactured = 1900;
		carCase = CarCase.ND;
		rentPricePerDay = 0f;
	}
	
	public Car (Integer i, String m, String mt, CarCase c, Integer y, Float r) {
		id = i;
		model = m;
		modelType = mt;
		carCase = c;
		yearManufactured = y;		
		rentPricePerDay = r;
	}
	
	public Integer getYearManufactured() {
		return yearManufactured;
	}

	public void setYearManufactured(Integer yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

	public String getModel() {
		return model;
	}
	
	public Float getRentPricePerDay() {
		return rentPricePerDay;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CarCase getCarCase() {
		return carCase;
	}

	public void setCarCase(CarCase case1) {
		this.carCase = case1;
	}
	
	public void setRentPricePerDay(Float rentPricePerDay) {
		this.rentPricePerDay = rentPricePerDay;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carCase == null) ? 0 : carCase.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result
				+ ((modelType == null) ? 0 : modelType.hashCode());
		result = prime * result
				+ ((rentPricePerDay == null) ? 0 : rentPricePerDay.hashCode());
		result = prime
				* result
				+ ((yearManufactured == null) ? 0 : yearManufactured.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
		return true;
	}

	@Override
	public String toString() {
		return id + FileRW.csvDelimiter  + model + FileRW.csvDelimiter + modelType + FileRW.csvDelimiter + carCase + FileRW.csvDelimiter + yearManufactured + FileRW.csvDelimiter + rentPricePerDay + FileRW.csvDelimiter;
		//return "\r\n Book [title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", pages=" + pages
		//		+ ", publisherName=" + publisherName + "]";
	}
	
	public boolean searchByField (String searchingString, CarFields fieldForSearch) {
		switch (fieldForSearch) {
		case ID: return ( this.id == Integer.parseInt(searchingString) );
		case MODEL: return this.model.equals(searchingString);
		case MODELTYPE: return this.modelType.equals(searchingString);
		case CARCASE: return this.carCase.equals(searchingString); 
		case YEARMANUFACTURED: return ( this.yearManufactured == Integer.parseInt(searchingString) );
		case RENTPRICEPERDAY: return ( this.rentPricePerDay == Float.parseFloat(searchingString) );
		}
		return false;
	}	
}


