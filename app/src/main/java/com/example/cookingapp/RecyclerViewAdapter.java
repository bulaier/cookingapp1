package com.example.cookingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> imageNames, ArrayList<String> images, Context context) {
        mImageNames = imageNames;
        mImages = images;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mealName;
        ImageView mealPic;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mealPic = itemView.findViewById(R.id.imageView1);
            mealName = itemView.findViewById(R.id.dishName);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
