import java.util.Scanner;

public class Nurse extends Person implements Displayable{
	private String shift;
	
	Nurse(){};
	
	Nurse(String id, String name, String sex, String shift){
		this.shift = shift;
		
		super.setID(id);
		super.setName(name);
		super.setSex(sex);
	}
	
	public void setShift(String shift)
	{
		this.shift = shift;
	}
	
	public String getShift()
	{
		return shift;
	}
	
	@Override
	public void readNewEntry(Scanner read)
	{
		System.out.println("----- New Nurse Registration -----");
		System.out.println("(ID Format - N000)");
		super.newPerson(read);
		System.out.print("Shift (AM/PM): ");
		setShift(read.nextLine());
	}
	
	@Override
	public void showInfo()
	{
		System.out.println("["+super.getID()+"]"+"    ["+super.getName()+"]    ["+getShift()+"]");
	}
	
	@Override
	public String returnClassName() {
		return "Nurse";
	}
	
	@Override
	public Displayable create() {
		return new Nurse();
	}
	
	@Override
	public String getInfoString(){
		return "["+super.getID()+"]"+"    ["+super.getName()+"]    ["+getShift()+"]";
	}
}
