package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


import CarModel.vehicle;
import Sortor.naturalorder;
import View.Carview;
import assignment2.Car;
import assignment2.Carlist;
import assignment2.makeorder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Carcontroller extends Application {
	private Carlist cars;
	private Carview gui;


	private static final int WIDTH = 800, HEIGHT = 550;
/**
 * carController constructor
 */

	public Carcontroller() {

		cars = new Carlist(); // the model
		gui = new Carview(WIDTH,HEIGHT); // the view

		//hook up buttons to action handlers below
		gui.setAddCarButtonAction(arg0 -> {
			try {
				processAddCar(arg0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		gui.setPrintCarsAction(this::processPrintAll);
		gui.setreport1(this::report1);
		gui.setreport2(this::report2);
		gui.setreport3(this::report3);
		gui.setRemoveAction(this::processRemove);
		gui.setExitAction(this::Exit);

	}


/**
 * this is use to set action on button and decide what will Add button do
 * @param event
 * @throws IOException
 */

	private void processAddCar(ActionEvent event) throws IOException {



		try {
			String make = gui.getmake();
			String model     = gui.getmodel();
			String reg     = gui.getreg();
			int year       = Integer.parseInt(gui.getyear());
			int mile       = Integer.parseInt(gui.getmile());

			cars.addCar(new Car(make,model,reg,year,mile));
			String filename = "car.ser";
			try {
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("car.ser"));
				os.writeObject(cars);
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gui.clearInputs();

		} catch (IllegalArgumentException e) {
			gui.showError(" Name must have only letters\n-"
					+ " Car must have between 2 and 6 doors");
		} 
	}

/**
 * this is use to set action on button and decide what will Print button do
 * @param event
 */
	private void processPrintAll(ActionEvent event) {

		try {
			ObjectInputStream is = new ObjectInputStream (new FileInputStream("car.ser"));
			cars = (Carlist) is.readObject();
			gui.setTextAreaText(cars.toString());
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
/**
 * this is use to set action on button and decide what will Remove button do
 * @param event
 */
	private void processRemove(ActionEvent event ) {

		//write method to remove all car from car database
		// simple instantiate a new Carlist object assign to this variable
		// will clear the list.
		try {
			int index =Integer.parseInt(gui.getremove()) ;
			cars.removeCar(index);
			gui.clearInputs();
		}catch (IllegalArgumentException e) {
			gui.showError("Enter valid Index");
		}finally {
			gui.setTextAreaText(cars.toString());
		}
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("car.ser"));
			os.writeObject(cars);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gui.clearInputs();
	}
	private void report1(ActionEvent event) {
		//Collection.sort(cars,new naturalorder());
		
	}  


	private void report2(ActionEvent event) {
//Didnt completed

	}
	private void report3(ActionEvent event) {
//didnt completed
	}
	/**
	 * this method is use to exit program
	 * @param event
	 */
	private void Exit(ActionEvent event) {
		Platform.exit();

	}

public void loop() throws InterruptedException {
	int dummyArraySize = 15;
	System.out.println("Max JVM memory: " + Runtime.getRuntime().maxMemory());
	long memoryConsumed = 0;
	try {
		long[] memoryAllocated = null;	
		for (int loop = 0; loop < Integer.MAX_VALUE; loop++) {
			memoryAllocated = new long[dummyArraySize];
			memoryAllocated[0] = 0;
			memoryConsumed += dummyArraySize * Long.SIZE;
			System.out.println("Memory Consumed till now: " + memoryConsumed);
			dummyArraySize *= dummyArraySize * 2;
			Thread.sleep(500);
		}
	} catch (OutOfMemoryError outofMemory) {
		System.out.println("Catching out of memory error");
		//Log the information,so that we can generate the statistics (latter on).
		throw outofMemory;
	}
}



	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Carcontroller controller = new Carcontroller();
		
		Scene scene = new Scene(controller.gui.getParent(), WIDTH, HEIGHT, Color.TRANSPARENT);
	
		primaryStage.setTitle("Car App : Create,Remove and Report Card!");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		//loop();
		
	}

	public static void main(String[] args) {
		launch(args);
		
		
	}














}


