package com.example.prebooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.prebooking.databinding.ActivityConfirmBookingBinding;

public class ConfirmBooking extends AppCompatActivity {
    ActivityConfirmBookingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_confirm_booking);
//        getSupportActionBar().setTitle("Confirm Booking");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        // Binding
        binding = ActivityConfirmBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.itemPrice.setText(getIntent().getStringExtra("price"));
        binding.itemPrice1.setText(getIntent().getStringExtra("price"));
        binding.itemPrice2.setText(getIntent().getStringExtra("price"));

        binding.confirmBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmBooking.this, BookingSuccessful.class));
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}