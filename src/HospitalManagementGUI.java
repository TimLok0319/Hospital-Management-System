import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class HospitalManagementGUI extends Application {
	

	String[] docAttribute =  {"ID","Name","Sex","Date"};
	
	@Override
	public void start(Stage primaryStage) 
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
		nurses.add(new Nurse("N0001","Max Verstappen","Male","AM"));
		nurses.add(new Nurse("N0002","Lily He","Female","PM"));
		nurses.add(new Nurse("N0003","Nico Hulkg","Male","AM"));
		
		ArrayList<String> className = new ArrayList<>();
		ArrayList<ArrayList<? extends Displayable>> list = new ArrayList<>();
		list.add(doctors);
		list.add(patients);
		list.add(staffs);		
		list.add(labs);
		list.add(facilities);
		list.add(medicines);
		list.add(nurses);
				
		//Finish the start()
		BorderPane mainMenu = createMainMenu();
	    Scene scene = new Scene(mainMenu, 600, 455);

	    // === Hook up Main Menu Buttons ===
	    // Doctor
	    ((Button)((VBox)((HBox)((VBox)mainMenu.getCenter()).getChildren().get(1)).getChildren().get(0)).getChildren().get(0))
	        .setOnAction(e -> {
	            BorderPane doctorMenu = createSectionPane("Doctor");
	            scene.setRoot(doctorMenu);

	            // add new doctor
	            ((Button)((HBox)((VBox)doctorMenu.getCenter()).getChildren().get(1)).getChildren().get(0))
	                .setOnAction(ev -> scene.setRoot(createAddMenu("Doctor", new String[]{"ID","Name","Sex","Specialist","WorkTime","Qualification","Room"})));

	            // display doctors
	            ((Button)((HBox)((VBox)doctorMenu.getCenter()).getChildren().get(1)).getChildren().get(1))
	                .setOnAction(ev -> scene.setRoot(displayAll("Doctor", doctors)));

	            // back to main menu
	            ((Button)((HBox)((VBox)doctorMenu.getBottom()).getChildren().get(0)).getChildren().get(1))
	                .setOnAction(ev -> scene.setRoot(mainMenu));
	        });

	    // Patient
	    ((Button)((VBox)((HBox)((VBox)mainMenu.getCenter()).getChildren().get(1)).getChildren().get(1)).getChildren().get(2))
	        .setOnAction(e -> {
	            BorderPane patientMenu = createSectionPane("Patient");
	            scene.setRoot(patientMenu);

	            ((Button)((HBox)((VBox)patientMenu.getCenter()).getChildren().get(1)).getChildren().get(0))
	                .setOnAction(ev -> scene.setRoot(createAddMenu("Patient", new String[]{"ID","Name","Sex","Disease","AdmitStatus","Age"})));

	            ((Button)((HBox)((VBox)patientMenu.getCenter()).getChildren().get(1)).getChildren().get(1))
	                .setOnAction(ev -> scene.setRoot(displayAll("Patient", patients)));

	            ((Button)((HBox)((VBox)patientMenu.getBottom()).getChildren().get(0)).getChildren().get(1))
	                .setOnAction(ev -> scene.setRoot(mainMenu));
	        });
	    
	    //Facility
	    ((Button)((VBox)((HBox)((VBox)mainMenu.getCenter()).getChildren().get(1)).getChildren().get(1)).getChildren().get(2))
        .setOnAction(e -> {
            BorderPane facilityMenu = createSectionPane("Facility");
            scene.setRoot(facilityMenu);

            ((Button)((HBox)((VBox)facilityMenu.getCenter()).getChildren().get(1)).getChildren().get(0))
                .setOnAction(ev -> scene.setRoot(createAddMenu("facility", new String[]{"Facility"})));

            ((Button)((HBox)((VBox)facilityMenu.getCenter()).getChildren().get(1)).getChildren().get(1))
                .setOnAction(ev -> scene.setRoot(displayAll("facility", facilities)));

            ((Button)((HBox)((VBox)facilityMenu.getBottom()).getChildren().get(0)).getChildren().get(1))
                .setOnAction(ev -> scene.setRoot(mainMenu));
        });
	    
	    //Staff
	    ((Button)((VBox)((HBox)((VBox)mainMenu.getCenter()).getChildren().get(1)).getChildren().get(1)).getChildren().get(2))
        .setOnAction(e -> {
            BorderPane staffMenu = createSectionPane("Staff");
            scene.setRoot(staffMenu);

            ((Button)((HBox)((VBox)staffMenu.getCenter()).getChildren().get(1)).getChildren().get(0))
                .setOnAction(ev -> scene.setRoot(createAddMenu("Staff", new String[]{"ID","Name","Sex","Designation","Salary"})));

            ((Button)((HBox)((VBox)staffMenu.getCenter()).getChildren().get(1)).getChildren().get(1))
                .setOnAction(ev -> scene.setRoot(displayAll("Staff", staffs)));

            ((Button)((HBox)((VBox)staffMenu.getBottom()).getChildren().get(0)).getChildren().get(1))
                .setOnAction(ev -> scene.setRoot(mainMenu));
        });
	    
	  //Lab
	    ((Button)((VBox)((HBox)((VBox)mainMenu.getCenter()).getChildren().get(1)).getChildren().get(1)).getChildren().get(2))
        .setOnAction(e -> {
            BorderPane labMenu = createSectionPane("Lab");
            scene.setRoot(labMenu);

            ((Button)((HBox)((VBox)labMenu.getCenter()).getChildren().get(1)).getChildren().get(0))
                .setOnAction(ev -> scene.setRoot(createAddMenu("Lab", new String[]{"Lab","Cost"})));

            ((Button)((HBox)((VBox)labMenu.getCenter()).getChildren().get(1)).getChildren().get(1))
                .setOnAction(ev -> scene.setRoot(displayAll("Lab", labs)));

            ((Button)((HBox)((VBox)labMenu.getBottom()).getChildren().get(0)).getChildren().get(1))
                .setOnAction(ev -> scene.setRoot(mainMenu));
        });
	    
	    //Medicine
	    ((Button)((VBox)((HBox)((VBox)mainMenu.getCenter()).getChildren().get(1)).getChildren().get(1)).getChildren().get(2))
        .setOnAction(e -> {
            BorderPane medicineMenu = createSectionPane("Medicine");
            scene.setRoot(medicineMenu);

            ((Button)((HBox)((VBox)medicineMenu.getCenter()).getChildren().get(1)).getChildren().get(0))
                .setOnAction(ev -> scene.setRoot(createAddMenu("Medicine", new String[]{"Name","Manufacturer","ExpiryDate","Cost","Count"})));

            ((Button)((HBox)((VBox)medicineMenu.getCenter()).getChildren().get(1)).getChildren().get(1))
                .setOnAction(ev -> scene.setRoot(displayAll("Medicine", medicines)));

            ((Button)((HBox)((VBox)medicineMenu.getBottom()).getChildren().get(0)).getChildren().get(1))
                .setOnAction(ev -> scene.setRoot(mainMenu));
        });
		
		//Scene scene = new Scene(mainMenu,600,455);
		//Scene scene = new Scene(doctorMenu,600,350);
		//Scene scene = new Scene(addNew,600,455);

		primaryStage.setTitle("Hospital Management System");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
        launch(args);  // This starts JavaFX
    }
	
	public static BorderPane createMainMenu()
	{
		BorderPane mainMenu = new BorderPane();
		mainMenu.setStyle("-fx-background-color: #f5f5DC ;");
		Label title = new Label("Hospital Management System");
		title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
		HBox titleBox = new HBox();
		titleBox.setStyle("-fx-background-color: #3895D3;-fx-padding: 20 20 20 20");
		titleBox.getChildren().add(title);
		titleBox.setAlignment(Pos.CENTER);
		
		//Instruction Text
		VBox vbox1 = new VBox();
		Label btnInstruction = new Label("Select category");
		btnInstruction.setStyle("-fx-font-size: 16px; -fx-font-weight: bold ; -fx-text-fill: black;" );
		vbox1.getChildren().add(btnInstruction);
		vbox1.setAlignment(Pos.TOP_CENTER);
		
		//Button Box
		HBox buttonBox = new HBox(10);
		VBox exitBox = new VBox();
		VBox column1 = new VBox(10);
		VBox column2 = new VBox(10);
		
		Button doctor = new Button("Doctor");
		doctor.setStyle("-fx-pref-width: 200; -fx-pref-height: 70; -fx-font-size: 16px;");
		Button staff = new Button("Staff");
		staff.setStyle("-fx-pref-width: 200; -fx-pref-height: 70;-fx-font-size: 16px;");
		Button facility = new Button("Facility");
		facility.setStyle("-fx-pref-width: 200; -fx-pref-height: 70;;-fx-font-size: 16px;");
		Button lab = new Button("Lab");
		lab.setStyle("-fx-pref-width: 200; -fx-pref-height: 70;-fx-font-size: 16px;");
		Button medicine = new Button("Medicine");
		medicine.setStyle("-fx-pref-width: 200; -fx-pref-height: 70;-fx-font-size: 16px;");
		Button patient = new Button("Patient");
		patient.setStyle("-fx-pref-width: 200; -fx-pref-height: 70;-fx-font-size: 16px;");
		
		
		Button exit = new Button("Exit Program");
		Label instruction = new Label("Instruction: Click on one of the button to proceed");
		instruction.setStyle("-fx-font-size: 16px; -fx-padding: 5 0 5 0; -fx-font-weight: bold;");
		
		column1.getChildren().addAll(doctor,staff,facility);
		column2.getChildren().addAll(lab,medicine,patient);
		column1.setAlignment(Pos.CENTER);
		column2.setAlignment(Pos.CENTER);
		
		buttonBox.getChildren().addAll(column1,column2);
		buttonBox.setSpacing(15);
		buttonBox.setAlignment(Pos.CENTER);
		
		exitBox.getChildren().addAll(instruction,exit);
		exitBox.setStyle("-fx-padding: 0 0 5 0;");
		exitBox.setAlignment(Pos.BOTTOM_CENTER);
		
		vbox1.getChildren().addAll(buttonBox,exitBox);
		//vbox1.setStyle("-fx-padding: 5 0 0 0;");
		
		mainMenu.setTop(titleBox);
		mainMenu.setCenter(vbox1);
		mainMenu.setBottom(exitBox);
		
		return mainMenu;
	}
	public static BorderPane createSectionPane(String sectionName)
	{
		
		BorderPane menu = new BorderPane();
		menu.setStyle("-fx-background-color: #f5f5DC ;");
		Label title = new Label(sectionName+" Section");
		title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
		HBox titleBox = new HBox();
		titleBox.setStyle("-fx-background-color: #3895D3;-fx-padding: 20 20 20 20");
		titleBox.getChildren().add(title);
		titleBox.setAlignment(Pos.CENTER);
		
		//Button Instruction
		VBox vbox = new VBox();
		Label btnInstruction = new Label("Select Operation");
		btnInstruction.setStyle("-fx-font-size: 16px; -fx-font-weight: bold");
		vbox.getChildren().add(btnInstruction);
		vbox.setAlignment(Pos.CENTER);
		
		//Bottom
		Label instruction = new Label("Instruction: Click on one of the button to proceed");
		instruction.setStyle("-fx-font-size: 16px; -fx-padding: 0 0 5 0; -fx-font-weight: bold;");
		VBox bottom = new VBox();
		HBox bottomBtnBox = new HBox(5); //doctor Bottom Button Box
		Button docExit = new Button("Exit Program");
		docExit.setStyle("-fx-pref-width: 150;");
		Button docReturnM = new Button("Return to Main Menu");
		docReturnM.setStyle("-fx-pref-width: 150;");
		bottomBtnBox.getChildren().addAll(docExit,docReturnM);
		bottomBtnBox.setAlignment(Pos.CENTER);
		
		bottom.getChildren().addAll(bottomBtnBox,instruction);
		bottom.setAlignment(Pos.CENTER);
		
		//ButtonBox
		HBox centerBtnBox = new HBox(10);
		Button add = new Button("Add "+sectionName);
		add.setStyle("-fx-pref-width: 150; -fx-pref-height: 50; -fx-font-size: 16px;");
		Button display = new Button("Display "+sectionName);
		display.setStyle("-fx-pref-width: 150; -fx-pref-height: 50; -fx-font-size: 16px;");
		centerBtnBox.getChildren().addAll(add,display);
		centerBtnBox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(centerBtnBox);
		
		menu.setTop(titleBox);
		menu.setCenter(vbox);
		menu.setBottom(bottom);
		
		return menu;
	}
	public static VBox createTextField(String att)
	{
		VBox labelField = new VBox(); 
		Label attribute = new Label(att+":");
		HBox inputBox = new HBox();
		TextField input = new TextField();
		inputBox.getChildren().add(input);
		HBox.setHgrow(input, Priority.ALWAYS);
		
		labelField.getChildren().addAll(attribute,inputBox);
		
		return labelField;
	}
	
	public static BorderPane createAddMenu(String sectionName, String[] attributes) {
	    BorderPane addMenu = new BorderPane();
	    addMenu.setStyle("-fx-background-color: #f5f5DC ;");

	    // Title
	    Label title = new Label("Record New " + sectionName);
	    title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
	    HBox titleBox = new HBox(title);
	    titleBox.setStyle("-fx-background-color: #3895D3; -fx-padding: 20 20 20 20");
	    titleBox.setAlignment(Pos.CENTER);

	    // Instruction
	    Label instruction = new Label("Please fill in the " + sectionName + "'s information");

	    // Form area
	    VBox formBox = new VBox(10);
	    formBox.setPadding(new Insets(20));
	    formBox.getChildren().add(instruction);

	    // Loop through attributes to generate fields
	    for (String att : attributes) {
	        formBox.getChildren().add(createTextField(att));
	    }

	    // Buttons (Save / Cancel)
	    HBox btnBox = new HBox(10);
	    Button saveBtn = new Button("Save");
	    Button cancelBtn = new Button("Cancel");
	    btnBox.getChildren().addAll(saveBtn, cancelBtn);
	    btnBox.setAlignment(Pos.CENTER);

	    formBox.getChildren().add(btnBox);

	    addMenu.setTop(titleBox);
	    addMenu.setCenter(formBox);

	    return addMenu;
	}

	public static BorderPane displayAll(String sectionName, ArrayList<? extends Displayable> list) {
	    BorderPane root = new BorderPane();
	    root.setStyle("-fx-background-color: #f5f5DC ;");

	    // Title
	    Label header = new Label(sectionName + " List");
	    header.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
	    HBox headerBox = new HBox(header);
	    headerBox.setAlignment(Pos.CENTER);
	    headerBox.setStyle("-fx-background-color: #3895D3; -fx-padding: 20;");
	    root.setTop(headerBox);

	    // Content
	    VBox contentBox = new VBox(5);
	    contentBox.setStyle("-fx-padding: 10;");
	    for (Displayable obj : list) {
	        Label row = new Label(obj.getInfoString());
	        row.setStyle("-fx-font-family: monospace; -fx-font-weight: bold;");
	        contentBox.getChildren().add(row);
	    }
	    root.setCenter(contentBox);

	    // Bottom buttons
	    HBox bottomBox = new HBox(10);
	    Button exportBtn = new Button("Exit to " + sectionName + " Section");
	    Button clearBtn = new Button("Exit Program");
	    bottomBox.getChildren().addAll(exportBtn, clearBtn);
	    bottomBox.setAlignment(Pos.CENTER);
	    bottomBox.setStyle("-fx-padding: 10;");
	    root.setBottom(bottomBox);

	    return root;
	}
}
