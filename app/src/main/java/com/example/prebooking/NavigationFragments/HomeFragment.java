package com.example.prebooking.NavigationFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.prebooking.homeScreen.Booking;
import com.example.prebooking.homeScreen.ProfileActivity;
import com.example.prebooking.R;
import com.example.prebooking.homeScreen.Adapter.FeaturedAdapter;
import com.example.prebooking.homeScreen.RecyclerItemClickListener;
import com.example.prebooking.homeScreen.Shopping;
import com.example.prebooking.homeScreen.model.CategoryHelper;
import com.example.prebooking.homeScreen.Adapter.RecommendAdapter;
import com.example.prebooking.homeScreen.model.FeaturedHelper;
import com.example.prebooking.homeScreen.model.RecommendHelper;
import com.example.prebooking.imageSlider.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Image Slider Variables
    SliderView sliderView;
    int[] images = {R.drawable.bg1, R.drawable.bg2, R.drawable.bg3};

    ArrayList<CategoryHelper> categoryLocation = new ArrayList<>();
    ArrayList<RecommendHelper> recommendLocation = new ArrayList<>();
    ArrayList<FeaturedHelper> featuredLocation = new ArrayList<>();

    // Category RecyclerView Variables
    RecyclerView categoryRecycler, recommendRecycler, featuredRecycler;
//    CategoryAdapter adapter;
    RecommendAdapter adapter2;
    FeaturedAdapter adapter3;
    Button book;
    LinearLayout linearLayout, bookingBtn, shoppingBtn;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        categoryRecycler = view.findViewById(R.id.view1);
        recommendRecycler = view.findViewById(R.id.view2);
        featuredRecycler = view.findViewById(R.id.view3);

        bookingBtn = view.findViewById(R.id.booking_btn);
        shoppingBtn = view.findViewById(R.id.shopping_btn);
        linearLayout = view.findViewById(R.id.linear2);

        book = view.findViewById(R.id.book);

        bookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Booking.class));
            }
        });

        shoppingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Shopping.class));
            }
        });

//        ****************************************************************
//                           Auto Image Slider
//        ****************************************************************

        sliderView = view.findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.startAutoCycle();

//        categoryRecycler();
        recommendRecycler();
        featuredRecycler();

        return view;

    }

//    private void categoryRecycler() {
//
////        ***************************************************************
////                         Category RecyclerView
////        ***************************************************************
//
//        categoryRecycler.setHasFixedSize(true);
//        categoryRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        categoryLocation.add(new CategoryHelper(R.drawable.booking, "Booking"));
//        categoryLocation.add(new CategoryHelper(R.drawable.buying, "Shopping"));
//        categoryLocation.add(new CategoryHelper(R.drawable.appoint, "Appointment"));
//        categoryLocation.add(new CategoryHelper(R.drawable.logo, "My Logo"));
//        categoryLocation.add(new CategoryHelper(R.drawable.profile, "My Profile"));
//        categoryLocation.add(new CategoryHelper(R.drawable.myphoto, "My Photo"));
//
//        adapter = new CategoryAdapter(categoryLocation);
//        categoryRecycler.setAdapter(adapter);
//    }

    private void recommendRecycler() {
//        ***************************************************************
//                         Recommended RecyclerView
//        ***************************************************************

        recommendRecycler.setHasFixedSize(true);
        recommendRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recommendLocation.add(new RecommendHelper(R.drawable.watch, "Watch", "799 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.i2, "Headphone", "1,299 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.i3, "Black Shoes", "1,399 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.i4, "Shoes", "4,999 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.i5, "Apple Watch", "20,999 Rs"));
        recommendLocation.add(new RecommendHelper(R.drawable.laptop2, "Lenovo IdeaPad 3", "58,999 Rs"));

        adapter2 = new RecommendAdapter(recommendLocation, getContext());
        recommendRecycler.setAdapter(adapter2);

//        recommendRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recommendRecycler, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//
//            }
//        }));

    }

    private void featuredRecycler() {

//        ***************************************************************
//                         Recommended RecyclerView
//        ***************************************************************

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        featuredLocation.add(new FeaturedHelper(R.drawable.watch, "Watch", "799 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.i2, "Headphone", "1,299 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.i3, "Black Shoes", "1,399 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.i4, "Shoes", "4,999 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.i5, "Apple Watch", "20,999 Rs"));
        featuredLocation.add(new FeaturedHelper(R.drawable.laptop1, "HP 15", "59,999 Rs"));

        adapter3 = new FeaturedAdapter(featuredLocation);
        featuredRecycler.setAdapter(adapter3);
    }

}