package com.example.cookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.net.URL;
import java.util.ArrayList;
import com.example.cookingapp.lib.Recipe;
import com.example.cookingapp.lib.Search;
import com.example.cookingapp.lib.Testing;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        initRecyclerView();

        findViewById(R.id.goButton).setOnClickListener(v -> proceed());
    }

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

    private ArrayList<URL> urls(final ArrayList<Recipe> recipes) {
        return Search.getImages(recipes);
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.newView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mImageUrls, mNames, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void proceed() {
        Intent intent = new Intent(this, ShowList.class);

    }
}
