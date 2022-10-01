package com.example.prebooking.homeScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.prebooking.NavigationFragments.AccountFragment;
import com.example.prebooking.NavigationFragments.HomeFragment;
import com.example.prebooking.NavigationFragments.SettingsFragment;
import com.example.prebooking.R;
import com.example.prebooking.authentication.Login;
import com.example.prebooking.authentication.LoginStartUp;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth mAuth;
    MeowBottomNavigation bottomNavigation;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout contentView;
    Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;
    static final float END_SCALE = 0.7f;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        loadFragments(new HomeFragment());



        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new HomeFragment()).commit();


//        // Binding
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

//        ***************************************************************
//                   Bottom Navigation Bar
//        ***************************************************************
//
//        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
//        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
//        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_booking_24));
//        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_buying_24));
//        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_appointment_24));
//        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_baseline_account_circle_24));
//
//
//        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
//            @Override
//            public void onShowItem(MeowBottomNavigation.Model item) {
//                switch (item.getId()) {
//                    case 1:
//                        loadFragments(new HomeFragment());
//                        break;
//
//                    case 2:
//                        loadFragments(new BookingFragment());
//                        break;
//
//                    case 3:
//                        loadFragments(new ShoppingFragment());
//                        break;
//
//                    case 4:
//                        loadFragments(new SettingsFragment());
//                        break;
//
//                    case 5:
//                        loadFragments(new AccountFragment());
//                        break;
//
//                }
//
//            }
//        });
//
//
//        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
//            @Override
//            public void onClickItem(MeowBottomNavigation.Model item) {
//                switch (item.getId()) {
//                    case 1:
//                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
//                        break;
//
//                    case 2:
//                        Toast.makeText(MainActivity.this, "Booking", Toast.LENGTH_SHORT).show();
//                        break;
//
//                    case 3:
//                        Toast.makeText(MainActivity.this, "Shopping", Toast.LENGTH_SHORT).show();
//                        break;
//
//                    case 4:
//                        Toast.makeText(MainActivity.this, "Appointment", Toast.LENGTH_SHORT).show();
//                        break;
//
//                    case 5:
//                        Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
//                        break;
//
//                }
//
//            }
//        });
//
//        bottomNavigation.setCount(5, "5");
//        bottomNavigation.show(1, true);

//        **************************************************************
//                       Navigation Drawer
//        **************************************************************

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        contentView = findViewById(R.id.content);
//        menuIcon = findViewById(R.id.menu_icon);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.action_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        naviagtionDrawer();

        mAuth = FirebaseAuth.getInstance();

    }

    private void naviagtionDrawer() {

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.setCheckedItem(R.id.nav_home);



//        menuIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (drawerLayout.isDrawerVisible(GravityCompat.START))
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                else drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });


    }


    public void onBackPressed() {
//            new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.ic_baseline_warning_24)
//                    .setTitle(R.string.exit).setMessage(R.string.exit_dialog)
//                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            finish();
//                        }
//                    }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            }).setNeutralButton(R.string.help, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Toast.makeText(MainActivity.this, "Press yes to exit this app", Toast.LENGTH_SHORT).show();
//                }
//            }).show();

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                loadFragments(new HomeFragment());

                break;

            case R.id.nav_categories:
                startActivity(new Intent(this, AllCategories.class));
                break;

            case R.id.nav_booking:
                Toast.makeText(MainActivity.this, "Booking Activity", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_buying:
                Toast.makeText(MainActivity.this, "Buying Activity", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_appointment:
                Toast.makeText(MainActivity.this, "Appointment Activity", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_account:
                loadFragments(new AccountFragment());
                break;

            case R.id.nav_setting:
                loadFragments(new SettingsFragment());
                break;

            case R.id.nav_help:
                Intent intent1 = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent1);
                break;

            case R.id.nav_privacy:
                Toast.makeText(MainActivity.this, "Privacy Policy Activity", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_terms:
                Toast.makeText(MainActivity.this, "Terms and Condition Activity", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:

                Intent intent = new Intent(getApplicationContext(), LoginStartUp.class);
                startActivity(intent);
                mAuth.signOut();
                finish();
                break;
        }
//        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, fragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadFragments(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, fragment).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.searchIcon) {
            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.notifiIcon) {
            Toast.makeText(getApplicationContext(), "Notification", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cartIcon) {
            Toast.makeText(getApplicationContext(), "Cart", Toast.LENGTH_SHORT).show();

        return true;
    }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_icon,menu);
        return true;
    }


}
