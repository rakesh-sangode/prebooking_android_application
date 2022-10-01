package com.example.prebooking.homeScreen.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prebooking.R;
import com.example.prebooking.homeScreen.model.AllCategoryHelper;

import java.util.ArrayList;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder> {

    ArrayList<AllCategoryHelper> allCategoryLocation;

    public AllCategoryAdapter(ArrayList<AllCategoryHelper> allCategoryLocation) {
        this.allCategoryLocation = allCategoryLocation;
    }

    @NonNull
    @Override
    public AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_rows_items,parent, false);
        AllCategoryViewHolder allCategoryViewHolder = new AllCategoryViewHolder(view);
        return allCategoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHolder holder, int position) {

        AllCategoryHelper allCategoryHelper = allCategoryLocation.get(position);
        holder.image.setImageResource(allCategoryHelper.getImage());
        holder.title.setText(allCategoryHelper.getTitle());

    }

    @Override
    public int getItemCount() {
        return allCategoryLocation.size();
    }

    public static class AllCategoryViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;

        public AllCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            // Hooks
            image = itemView.findViewById(R.id.all_category_image);
            title = itemView.findViewById(R.id.all_category_heading);
        }
    }


}
