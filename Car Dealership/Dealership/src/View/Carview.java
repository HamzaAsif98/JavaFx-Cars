package View;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Carview {



	//Width and height of the window
	private final int WIDTH;
	private final int HEIGHT;


	//primary box to hold everything
	private VBox primaryBox;

	//heading text
	private Text headingOneText, headingTwoText;


	//Input fields for parameters to create car
	private TextField textmake;
	private Label Carmake;
	private static final String CAR_MAKE_NAME_INPUT_PROMPT_TEXT = "Make";

	private TextField carmo;
	private Label Carmodel;
	private static final String CAR_MODEL_NAME_INPUT_PROMPT_TEXT = "Model";

	private TextField reg;
	private Label carreg;
	private static final String CAR_REG_INPUT_PROMPT_TEXT = "Reg No";

	private TextField year;
	private Label manufacture;
	private static final String CAR_YEAR_INPUT_PROMPT_TEXT = "Manufacture year";

	private TextField mile;
	private Label mileage;
	private static final String CAR_MILEAGE_INPUT_PROMPT_TEXT = "Mileage";

	private TextField remove;
	private Label removeindex;
	private static final String CAR_REMOVE_INPUT_PROMPT_TEXT = "Car Index Remove";


	//Buttons

	Button AddCar;
	Button PrintCars;
	Button Remove;
	Button Report1;
	Button Report2;
	Button Report3;
	Button Exit;


	//output text area
	private TextArea outputTextArea;


	private final static Font headingOneFont = Font.font("Helvetica", 35);
	private final static Font headingTwoFont = Font.font("Helvetica", 15);


	public Carview(int WIDTH, int HEIGHT) {

		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;

		//method to set up the layout.
		createLayout();

	}

	public void createLayout() {


		primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(50);
		//primaryBox.setStyle("-fx-background-color: white");
		//primaryBox.setStyle("fx-text-fill: white");

		//Set Background

		BackgroundImage myBI = new BackgroundImage(new Image("https://images.wallpaperscraft.com/image/lights_car_dark_128635_1920x1080.jpg",
				WIDTH, HEIGHT, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		primaryBox.setBackground(new Background(myBI));

		///////////////HeadingBox////////////////////////////////

		headingOneText = new Text("WELCOME TO CAR SYSTEM");
		headingTwoText = new Text("You can add cars,remove cars, print cars and get Report");

		headingOneText.setFont(headingOneFont);
		headingOneText.setFill(Color.WHITE);
		headingTwoText.setFont(headingTwoFont);
		headingTwoText.setFill(Color.WHEAT);

		VBox headingBox = new VBox(headingOneText, headingTwoText);
		headingBox.setAlignment(Pos.CENTER);
		headingBox.setSpacing(10);

		////////////////BodyBox//////////////////////////////////
		//-----------------Make--------------------//
		textmake = new TextField();
		textmake.setPromptText("Please Enter: " + CAR_MAKE_NAME_INPUT_PROMPT_TEXT);
		textmake.setPrefWidth(WIDTH * .25);

		Carmake = new Label(CAR_MAKE_NAME_INPUT_PROMPT_TEXT );
		Carmake.setPrefWidth(WIDTH * .15);
		Carmake.setTextFill(Color.WHITE);



		HBox make = new HBox(Carmake, textmake);
		make.setPrefWidth(WIDTH);
		make.setAlignment(Pos.CENTER);
		make.setSpacing(5);

		// --------------model Input box ------------------- //
		carmo = new TextField();
		carmo.setPromptText("Please Enter: " + CAR_MODEL_NAME_INPUT_PROMPT_TEXT);
		carmo.setPrefWidth(WIDTH * .25);

		Carmodel = new Label(CAR_MODEL_NAME_INPUT_PROMPT_TEXT);
		Carmodel.setPrefWidth(WIDTH * .15);
		Carmodel.setTextFill(Color.WHITE);


		HBox model = new HBox(Carmodel, carmo);
		model.setPrefWidth(WIDTH);
		model.setAlignment(Pos.CENTER);
		model.setSpacing(5);

		// -------------- Reg Input box ------------------- //
		reg = new TextField();
		reg.setPromptText("Please Enter: " + CAR_REG_INPUT_PROMPT_TEXT);
		reg.setPrefWidth(WIDTH * .25);

		carreg = new Label(CAR_REG_INPUT_PROMPT_TEXT);
		carreg.setPrefWidth(WIDTH * .15);
		carreg.setTextFill(Color.WHITE);


		HBox regbox = new HBox(carreg, reg);
		regbox.setPrefWidth(WIDTH);
		regbox.setAlignment(Pos.CENTER);
		regbox.setSpacing(5);


		// -------------- Year Input box ------------------- //
		year = new TextField();
		year.setPromptText("Please Enter: " + CAR_YEAR_INPUT_PROMPT_TEXT);
		year.setPrefWidth(WIDTH * .25);

		manufacture = new Label(CAR_YEAR_INPUT_PROMPT_TEXT);
		manufacture.setPrefWidth(WIDTH * .15);
		manufacture.setTextFill(Color.WHITE);

		HBox yearbox = new HBox(manufacture, year);
		yearbox.setPrefWidth(WIDTH);
		yearbox.setAlignment(Pos.CENTER);
		yearbox.setSpacing(5);




		// -------------- Mile Input box ------------------- //
		mile = new TextField();
		mile.setPromptText("Please Enter: " + CAR_MILEAGE_INPUT_PROMPT_TEXT);
		mile.setPrefWidth(WIDTH * .25);

		mileage = new Label(CAR_MILEAGE_INPUT_PROMPT_TEXT);
		mileage.setPrefWidth(WIDTH * .15);
		mileage.setTextFill(Color.WHITE);


		HBox milebox = new HBox(mileage, mile);
		milebox.setPrefWidth(WIDTH);
		milebox.setAlignment(Pos.CENTER);
		milebox.setSpacing(5);


		//--------------remove by index ---------------///
		remove = new TextField();
		remove.setPromptText("Please Enter: " + CAR_REMOVE_INPUT_PROMPT_TEXT );
		remove.setPrefWidth(WIDTH * .25);

		removeindex = new Label(CAR_REMOVE_INPUT_PROMPT_TEXT );
		removeindex.setPrefWidth(WIDTH * .15);
		removeindex.setTextFill(Color.WHITE);


		HBox re = new HBox(removeindex, remove);
		re.setPrefWidth(WIDTH);
		re.setAlignment(Pos.CENTER);
		re.setSpacing(5);


		//adding all the input parameter boxes into a vbox

		VBox bodyBox = new VBox(make,
				model
				, regbox
				, yearbox
				,milebox
				,re);

		bodyBox.setMaxWidth(WIDTH);
		bodyBox.setAlignment(Pos.CENTER);
		bodyBox.setSpacing(5);

		////////////////BodyTwoBox//////////////////////////////////

		// --------------  Add Car button ------------------- //
		AddCar = new Button("Add Car");

		// --------------  Print All Car Button ------------------- //
		PrintCars = new Button("Print Cars");

		// --------------  Remove All Car Button ------------------- //
		Remove = new Button("Remove Cars");

		// --------------  Report 1 ------------------- //
		Report1 = new Button("Report 1");

		// --------------  Report 2 ------------------- //
		Report2 = new Button("Report 2");

		// --------------  Report 3 ------------------- //
		Report3 = new Button("Report 3");

		// --------------  Exit  Button ------------------- //
		Exit = new Button("Exit");


		//adding all the buttons into an hbox
		HBox buttonBox = new HBox(AddCar, PrintCars, Remove,Report1,Report2,Report3,Exit);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setMinWidth(WIDTH);
		buttonBox.setSpacing(20);


		//adding all the hbox into a vbox
		VBox bodyTwoBox = new VBox(buttonBox);

		//bodyBox.setPrefHeight(HEIGHT * 0.33);
		bodyTwoBox.setMaxWidth(WIDTH);
		bodyTwoBox.setAlignment(Pos.CENTER);
		bodyTwoBox.setSpacing(5);

		////////////////BodyThreeBox//////////////////////////////////

		outputTextArea = new TextArea("");
		outputTextArea.setMaxWidth(WIDTH * .95);

		VBox bodyThreeBox = new VBox(outputTextArea);

		bodyThreeBox.setMaxWidth(WIDTH);
		bodyThreeBox.setAlignment(Pos.CENTER);
		bodyThreeBox.setSpacing(5);


		//adding the heading, and three body into the primaryBox

		primaryBox.getChildren().add(headingBox);
		primaryBox.getChildren().add(bodyBox);
		primaryBox.getChildren().add(bodyTwoBox);
		primaryBox.getChildren().add(bodyThreeBox);


	}

	//returns the layout (vbox)

	public Parent getParent() {
		return primaryBox;
	}


	//process button actions (handler function is sent from controller class)


	public void setAddCarButtonAction(EventHandler<ActionEvent> handler) {
		AddCar.setOnAction(handler);
	}

	public void setPrintCarsAction(EventHandler<ActionEvent> handler) {
		PrintCars.setOnAction(handler);
	}

	public void setRemoveAction(EventHandler<ActionEvent> handler) {
		Remove.setOnAction(handler);
	}
	public void setreport1(EventHandler<ActionEvent> handler) {
		Report1.setOnAction(handler);
	}

	public void setreport2(EventHandler<ActionEvent> handler) {
		Report2.setOnAction(handler);
	}

	public void setreport3(EventHandler<ActionEvent> handler) {
		Report3.setOnAction(handler);

	}
	public void setExitAction(EventHandler<ActionEvent> handler) {
		Exit.setOnAction(handler);

	}


	//change the text in the outputTextArea

	public void displayResultText(String output) {

		outputTextArea.setText(output);
	}


	//clear all inputs for the car parameters
	public void clearInputs() {
		textmake.clear();
		carmo.clear();
		reg.clear();
		year.clear();
		mile.clear();
	}


	//getters for car parameters to pass to car class

	public String getmake() {
		return textmake.getText();
	}

	public String getmodel() {
		return carmo.getText();
	}

	public String getreg() {
		return reg.getText();
	}

	public String getyear() {

		return year.getText();
	}
	public String getmile() {

		return mile.getText();
	}
	public String getremove() {
		return remove.getText();
	}


	public void setTextAreaText(String s){
		outputTextArea.setText(s);
	}
	


	public void showError(String errorMessage) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Input Error");
		alert.setHeaderText(null);
		alert.setContentText(errorMessage);
		alert.showAndWait();
	}

}

