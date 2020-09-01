package a2;

import java.util.Arrays;
import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Your code here.

		// Initialize
		int numberOfIngredients = scan.nextInt();
		String[] ingredientNames = new String[numberOfIngredients];
		double[] pricePerOunce = new double[numberOfIngredients];
		boolean[] isVegetarian = new boolean[numberOfIngredients];
		int[] caloriesPerOunce = new int[numberOfIngredients];

		// Records ingredients
		for (int i = 0; i < numberOfIngredients; i++) {
			ingredientNames[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			isVegetarian[i] = scan.nextBoolean();
			caloriesPerOunce[i] = scan.nextInt();
		}

		// Records menu
		int numOfRecipes = scan.nextInt();
		String[] recipeNames = new String[numOfRecipes];
		double[] prices = new double[numOfRecipes];
		double[] calories = new double[numOfRecipes];
		boolean[] vegStatus = new boolean[numOfRecipes];
		Arrays.fill(vegStatus, true);
		for(int i = 0; i < numOfRecipes; i++) {
			// each recipe
			recipeNames[i] = scan.next();
			int ingredients = scan.nextInt();
			for(int index = 0; index < ingredients; index++) {
				// each ingredient
				String ingredientName = scan.next();
				double amountOfItem = scan.nextDouble();
				for(int count = 0; count < numberOfIngredients; count++) {
					// search
					if(ingredientName.equals(ingredientNames[count])) {
						calories[i] += caloriesPerOunce[count] * amountOfItem;
						prices[i] += pricePerOunce[count] * amountOfItem;
						if(!isVegetarian[count]) {
							vegStatus[i] = false;
						}
					}
				}
			}
		}

		// output
		for(int i = 0; i < numOfRecipes; i++) {
			if(vegStatus[i]) {
				System.out.println(recipeNames[i] + ":\n  " + ((int) (calories[i] + 0.5)) + " calories\n  " + "$" + String.format("%.2f", prices[i]) + "\n  " + "Vegetarian");	
			}else {
				System.out.println(recipeNames[i] + ":\n  " + ((int) (calories[i] + 0.5)) + " calories\n  " + "$" + String.format("%.2f", prices[i]) + "\n  " + "Non-Vegetarian");
			}
			scan.close();
		}

		// You can define helper methods here if needed.

	}
}