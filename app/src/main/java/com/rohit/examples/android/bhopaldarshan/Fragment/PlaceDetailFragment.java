package com.rohit.examples.android.bhopaldarshan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rohit.examples.android.bhopaldarshan.Model.Place;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.Utils.Utils;

import static com.rohit.examples.android.bhopaldarshan.Activity.DetailActivity.INTENT_EXTRA;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlaceDetailFragment extends Fragment implements View.OnClickListener {

    private Place place;


    public static PlaceDetailFragment newInstance(Place place) {
        PlaceDetailFragment placeDetailFragment = new PlaceDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(INTENT_EXTRA, place);
        placeDetailFragment.setArguments(bundle);
        return placeDetailFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Place place = (Place) getArguments().getSerializable(INTENT_EXTRA);
            if (place != null) {
                this.place = place;
            }
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_place_fg_detail, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Fetching view IDs for elements from resource
        ImageView placeImg = view.findViewById(R.id.shop_Image);
        TextView placeTitle = view.findViewById(R.id.title);
        TextView placeRating = view.findViewById(R.id.rating);
        //RatingBar placeRatingBar = view.findViewById(R.id.ratingBar);
        TextView placePhone = view.findViewById(R.id.phone);
        TextView placeHours = view.findViewById(R.id.hours);
        TextView placeDirections = view.findViewById(R.id.directions);
        //Toolbar toolbar = view.findViewById(R.id.toolbar);


        //Utils.setUpToolbar(getActivity(), toolbar, place.getPlaceTitle());


        placePhone.setOnClickListener(this);
        placeDirections.setOnClickListener(this);


        placeImg.setImageResource(place.getPlaceImageId());
        placeTitle.setText(place.getPlaceTitle());
        placePhone.setText(place.getPlacePhone());
        placeHours.setText(place.getPlaceTime());
        placeRating.setText(place.getPlaceRating());
        //placeRatingBar.setRating(place.getPlaceRating());
        placeDirections.setText(place.getPlaceLocation());
    }



    @Override
    public void onClick(View view) {
        if (getContext() != null) {
            switch (view.getId()) {
                case R.id.phone:
                    Utils.phoneIntent(getContext(), place.getPlacePhone());
                    break;
                case R.id.directions:
                    Utils.directionsIntent(getContext(), place.getPlaceLocation());
                    break;
            }
        }
    }
}