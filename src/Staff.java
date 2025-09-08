import java.util.InputMismatchException;
import java.util.Scanner;

public class Staff extends Person implements Displayable{
	private String designation;
	private int salary;
	
	Staff(){};
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
		boolean undone = true;
		System.out.println("----- New Staff Registration -----");
		System.out.println("(ID Format - A000)");
		super.newPerson(read);
		System.out.print("Designation (e.g. Lab Officer): ");
		designation = read.nextLine();	
		
		while(undone)
		{
			try {
				System.out.print("Salary :RM");
				setSalary(read.nextInt());
				undone = false;
			}catch(InputMismatchException e){
				System.out.println("//Error - Please enter number only!");
				undone = true;
			};
			read.nextLine();
		}
	}
	
	@Override
	public void showInfo()
	{
		System.out.println("["+super.getID()+"]"+"    ["+super.getName()+"]    ["+getDes()+"]    ["+super.getSex()+"]    [RM"+getSalary()+"]");
	}
}
