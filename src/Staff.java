import java.util.Scanner;

public class Staff {
	private String id, name, designation, sex;
	private int salary;
	
	Scanner read = new Scanner(System.in);
	
	public void newStaff()
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
