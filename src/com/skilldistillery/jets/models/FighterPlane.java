package com.skilldistillery.jets.models;

public class FighterPlane extends Jet implements CombatReady {

	
	
	public FighterPlane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FighterPlane(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fight() {
		System.out.println(super.getModel()+ " You can be my wingman anytime!");
	}

}
