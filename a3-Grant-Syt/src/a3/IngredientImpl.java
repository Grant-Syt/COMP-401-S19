package a3;

public class IngredientImpl implements Ingredient {

	// instances
	private String name;
	private double price;
	private int calories;
	private boolean is_vegetarian;

	// constructor
	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian) {
		if (name.isEmpty()) {
			throw new RuntimeException("Name is null");
		} else {
			this.name = name;
		}
		if (price < 0) {
			throw new RuntimeException("Price is negative");
		} else {
			this.price = price;
		}
		if (calories < 0) {
			throw new RuntimeException("Calories is negative");
		} else {
			this.calories = calories;
		}
		this.is_vegetarian = is_vegetarian;
	}

	// methods
	public String getName() {
		return this.name;
	}

	public boolean getIsVegetarian() {
		return this.is_vegetarian;
	}

	public double getPricePerOunce() {
		return this.price;
	}

	public int getCaloriesPerOunce() {
		return this.calories;
	}

	public double getCaloriesPerDollar() {
		return (this.calories/this.price);
	}
}
