package com.skilldistillery.jets.models;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	
	public Jet() {
		super();
	}

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public double getSpeedInMach() {
		
		return 0.00;
	}
	
	public void fly() {
		System.out.println("Just flying around in my " + model);
	}

	@Override
	public String toString() {
		if(model.equalsIgnoreCase("F-16") || model.equalsIgnoreCase("F-22")) {
			return model + "\t\tMax Speed: " + speed + "\tRange:" + range + "\tPrice: " + price + "\n";
		}
		if(model.equalsIgnoreCase("Kruk")) {
			return model + "\t\tMax Speed: " + speed + "\t\tRange:" + range + "\tPrice: " + price + "\n";
		}
		return  model + "\tMax Speed: " + speed + "\tRange:" + range + "\tPrice: " + price + "\n";
	}
	
	
	
	
}
