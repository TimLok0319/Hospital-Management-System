import java.util.Scanner;

public interface Displayable {
	void showInfo();	
	void readNewEntry(Scanner read);
	String returnClassName();
	Displayable create();
	String getInfoString();
}
