package com.example.lib;

import java.net.URL;

public final class Recipe {
    private String[] ingredients;
    private String instruction;
    private String title;
    private URL image;


    // the method to return ingredients. all small cases, no plurals.
    public String getIngredients() {
        String str = "";
        for (int i = 0; i < ingredients.length; i++) {
            str += ingredients[i];
        }
        return str;
    }
    //return instructions as a string. Including the amount of each ingredients.
    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String s) {
        instruction = s;
    }
    public void setIngredients(String ingre) {
        String[] str = ingre.split(", ");
        ingredients = str;
    }
    public void setImage(String s) throws Exception {
        image = new URL(s);
    }

    public Recipe(String ingre, String ttl) {
        setIngredients(ingre);
        title = ttl;
    }
    public Recipe() {}

    //public static final Recipe tunaCasserole =
}
