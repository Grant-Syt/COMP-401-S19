package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// initializes variable
		int numberOfPeople = scan.nextInt();

		for(int i = 0; i < numberOfPeople; i++) {
			// processes each customer
			String firstName = scan.next();
			String lastName = scan.next();
			double totalCost = 0;
			int numberOfItems = scan.nextInt();

			for(int count = 0; count < numberOfItems; count++) {
				// processes each item purchased
				int itemAmount = scan.nextInt();
				String itemName = scan.next();
				double itemPrice = scan.nextDouble();
				double itemCost = itemAmount * itemPrice;
				totalCost += itemCost;
			}
			// prints each total individually
			System.out.println(firstName.charAt(0) + ". " + lastName + ": " + String.format("%.2f", totalCost));
		}
		scan.close();
	}
}

// You can define / use static helper methods here.

