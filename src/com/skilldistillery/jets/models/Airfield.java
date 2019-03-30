package com.skilldistillery.jets.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	private List<Jet> jets;
	private String fileName = "./InitialData.txt";

	public Airfield() {
		jets = populateAirfield(fileName);
		System.out.println("Airfield populated");
		
	}

	public List<Jet> populateAirfield(String file) {
		List<Jet> jet1 = new ArrayList<Jet>();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] jetInfo = line.split(",");
				if (jetInfo[0].equalsIgnoreCase("Cargo")) {
					Jet jet = new CargoPlane(jetInfo[1], Double.parseDouble(jetInfo[2]), Integer.parseInt(jetInfo[3]),
							Long.parseLong(jetInfo[4]));
					jet1.add(jet);
				} else if (jetInfo[0].equalsIgnoreCase("Fighter")) {
					Jet jet = new FighterPlane(jetInfo[1], Double.parseDouble(jetInfo[2]), Integer.parseInt(jetInfo[3]),
							Long.parseLong(jetInfo[4]));
					jet1.add(jet);
				} else if (jetInfo[0].equalsIgnoreCase("CropDuster")) {
					Jet jet = new CropPlane(jetInfo[1], Double.parseDouble(jetInfo[2]), Integer.parseInt(jetInfo[3]),
							Long.parseLong(jetInfo[4]));
					jet1.add(jet);

				}
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return jet1;

	}

	public void addCargo(String model, double speed, int range, long price) {
		CargoPlane cp = new CargoPlane(model, speed, range, price);
		jets.add(cp);
	}
	public void addFighter(String model, double speed, int range, long price) {
		FighterPlane fp = new FighterPlane(model, speed, range, price);
		jets.add(fp);
	}
	public void addCropPlane(String model, double speed, int range, long price) {
		CropPlane cp = new CropPlane(model, speed, range, price);
		jets.add(cp);
	}

	@Override
	public String toString() {
		return jets.toString();
	}
	public void fly() {
		for(Jet jet : jets) {
			jet.fly();
		}
	}
	
	public void displayFastestJet() {
		double fastestSpeed = 0;
		String model = "";
		long price = 0;
		int range = 0;
		for(Jet jet: jets) {
			if(jet.getSpeed() > fastestSpeed) {
				fastestSpeed = jet.getSpeed();
				model = jet.getModel();
				price = jet.getPrice();
				range = jet.getRange();
			}
		}
		System.out.println("The fastest aircraft at our airfield, the " + model + ", can go " + fastestSpeed + " MPH for " + range + " miles and costs $" + price);
	}
	
	public void displayLongestRange() {
		int longestRange = 0;
		String model = "";
		long price = 0;
		double speed = 0.0;
		for(Jet jet: jets) {
			if(jet.getRange() > longestRange) {
				longestRange = jet.getRange();
				model = jet.getModel();
				price = jet.getPrice();
				speed = jet.getSpeed();
			}
		}
		System.out.println("The aircraft with the longest range at our airfield, the " + model + ", can go " + longestRange + " miles at " + speed + " MPH and cost $" + price);
		
	}
	
	public void displayCargoJets() {
		for(Jet jet : jets) {
			if(jet instanceof CargoPlane) {
				System.out.print(jet.getModel() + " ");
				((CargoPlane) jet).loadCargo();
			}
		}
	}
	public void fight() {

		for(Jet jet : jets) {
			if(jet instanceof FighterPlane) {
				((FighterPlane) jet).fight();
			}
		}
	}

	public void removePlane(int index) {
		
		jets.remove(index);
		System.out.println();
	}
	
	public void printListOfInventory() {
		int count = 1;
		for (Jet jet : jets) {
			System.out.println(count + ": " + jet);
			count++;
		}
	}
	
	public void getJet(int index) {
		
		System.out.println(jets.get(index));
	}

	
	
}
