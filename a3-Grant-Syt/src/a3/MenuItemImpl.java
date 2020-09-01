package a3;

public class MenuItemImpl implements MenuItem {
	// instances
	private String name;
	private IngredientPortion[] ingredients;

	//constructor
	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
		IngredientPortion[] ingredientsCopy = ingredients.clone();
		if (name == null) {
			throw new RuntimeException("Name is null");
		} else {
			this.name = name;
		}
		if (ingredientsCopy == null) {
			throw new RuntimeException("Ingredients is null");
		} else if (ingredientsCopy.length == 0) {
			throw new RuntimeException("Length of ingredients is zero");
		} else {
			boolean temp = true;
			for(int i = 0; i < ingredientsCopy.length; i++) {
				if(ingredientsCopy[i] == null) {
					temp = false;
				}
				if (!temp) {
					throw new RuntimeException("Ingredients contains null values");
				} else {
					this.ingredients = ingredientsCopy;
				}
			}
		}
	}

	// methods
	public String getName() {
		return this.name;
	}

	public IngredientPortion[] getIngredients() {
		return this.ingredients.clone();
	}

	public int getCalories() {
		double calorieCount = 0;
		for(int i = 0; i < ingredients.length; i++) {
			calorieCount += ingredients[i].getCalories();
		}
		return (int) Math.round(calorieCount);
	}

	public double getCost() {
		double totalCost = 0;
		for(int i = 0; i < ingredients.length; i++) {
			totalCost += ingredients[i].getCost();
		}
		return (double) Math.round(totalCost*100)/100;
	}

	public boolean getIsVegetarian() {
		boolean Veg = true;
		for(int i = 0; i < ingredients.length; i++) {
			if(!ingredients[i].getIsVegetarian()) {
				Veg = false;
			}
		}
		return Veg;
	}

}
