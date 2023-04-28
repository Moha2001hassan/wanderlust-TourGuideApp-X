package com.rohit.examples.android.bhopaldarshan.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rohit.examples.android.bhopaldarshan.Fragment.HotelFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.PlaceFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.ProfileFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.RestaurantFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.ShopFragment;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.databinding.ActivityBottomNavigationBinding;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    private ActivityBottomNavigationBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HotelFragment());


        binding.navView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.navigation_hotel:
                    replaceFragment(new HotelFragment());
                    break;
                case R.id.navigation_place:
                    replaceFragment(new PlaceFragment());
                    break;
                case R.id.navigation_restaurant:
                    replaceFragment(new RestaurantFragment());
                    break;
                case R.id.navigation_shopping:
                    replaceFragment(new ShopFragment());
                    break;
                case R.id.navigation_profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}