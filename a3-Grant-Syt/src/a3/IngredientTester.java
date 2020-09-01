package a3;

public class IngredientTester {
	public static void main(String[] args) {

		IngredientImpl a = new IngredientImpl("Carrots", 1.23, 20, true);

		System.out.print(a.getName());
		System.out.println(a.getIsVegetarian());
		System.out.println(a.getPricePerOunce());
		System.out.println(a.getCaloriesPerOunce());
		System.out.println(a.getCaloriesPerDollar());

	}
}
