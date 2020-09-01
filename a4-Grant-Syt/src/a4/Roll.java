package a4;

import java.util.ArrayList;

public class Roll implements Sushi {

	private String name;
	private IngredientPortion[] ingredients;

	public Roll(String name, IngredientPortion[] ingredients) {
		if(ingredients == null) {
			throw new RuntimeException("Ingredient portion array is null");
		}
		for(int i = 0; i < ingredients.length; i++) {
			if(ingredients[i] == null) {
				throw new RuntimeException("An item in ingredient portion array is null");
			}
		}

		ArrayList<IngredientPortion> tempIngredients = new ArrayList<IngredientPortion>();

		// Combines like ingredients
		for(int a = 0; a < ingredients.length; a++) {
			boolean foundIt = false;
			for(int b = 0; b < tempIngredients.size(); b++) {
				if(tempIngredients.get(b).getName().equals(ingredients[a].getName())) {
					foundIt = true;
					tempIngredients.set(b, tempIngredients.get(b).combine(ingredients[a]));
				}
			}
			if (!foundIt) {
				tempIngredients.add(ingredients[a]);
			}
		}

		// Checks for seaweed and adds some if it does have any
		Ingredient standardSeaweed = new Seaweed();
		boolean needsSeaweed = true;
		for(int i = 0; i < tempIngredients.size(); i++) {
			System.out.println(tempIngredients.get(i).getIngredient().getName());
			if(tempIngredients.get(i).getIngredient().equals(standardSeaweed)) {
				needsSeaweed = false;
				if(tempIngredients.get(i).getAmount() < 0.1) {
					tempIngredients.set(i, tempIngredients.get(i).combine(new SeaweedPortion(0.1 - tempIngredients.get(i).getAmount())));
				}
			}
		}
		if(needsSeaweed) {
			tempIngredients.add(new SeaweedPortion(0.1));
		}

		this.name = name;
		this.ingredients = tempIngredients.toArray(new IngredientPortion[tempIngredients.size()]);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return ingredients.clone();
	}

	@Override
	public int getCalories() {
		double cal = 0;
		for(int i = 0; i < ingredients.length; i++) {
			cal += ingredients[i].getCalories();
		}
		return (int) Math.round(cal);
	}

	@Override
	public double getCost() {
		double cost = 0;
		for(int i = 0; i < ingredients.length; i++) {
			cost += ingredients[i].getCost();
		}
		return Math.round(cost * 100.0) / 100.0;
	}

	@Override
	public boolean getHasRice() {
		for(int i = 0; i < ingredients.length; i++) {
			if(ingredients[i].getIsRice()) {
				return true;	
			}
		}
		return false;
	}

	@Override
	public boolean getHasShellfish() {
		for(int i = 0; i < ingredients.length; i++) {
			if(ingredients[i].getIsShellfish()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		for(int i = 0; i < ingredients.length; i++) {
			if(!ingredients[i].getIsVegetarian()) {
				return false;
			}
		}
		return true;
	}
}
