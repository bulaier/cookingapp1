package com.example.lib;

public class Recipe {
    private int min;
    private String[] ingredients;
    public String getIngredients() {
        String str = "";
        for (int i = 0; i < ingredients.length; i++) {
            str += ingredients[i];
        }
        return str;
    }
    public boolean ifAvail() {
        if (min == 0) {
            return true;
        } else {
            return false;
        }
    }
}
