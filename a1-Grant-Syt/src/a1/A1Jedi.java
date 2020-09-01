package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Your code goes here.

		// initialize
		int numOfItems = scan.nextInt();
		String[] itemNames = new String[numOfItems];
		double[] itemPrices = new double[numOfItems];

		for(int i = 0; i < numOfItems; i++) {
			// assigns item names and prices to arrays
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}

		// initialize
		int numOfPeople = scan.nextInt();
		String[] firstNames = new String[numOfPeople];
		String[] lastNames = new String[numOfPeople];
		int[] numOfItemsPurchased = new int[numOfPeople];
		int amountOfItem = 0;
		String nameOfItem = "";
		int[] totalProductsPurchased = new int[numOfItems];
		int[] customersPerItem = new int[numOfItems];

		for(int i = 0; i < numOfPeople; i++) {
			// processes each person
			int[] tempProductsPurchased = new int[numOfItems];
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			numOfItemsPurchased[i] = scan.nextInt();
			for(int count = 0; count < numOfItemsPurchased[i]; count++) {
				// processes each item purchased
				amountOfItem = scan.nextInt();
				nameOfItem = scan.next();
				for(int index = 0; index < numOfItems; index++) {
					// determines matching index of each item
					if(nameOfItem.equals(itemNames[index])) {
						// adds the amount of each item to temp
						tempProductsPurchased[index] += amountOfItem;
					}
				}
			}
			for(int count = 0; count < tempProductsPurchased.length; count++) {
				// adds to the number of customers
				if(tempProductsPurchased[count] != 0) {
					customersPerItem[count] += 1;
				}
			}
			for(int count = 0; count < tempProductsPurchased.length; count++) {
				// adds the item amounts to the total
				totalProductsPurchased[count] += tempProductsPurchased[count];
			}
		}
		for(int i = 0; i < numOfItems; i++) {
			// output
			if(customersPerItem[i] == 0) {
				// output for no purchases
				System.out.println("No customers bought " + itemNames[i]);
			} else {
				// normal output
				System.out.println(customersPerItem[i] + " customers bought " + totalProductsPurchased[i] + " " + itemNames[i]);
			}
		}
		scan.close();
	}

	// You can define / use static helper methods here.
}
