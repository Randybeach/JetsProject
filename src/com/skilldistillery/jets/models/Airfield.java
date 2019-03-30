package com.skilldistillery.jets.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	private List<Jet> jets;
	private String fileName = "InitialData.txt";

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
				if (jetInfo[0].equalsIgnoreCase("CargoPlane")) {
					Jet jet = new CargoPlane(jetInfo[0],jetInfo[1], Double.parseDouble(jetInfo[2]), Integer.parseInt(jetInfo[3]),
							Long.parseLong(jetInfo[4]));
					jet1.add(jet);
				} else if (jetInfo[0].equalsIgnoreCase("FighterPlane")) {
					Jet jet = new FighterPlane(jetInfo[0],jetInfo[1], Double.parseDouble(jetInfo[2]), Integer.parseInt(jetInfo[3]),
							Long.parseLong(jetInfo[4]));
					jet1.add(jet);
				} else if (jetInfo[0].equalsIgnoreCase("CropPlane")) {
					Jet jet = new CropPlane(jetInfo[0], jetInfo[1], Double.parseDouble(jetInfo[2]), Integer.parseInt(jetInfo[3]),
							Long.parseLong(jetInfo[4]));
					jet1.add(jet);
				}else {
					Jet jet = new OtherPlane(jetInfo[0], jetInfo[1], Double.parseDouble(jetInfo[2]), Integer.parseInt(jetInfo[3]),
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

	public void addCargo(String type, String model, double speed, int range, long price) {
		CargoPlane cp = new CargoPlane(type, model, speed, range, price);
		jets.add(cp);
	}
	public void addFighter(String type, String model, double speed, int range, long price) {
		FighterPlane fp = new FighterPlane(type, model, speed, range, price);
		jets.add(fp);
	}
	public void addCropPlane(String type, String model, double speed, int range, long price) {
		CropPlane cp = new CropPlane(type, model, speed, range, price);
		jets.add(cp);
	}
	public void addOtherPlane(String type, String model, double speed, int range, long price) {
		OtherPlane op = new OtherPlane(type, model, speed, range, price);
		jets.add(op);
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
		double mach = 0.0;
		for(Jet jet: jets) {
			if(jet.getSpeed() > fastestSpeed) {
				fastestSpeed = jet.getSpeed();
				model = jet.getModel();
				price = jet.getPrice();
				range = jet.getRange();
				mach = jet.getSpeedInMach();
			}
		}
		System.out.println("The fastest aircraft at our airfield, the " + model + ", can go " + fastestSpeed + " MPH (mach " + mach + ") for " + range + " miles and costs $" + price);
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
	
	public void loadCargoJets() {
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

	public void savePlane(String fileName) {
		
		try {
			FileOutputStream fr = new FileOutputStream(fileName);
			PrintWriter pw = new PrintWriter(fr);
			System.out.println("Trying to populate file");
			for (Jet jet : jets) {
				String type = jet.getType();
				String model = jet.getModel();
				double speed = jet.getSpeed();
				int range = jet.getRange();
				long price = jet.getPrice();
				pw.println(type + "," + model + "," + speed + "," + range + "," + price);
				
			}
			System.out.println("All planes saved to file.");
			pw.close();
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public String getFileName() {
		return fileName;
	}
	public int jetsSize() {
		return jets.size();
	}
	
	
}
