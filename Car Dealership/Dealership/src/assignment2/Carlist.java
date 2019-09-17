package assignment2;

import java.io.Serializable;
import java.util.ArrayList;


import CarModel.vehicle;

public class Carlist implements Serializable{
	private ArrayList<vehicle> listOfCars;


	public Carlist() {

		listOfCars = new ArrayList<>();

	}
/**
 * this method is use to add car in the list
 * @param myvehicle
 */
	public void addCar(vehicle myvehicle) {

		listOfCars.add(myvehicle);

	}
/**
 * this method is use to remove car from the list by index
 * @param indexNum
 * @return
 */
	public vehicle removeCar(int indexNum) {

		vehicle removedvehicle = null;

		try {
			removedvehicle = listOfCars.get(indexNum);
			listOfCars.remove(indexNum);
		}
		catch (IndexOutOfBoundsException e ) {
			System.out.println(e.toString());
		}

		return removedvehicle;
	}

	//getters
	/**
	 * this method is use to list all cars in the 
	 * @return list of Cars
	 */

	public ArrayList<vehicle> getListOfCars() {
		return listOfCars;
	}

/**
 * 
 * @param listOfCars
 */
	//setters
	public void setListOfCars(ArrayList<vehicle> listOfCars) {
		this.listOfCars = listOfCars;
	}


	// 
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 1; i <= listOfCars.size(); i++){
			vehicle car = listOfCars.get(i-1);
			str.append(i + ": "+ "Car Make " + car.getmake().toString()
					+ " , " + "Car Model " + car.getmodel().toString()
					+ " , " + "Car Reg " + car.getreg().toString()
					+ " , " + "Car Manufacture Year " + car.getyear()
					+ " , " + "Car Mileage " + car.getmile() + "\n");
		}
		return str.toString();
	}




}
