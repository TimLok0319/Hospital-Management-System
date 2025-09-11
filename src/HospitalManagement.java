import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

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
		ArrayList<Nurse> nurses = new ArrayList<>(25);
		
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
		
		//Nurse(String id, String name, String sex, String shift)
		/*nurses.add(new Nurse("N0001","Max Verstappen","Male","AM"));
		nurses.add(new Nurse("N0002","Lily He","Female","PM"));
		nurses.add(new Nurse("N0003","Nico Hulkg","Male","AM"));*/
		
		ArrayList<String> className = new ArrayList<>();
		ArrayList<ArrayList<? extends Displayable>> list = new ArrayList<>();
		list.add(doctors);
		list.add(patients);
		list.add(staffs);		
		list.add(labs);
		list.add(facilities);
		list.add(medicines);
		//list.add(nurses);
		
		//get number of class
		for(int i= 0 ; i < list.size(); i ++)
			className.add(list.get(i).get(0).returnClassName());
		
		//
		String[] classNumArray = new String[className.size()+1];
		classNumArray[0] = "X";
		for (int i = 1; i < className.size()+1; i++)
		{
			classNumArray[i] = Integer.toString(i);
		}
		
		String choice ;
		do 
		{
			//Display Welcome Message
			System.out.println("Welcome to the Hospital Management System!");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			System.out.println("Current Date & Time: " + dtf.format(LocalDateTime.now()));
			Scanner read = new Scanner(System.in);

			//Display Main Menu
			displayMainMenu(className.size(), className);
			choice = getValidatedChoice(read,classNumArray);
			
			if(!choice.equalsIgnoreCase("X"))
			{
				String chosenClass = new String();
				int choiceNum = Integer.parseInt(choice);
				chosenClass = className.get(choiceNum-1);
				
				do {
					//Sub Menu
					displaySubMenu(1,chosenClass);
					choice = getValidatedChoice(read,"1","2","M","X");
					
					//Add New Object
					if(choice.equals("1"))
					{
						do {
							//Add New
							createNew(chosenClass,list, read);
							//Next Step
							choice = getValidatedChoice(read, "A", "M","B", "X");
							
						}while(choice.equals("A" ));
					}		
					
					//Display All Object
					else if(choice.equals("2"))
					{
						displayAll(chosenClass, list);
						choice = getValidatedChoice(read, "M","B", "X");
						if(choice.equalsIgnoreCase("X"))
							break;
					}
				}while(!choice.equalsIgnoreCase("M") && !choice.equalsIgnoreCase("X"));
			}
		}while(!choice.equalsIgnoreCase("X"));
		
		System.out.println("Program Exited");
	}
	
	//Helper Function
	
	//Function to validated user input
	private static String getValidatedChoice(Scanner read, String... validOptions) {
	    String input;
	    boolean valid;
	    do {
	    	
	    	System.out.print("**Enter your choice: ");
	        input = read.nextLine().trim();
	        valid = false;
	        for (String option : validOptions) {
	            if (input.equalsIgnoreCase(option)) {
	                valid = true;
	                break;
	            }
	        }
	        if (!valid) {
	            System.out.println("\n//Invalid Input!//");
	        }
	    } while (!valid);
	    return input;
	}
	
	//Function to print out sub menu 
	private static void displaySubMenu(int page,String target)
	{
		if(page == 1)
		{
			System.out.println("\n======== HMS - "+target+" Section ========");
			System.out.println("Please choose from the follwing selections(1-2)");
			System.out.println("\n1. Add New "+target);
			System.out.println("2. Display All "+target);
			System.out.println("\nM --- Return to main menu");
			System.out.println("X --- Exit program\n");
		}
		else if(page == 2)
		{
			System.out.print("\nNext Step:");
			System.out.println("\nA --- Add another entry");
			System.out.println("B --- Return to "+target+" Section ");
			System.out.println("M --- Return to main menu ");
			System.out.println("X --- Exit program\n");
		}
		
		else if(page == 3)
		{
			System.out.print("\nNext Step:");
			System.out.println("\nB --- Return to "+target+" Section ");
			System.out.println("M --- Return to main menu ");
			System.out.println("X --- Exit program\n");
		}
		
	}
	
	//Display All object
	private static void displayAll(String category, ArrayList<ArrayList<? extends Displayable>> list) {
		System.out.println("\n----- "+category+"'s List -----");
		for(ArrayList<? extends Displayable> item: list)
		{
			for(Displayable object : item)
			{
				if(object.returnClassName().equalsIgnoreCase(category))	
					object.showInfo();
			}
		}
		displaySubMenu(3,category);
	}
	
	//Create new object
	private static void createNew(String category, ArrayList<ArrayList<? extends Displayable>> list, Scanner read) 
	{
		for(ArrayList<? extends Displayable> classes: list)
		{
			ArrayList<Displayable> toAdd = new ArrayList<>();
			for(Displayable object : classes)
			{
				if(object.returnClassName().equalsIgnoreCase(category))	
				{
					Displayable newObj = object.create();
					newObj.readNewEntry(read);
					toAdd.add(newObj);
					break;
				}
			}
			((ArrayList<Displayable>) classes).addAll(toAdd);
		}
		//prompt successful entry
		System.out.println("\nYour Entry had been recorded!");
		displaySubMenu(2,category);
	}
	
	//Display Main Menu
	private static void displayMainMenu(int classNum, ArrayList<String> className) {
		System.out.println("\n======== HMS - Main Menu ========");
		System.out.println("Please choose from one of the selections:");
		for(int i = 0; i < classNum; i++)
		{
			System.out.println((i+1)+". "+className.get(i));
		}
		System.out.println("\nX --- Exit program\n");
	}
	
}
