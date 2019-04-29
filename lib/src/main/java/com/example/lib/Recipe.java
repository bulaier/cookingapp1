package com.example.lib;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class Recipe {
    private ArrayList<String> ingredients;
    private String instruction;
    private String title;
    private URL image;


    // the method to return ingredients. all small cases, no plurals.
    public ArrayList<String> getIngredients() {
        ArrayList<String> str = new ArrayList<>();

        return ingredients;
    }
    //return instructions as a string. Including the amount of each ingredients.
    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String s) {
        instruction = s;
    }
    //it is a setter of the ingredients, but also returns for convenience.
    public ArrayList<String> setIngredients(String ingre) {
        String[] str = ingre.split(", ");
        for (int i = 0; i < str.length; i++) {
            ingredients.add(str[i]);
        }
        return ingredients;
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
