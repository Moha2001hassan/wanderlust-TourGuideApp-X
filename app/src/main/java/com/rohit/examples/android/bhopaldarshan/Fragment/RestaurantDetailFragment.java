package com.rohit.examples.android.bhopaldarshan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.rohit.examples.android.bhopaldarshan.Model.Restaurant;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.Utils.Utils;

import static com.rohit.examples.android.bhopaldarshan.Activity.DetailActivity.INTENT_EXTRA;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RestaurantDetailFragment extends Fragment implements View.OnClickListener {

    private Restaurant restaurant;


    public static RestaurantDetailFragment newInstance(Restaurant restaurant) {
        RestaurantDetailFragment fragment = new RestaurantDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(INTENT_EXTRA, restaurant);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Restaurant restaurant = (Restaurant) getArguments().getSerializable(INTENT_EXTRA);
            if (restaurant != null) {
                this.restaurant = restaurant;
            }
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_restaurant_fg_detail, container, false);
    }


    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Fetching view IDs for elements from resource
        ImageView restoImg = view.findViewById(R.id.restaurant_image);
        TextView restoTitle = view.findViewById(R.id.title);
        TextView restoRating = view.findViewById(R.id.rating);
        //RatingBar restoRatingBar = view.findViewById(R.id.ratingBar);
        TextView restoDirections = view.findViewById(R.id.directions);
        TextView restoPhone = view.findViewById(R.id.phone);
        TextView restoHours = view.findViewById(R.id.hours);

        //Toolbar toolbar = view.findViewById(R.id.toolbar);

        //Utils.setUpToolbar(getActivity(), toolbar, restaurant.getRestaurantTitle());

        restoPhone.setOnClickListener(this);
        restoDirections.setOnClickListener(this);


        restoImg.setImageResource(restaurant.getRestaurantImageId());
        restoTitle.setText(restaurant.getRestaurantTitle());
        restoRating.setText(String.valueOf(restaurant.getRestaurantRating()));
        //restoRatingBar.setRating(restaurant.getRestaurantRating());
        restoPhone.setText(restaurant.getRestaurantPhone());
        restoHours.setText(restaurant.getRestaurantTime());
        restoDirections.setText(restaurant.getRestaurantLocation());
    }

    @Override
    public void onClick(View view) {
        if (getContext() != null) {
            switch (view.getId()) {
                case R.id.directions:
                    Utils.directionsIntent(getContext(), restaurant.getRestaurantLocation());
                    break;
                case R.id.phone:
                    Utils.phoneIntent(getContext(), restaurant.getRestaurantPhone());
                    break;
            }
        }
    }
}