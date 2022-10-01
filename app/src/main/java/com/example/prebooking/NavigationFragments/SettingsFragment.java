package com.example.prebooking.NavigationFragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.prebooking.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}