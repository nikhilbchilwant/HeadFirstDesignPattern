package com.headfirst.appendix.flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
public class TreeFactory {
    // Cache for shared flyweights
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String otherTreeData) {
        String key = name + "-" + color;
        if (treeTypes.containsKey(key)) {
            return treeTypes.get(key);
        } else {
            TreeType treeType = new TreeType(name, color, otherTreeData);
            treeTypes.put(key, treeType);
            return treeType;
        }
    }

    public static int getUniqueTreeTypeCount() {
        return treeTypes.size();
    }
}
