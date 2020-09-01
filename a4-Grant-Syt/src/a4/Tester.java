package a4;

public class Tester {

	public static void main(String[] args) {
		
//		System.out.println("Ingredient Test:");
//		Avocado a = new Avocado();
//		Rice b = new Rice();
//		System.out.println(a.getName());
//		System.out.println(a.getCaloriesPerDollar());
//		System.out.println(a.getCaloriesPerOunce());
//		System.out.println(a.getPricePerOunce());
//		System.out.println(a.equals(a));
//		System.out.println(a.equals(b));
//		System.out.println(a.getIsVegetarian());
//		System.out.println(b.getIsVegetarian());
//		System.out.println(a.getIsRice());
//		System.out.println(a.getIsShellfish());
//		
//		System.out.println("Portion Test: ");
		AvocadoPortion c = new AvocadoPortion(0.75);
//		System.out.println(c.getIngredient().getName());
//		System.out.println(c.getName());
//		System.out.println(c.getAmount());
//		System.out.println(c.getCalories());
//		System.out.println(c.getCost());
//		System.out.println(c.getIsVegetarian());
//		System.out.println(c.getIsRice());
//		System.out.println(c.getIsShellfish());
//		System.out.println(c.combine(c).getAmount());
//		
//		System.out.println("Sashimi Test: ");
//		Sashimi z = new Sashimi(Sashimi.SashimiType.TUNA);
//		System.out.println(z.getCalories());
//		
		System.out.println("Roll Test: ");
		TunaPortion d = new TunaPortion(1.25);
		SeaweedPortion g = new SeaweedPortion(2);
		IngredientPortion[] e = new IngredientPortionImpl[]{c, g, d, c};
		Roll f = new Roll("tuna avocado", e);
		System.out.println(f.getIngredients()[0].getName());
		System.out.println(f.getIngredients()[0].getAmount());
		System.out.println(f.getIngredients()[1].getName());
		System.out.println(f.getIngredients()[1].getAmount());
		System.out.println(f.getIngredients()[2].getName());
		System.out.println(f.getIngredients()[2].getAmount());
		System.out.println(f.getName());
		System.out.println(f.getIngredients().length);
//		
//		System.out.println("Random Tests: ");
//		int g = (int) Math.round(31.5);
//		int h = (int) Math.round(31.4);
//		System.out.println(g);
//		System.out.println(h);
//		Tuna i = new Tuna();
//		System.out.println(i.getName());
//		System.out.println(i.getCaloriesPerOunce());
//		TunaPortion j = new TunaPortion(0.75);
//		System.out.println(j.getName());
//		System.out.println(j.getCalories());
//		Sashimi k = new Sashimi(Sashimi.SashimiType.TUNA);
//		System.out.println(k.getName());
//		System.out.println(k.getCalories());

//		Sushi a = new Nigiri(Nigiri.NigiriType.YELLOWTAIL);
//		System.out.println(a.getName());
//		System.out.println(a.getCalories());
//		System.out.println(a.getCost());
//		System.out.println(a.getIngredients()[0].getName());
		
	}
}
