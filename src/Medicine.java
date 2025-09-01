
import java.util.Scanner;

public class Medicine {
    private String name;
    private String manufacturer;
    private String expiryDate;
    private int cost;
    private int count;

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
    	System.out.println("----- New Medicine Registration -----");
    	System.out.print("Name: ");
    	setName(read.nextLine());
    	System.out.print("Manufacturer: ");
    	setManufacturer(read.nextLine());
    	System.out.print("expiryDate: ");
    	setExpiryDate(read.nextLine());
    	System.out.print("Cost: ");
    	setCost(read.nextInt());
    	System.out.print("Unit: ");
    	setCount(read.nextInt());
    }
    
    public void findMedicine() {
    	System.out.println("["+getName()+"]"+"    ["+getManufacturer()+"]	["+getExpiryDate()+"]    [RM"+getCost()+"]");
    }
}
