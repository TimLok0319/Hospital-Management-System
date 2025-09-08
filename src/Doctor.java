import java.util.Scanner;

public class Doctor extends Person implements Displayable{
	private String specialist, workTime, qualification;
	private int room;
	
	Doctor(){};
	
	Doctor(String id, String name, String sex, String specialist,String workTime, String qualification, int room){
		this.specialist = specialist;
		this.workTime = workTime;
		this.qualification = qualification;
		this.room = room;
		
		super.setID(id);
		super.setName(name);
		super.setSex(sex);
	}
	
	public String getSpec()
	{
		return specialist;
	}
	
	public void setSpec(String specialist)
	{
		this.specialist = specialist;
	}
	
	public String getWorkT()
	{
		return workTime;
	}
	
	public void setWorkT(String workTime)
	{
		this.workTime = workTime;
	}
	
	public String getQuali()
	{
		return qualification;
	}
	
	public void setQuali(String qualification)
	{
		this.qualification = qualification;
	}
	
	public int getRoom()
	{
		return room;
	}
	
	public void setRoom(int room)
	{
		this.room = room;
	}
	
	public void newDoctor(Scanner read)
	{
		System.out.println("----- New Doctor Registration -----");
		super.newPerson(read);
		System.out.print("Specialization: ");
		setSpec(read.nextLine());
		System.out.print("Work Time: ");
		setWorkT(read.nextLine());
		System.out.print("Qualification: ");
		setQuali(read.nextLine());
		System.out.print("Room: ");
		setRoom(read.nextInt());
		read.nextLine();
	}
	
	@Override
	public void showInfo()
	{
		System.out.println("["+super.getID()+"]"+"    ["+super.getName()+"]    ["+getSpec()+"]    ["+getWorkT()+"]    ["+getQuali()+"]    ["+getRoom()+"]");
	}
}
