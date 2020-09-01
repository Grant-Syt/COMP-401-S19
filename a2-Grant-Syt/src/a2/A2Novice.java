package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Your code here.

		// Initialize
		int numberOfIngredients = scan.nextInt();
		String[] ingredientNames = new String[numberOfIngredients];
		double[] pricePerOunce = new double[numberOfIngredients];
		boolean[] isVegetarian = new boolean[numberOfIngredients];
		int[] caloriesPerOunce = new int[numberOfIngredients];

		// Reads input
		for (int i = 0; i < numberOfIngredients; i++) {
			ingredientNames[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			isVegetarian[i] = scan.nextBoolean();
			caloriesPerOunce[i] = scan.nextInt();
		}

		// Determines Output
		int numOfVeg = 0;
		for (int i = 0; i < numberOfIngredients; i++) {
			if(isVegetarian[i]) {
				numOfVeg += 1;
			}
		}
		double[] calsPerDollar = new double[numberOfIngredients];
		for(int i = 0; i < numberOfIngredients; i++) {
			calsPerDollar[i] = caloriesPerOunce[i] / pricePerOunce[i];
		}
		String highest = ingredientNames[indexOfLargest(calsPerDollar)];
		String lowest = ingredientNames[indexOfSmallest(calsPerDollar)];

		// Output
		System.out.println("Number of vegetarian ingredients: " + numOfVeg);
		System.out.println("Highest cals/$: " + highest);
		System.out.println("Lowest cals/$: " + lowest);

		scan.close();
	}

	// You can define helper methods here if needed.

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
