import java.util.Scanner;

public class Doctor extends Staff{
	private String specialist, workTime, qualification;
	private int room;
	
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
		super.newStaff(read);
		System.out.print("Specialization: ");
		specialist = read.nextLine();
		System.out.print("Work Time: ");
		workTime = read.nextLine();
		System.out.print("Qualification: ");
		qualification = read.nextLine();
		System.out.print("Room: ");
		room = read.nextInt();
		read.nextLine();
	}
	
	public void showDoctorInfo()
	{
		System.out.println("["+super.getID()+"]"+"    ["+super.getName()+"]    ["+specialist+"]    ["+workTime+"]    ["+qualification+"]    ["+room+"]");
	}
}
