import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AdminCLI {
	public final static String NOT_IMPLEMENTED = "Not implemented";
	public final static String INVALID = "Invalid input";

    public static void run(Scanner consoleInput) {
    	System.out.println("\nADMIN VIEW");
    	
    	int id = Integer.parseInt(Main.usrDetails.get(0));
    	String name = Main.usrDetails.get(1);
    	int houseNum = Integer.parseInt(Main.usrDetails.get(2));
    	String pstCode = Main.usrDetails.get(3);
    	String city = Main.usrDetails.get(4);
    	
    	Admin adminInst = new Admin(id, name, houseNum, pstCode, city, Role.ADMIN);
 
        while (true) {
        	
        	printAdminMenu();
        	
        	int selection = Integer.parseInt(consoleInput.nextLine().trim());
        	
        	switch (selection) {
        		case 1:
        			System.out.println("\n");
        			System.out.println("PRODUCT LIST\n");
        			adminInst.viewProducts();
        			System.out.println("\n");
        			break;
        		
        		case 2:
        			System.out.println("ADDING PRODUCT\n");
        			String[] inputParams = {"PRODUCT ID: ", "PRODUCT CATEGORY:\n\nFor Boardgame: Type 1\nFor Accessory: Type 2", "PRODUCT TYPE: ", "PRODUCT NAME: ", "PRODUCT PRICE: ", "PRODUCT STOCK: ", "PRODUCT COST: ", "ADDITIONAL PRODUCT INFO: "};
        			ArrayList<String> inputs = new ArrayList<>();
        			
        			for (int i=0;i<2;i++) {
        				System.out.printf("%s\n", inputParams[i]);
        				inputs.add(consoleInput.nextLine());
        			}
        			
        			if (inputs.get(1).equals(String.valueOf(1))) {
        				inputs.set(1, "BOARDGAME");
        				inputParams[2] = "BOARDGAME TYPE:\n\nFor Strategy: Type 1\nFor Party: Type 2";
        				System.out.printf("%s\n", inputParams[2]);
        				String cliIn = consoleInput.nextLine();
        				if (cliIn.equals(String.valueOf(1))) {
        					inputs.add("STRATEGY");
        				}
        				else if (cliIn.equals(String.valueOf(2))) {
        					inputs.add("PARTY");
        				}
        				else {
        					System.out.println("Invalid Input!\n Retry with either input 1 or 2");
        				}
        			}
        			else if (inputs.get(1).equals(String.valueOf(2))) {
        				inputs.set(1, "ACCESSORY");
        				inputParams[2] = "ACCESSORY TYPE:\n\nFor Dice: Type 1\nFor Miniature: Type 2\nFor Accessory Kit: Type 3";
        				System.out.printf("%s\n", inputParams[2]);
        				String cliIn = consoleInput.nextLine();
        				if (cliIn.equals(String.valueOf(1))) {
        					inputs.add("DICE");
        				}
        				else if (cliIn.equals(String.valueOf(2))) {
        					inputs.add("MINIATURE");
        				}
        				else if (cliIn.equals(String.valueOf(3))) {
        					inputs.add("ACCESSORY_KIT");
        				}
        				else {
        					System.out.println("Invalid Input!\n Retry with either input 1, 2 or 3");
        				}
        			}
        			else {
        				System.out.println("Invalid Input!\n Retry with either input 1 or 2");
        			}
        			
        			for (int i=3;i<7;i++) {
        				System.out.printf("%s\n", inputParams[i]);
        				inputs.add(consoleInput.nextLine());
        			}
        			
        			if (inputs.get(1) == "BOARDGAME") {
        				inputParams[7] = "MAX PLAYERS: ";
        				System.out.printf("%s\n", inputParams[7]);
        				inputs.add(consoleInput.nextLine());
        			}
        			else {
        				inputParams[7] = "COMPATIBILITY: ";
        				System.out.printf("%s\n", inputParams[7]);
        				inputs.add(consoleInput.nextLine());
        			}

    
        			if (ProductCategory.valueOf(inputs.get(1)) == ProductCategory.ACCESSORY) {
        				
        				Accessories newProduct = new Accessories(Integer.valueOf(inputs.get(0)), ProductCategory.ACCESSORY, inputs.get(3), Double.valueOf(inputs.get(6)), Integer.valueOf(inputs.get(5)), Double.valueOf(inputs.get(4)), AccessoryType.valueOf(inputs.get(2)), inputs.get(7));
        				adminInst.addProduct(newProduct);
        			}
        			else if (ProductCategory.valueOf(inputs.get(1)) == ProductCategory.BOARDGAME) {
        				
        				BoardGame newProduct = new BoardGame(Integer.valueOf(inputs.get(0)), ProductCategory.BOARDGAME, inputs.get(3), Double.valueOf(inputs.get(6)), Integer.valueOf(inputs.get(5)), Double.valueOf(inputs.get(4)), BoardGameType.valueOf(inputs.get(2)), Integer.valueOf(inputs.get(7)));
        				adminInst.addProduct(newProduct);
        			}
        			
        			else {
        				System.out.println("Failed to add Product!");
        			}
        			
        			System.out.println();
        			break;
        			
        		case 0:
        			return;
        			
        		default:
        			System.out.println(INVALID);
        			System.out.println();
        	}
        }
    }

    
    private static void printAdminMenu() {

        System.out.println("PLEASE SELECT ACTION BY INPUTTING THE CORRESPONDING NUMBER (or 0 for logout)");
        System.out.println("1) View all products");
        System.out.println("2) Add new product");
        

        System.out.println("0) Log out");
    }
    
    
       
}