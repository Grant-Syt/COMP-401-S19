package a3;

public class MenuItemTester {

	static public void main(String[] args) {
		// each ingredient has values
		IngredientImpl a = new IngredientImpl("Carrots", 1.23, 20, true);
		IngredientImpl b = new IngredientImpl("Beef", 2.04, 50, false);
		// each portion has an ingredient and an amount
		IngredientPortionImpl c = new IngredientPortionImpl(a, 10);
		IngredientPortionImpl d = new IngredientPortionImpl(b, 15);
		IngredientPortionImpl e = new IngredientPortionImpl(a, 15);
		IngredientPortionImpl f = null;
		// a menu item is an array of portions with a name
		IngredientPortion[] stewIng = new IngredientPortion[2];
		stewIng[0] = c;
		stewIng[1] = d;
		//		stewIng[2] = f;
		MenuItem recipe1 = new MenuItemImpl("stew", stewIng);
		System.out.println(recipe1.getName());
		System.out.println(recipe1.getIngredients()[0].getName());
		System.out.println(recipe1.getCalories());
		System.out.println(recipe1.getCost());
		System.out.println(recipe1.getIsVegetarian());
	}
}
