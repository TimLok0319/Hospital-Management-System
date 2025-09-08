import java.util.Scanner;

public class Patient extends Person implements Displayable{
	private String disease, admitStatus;
	private int age;
	
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
		System.out.println("----- New Patient Registration -----");
		super.newPerson(read);
		System.out.println("Disease:");
		setDisease(read.nextLine());
		System.out.println("Sex:");
		super.setSex(read.nextLine());
		System.out.println("Admit Status:");
		setAdmitS(read.nextLine());
		System.out.println("Age:");
		setAge(read.nextInt());
	}
	
	@Override
	public void showInfo() {
		System.out.println("["+super.getID()+"]"+"    ["+super.getName()+"]    ["+getDisease()+"]    ["+getSex()+"]    ["+getAdmitS()+"]    ["+getAge()+"]");
	}
	
}
