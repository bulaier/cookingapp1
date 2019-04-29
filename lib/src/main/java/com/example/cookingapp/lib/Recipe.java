package com.example.cookingapp.lib;

import java.net.URL;
import java.util.ArrayList;

public final class Recipe {
    private ArrayList<String> ingredients;
    private String instruction;
    private String title;
    private URL image;


    /**
     *  the method to return ingredients. all small cases, no plurals.
     * @return an arraylist of ingredients.
     */
    public ArrayList<String> getIngredients() {
        ArrayList<String> str = new ArrayList<>();
        return ingredients;
    }
    /**
     *  return instructions as a string. Including the amount of each ingredients.
     * @return returns a string of instruction.
     */
    public String getInstruction() {
        return instruction;
    }
    public String getTitle() {
        return title;
    }

    /**
     *  return the image as an URL.
     * @return a URL.
     */
    public URL getImage() {
        return image;
    }


    public void setInstruction(String s) {
        instruction = s;
    }
    public void setIngredients(String ingre) {
        String[] str = ingre.split(", ");
        for (int i = 0; i < str.length; i++) {
            ingredients.add(str[i]);
        }
    }
    public void setImage(String s) throws Exception {
        image = new URL(s);
    }


    public Recipe(String ingre, String ttl) {
        setIngredients(ingre);
        title = ttl;
    }
    public Recipe() {}
}
