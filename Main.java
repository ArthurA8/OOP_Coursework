import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Main {
	
	public static ArrayList<String> usrDetails = new ArrayList<String>();
	
    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);

        System.out.println("WELCOME");
        
        while (true) {
            printWelcomeMenu();

            String line = consoleInput.nextLine().trim();

            int selection = Integer.parseInt(line.trim());

            switch (selection) {
            	case 0:
            		System.out.println("Goodbye");
            		System.out.println("Closing program...");
            		System.out.println();
            		return;
            		
            	case 1:
            		
            		if (login(1, consoleInput)) {
            			AdminCLI.run(consoleInput);
            		}
            		else {
            			System.out.println("Invalid Admin ID!");
            			System.out.println("Returning to Login Page");
            		}
            		break;
            		
            	case 2:
            		
            		if (login(2, consoleInput)) {
            			CustomerCLI.run(consoleInput);
            		}
            		else {
            			System.out.println("Invalid User ID!");
            			System.out.println("Returning to Login Page");
            		}
            		break;
            }
        }
    }

    private static void printWelcomeMenu() {

        // Replace placeholders with enumeration of existing users (1..n)
        System.out.println("PLEASE SELECT USER TYPE BY INPUTTING THE CORRESPONDING NUMBER (or 0 for exit)");
        System.out.println("1) admin");
        System.out.println("2) customer");
        System.out.println("0) Exit");
    }

    private static String readLine(Scanner consoleInput) {
        if (!consoleInput.hasNextLine()) {
            return null;
        }
        return consoleInput.nextLine();
    }
    
    private static boolean login(int type, Scanner scanner) {
    	
    	File userAccounts = new File("UserAccounts.txt");
    	String login = "%s: %d";
    	
    	try {
			
			switch (type) {
	    	
	    	case 1: {
	    		
	    		System.out.println("ADMIN LOGIN");
	    		Scanner adminAccountReader = new Scanner(userAccounts);
	    		while (adminAccountReader.hasNextLine()) {
	    			String[] userDetails = adminAccountReader.nextLine().split("; ");
	    			
	    			if (userDetails[5].trim().equals("admin")) {
	    				System.out.println(String.format(login, userDetails[1], Integer.parseInt(userDetails[0])));
	    			}
	    		}
	    		
	    		adminAccountReader.close();
	    		System.out.println("Enter 3-digit User ID: ");
	    				
	    		
	    		if (scanner.hasNextLine()) {
	    			String input = scanner.nextLine().trim();
	    		
	    			Scanner searchAdminReader = new Scanner(userAccounts);
	    			while (searchAdminReader.hasNextLine()) {
		    			String[] userDetails = searchAdminReader.nextLine().split("; ");
		    			
		    			if (Integer.parseInt(userDetails[0]) == Integer.parseInt(input) && userDetails[5].trim().equals("admin")) {
		    				for (int i=0; i<userDetails.length; i++) {
		    					usrDetails.add(userDetails[i]);
		    				}
		    				searchAdminReader.close();
		    				return true;
		    			}
		    		}
	    			searchAdminReader.close();
	    		}
	    		return false;
	    	}
	    		
	    	case 2: {
	    		System.out.println("CUSTOMER LOGIN");
	    		
	    		Scanner userAccountReader = new Scanner(userAccounts);
	    		while (userAccountReader.hasNextLine()) {
    				String[] userDetails = userAccountReader.nextLine().split("; ");
    				if (userDetails[5].trim().equals("customer")) {
	    				System.out.println(String.format(login, userDetails[1], Integer.parseInt(userDetails[0])));
	    			}
	    		}
	    		
	    		userAccountReader.close();
	    		
	    		System.out.println("Enter 3-digit User ID: ");
	    		
	    		if (scanner.hasNextLine()) {
	    			String input = scanner.nextLine().trim();
	    			
	    			Scanner searchCustomerReader = new Scanner(userAccounts);
	    			while (searchCustomerReader.hasNextLine()) {
	    				String[] userDetails = searchCustomerReader.nextLine().split("; ");
	    				
	    				if (Integer.parseInt(userDetails[0]) == Integer.parseInt(input) && userDetails[5].trim().equals("customer")) {
	    					for (int i=0; i<userDetails.length; i++) {
		    					usrDetails.add(userDetails[i]);
		    				}
	    					searchCustomerReader.close();
	    					return true;
	    				}
	    			}
	    			searchCustomerReader.close();
	    		}
	    		return false;
	    	}
	    	
		}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	return false;
    	
    }
    
    
}