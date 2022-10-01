package com.example.prebooking.homeScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import com.example.prebooking.R;
import com.example.prebooking.homeScreen.Adapter.AllCategoryAdapter;
import com.example.prebooking.homeScreen.Adapter.CategoryAdapter;
import com.example.prebooking.homeScreen.model.AllCategoryHelper;
import com.example.prebooking.homeScreen.model.CategoryHelper;

import java.util.ArrayList;

public class AllCategories extends AppCompatActivity {

    ArrayList<AllCategoryHelper> allCategoryLocation = new ArrayList<>();
    RecyclerView allcategoryRecycler;
    AllCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);
        allcategoryRecycler = findViewById(R.id.recycler);

        allcategoryRecycler();
    }

    private void allcategoryRecycler() {

//        ***************************************************************
//                    All Category RecyclerView
//        ***************************************************************

        allcategoryRecycler.setHasFixedSize(true);
        allcategoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        allCategoryLocation.add(new AllCategoryHelper(R.drawable.booking, "Booking"));
        allCategoryLocation.add(new AllCategoryHelper(R.drawable.buying, "Shopping"));
        allCategoryLocation.add(new AllCategoryHelper(R.drawable.appoint, "Appointment"));
        allCategoryLocation.add(new AllCategoryHelper(R.drawable.logo, "My Logo"));
        allCategoryLocation.add(new AllCategoryHelper(R.drawable.profile, "My Profile"));
        allCategoryLocation.add(new AllCategoryHelper(R.drawable.myphoto, "My Photo"));

        getActionBar().setTitle("Categories");

        adapter = new AllCategoryAdapter(allCategoryLocation);
        allcategoryRecycler.setAdapter(adapter);



    }

}