package com.example.cookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.net.URL;
import java.util.ArrayList;
import com.example.cookingapp.lib.Recipe;
import com.example.cookingapp.lib.Search;
import com.example.cookingapp.lib.Testing;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("the first view");
        findViewById(R.id.goButton).setOnClickListener(v -> proceed());
        findViewById(R.id.createNewList).setOnClickListener(v -> empty());
    }

    String getTextIn() {
        return ((EditText) findViewById(R.id.input)).getText().toString();
    }
    void proceed() {
        Intent intent = new Intent(this, ShowList.class);
        intent.putExtra("input", getTextIn());
        startActivity(intent);
        System.out.println("finished intent");
        finish();
    }
    void empty() {
        EditText edit = findViewById(R.id.input);
        edit.setText("");
    }
}
