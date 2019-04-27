package com.example.lib;
import  com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class Recipe {
    private int min;
    private String[] ingredients;
    private int id;
    private String title;
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
