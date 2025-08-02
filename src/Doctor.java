import java.util.Scanner;

public class Doctor extends Staff{
	private String specialist, workTime, qualification;
	private int room;
	
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
		read.nextInt();
	}
}
