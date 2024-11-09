import java.util.Scanner;

public class Assignment3 {

	public static void main(String[] args) {
		
		// Declare variable 
		String option;
	
		// Displaying the available services offered
		System.out.println("**List of available services**");
		System.out.println("\t1.Oil_Change");
		System.out.println("\t2.Tire_Rotation");
		System.out.println("\t3.Battery_Check");
		System.out.println("\t4.Brake_Inspection");
		System.out.print("\n");
		
		// Display message for the user to type service he/she want
		System.out.print("Please type the service you want here: ");
		
		// New Scanner
		Scanner input = new Scanner(System.in);
		
		//taking input from the user for option selection
		option = input.nextLine();
		
		// closing scanner
		input.close();
		
		// If-ElseIf-Else code-block, Display the option and its price
		if (option.equalsIgnoreCase(option)) {
			System.out.println(option.toLowerCase()+" is R250");
		}
		else if (option.equalsIgnoreCase(option)) {
			System.out.println("Tire roration is R220");
		}
		else if (option.equalsIgnoreCase(option)) {
			System.out.println("Battery check is R150");
		}
		else if (option.equalsIgnoreCase(option)) {
			System.out.println("Brake inspection is R50");
		}
		else {
			System.out.println("Invalid item entry!!");	
		}
	}

}
