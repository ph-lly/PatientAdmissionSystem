/*
 * Created on: Feb 8, 2024
 * 
 * ULID: pbnguye
 * Class: IT 179
 */
package edu.ilstu;

/**
 * Patient abstract class
 * @author Phillip
 *
 */
public abstract class Patient {

	private int id;
	private String fName;
	private String lName;
	private int age;
	private boolean pcr;
	
	/**
	 * Overloaded constructor field initialization
	 * @param id - id to be used
	 * @param fName - first name to be used
	 * @param lName - last name to be used 
	 * @param age - age to be used
	 */
	public Patient(int id, String fName, String lName, int age){
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	/**
	 * method that returns the id of the patient
	 * @return - int
	 */
	public int getId() {
		return id;
	}

	/**
	 * method that returns the first name of the patient
	 * @return - String
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * method that returns the last name of the patient
	 * @return - String
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * method that returns the age of the patient
	 * @return - int
	 */
	public int getAge() {
		return age;
	}

	/**
	 * method that returns the pcr result
	 * @return - boolean
	 */
	public boolean getPcr() {
		return pcr;
	}

	/**
	 * method that sets the patient's id
	 * @param id - id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * method that sets the first name of the patient
	 * @param fName - first name to be set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * method that sets the last name of the patient
	 * @param lName - last name to be set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * method that sets the age of the patient
	 * @param age - age to be set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * method that sets the pcr of the patient
	 * @param pcr - pcr to be set
	 */
	public void setPcr(boolean pcr) {
		this.pcr = pcr;
	}
	/**
	 * abstract method inherited by parent class that returns recommended treatment as a String
	 * @return - String
	 */
	public abstract String treat();

	/**
	 * toString method that returns a string with field labels
	 */
	@Override
	public String toString() {
		return "Patient ID: " + this.id + ", \nFull Name: " + this.fName + " " + this.lName + "\nAge: " + this.age + "\nPCR: " + this.pcr;
	}
	
	
}
