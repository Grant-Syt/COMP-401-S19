package a3;

public class IngredientPortionTester {

	public static void main(String[] args) {
		IngredientImpl a = new IngredientImpl("Carrots", 1.23, 20, true);
		IngredientImpl b = new IngredientImpl("Beef", 2.04, 50, false);
		IngredientPortionImpl c = new IngredientPortionImpl(a, 10);
		IngredientPortionImpl d = new IngredientPortionImpl(b, 15);
		IngredientPortionImpl e = new IngredientPortionImpl(a, 15);
		IngredientPortionImpl g = null;
		
		System.out.println(c.getIngredient().getName());
		System.out.println(c.getAmount());
		System.out.println(c.getName());
		System.out.println(c.getIsVegetarian());
		System.out.println(c.getCalories());
		System.out.println(c.getCost());
		
		IngredientPortionImpl f = c.combine(g);
		System.out.println(f.getIngredient().getName());
		System.out.println(f.getAmount());
	}
}
