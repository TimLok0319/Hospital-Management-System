import java.util.Scanner;

public class hmsTesting {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		
		Staff staff = new Staff();
		staff.newStaff(read);
		
		staff.showStaffInfo();
	}

}
