package com.skilldistillery.jets.models;

public class CropPlane extends Jet implements SprayReady {
	
	

	public CropPlane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CropPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void spray() {
		System.out.println("Spray and pray!");
	}
	
	
	

}
