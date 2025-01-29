/*
 * Created on: Feb 8, 2024
 * 
 * ULID: pbnguye
 * Class: IT 179
 */
package edu.ilstu;

/**
 * Regular Patient class
 * @author Phillip
 *
 */
public class RegularPatient extends Patient{

	private String mainSymptom;
	
	/**
	 * Overloaded constructor for field initialization
	 * @param id - id to be used
	 * @param fName - first name to be used
	 * @param lName - last name to be used
	 * @param age - age to be used
	 * @param mainSymptom - main symptom to be used
	 */
	public RegularPatient(int id, String fName, String lName, int age, String mainSymptom) {
		super(id,fName,lName,age);
		this.mainSymptom = mainSymptom;
	}

	/**
	 * inherited treat method that give a certain treatment based on the patient's symptoms
	 * @return - String
	 */
	public String treat() {
		String treatment = "none";
		if (this.mainSymptom.equalsIgnoreCase("coughing")||this.mainSymptom.equalsIgnoreCase("stuffy nose")||this.mainSymptom.equalsIgnoreCase("runny nose")) {
			treatment = "Amoxicillin";
		}
		else if (this.mainSymptom.equalsIgnoreCase("hypertension")) {
			treatment = "ACE inhibitors";
		}
		else {
			treatment = "IV fluids";
		}
		return treatment;
	}

	/**
	 * toString method that prints fields in the provided format
	 */
	@Override
	public String toString() {
		return "Id: " + this.getId() + "\nFull name: " + this.getfName() + " " + this.getlName() + "\nAge: " + this.getAge() + "\nMain Symptom: " + this.mainSymptom + "\nPCR test result: Negative"  + "\nTreatment: " + this.treat() + "\n";
	}
	
}
