import java.util.Scanner;
public class Facility implements Displayable{

	private String facility;
	
	Facility(){};
	
	Facility(String facility){
		this.facility = facility;
	}
	
	public String getFacility() {
		return facility;
	}
	
	public void setFacility(String facility) {
		this.facility = facility;
	}
	
	@Override
	public void readNewEntry(Scanner read) {
		System.out.println("----- New Facility Registration -----");
    	System.out.print("Name: ");
    	setFacility(read.nextLine());
	}
	@Override
	public void showInfo() {
		System.out.println("["+getFacility()+"]");
	}

	@Override
	public String returnClassName() {
		return "Facility";
	}

	@Override
	public Displayable create() {
		return new Facility();
	}
	
	@Override
	public String getInfoString(){
		return "["+getFacility()+"]";
	}
	
}
