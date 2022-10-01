package com.example.prebooking.homeScreen.Adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prebooking.BookingDetails;
import com.example.prebooking.R;
import com.example.prebooking.homeScreen.model.RecommendHelper;

import java.util.ArrayList;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder> {

    ArrayList<RecommendHelper> recommendLocation;
    Context context;

    public RecommendAdapter(ArrayList<RecommendHelper> recommendLocation, Context context) {
        this.recommendLocation = recommendLocation;
        this.context = context;
    }

    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_card_items,parent, false);
        RecommendViewHolder recommendViewHolder = new RecommendViewHolder(view);
        return recommendViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendViewHolder holder, int position) {
        RecommendHelper recommendHelper = recommendLocation.get(position);
        holder.image.setImageResource(recommendHelper.getImage());
        holder.title.setText(recommendHelper.getTitle());
        holder.price.setText(recommendHelper.getPrice());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookingDetails.class);
                intent.putExtra("image", recommendHelper.getImage());
                intent.putExtra("heading", recommendHelper.getTitle());
                intent.putExtra("price", recommendHelper.getPrice());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recommendLocation.size();
    }

    public static class RecommendViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, price;

        public RecommendViewHolder(@NonNull View itemView) {
            super(itemView);

            // Hooks
            image = itemView.findViewById(R.id.item_image);
            title = itemView.findViewById(R.id.item_heading);
            price = itemView.findViewById(R.id.item_price);
        }
    }


}
