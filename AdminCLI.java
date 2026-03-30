import java.util.ArrayList;
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
        			String[] inputParams = {"PRODUCT ID", "PRODUCT CATEGORY", "PRODUCT TYPE", "PRODUCT NAME", "PRODUCT PRICE", "PRODUCT STOCK", "PRODUCT COST", "ADDITIONAL PRODUCT INFO"};
        			ArrayList<String> inputs = new ArrayList<>();
        			//The order of the input should follow the order appearing in the Stock.txt file
        			//read data one entry at a time.
        			for (int i=0;i<8;i++) {
        				System.out.printf("%s:\n", inputParams[i]);
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
        				System.out.println("Ensure PRODUCT CATEGORY field is entered as either: BOARDGAME or ACCESSORY");
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