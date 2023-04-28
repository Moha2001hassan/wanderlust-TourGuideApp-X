package com.rohit.examples.android.bhopaldarshan.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.rohit.examples.android.bhopaldarshan.Fragment.HotelDetailFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.PlaceDetailFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.RestaurantDetailFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.ShopDetailFragment;
import com.rohit.examples.android.bhopaldarshan.Model.Hotel;
import com.rohit.examples.android.bhopaldarshan.Model.Place;
import com.rohit.examples.android.bhopaldarshan.Model.Restaurant;
import com.rohit.examples.android.bhopaldarshan.Model.Shop;
import com.rohit.examples.android.bhopaldarshan.R;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA = "extras";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Object object = getIntent().getSerializableExtra(INTENT_EXTRA);
        Fragment fragment = null;

        //Verifying object type obtained from intent and instantiating fragments accordingly
        if (object instanceof Hotel) {
            fragment = HotelDetailFragment.newInstance((Hotel) object);
        } else if (object instanceof Place) {
            fragment = PlaceDetailFragment.newInstance((Place) object);
        } else if (object instanceof Shop) {
            fragment = ShopDetailFragment.newInstance((Shop) object);
        } else if (object instanceof Restaurant) {
            fragment = RestaurantDetailFragment.newInstance((Restaurant) object);
        }

        //Using fragment manager that creates a transaction to replace the container with required fragment
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}