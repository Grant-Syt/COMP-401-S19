package a3;

public class IngredientPortionImpl implements IngredientPortion {
	// instances
	private Ingredient ing;
	private double amount;

	//constructor
	public IngredientPortionImpl(Ingredient ing, double amount) {
		if (ing == null) {
			throw new RuntimeException("Ingredient is null");
		} else {
			this.ing = ing;
		}
		if (amount < 0) {
			throw new RuntimeException("Amount is negative");
		} else {
			this.amount = amount;
		}
	}

	//methods
	public Ingredient getIngredient() {
		return this.ing;
	}

	public double getAmount() {
		return this.amount;
	}

	public String getName() {
		return this.ing.getName();
	}

	public boolean getIsVegetarian() {
		return this.ing.getIsVegetarian();
	}

	public double getCalories() {
		return this.ing.getCaloriesPerOunce() * this.amount;
	}

	public double getCost() {
		return this.ing.getPricePerOunce() * this.amount;
	}

	public IngredientPortionImpl combine(IngredientPortion other) {
		// combines ingredient amounts
		if (other == null) {
			return this;
		} else {
			if(other.getIngredient() != this.getIngredient()) {
				throw new RuntimeException("Combing ingredients of different types");
			} else {
				Ingredient ing = this.getIngredient();
				double amount = this.getAmount() + other.getAmount();
				return new IngredientPortionImpl(ing, amount);
			}
		}
	}

}
