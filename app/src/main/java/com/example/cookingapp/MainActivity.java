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



    void proceed() {
        Intent intent = new Intent(this, ShowList.class);

        intent.putExtra("input", getTextIn(R.id.input));
    }
}
