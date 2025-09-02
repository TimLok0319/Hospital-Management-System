import java.util.Scanner;
public class Facility implements Displayable{

	private String facility;
	
	public String getFacility() {
		return facility;
	}
	
	public void setFacility(String facility) {
		this.facility = facility;
	}
	
	public void newFacility(Scanner read) {
		System.out.println("----- New Facility Registration -----");
    	System.out.print("Name: ");
    	setFacility(read.nextLine());
	}
	@Override
	public void showInfo() {
		System.out.println("["+getFacility()+"]");
	}
	
}
