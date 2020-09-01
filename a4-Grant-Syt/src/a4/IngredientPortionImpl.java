package a4;

abstract public class IngredientPortionImpl implements IngredientPortion {

	Ingredient ingredient;
	double amount;
	
	public IngredientPortionImpl(Ingredient ingredient, double amount) {
		this.ingredient = ingredient;
		this.amount = amount;
	}
	
	
	public Ingredient getIngredient() {
		return ingredient;
	}

	
	public String getName() {
		return ingredient.getName();
	}

	
	public double getAmount() {
		return amount;
	}

	
	public double getCalories() {
		return ingredient.getCaloriesPerOunce()*amount;
	}

	
	public double getCost() {
		return ingredient.getPricePerOunce()*amount;
	}

	
	public boolean getIsVegetarian() {
		return ingredient.getIsVegetarian();
	}

	
	public boolean getIsRice() {
		return ingredient.getIsRice();
	}

	
	public boolean getIsShellfish() {
		return ingredient.getIsShellfish();
	}
	
	abstract public IngredientPortion combine(IngredientPortion other);

}
