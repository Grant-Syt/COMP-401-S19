package a2;

import java.util.Arrays;
import java.util.Scanner;

public class A2Jedi {

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
		String[][] recipeIngredients = new String[numOfRecipes][];
//		for(int i = 0; i < numOfRecipes; i++) {
//			Arrays.fill(recipeIngredients[i], "");
//		}
		double[][] recipeOunces = new double[numOfRecipes][];
//		for(int i = 0; i < numOfRecipes; i++) {
//			Arrays.fill(recipeOunces[i], 0);
//		}
		for(int i = 0; i < numOfRecipes; i++) {
			// each recipe
			recipeNames[i] = scan.next();
			int ingredients = scan.nextInt();
			String[] tempRecipeIngredients = new String[ingredients];
			double[] tempRecipeOunces = new double[ingredients];
			for(int index = 0; index < ingredients; index++) {
				// each ingredient
				String ingredientName = scan.next();
				double amountOfItem = scan.nextDouble();
				tempRecipeIngredients[index] = ingredientName;
				tempRecipeOunces[index] = amountOfItem;
				recipeIngredients[i] = tempRecipeIngredients;
				recipeOunces[i] = tempRecipeOunces;
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
		boolean go = true;
		double[] ouncesOfIngredients = new double[numberOfIngredients];
		while(go) {
			String order = scan.next();
			if(order.equals("EndOrder")) {
				// base case
				go = false;
			} else {
				for(int i = 0; i < numOfRecipes; i++) {
					if(order.equals(recipeNames[i])) {
						// each recipe
						String[] ingredients = recipeIngredients[i];
						for(int index = 0; index < ingredients.length; index++) {
							// each list of ingredients
							for(int count = 0; count < numberOfIngredients; count++) {
								// each ingredient
								if(ingredients[index].equals(ingredientNames[count])) {
									ouncesOfIngredients[count] += recipeOunces[i][index];
								}
							}

						}
					}
				}
			}
		}
		// output
		System.out.println("The order will require:");
		for(int i = 0; i < numberOfIngredients; i++) {
			System.out.println(String.format("%.2f", ouncesOfIngredients[i]) + " ounces of " + ingredientNames[i]);
		}
		scan.close();
	}

	// You can define helper methods here if needed.

}
