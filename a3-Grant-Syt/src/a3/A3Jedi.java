package a3;

import java.util.Scanner;

public class A3Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Initialize
		int numberOfIngredients = scan.nextInt();
		String[] ingredientNames = new String[numberOfIngredients];
		double[] pricePerOunce = new double[numberOfIngredients];
		boolean[] isVegetarian = new boolean[numberOfIngredients];
		int[] caloriesPerOunce = new int[numberOfIngredients];
		IngredientImpl[] ingredientData = new IngredientImpl[numberOfIngredients];

		// Records ingredients
		for (int i = 0; i < numberOfIngredients; i++) {
			ingredientNames[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			isVegetarian[i] = scan.nextBoolean();
			caloriesPerOunce[i] = scan.nextInt();
			ingredientData[i] = new IngredientImpl(ingredientNames[i], pricePerOunce[i], caloriesPerOunce[i], isVegetarian[i]);
		}

		// Records menu
		int numOfRecipes = scan.nextInt();
		String[] recipeNames = new String[numOfRecipes];
		MenuItem[] Recipes = new MenuItem[numOfRecipes];
		for(int i = 0; i < numOfRecipes; i++) {
			// for each recipe
			recipeNames[i] = scan.next();
			int ingredientCount = scan.nextInt();
			IngredientPortionImpl[] ingredientPortionsPerRecipe = new IngredientPortionImpl[ingredientCount];
			for(int index = 0; index < ingredientCount; index++) {
				// for each ingredient
				String ingredientName = scan.next();
				double amountOfItem = scan.nextDouble();
				for(int count = 0; count < numberOfIngredients; count++) {
					// matching ingredient with ingredient data
					if(ingredientName.equals(ingredientNames[count])) {
						ingredientPortionsPerRecipe[index] = new IngredientPortionImpl(ingredientData[count], amountOfItem);						
					}
				}
			}
			// assigning individual ingredient portion array to the corresponding recipe
			Recipes[i] = new MenuItemImpl(recipeNames[i], ingredientPortionsPerRecipe);
		}
		

		boolean go = true;
		double[] ouncesOfIngredients = new double[numberOfIngredients];
		while(go) {
		// processing order
			String order = scan.next();
			if(order.equals("EndOrder")) {
				// base case
				go = false;
			} else {
				for(int i = 0; i < numOfRecipes; i++) {
					if(order.equals(recipeNames[i])) {
						// each recipe
						for(int index = 0; index < Recipes[i].getIngredients().length; index++) {
							// each list of ingredients
							for(int count = 0; count < numberOfIngredients; count++) {
								// each ingredient
								if(Recipes[i].getIngredients()[index].getName().equals(ingredientNames[count])) {
									ouncesOfIngredients[count] += Recipes[i].getIngredients()[index].getAmount();
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

}
