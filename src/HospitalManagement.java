import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.omg.CORBA.SystemException;

public class HospitalManagement {

	public static void main(String[] args)
	{
		
		//ArrayList Declaration
		ArrayList<Doctor> doctors = new ArrayList<>(25);
		ArrayList<Patient> patients = new ArrayList<>(100);
		ArrayList<Staff> staffs = new ArrayList<>(100);
		ArrayList<Lab> labs = new ArrayList<>(20);
		ArrayList<Facility> facilities = new ArrayList<>(20);
		ArrayList<Medicine> medicines = new ArrayList<>(100);
		
		//Values Initialization
		//Doctor(String id, String name, String sex, String specialist,String workTime, String qualification, int room)
		doctors.add(new Doctor("094","Liang Tim Lok","Male","Cardiologist","9.00AM - 6PM","Professor",100));
		doctors.add(new Doctor("302","Wong Wei Qi","Female","Dermatologist","9.00AM - 6PM","Professor",101));
		doctors.add(new Doctor("921","Ali Malou","Male","Pediatrician","9.00AM - 6PM","Master",102));
		
		//Patient(String id, String name, String sex, String disease, String admitStatus, int age)
		patients.add(new Patient("P001","Charles Leclerc","Male","Diabetes","Admitted",30));
		patients.add(new Patient("P002","Abu Bin Ali","Male","Hypertension","Discharged",62));
		patients.add(new Patient("P003","Leong Ru Hua","Female","Malaria","Admitted",15));
		
		//Staff(String id, String name, String sex, String designation, int salary)
		staffs.add(new Staff("S001", "Tan Boon Boon", "Male", "Pharmacist", 7000));
		staffs.add(new Staff("S002", "Muthu Hemsivran", "Male", "Lab Technician", 5000));
		staffs.add(new Staff("S003", "Christian Horner", "Male", "Receptionist", 3000));
		
		//Lab(String lab, int cost)
		labs.add(new Lab("Pathology Lab",200));
		labs.add(new Lab("Radiology Lab",300));
		labs.add(new Lab("Micrology Lab",350));
		
		//Facility(String facility)
		facilities.add(new Facility("Emergency Department"));
		facilities.add(new Facility("Intensive Care Unit"));
		facilities.add(new Facility("Pharmacy"));
		
		//Medicine(String name, String manufacturer,String expiryDate, int cost, int count)
		medicines.add(new Medicine("Paracetamol","Pfizer","01/12/2030",10,100));
		medicines.add(new Medicine("Amoxicillin","Novartis","03/09/2028",25,87));
		medicines.add(new Medicine("Ibuprofen","Johnson","03/09/2026",39,12));
		
		
		
		
		String choice ;
		//Exception Handling for main menu
		do 
		{
			//Display Welcome Message
			System.out.println("Welcome to the Hospital Management System!");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			System.out.println("Current Date & Time: " + dtf.format(LocalDateTime.now()));
			Scanner read = new Scanner(System.in);
			
			
			
			//Display Menu
			boolean invalid = false;
			System.out.println("\n======== HMS - Main Menu ========");
			System.out.println("Please choose from one of the selections(1-6)");
			System.out.println("1. Doctor\n2. Patients\n3. Medicine\n4. Laboratories\n5. Facilities\n6. Staff");
			System.out.println("\nExit program --- X");
			
			if(invalid) 
				System.out.println("\n//Invalid Input!//");
			
			invalid = false;
			
			System.out.print("\n**Enter your choice: ");
			choice = read.nextLine();
			if(!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2") && !choice.equalsIgnoreCase("3") && !choice.equalsIgnoreCase("4") && !choice.equalsIgnoreCase("5") && !choice.equalsIgnoreCase("6") && !choice.equalsIgnoreCase("x"))
				invalid = true;
		
				if(choice.equals("1"))
				{
					System.out.println("\n======== HMS - Doctor Section ========");
					System.out.println("Please choose from the follwing selections(1-2)");
					System.out.println("\n1. Add New Doctor");
					System.out.println("2. Display All Doctor");
					System.out.println("\nReturn to main menu --- M");
					System.out.println("Exit program --- X");
					
					do
					{
						if(invalid)
							System.out.println("\n//Invalid Input!//");
						
						invalid = false;
						System.out.print("\n**Enter your choice: ");
						choice = read.nextLine();
						if(!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2") && !choice.equalsIgnoreCase("M")&& !choice.equalsIgnoreCase("X"))
							invalid = true;
						
					}while(invalid);
					
					//Doctor Section conditional statement
					if(choice.equals("1"))
					{
						//Add New Doctor
						Doctor doctor = new Doctor();
						doctor.newDoctor(read);
						doctors.add(doctor);
					}		
					else if(choice.equals("2"))
					{
						
					}
					else if(choice.equalsIgnoreCase("M"))
					{
						
					}
					else if(choice.equalsIgnoreCase("X"))
					{
						
					}
				}
				
				else if(choice.equals("2"))
				{}
				else if(choice.equals("3"))
				{}
				else if(choice.equals("4"))
				{}
				else if(choice.equals("5"))
				{}
				else if(choice.equals("6"))
				{}
				
		}while(!choice.equalsIgnoreCase("X"));
		
		System.out.println("Program Exited");
	}
	
	
}
