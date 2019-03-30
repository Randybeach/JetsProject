package com.skilldistillery.jets.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.jets.models.Airfield;

public class JetsApp {
	private Airfield airfield;
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JetsApp app = new JetsApp();
		app.launch();
	}

	private void launch() {
		airfield = new Airfield();
		
		displayUserMenu();
	}

	private void displayUserMenu() {
		boolean go = true;
		int choice = 0;
		boolean correct = false;
		do {
			while(!correct) {
			try {
				printMenu();
				choice = sc.nextInt();
				
				if(choice <= 9 && choice >= 1) {
					correct = true;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter a number from 1-9.");
				sc.nextLine();
			}
			}
			switch (choice) {
			case 1:
				airfield.printListOfInventory();
				break;
			case 2:
				airfield.fly();
				break;
			case 3:
				airfield.displayFastestJet();
				break;
			case 4:
				airfield.displayLongestRange();
				break;
			case 5:
				airfield.displayCargoJets();
				break;
			case 6:
				airfield.fight();
				break;
			case 7:
				addPlane();
				break;
			case 8:
				removePlane();
				break;
			case 9:
				go = false;
				break;

			}
			correct = false;

		} while (go);
	}

	private void printMenu() {
		System.out.println(
				"\n1. List fleet\n2. Fly all jets\n3. View fastest jet\n4. View jet with longest range\n5. Load all cargo jets"
						+ "\n6. Dogfight!!\n7. Add a jet to fleet\n8. Remove a jet from fleet \n9. Quit");
	}
	
	private void addPlane() {
		int choice=0;
		String model = "";
		Double speed = 0.00;
		Integer range = 0;
		Long price = (long)000;
		boolean correct = false;
		while(!correct) {
			try {
				System.out.println("What type are you adding?\n1. Cargo\n2. Fighter\n3. Crop Duster\n4. Go Back");
				choice = sc.nextInt();
				if(choice > 0 && choice < 5) {
					correct = true;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter a number");
				sc.nextLine();
			}
		}
		correct = false;
		while(!correct) {
			try {
				System.out.println("What is the model");
				model = sc.next();
				if(model instanceof String) {
					correct = true;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter a model name");
				sc.nextLine();
			}
		}
		correct = false;
		while(!correct) {
			try {
				System.out.println("What is the speed?");
				speed = sc.nextDouble();
				if(speed instanceof Double) {
					correct = true;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter a number for speed");
				sc.nextLine();
			}
		}
		correct = false;
		while(!correct) {
			try {
				System.out.println("What is the range?");
				range = sc.nextInt();
				if(range instanceof Integer) {
					correct = true;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter a number for range");
				sc.nextLine();
			}
		}
		correct = false;
		while(!correct) {
			try {
				System.out.println("What is the price?");
				price = sc.nextLong();
				if(price instanceof Long) {
					correct = true;
				}
			} catch (Exception e) {
				System.err.println("Enter a number for price");
				sc.nextLine();
			}
		}
		switch(choice) {
		case 1: airfield.addCargo(model, speed, range, price);break;
		case 2: airfield.addFighter(model, speed, range, price);break;
		case 3: airfield.addCropPlane(model, speed, range, price);break;
		case 4: System.out.println("Back to menu");
		default:
		}
	}
	
	private void removePlane() {
		boolean correct = false;
		Integer choice = 0;
		while(!correct) {
			try {
				airfield.printListOfInventory();
				System.out.println("Which jet above do you want to remove?");
				choice = sc.nextInt();
				if(choice instanceof Integer) {
					correct = true;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter a number please");
				sc.nextLine();
			}
		}
		System.out.print("Are you sure you want to remove ");
		airfield.getJet(choice-1);
		correct = false;
		while(!correct) {
			
		try {
			String choiceString = sc.next();
			if(choiceString.equalsIgnoreCase("yes")) {
				airfield.removePlane(choice -1);
				System.out.println("Plane removed");
				correct = true;
			}
		} catch (InputMismatchException e) {
			System.err.println("Enter yes to remove aircraft or no to return to menu.");
		}
		}
	}

}
