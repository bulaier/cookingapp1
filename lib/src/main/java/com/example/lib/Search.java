package com.example.lib;

import java.util.ArrayList;

import static com.example.lib.Testing.store;

public class Search {
    private static int number = store.length;

    /**
     *   seperate the ingredients with " ," and all small case letters. No plurals please.
     * @param str the string entered by UI interface. (ingredients the user have)
     * @return an arraylist of recipes.
     */
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
            for (String name : store[i].getIngredients()) {
                if (!ingredients.contains(name)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                recipes.add(store[i]);
            }
        }
        return recipes;
    }
}
