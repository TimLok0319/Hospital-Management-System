import java.util.Scanner;

public abstract class Person {
	
	private String id, name, sex;
	
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
	
	public String getSex()
	{
		return sex;
	}
	
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public void newPerson(Scanner read)
	{
		System.out.print("ID: ");
		setID(read.nextLine());
		System.out.print("Name: ");
		setName(read.nextLine());
		System.out.print("Sex: ");
		setSex(read.nextLine());
	}
	
	public abstract void showInfo();
	
}
