package com.example.prebooking.homeScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

public class Shopping extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        categoryRecycler = findViewById(R.id.view1);
        recommendRecycler = findViewById(R.id.view2);
        featuredRecycler = findViewById(R.id.view3);

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
        categoryLocation.add(new CategoryHelper(R.drawable.electronics, "Electronic"));
        categoryLocation.add(new CategoryHelper(R.drawable.cloths, "Fashion"));
        categoryLocation.add(new CategoryHelper(R.drawable.book, "Books"));
        categoryLocation.add(new CategoryHelper(R.drawable.groceries, "Grocery"));
        categoryLocation.add(new CategoryHelper(R.drawable.chef, "Kitchen"));
        categoryLocation.add(new CategoryHelper(R.drawable.toys, "Toys"));

        adapter = new CategoryAdapter(categoryLocation);
        categoryRecycler.setAdapter(adapter);
    }

    private void recommendRecycler() {
//        ***************************************************************
//                         Recommended RecyclerView
//        ***************************************************************

        recommendRecycler.setHasFixedSize(true);
        recommendRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recommendLocation.add(new RecommendHelper(R.drawable.laptop1, "HP 15", "41,990 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.laptop2, "Lenovo IdeaPad 3", "60,990 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.book1, "Rich Dad Poor Dad", "172 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.mobile1, "OnePlus Nord 2", "29,999 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.earphone1, "boAt Airdopes", "1,299 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.echo, "Echo Dot 4", "3,899 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.watch2, "Noise ColorFit Pro", "2,799 Rs"));

        adapter2 = new RecommendAdapter(recommendLocation, getApplicationContext());
        recommendRecycler.setAdapter(adapter2);
    }

    private void featuredRecycler() {

//        ***************************************************************
//                         Recommended RecyclerView
//        ***************************************************************

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        featuredLocation.add(new FeaturedHelper(R.drawable.i4, "Nike Shoes", "2,094 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.shoes1, "Puma Men's Loop ", "1,247 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.shirt, "Dennis Lingo Shirt", "459 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.pant, "END3R Trackpants", "499 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.tv, "Redmi Smart TV", "14,998 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.game, "Redgear Gamepad", "1,699 Rs"));

        adapter3 = new FeaturedAdapter(featuredLocation);
        featuredRecycler.setAdapter(adapter3);
    }

}
