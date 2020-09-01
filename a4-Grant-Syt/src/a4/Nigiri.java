package a4;

public class Nigiri implements Sushi {

	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};

	private String name;
	private IngredientPortion[] ingredients = new IngredientPortionImpl[2];

	public Nigiri(NigiriType type) {
		if (type == NigiriType.TUNA) {
			name = "tuna nigiri";
			ingredients[0] = new TunaPortion(0.75);
		} else if (type == NigiriType.YELLOWTAIL) {
			name = "yellowtail nigiri";
			ingredients[0] = new YellowtailPortion(0.75);
		} else if (type == NigiriType.EEL) {
			name = "eel nigiri";
			ingredients[0] = new EelPortion(0.75);
		} else if (type == NigiriType.CRAB) {
			name = "crab nigiri";
			ingredients[0] = new CrabPortion(0.75);
		} else {
			name = "shrimp nigiri";
			ingredients[0] = new ShrimpPortion(0.75);
		}
		ingredients[1] = new RicePortion(0.5);
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
