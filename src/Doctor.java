import java.util.Scanner;

public class Doctor extends Staff{
	private String specialist, workTime, qualification;
	private int room;
	
	public void newDoctor()
	{
		super.newStaff();
		System.out.print("Specialization: ");
		specialist = read.nextLine();
	}
}
