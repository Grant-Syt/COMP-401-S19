package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

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
		double[] totalPerPerson = new double[numOfPeople];
		String nameOfItem = "";

		for(int i = 0; i < numOfPeople; i++) {
			// processes each person
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			numOfItemsPurchased[i] = scan.nextInt();
			for(int count = 0; count < numOfItemsPurchased[i]; count++) {
				// processes each item purchased
				amountOfItem = scan.nextInt();
				nameOfItem = scan.next();
				for(int index = 0; index < numOfItems; index++) {
					// prices item from database
					if(nameOfItem.equals(itemNames[index])) {
						totalPerPerson[i] += amountOfItem * itemPrices[index];
					}
				}
			}
		}

		// determine output
		int indexOfLarge = indexOfLargest(totalPerPerson);
		int indexOfSmall = indexOfSmallest(totalPerPerson);
		double average = averageArray(totalPerPerson, numOfPeople);

		// output
		System.out.println("Biggest: " + firstNames[indexOfLarge] + " " + lastNames[indexOfLarge] + " (" + String.format("%.2f", totalPerPerson[indexOfLarge]) + ")");
		System.out.println("Smallest: " + firstNames[indexOfSmall] + " " + lastNames[indexOfSmall] + " (" + String.format("%.2f", totalPerPerson[indexOfSmall]) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
		scan.close();
	}

	// You can define / use static helper methods here.
	public static double averageArray(double[] array, int num) {
		// takes the average of the numbers in a double array
		double number = 0;
		for(int i = 0; i < array.length; i++) {
			number += array[i];
		}
		return number/num;
	}
	public static int indexOfLargest(double[] array) {
		// finds the index of the largest number
		int index = 0;
		double number = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] > number) {
				index = i;
				number = array[i]; 
			}
		}

		return index;
	}
	public static int indexOfSmallest(double[] array) {
		// finds the index of the smallest number
		int index = 0;
		double number = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] < number) {
				index = i;
				number = array[i]; 
			}
		}
		return index;
	}
}

