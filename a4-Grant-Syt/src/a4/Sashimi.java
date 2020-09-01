package a4;

public class Sashimi implements Sushi {

	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};

	private String name;
	private IngredientPortion[] ingredients = new IngredientPortionImpl[1];

	public Sashimi(SashimiType type) {
		if (type == SashimiType.TUNA) {
			name = "tuna sashimi";
			ingredients[0] = new TunaPortion(0.75);
		} else if (type == SashimiType.YELLOWTAIL) {
			name = "yellowtail sashimi";
			ingredients[0] = new YellowtailPortion(0.75);
		} else if (type == SashimiType.EEL) {
			name = "eel sashimi";
			ingredients[0] = new EelPortion(0.75);
		} else if (type == SashimiType.CRAB) {
			name = "crab sashimi";
			ingredients[0] = new CrabPortion(0.75);
		} else {
			name = "shrimp sashimi";
			ingredients[0] = new ShrimpPortion(0.75);
		}
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
