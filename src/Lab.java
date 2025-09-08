
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab implements Displayable {
	private String 	lab;
	private int cost;
	
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
	
	public void newLab(Scanner read) {
		System.out.println("----- New Lab Registration -----");
    	System.out.print("Lab Name: ");
    	setLab(read.nextLine());
    	System.out.print("Cost: ");
    	try {
			setCost(read.nextInt());
		}catch(InputMismatchException e)
		{
			System.out.println("//Error - Please enter number only!");
		};
		read.nextLine();
	}
	
	@Override
	public void showInfo() {
		System.out.println("["+getLab()+"]	["+getCost()+"]");
	}
	
}
