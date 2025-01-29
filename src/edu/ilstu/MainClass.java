/*
 * Created on: Feb 8, 2024
 * 
 * ULID: pbnguye
 * Class: IT 179
 */
package edu.ilstu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main hospital program for patients
 * @author Phillip
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Patient> hospital = new ArrayList<>();
		System.out.println("Welcome!");
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		String pcr = "unknown";
		while(choice != 6) {
			try {
				textMenu();
				choice = scan.nextInt();
				scan.nextLine(); //consume newline
				System.out.println();
				switch(choice) {
					case 1: //Admits a patient based on the PCR test result
						System.out.print("PCR Test Result (Enter negative or positive): ");
						pcr = scan.nextLine();
						if(pcr.equalsIgnoreCase("positive")) {
							System.out.print("Enter patient ID: ");
							int id = scan.nextInt();
							scan.nextLine(); //consume newline
							System.out.print("Enter patient first name: ");
							String fName = scan.nextLine();
							System.out.print("Enter patient last name: ");
							String lName = scan.nextLine();
							System.out.print("Enter patient age: ");
							int age = scan.nextInt();
							scan.nextLine(); //consume newline
							System.out.print("Enter patient temperature: ");
							double temperature = scan.nextDouble();
							Covid19Patient c19 = new Covid19Patient(id, fName, lName, age, temperature);
							c19.setPcr(true);
							hospital.add(c19); 
							System.out.println("\nPatient " + fName + " with Covid was added.");
						}
						else if(pcr.equalsIgnoreCase("negative")) {
							System.out.print("Enter patient ID: ");
							int id = scan.nextInt();
							scan.nextLine(); //consume newline
							System.out.print("Enter patient first name: ");
							String fName = scan.nextLine();
							System.out.print("Enter patient last name: ");
							String lName = scan.nextLine();
							System.out.print("Enter patient age: ");
							int age = scan.nextInt();
							scan.nextLine(); //consume newline
							System.out.print("Enter main symptom: ");
							String mainSymptom = scan.nextLine();
							RegularPatient regularPatient = new RegularPatient(id, fName, lName, age, mainSymptom);
							regularPatient.setPcr(false); // dont think I need this
							hospital.add(regularPatient);
							System.out.println("\nPatient " + fName + " without Covid was added.");
						}
						else {
							System.out.println("\nInvalid PCR Test Result.");
						}
						break;
					case 2: //prints current patients enrolled at the hospital
						if(hospital.isEmpty()) {
							System.out.println("No patients currently enrolled.");
						}
						else {
							System.out.println("Patients currently enrolled");
							System.out.println("+++++++++++++++++++++++++++++++++++++\n");
							for(Patient p : hospital) {
								if(p instanceof RegularPatient) {
									System.out.println(((RegularPatient)p).toString());
								}
								else if(p instanceof Covid19Patient) {
									System.out.println(((Covid19Patient)p).toString());
								}
								else {
									System.out.println("Irregular Patient found");
								}
							}
						}
						break;
					case 3: //updates the PCR test result for a patient
						System.out.print("Enter the ID of the patient you wish to update: ");
						int id = scan.nextInt();
						System.out.print("Submit PCR Test Result (positive or negative): ");
						scan.nextLine();
						pcr = scan.nextLine();
						boolean updatedpcr = false;
						boolean found = false;
						if (pcr.equalsIgnoreCase("positive")) {
							updatedpcr = true;
						}
						else if(pcr.equalsIgnoreCase("negative")) {
						}
						else {
							System.out.println("\nInvalid input.");
							break;
						}
						System.out.println("\nPCR Test Result to submit: " + pcr);
						for(int i = 0; i < hospital.size();i++) {
							if(hospital.get(i)!=null) {
								if(hospital.get(i).getId() == id) {
									found = true;
									hospital.get(i).setPcr(updatedpcr);
									System.out.println("Submitted PCR Test Result.");
									if (hospital.get(i).getPcr()) {
										if (hospital.get(i) instanceof RegularPatient) {
											System.out.println("Patient " + hospital.get(i).getfName()+ " has Covid.");
											System.out.print("\nEnter temperature for " + hospital.get(i).getfName() + ": ");
											double temperature = scan.nextDouble();
											Covid19Patient deepcopy = new Covid19Patient(hospital.get(i).getId(),hospital.get(i).getfName(),hospital.get(i).getlName(),hospital.get(i).getAge(), temperature);
											deepcopy.setPcr(updatedpcr);
											hospital.remove(i);
											hospital.add(i,deepcopy);
											System.out.println("Temperature updated. \n");
											break;
										}
									}
									if (!hospital.get(i).getPcr()) {
										if (hospital.get(i) instanceof Covid19Patient) {
											System.out.println("\nPatient " + hospital.get(i).getfName() + " no longer has Covid. Discharging patient.");
											hospital.remove(i);
											break;
										}
									}
								}
							}
						}
						if(!found) {
							System.out.println("No patient with ID " + id + " found.");
						}
						break;
					case 4: //Updates temperatures for patients at hospital with covid (rounds)
						if(hospital.isEmpty()) {
							System.out.println("No patients found.");
						}
						else {
							for(int i = 0; i < hospital.size(); i++) {
								if(hospital.get(i) instanceof Covid19Patient) {
									System.out.print("Update the temperature for patient " + hospital.get(i).getfName() + " (ID: "+ hospital.get(i).getId() +"): ");
										double temp = scan.nextDouble();
										scan.nextLine();
										((Covid19Patient) hospital.get(i)).setTemp(temp);
										System.out.println("Patient ID: " + hospital.get(i).getId());
										System.out.println("Recommended Treatment: "+ hospital.get(i).treat());
										System.out.println();
								}
							}
							System.out.println("Rounds complete.");
						}
						break;
					case 5: //Discharges patient only if they have a negative PCR test result.
						System.out.print("Enter ID of patient to be discharged: ");
						id = scan.nextInt();
						for (int i = 0; i < hospital.size(); i++) {
							if(hospital.get(i)!= null) {
								if ((hospital.get(i)).getId() == id) {
									if(hospital.get(i).getPcr()) {
										System.out.println("Patient " + hospital.get(i).getfName()+ " still has Covid. Unable to discharge patient.");
										break; //found so exit
									}
									else if (!hospital.get(i).getPcr()) {
										hospital.remove(i);
										System.out.println("Patient " + id + " removed.");
										break; //exit
									}
									else {
										System.out.println("test");
									}
								}
							}
							else {
							}
						}
						System.out.println("Patient with ID " + id + " not found.");
						break;
					case 6: //exit
						break;
					default:
						System.out.println("Invalid choice. Please enter a number between 1 and 6.");
				}
			}
			catch(InputMismatchException ime) {
				System.out.println("-------------------------------------");
				System.out.println("Invalid input. Please double check your input.");
				scan.nextLine(); //consume newline
			}
		}
		System.out.println("=====================================\nThank you for using Hospital Program.\n=====================================");
		scan.close();
	}
	/**
	 * textMenu helper method that prints out choices
	 */
	public static void textMenu() {
		System.out.println("-------------------------------------");
		System.out.println("1. Admit a patient");
		System.out.println("2. Print patient information");
		System.out.println("3. Submit a PCR test result");
		System.out.println("4. Do rounds");
		System.out.println("5. Discharge patient");
		System.out.println("6. Exit");
		System.out.println("-------------------------------------");
		System.out.print("Enter a choice: ");
	}

}
