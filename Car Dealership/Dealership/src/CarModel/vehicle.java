package CarModel;
import java.io.Serializable;
import java.util.Comparator;


public abstract class vehicle implements Serializable{
    private String make;
    private String model;
    private String Reg;
    private int manufactureyear;
    private int mileage;
/**
 * constructor for vehicle
 * @param make
 * @param model
 * @param reg
 * @param year
 * @param mile
 */
    public vehicle(String make, String model, String reg, int year, int mile) {

        this.make=make;
        this.model = model;
        this.Reg = reg;
        this.manufactureyear=year;
        this.mileage=mile;
    }


  
/**
 * takes in make from user input
 * @return make
 */
    //Getters

    public String getmake() {
        return make;
    }
    /**
     * takes in model from user input
     * @return model
     */
    public String getmodel() {
        return model;
    }
    /**
     * takes in reg from user input
     * @return reg
     */
    public String getreg() {
        return Reg;
    }
    /**
     * takes in manufactureyear from user input
     * @return manufactureyear
     */
    public int getyear() {
        return manufactureyear;
    }
    /**
     * takes in mileage from user input
     * @return mileage
     */
    public int getmile() {
        return mileage;
    }

    //Setter
/**
 * 
 * @param make
 */
    public void setMake(String make) {
        this.make = make;
    }
/**
 * 
 * @param model
 */
    public void setModel(String model) {
        this.model = model;
    }
    /**
     * 
     * @param reg
     */
    public void setreg(String reg) {
    	this.Reg=reg;
    	    }
    /**
     * 
     * @param year
     */
    public void setyear(int year) {
this.manufactureyear=year;
    }
/**
 * 
 * @param mile
 */

    public void setmile(int mile) {

     this.mileage=mile;
    }
 
/**
 * this methods print the details and overrides
 */
    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "Make ='" + make + '\'' +
                ", Model='" + model + '\'' +
                ", Reg No='" + Reg + '\'' +
                ",Manufacture year ='" + manufactureyear + '\'' +
                ", Mileage=" + mileage +
                '}' + "\n";
    }

   

    }
