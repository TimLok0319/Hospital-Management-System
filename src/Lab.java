
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab implements Displayable {
	private String 	lab;
	private int cost;
	
	Lab(){};
	
	Lab(String lab, int cost){
		this.lab = lab;
		this.cost = cost;
	}

	public String getLab() {
		return lab;
	}

	public void setLab(String lab) {
		this.lab = lab;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public void readNewEntry(Scanner read) {
		boolean undone = true;
		System.out.println("----- New Lab Registration -----");
    	System.out.print("Lab Name: ");
    	setLab(read.nextLine());
    	
    	while(undone)
		{
			try {
				System.out.print("Cost :RM ");
				setCost(read.nextInt());
				undone = false;
			}catch(InputMismatchException e){
				System.out.println("//Error - Please enter number only!");
				undone = true;
			};
			read.nextLine();
		}
	}
	
	@Override
	public void showInfo() {
		System.out.println("["+getLab()+"]	["+getCost()+"]");
	}
	
	@Override
	public String returnClassName() {
		return "Lab";
	}
	
	@Override
	public Displayable create() {
		return new Lab();
	}
	
	@Override
	public String getInfoString(){
		return "["+getLab()+"]	["+getCost()+"]";
	}
	
	
}
