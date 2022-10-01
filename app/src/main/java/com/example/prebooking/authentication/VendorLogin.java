package com.example.prebooking.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.prebooking.R;
import com.example.prebooking.databinding.ActivityLoginBinding;
import com.example.prebooking.databinding.ActivityVendorLoginBinding;

public class VendorLogin extends AppCompatActivity {

    ActivityVendorLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_vendor_login);
        binding = ActivityVendorLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

        binding.signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), VendorRegistration.class));
            }
        });

    }
}