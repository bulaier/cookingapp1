package com.example.cookingapp;

import android.app.AppComponentFactory;
import android.os.Bundle;

import com.example.cookingapp.lib.Testing;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.cookingapp.lib.Recipe;

public final class RecipeView extends AppCompatActivity {
    private static final String TAG = "cookingApp:recipe";

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activty_main_output2);
        setTitle("Show the recipe");

        findViewById(R.id.backButt).setOnClickListener(v -> back());
    }

    void back() {
        /*
           I'm calling MainActivity only because there is no class available for the Activity_main_output.
           Later it should return to it. However, if that's hard to implement, it's also ok to turn to mainactivity.
         */
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();
    }
}
