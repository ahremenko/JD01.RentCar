package by.htp.ahremenko.bean;

import by.htp.ahremenko.bean.Car.CarCase;
import by.htp.ahremenko.dao.impl.FileRW;

public class RentCar extends Car {
	
	public enum TransmissionType { MT, AT, ND}
	public enum FuelType {DIESEL, GAS, BENZINE, ND}
	
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
	

}
