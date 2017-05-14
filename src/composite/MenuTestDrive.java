package composite;

public class MenuTestDrive {
	public static void main(String args[]){
		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Brekfast");
		MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
		MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
		MenuComponent dessertMenu = new Menu("PANCAKE HOUSE MENU", "Brekfast");
		
		MenuComponent allMenus = new Menu("ALL MENUS", "All Menuds combined");
		
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		
		dinerMenu.add(new MenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", 3.89, true));
		dinerMenu.add(dessertMenu);
		
		dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", 1.59, true));
		
		Waitress cindy = new Waitress(allMenus);
		
		cindy.printMenu();
	}
}
