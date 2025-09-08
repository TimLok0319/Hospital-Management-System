
import java.util.InputMismatchException;
import java.util.Scanner;

public class Medicine implements Displayable{
    private String name;
    private String manufacturer;
    private String expiryDate;
    private int cost;
    private int count;
    
    Medicine(){};
    
    Medicine(String name, String manufacturer,String expiryDate, int cost, int count){
    	this.name = name;
    	this.manufacturer = manufacturer;
    	this.expiryDate = expiryDate;
    	this.cost = cost;
    	this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public void newMedicine(Scanner read) {
    	boolean undone = true;
    	System.out.println("----- New Medicine Registration -----");
    	System.out.print("Name: ");
    	setName(read.nextLine());
    	System.out.print("Manufacturer: ");
    	setManufacturer(read.nextLine());
    	System.out.print("expiryDate (DD/MM/YYY): ");
    	setExpiryDate(read.nextLine());
    	
    	while(undone)
		{
			try {
				System.out.print("Cost:RM");
				setCost(read.nextInt());
				undone = false;
			}catch(InputMismatchException e){
				System.out.println("//Error - Please enter number only!");
				undone = true;
			};
			read.nextLine();
		}
    	undone = true;
    	while(undone)
		{
			try {
				System.out.print("Count (Pcs): ");
				setCount(read.nextInt());
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
    	System.out.println("["+getName()+"]"+"    ["+getManufacturer()+"]	["+getExpiryDate()+"]    [RM"+getCost()+"]");
    }
}
