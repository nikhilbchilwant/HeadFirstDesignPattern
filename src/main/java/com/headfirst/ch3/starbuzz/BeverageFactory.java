package com.headfirst.ch3.starbuzz;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BeverageFactory {

    private static final Map<BeverageType, Supplier<Beverage>> beverageMap = new HashMap<>();

    static {
        beverageMap.put(BeverageType.ESPRESSO, Espresso::new);
        beverageMap.put(BeverageType.HOUSE_BLEND, HouseBlend::new);
    }

    public static Beverage createBeverage(BeverageType type) {
        Supplier<Beverage> beverageSupplier = beverageMap.get(type);
        if (beverageSupplier != null) {
            return beverageSupplier.get();
        }
        throw new IllegalArgumentException("Invalid beverage type: " + type);
    }
}
