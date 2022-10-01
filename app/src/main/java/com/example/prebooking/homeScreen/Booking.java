package com.example.prebooking.homeScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.prebooking.R;
import com.example.prebooking.homeScreen.Adapter.CategoryAdapter;
import com.example.prebooking.homeScreen.Adapter.FeaturedAdapter;
import com.example.prebooking.homeScreen.Adapter.RecommendAdapter;
import com.example.prebooking.homeScreen.model.CategoryHelper;
import com.example.prebooking.homeScreen.model.FeaturedHelper;
import com.example.prebooking.homeScreen.model.RecommendHelper;
import com.example.prebooking.imageSlider.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class Booking extends AppCompatActivity {

    // Image Slider Variables
    SliderView sliderView;
    int[] images = {R.drawable.bg1, R.drawable.bg2, R.drawable.bg3};

    ArrayList<CategoryHelper> categoryLocation = new ArrayList<>();
    ArrayList<RecommendHelper> recommendLocation = new ArrayList<>();
    ArrayList<FeaturedHelper> featuredLocation = new ArrayList<>();

    // Category RecyclerView Variables
    RecyclerView categoryRecycler, recommendRecycler, featuredRecycler;
    CategoryAdapter adapter;
    RecommendAdapter adapter2;
    FeaturedAdapter adapter3;

    TextView catViewAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);


        categoryRecycler = findViewById(R.id.view1);
        recommendRecycler = findViewById(R.id.view2);
        featuredRecycler = findViewById(R.id.view3);
        catViewAll = findViewById(R.id.cat_view_all);

        catViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
            }
        });

//        ****************************************************************
//                           Auto Image Slider
//        ****************************************************************

        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.startAutoCycle();


        categoryRecycler();
        recommendRecycler();
        featuredRecycler();

    }

    private void categoryRecycler() {
//        ***************************************************************
//                         Category RecyclerView
//        ***************************************************************

        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        categoryLocation.add(new CategoryHelper(R.drawable.hotel, "Hotels"));
        categoryLocation.add(new CategoryHelper(R.drawable.restaurant, "Restaurant"));
        categoryLocation.add(new CategoryHelper(R.drawable.plane, "Flights"));
        categoryLocation.add(new CategoryHelper(R.drawable.taxi, "Taxi"));
        categoryLocation.add(new CategoryHelper(R.drawable.train, "Trains"));
        categoryLocation.add(new CategoryHelper(R.drawable.bus, "Bus"));
        categoryLocation.add(new CategoryHelper(R.drawable.ticket, "Movies"));

        adapter = new CategoryAdapter(categoryLocation);
        categoryRecycler.setAdapter(adapter);
    }

    private void recommendRecycler() {
//        ***************************************************************
//                         Recommended RecyclerView
//        ***************************************************************

        recommendRecycler.setHasFixedSize(true);
        recommendRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recommendLocation.add(new RecommendHelper(R.drawable.hotel1, "Anand Mahal Hotel ", "2,246 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.hotel2, "Hotel Darshan", "1,397 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.hotel3, "Raj Mahal Hotel", "2,198 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.res1, "Barbeque Restaurant", "99 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.res2, "Ashoka Restaurant", "35 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.res3, "Café Illusions", "25 Rs"));

        adapter2 = new RecommendAdapter(recommendLocation, getApplicationContext());
        recommendRecycler.setAdapter(adapter2);
    }

    private void featuredRecycler() {

//        ***************************************************************
//                         Recommended RecyclerView
//        ***************************************************************

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false));
        featuredLocation.add(new FeaturedHelper(R.drawable.hotel4, "Hotel Highway Break", "1,499 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.hotel6, "Hotel Kamal", "900 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.hotel5, "Hotel President", "2,433 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.hotel7, "Sai Guest House", "1,244 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.hotel8, "Hotel Sonali", "1,311 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.hotel9, "Ashoka Imperial", "1,976 Rs"));

        adapter3 = new FeaturedAdapter(featuredLocation);
        featuredRecycler.setAdapter(adapter3);
    }
    }
