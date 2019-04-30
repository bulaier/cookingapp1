package com.example.cookingapp;

import android.app.AppComponentFactory;
import android.os.Bundle;

import com.example.cookingapp.lib.Testing;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.cookingapp.lib.Recipe;

public final class ShowList extends AppCompatActivity {
    private static final String TAG = "cookingApp:ShowList";

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_output);
        setTitle("showing the list");

        findViewById(R.id.backList).setOnClickListener(v -> back());
    }

    void back() {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();
    }
}
