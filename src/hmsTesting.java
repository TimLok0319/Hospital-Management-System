import java.util.Scanner;

public class hmsTesting {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		
		Staff staff = new Staff();
		staff.newStaff(read);
		
		Doctor doc1 = new Doctor();
		doc1.newDoctor(read);
		
		
		staff.showInfo();
		doc1.showInfo();
	}

}
