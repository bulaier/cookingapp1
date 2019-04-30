package com.example.cookingapp;

import android.app.AppComponentFactory;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.cookingapp.lib.Search;
import com.example.cookingapp.lib.Testing;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cookingapp.lib.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
        String imageUrl;
        if (str == null) {
            str = "";
        }
        ArrayList<Recipe> res = Search.search(str);
        TextView text = findViewById(R.id.nice);
        if (res.size() == 0) {
            text.setText("No available recipe found");
            imageUrl = "";
        } else {
            text.setText(res.get(0).getInstruction());
            imageUrl = res.get(0).getImage().toString();
        }

        new DownloadImageTask((ImageView) findViewById(R.id.profile_image))
                .execute(imageUrl);


    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
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
