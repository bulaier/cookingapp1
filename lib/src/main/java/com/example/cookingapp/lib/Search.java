package com.example.cookingapp.lib;

import java.net.URL;
import java.util.ArrayList;

import com.example.cookingapp.lib.Testing;

public class Search {
    private static int number = Testing.store.length;

    /**
     *  This function returns a list of URLs of the recipes we show on the UI. The recipes depend on the ingredients the user enters, so ideally use with search method.
     * @param recipes The recipes we return. It should be the result (output) of the Search.search function.
     * @return an arraylist of URLs.
     */
    public static ArrayList<URL> getImages(ArrayList<Recipe> recipes) {
        ArrayList<URL> urls = new ArrayList<>();
        if (recipes == null) {
            return urls;
        }
        for (int i = 0; i < recipes.size(); i++) {
            urls.add(recipes.get(i).getImage());
        }
        return urls;
    }
    /**
     *  This function returns a list of names of the recipes we show on the UI. The recipes depend on the ingredients the user enters, so ideally use with search method.
     * @param recipes The recipes we return. It should be the result (output) of the Search.search function.
     * @return an arraylist of titles of recipes.
     */
    public static ArrayList<String> getTitles(ArrayList<Recipe> recipes) {
        ArrayList<String> names = new ArrayList<>();
        if (recipes == null) {
            return names;
        }
        for (int i = 0; i < recipes.size(); i++) {
            names.add(recipes.get(i).getTitle());
        }
        return names;
    }

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
            if (Testing.store[i] == null) {
                System.out.println("null store [" + i + "]" + number);
                break;
            }
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
