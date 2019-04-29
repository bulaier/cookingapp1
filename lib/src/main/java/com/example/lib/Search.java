package com.example.lib;

import java.util.ArrayList;

public class Search {
    private static int number = Testing.store.length;

    // seperate the ingredients with " ," and all small case letters. No plurals please.
    public static ArrayList<Recipe> search(String str) {
        if (str == null) {
            return null;
        }
        ArrayList<String> ingredients = new ArrayList<>();
        ArrayList<Recipe> recipes = new ArrayList<>();
        String[] s = str.split(", ");
        for (int i = 0; i < s.length; i++) {
            ingredients.add(s[i]);
        }
        for (int i = 0; i < number; i++) {
            boolean b = true;
            for (String name : Testing.store[i].getIngredients()) {
                if (!ingredients.contains(name)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                recipes.add(Testing.store[i]);
            }
        }
        return recipes;
    }
}
