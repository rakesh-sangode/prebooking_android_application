package com.example.prebooking.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.prebooking.R;
import com.example.prebooking.homeScreen.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginStartUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth mAuth;

        setContentView(R.layout.activity_login_start_up);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    public void loginButton(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        Pair [] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.login_button), "transition_login");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginStartUp.this, pairs);
        startActivity(intent, options.toBundle());
        savePrefsData();
        finish();

    }



    public void signupButton(View view) {
        Intent intent = new Intent(getApplicationContext(), Registration.class);
        Pair [] pair1 = new Pair[1];

        pair1[0] = new Pair<View, String>(findViewById(R.id.signup_button), "transition_sign_up");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginStartUp.this, pair1);
        startActivity(intent, options.toBundle());
        savePrefsData();
        finish();

    }

    private boolean restorePrefData() {


        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend",false);
        return  isIntroActivityOpnendBefore;



    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();


    }
}