package com.skilldistillery.jets.models;

public class CargoPlane extends Jet implements CargoCarrier {

	
	
	public CargoPlane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadCargo() {
		System.out.println("Loaded and ready!");
	}

}
