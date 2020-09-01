package a4;

public class IngredientImpl {

	private String name;
	private double pricePerOunce;
	private int caloriesPerOunce;
	private boolean isVegetarian;
	private boolean isRice;
	private boolean isShellfish;

	public IngredientImpl(String name, double pricePerOunce, int caloriesPerOunce, boolean isVegetarian, boolean isRice, boolean isShellfish) {
		this.name = name;
		this.pricePerOunce = pricePerOunce;
		this.caloriesPerOunce = caloriesPerOunce;
		this.isVegetarian = isVegetarian;
		this.isRice = isRice;
		this.isShellfish = isShellfish;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	
	public double getCaloriesPerDollar() {
		// TODO Auto-generated method stub
		return caloriesPerOunce/pricePerOunce;
	}

	
	public int getCaloriesPerOunce() {
		// TODO Auto-generated method stub
		return caloriesPerOunce;
	}

	
	public double getPricePerOunce() {
		// TODO Auto-generated method stub
		return pricePerOunce;
	}

	
	public boolean equals(Ingredient other) {
		// TODO Auto-generated method stub
		if(name.equals(other.getName()) && (caloriesPerOunce == other.getCaloriesPerOunce()) && (pricePerOunce - other.getPricePerOunce() < 0.01) && (isVegetarian == other.getIsVegetarian()) && (isRice == other.getIsRice()) && (isShellfish == other.getIsShellfish())) {
			return true;
		} else {
			return false;
		}
	}

	
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return isVegetarian;
	}

	
	public boolean getIsRice() {
		// TODO Auto-generated method stub
		return isRice;
	}

	
	public boolean getIsShellfish() {
		// TODO Auto-generated method stub
		return isShellfish;
	}

}
