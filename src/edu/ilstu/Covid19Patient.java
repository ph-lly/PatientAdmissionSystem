/*
 * Created on: Feb 8, 2024
 * 
 * ULID: pbnguye
 * Class: IT 179
 */
package edu.ilstu;

/**
 * Covid19Patient class 
 * @author Phillip
 *
 */
public class Covid19Patient extends Patient {

	private double temperature;

	/**
	 * Overloaded constructor for initialization
	 * @param id - id to be used
	 * @param fName - first name to be used
	 * @param lName - last name to be used
	 * @param age - age to be used
	 * @param temperature - temperature to be used
	 */
	public Covid19Patient(int id, String fName, String lName, int age, double temperature) {
		super(id, fName,lName, age);
		this.temperature = temperature;
	}
	
	/**
	 * method that gets the patient's current temperature
	 * @return - double
	 */
	public double getTemp() {
		return temperature;
	}

	/**
	 * method that sets the patient's current temperature
	 * @param temperature - temperature to be used
	 */
	public void setTemp(double temperature) {
		this.temperature = temperature;
	}
	
	/**
	 * inherited treat method that give a certain treatment based on the patient's temperature
	 * @return - String
	 */
	public String treat() {
		String treatment = "none";
		if (this.getAge() > 70 && this.temperature > 39.75) {
			treatment = "Paxlovid";
		}
		else if (this.temperature > 41) {
			treatment = "Dexamethasone";
		}
		else {
			treatment = "Fluids and Acetaminophen";
		}
		
		return treatment;
	}

	/**
	 * toString method that returns a string formatting all of the fields with labels
	 * @return - String
	 */
	@Override
	public String toString() {
		return "Id: " + this.getId() + "\nFull name: " + this.getfName() + " " + this.getlName() + "\nAge: " + this.getAge() + "\nTemperature: " + this.temperature + "\nPCR test result: Positive" + "\nTreatment: " + this.treat() + "\n";
	}
	
	
}
