package com.headfirst.ch9.iterator;

/**
 * Waitress - uses iterators to print menus.
 * 
 * TODO: Complete the waitress class.
 * 
 * YOUR TASKS:
 * 1. Add fields for both menus
 * 2. Implement constructor to store menus
 * 3. Implement printMenu() using iterators
 */
public class Waitress {
    // TODO 1: Add fields
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;
    
    
    // TODO 2: Implement constructor
    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
        // TODO: Store both menus
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }
    
    // TODO 3: Implement printMenu()
    public void printMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
    }
    
    private void printMenu(Iterator iterator) {
        // TODO: Iterate and print each menu item
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}
