package a4;

public class YellowtailPortion extends IngredientPortionImpl implements IngredientPortion {
	
	public YellowtailPortion(double amount) {
		super(new Yellowtail(), amount);
		if (amount < 0) {
			throw new RuntimeException("Amount of ingredient portion is less than zero");
		}
	}
	
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if(other == null) {
			return this;
		} else if (!(this.getIngredient().equals(other.getIngredient()))) {
			throw new RuntimeException("Combining different types of ingredients");
		} else {
			return new YellowtailPortion(this.getAmount() + other.getAmount());
		}
	}
}