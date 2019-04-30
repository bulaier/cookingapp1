package com.example.cookingapp;

import android.app.AppComponentFactory;
import android.os.Bundle;

import com.example.cookingapp.lib.Search;
import com.example.cookingapp.lib.Testing;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cookingapp.lib.Recipe;

import java.util.ArrayList;

public final class RecipeView extends AppCompatActivity {
    private static final String TAG = "cookingApp:recipe";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activty_main_output2);
        setTitle("Show the recipe");

        findViewById(R.id.backButt).setOnClickListener(v -> back());
        Intent intent = getIntent();
        String str = intent.getStringExtra("input");
        if (str == null) {
            str = "";
        }
        ArrayList<Recipe> res = Search.search(str);
        TextView text = findViewById(R.id.nice);
        if (res.size() == 0) {
            text.setText("No available recipe found");
        } else {
            text.setText(res.get(0).getInstruction());
        }
    }

    void back() {
        /*
           I'm calling MainActivity only because there is no class available for the Activity_main_output.
           Later it should return to it. However, if that's hard to implement, it's also ok to turn to mainactivity.

           I now changed it.
         */
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();
    }
}
