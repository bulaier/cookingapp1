package com.example.cookingapp;

import android.app.AppComponentFactory;
import android.os.Bundle;

import com.example.cookingapp.lib.Search;
import com.example.cookingapp.lib.Testing;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.cookingapp.lib.Recipe;

import java.net.URL;
import java.util.ArrayList;

public final class ShowList extends AppCompatActivity {
    private static final String TAG = "cookingApp:ShowList";

    // The three ArrayLists you are going to use.
    /**
     *  Returns a list a recipes in ArrayList<Recipe>.
     * @param s the string the user enters.
     * @return as I said above.
     */
    private ArrayList<Recipe> recipes(final String s) {
        return Search.search(s);
    }
    /**
     *  returns a list of titles of the recipe. Helps you to modify recyclerView.
     * @param recipes the result from the above method "ingredients".
     * @return as I said above.
     */
    private ArrayList<String> titles(final ArrayList<Recipe> recipes) {
        return Search.getTitles(recipes);
    }

    /**
     *  it gives you the URLs of the pictures
     * @param recipes the recipes
     * @return as I said above.
     */
    private ArrayList<URL> urls(final ArrayList<Recipe> recipes) {
        return Search.getImages(recipes);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRecyclerView();
        setContentView(R.layout.activity_main_output);
        setTitle("showing the list");

        findViewById(R.id.backList).setOnClickListener(v -> back());
    }
    Intent intent = getIntent();
    String string = intent.getStringExtra("input");
    ArrayList<Recipe> res = recipes(string);
    private ArrayList<String> mNames = titles(res);
    private ArrayList<URL> mImageUrls = urls(res);
    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.newView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void back() {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();
    }
}
