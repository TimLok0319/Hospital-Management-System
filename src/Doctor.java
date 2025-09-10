import java.util.InputMismatchException;
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
	
	@Override
	public void readNewEntry(Scanner read)
	{
		boolean undone = true;
		System.out.println("----- New Doctor Registration -----");
		System.out.println("(ID Format - 000)");
		super.newPerson(read);
		System.out.print("Specialization: ");
		setSpec(read.nextLine());
		System.out.print("Work Time(e.g. 9.00AM - 6PM): ");
		setWorkT(read.nextLine());
		System.out.print("Qualification (e.g. Professor): ");
		setQuali(read.nextLine());
		
		while(undone)
		{
			try {
				System.out.print("Room (e.g. 101): ");
				setRoom(read.nextInt());
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
		System.out.println("["+super.getID()+"]"+"    ["+super.getName()+"]    ["+getSpec()+"]    ["+getWorkT()+"]    ["+getQuali()+"]    ["+getRoom()+"]");
	}
	
	@Override
	public String returnClassName() {
		return "Doctor";
	}
	
	@Override
	public Displayable create() {
		return new Doctor();
	}
	
	@Override
	public String getInfoString() {
	    // String version for GUI
	    return "[" + super.getID() + "]    [" + super.getName() + "]    [" +
	           getSpec() + "]    [" + getWorkT() + "]    [" +
	           getQuali() + "]    [" + getRoom() + "]";
	}
}
