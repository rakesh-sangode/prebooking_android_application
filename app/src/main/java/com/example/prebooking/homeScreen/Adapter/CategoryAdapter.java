package com.example.prebooking.homeScreen.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prebooking.R;
import com.example.prebooking.homeScreen.model.CategoryHelper;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    ArrayList<CategoryHelper> categoryLocation;

    public CategoryAdapter(ArrayList<CategoryHelper> categoryLocation) {
        this.categoryLocation = categoryLocation;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view,parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        CategoryHelper categoryHelper = categoryLocation.get(position);
        holder.image.setImageResource(categoryHelper.getImage());
        holder.title.setText(categoryHelper.getTitle());

    }

    @Override
    public int getItemCount() {
        return categoryLocation.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            // Hooks
            image = itemView.findViewById(R.id.categoryPic);
            title = itemView.findViewById(R.id.categoryName);
        }
    }


}
