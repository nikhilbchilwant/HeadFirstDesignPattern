package com.headfirst.ch9.iterator;

/**
 * Test drive for Iterator Pattern.
 */
public class MenuTestDrive {
    
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}
