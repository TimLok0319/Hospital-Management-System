import java.util.InputMismatchException;
import java.util.Scanner;

public class Patient extends Person implements Displayable{
	private String disease, admitStatus;
	private int age;
	
	Patient(){};
	
	Patient(String id, String name, String sex, String disease, String admitStatus, int age){
		super.setID(id);
		super.setName(name);
		super.setSex(sex);
		
		this.disease = disease;
		this.admitStatus = admitStatus;
		this.age = age;
	}
	
	public String getDisease()
	{
		return disease;
	}
	
	public void setDisease(String disease)
	{
		this.disease = disease;
	}
	
	public String getAdmitS()
	{
		return admitStatus;
	}
	
	public void setAdmitS(String admitStatus)
	{
		this.admitStatus = admitStatus;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void newPatient(Scanner read)
	{
		boolean undone = true;
		System.out.println("----- New Patient Registration -----");
		System.out.println("(ID Format - P000)");
		super.newPerson(read);
		System.out.println("Disease:");
		setDisease(read.nextLine());
		super.setSex(read.nextLine());
		System.out.println("Admit Status (Admitted/Discharged):");
		setAdmitS(read.nextLine());
		
		while(undone)
		{
			try {
				System.out.println("Age (e.g. 18):");
				setAge(read.nextInt());
				undone = false;
			}catch(InputMismatchException e){
				System.out.println("//Error - Please enter number only!");
				undone = true;
			};
			read.nextLine();
		}
	}
	
	@Override
	public void showInfo() {
		System.out.println("["+super.getID()+"]"+"    ["+super.getName()+"]    ["+getDisease()+"]    ["+getSex()+"]    ["+getAdmitS()+"]    ["+getAge()+"]");
	}
	
}
