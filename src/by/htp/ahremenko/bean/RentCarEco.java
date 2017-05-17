package by.htp.ahremenko.bean;

import by.htp.ahremenko.bean.Car.CarCase;
import by.htp.ahremenko.bean.RentCar.FuelType;
import by.htp.ahremenko.bean.RentCar.TransmissionType;
import by.htp.ahremenko.dao.impl.FileRW;

public class RentCarEco extends Car {
	private Integer maxDistance;
	
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
	
	
}
