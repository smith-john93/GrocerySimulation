package grocery;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class GroceryMain {

	public static void main(String[] args) throws IOException {
		String lineIn;
		GroceryData nextGrocery;
		ArrayList<GroceryData> groceryStock = new ArrayList<GroceryData>();
		
		Scanner inFile = new Scanner(new File("GroceryData2.txt"));
		
		while(inFile.hasNext()) {			
			//read the next line and delimit on semicolon
			lineIn = inFile.nextLine();
			String[] nextItem = lineIn.split(";");

			nextGrocery = new GroceryData(nextItem[0], nextItem[1], nextItem[2], Float.parseFloat(nextItem[3]), nextItem[4]);
			groceryStock.add(nextGrocery);
		}
		
		
		//closes the file
		inFile.close();
		String response;

		//creates and initializes totalCost
		float totalCost = 0;

		//create a formatter for the cost
		DecimalFormat formatter = new DecimalFormat("$0.00");
		
		//create a string builder for the receipt
		StringBuilder receipt = new StringBuilder("Your item(s) are: ");

		Scanner keyboard = new Scanner(System.in);

		do {
			System.out.println("Please enter the item UPC.");

			//takes UPC entered by customer and create a new GroceryData object with it
			String userInput = keyboard.nextLine();
			GroceryData target = new GroceryData(null,null,null,0,userInput);
			
			//attempt to locate the new GrocertData object in the ArrayList
			int index = groceryStock.indexOf(target);
			
			if(index == -1) {				
				//if item is not found, message with 
				//entered number is displayed
				System.out.println("Item "  + userInput+ " Not Found");
			}
			else {
				GroceryData item = groceryStock.get(index);				
				
				//adds found item to receipt
				receipt.append("\n" + item);
				
				//adds cost of new item to total
				totalCost = totalCost + item.getCost();
				
				//output the item and current cost of all items
				System.out.println(String.format("Item: %s", item.getName()));
				System.out.println(String.format("Cost: %s", item.getCost()));
				System.out.println(String.format("CurrentTotal: %.2f \n", totalCost));
			}
			
			System.out.println("Do you have another item?");
			response = keyboard.nextLine();
				//takes user response
		} while( response.charAt(0) == 'y' || response.charAt(0) == 'Y');

		keyboard.close();
		
		System.out.println(receipt);
		System.out.println("Your total is: " + formatter.format(totalCost));
	}
}
