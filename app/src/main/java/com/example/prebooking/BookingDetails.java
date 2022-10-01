package com.example.prebooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.prebooking.databinding.ActivityBookingDetailsBinding;

public class BookingDetails extends AppCompatActivity {
    ActivityBookingDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_booking_details);

        // Binding
        binding = ActivityBookingDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().setTitle("Booking Details");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.itemImage.setImageResource(getIntent().getIntExtra("image",0));
        binding.itemHeading.setText(getIntent().getStringExtra("heading"));
        binding.itemPrice.setText(getIntent().getStringExtra("price"));

        binding.bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = binding.itemPrice.getText().toString();
                Intent intent = new Intent(BookingDetails.this, ConfirmBooking.class);
                intent.putExtra("price", price);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}