package com.headfirst.ch9.composite;

/**
 * Test drive for Composite Pattern.
 * Demonstrates nested menus (tree structure).
 */
public class MenuTestDrive {
    
    public static void main(String[] args) {
        // Create menu components
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
        
        // Create top-level menu (contains all other menus)
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        
        // Add menus to top-level menu
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);
        
        // Add menu items to pancake house menu
        pancakeHouseMenu.add(new MenuItem(
            "K&B's Pancake Breakfast",
            "Pancakes with scrambled eggs, and toast",
            true,
            2.99));
        pancakeHouseMenu.add(new MenuItem(
            "Regular Pancake Breakfast",
            "Pancakes with fried eggs, sausage",
            false,
            2.99));
        
        // Add menu items to diner menu
        dinerMenu.add(new MenuItem(
            "Vegetarian BLT",
            "(Fakin') Bacon with lettuce & tomato on whole wheat",
            true,
            2.99));
        dinerMenu.add(new MenuItem(
            "BLT",
            "Bacon with lettuce & tomato on whole wheat",
            false,
            2.99));
        
        // Add dessert menu as submenu of diner menu (nested!)
        dinerMenu.add(dessertMenu);
        
        dessertMenu.add(new MenuItem(
            "Apple Pie",
            "Apple pie with a flakey crust, topped with vanilla ice cream",
            true,
            3.89));
        dessertMenu.add(new MenuItem(
            "Cheesecake",
            "Creamy New York cheesecake, with a chocolate graham crust",
            true,
            3.99));
        
        // Add menu items to cafe menu
        cafeMenu.add(new MenuItem(
            "Veggie Burger and Air Fries",
            "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
            true,
            3.99));
        
        // Create waitress and print entire menu tree
        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
