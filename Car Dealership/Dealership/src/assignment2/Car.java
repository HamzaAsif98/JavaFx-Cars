package assignment2;

import java.util.Comparator;

import CarModel.vehicle;

public class Car extends vehicle {
	private static int numOfCarsCreated = 0;

/**
 * constructor
 * @param make
 * @param model
 * @param Reg
 * @param manufactureyear
 * @param mileage
 */
	public Car(String make, String model, String Reg, int manufactureyear,int mileage) {
		super(make,model,Reg,manufactureyear,mileage);
		numOfCarsCreated++;
	}

/**
 * 
 * @return numofCars that are created
 */

	public static int getNumOfCarsCreated() {
		return numOfCarsCreated;
	}
	/**
	 * 
	 * @param numOfCarsCreated
	 */

	public static void setNumOfCarsCreated(int numOfCarsCreated) {
		Car.numOfCarsCreated = numOfCarsCreated;
	}





}
