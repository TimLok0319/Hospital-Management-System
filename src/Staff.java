import java.util.Scanner;

public class Staff {
	private String id, name, designation, sex;
	private int salary;
	
	public String getID()
	{
		return id;
	}
	
	public void setID(String id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDes()
	{
		return designation;
	}
	
	public void setDes(String designation)
	{
		this.designation = designation;
	}
	
	public String getSex()
	{
		return sex;
	}
	
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public int getSalary()
	{
		return salary;
	}
	
	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	
	public void newStaff(Scanner read)
	{	
		System.out.println("----- New Staff Registration -----");
		System.out.print("Staff's ID: ");
		id = read.nextLine();
		System.out.print("Name: ");
		name = read.nextLine();	
		System.out.print("Designation: ");
		designation = read.nextLine();	
		System.out.print("Sex: ");
		sex = read.nextLine();	
		System.out.print("Salary: ");
		salary = read.nextInt();	
		read.nextLine();
	}
	
	public void showStaffInfo()
	{
		System.out.println("["+id+"]"+"    ["+name+"]    ["+designation+"]    ["+sex+"]    [RM"+salary+"]");
	}
}
