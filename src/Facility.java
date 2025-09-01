
public class Facility implements Displayable{

	private String facility;
	
	public String getFacility() {
		return facility;
	}
	
	public void setFacility(String facility) {
		this.facility = facility;
	}
	@Override
	public void showInfo() {
		System.out.println("["+getFacility()+"]");
	}
	
}
