import java.util.InputMismatchException;
import java.util.Scanner;

public class Staff extends Person implements Displayable{
	private String designation;
	private int salary;
	
	Staff(String id, String name, String sex, String designation, int salary){
		super.setID(id);
		super.setName(name);
		super.setSex(sex);
		
		this.designation = designation;
		this.salary = salary;
	}
	
	public String getDes()
	{
		return designation;
	}
	
	public void setDes(String designation)
	{
		this.designation = designation;
	}
	
	public int getSalary()
	{
		return salary;
	}
	
	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	
	public void newStaff(Scanner read) throws InputMismatchException
	{	
		System.out.println("----- New Staff Registration -----");
		super.newPerson(read);
		System.out.print("Designation: ");
		designation = read.nextLine();	
		System.out.print("Salary: ");
		try {
			setSalary(read.nextInt());
		}catch(InputMismatchException e)
		{
			System.out.println("//Error - Please enter number only!");
		};	
		read.nextLine();
	}
	
	@Override
	public void showInfo()
	{
		System.out.println("["+super.getID()+"]"+"    ["+super.getName()+"]    ["+getDes()+"]    ["+super.getSex()+"]    [RM"+getSalary()+"]");
	}
}
