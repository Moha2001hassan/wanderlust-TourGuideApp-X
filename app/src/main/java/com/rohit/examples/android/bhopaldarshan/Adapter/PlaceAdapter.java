package com.rohit.examples.android.bhopaldarshan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohit.examples.android.bhopaldarshan.Model.Place;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.Utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlacesViewHolder> {

    private List<Place> places;
    private final Context context;

    public PlaceAdapter(List<Place> places, Context context) {
        this.places = places;
        this.context = context;
    }

    @NotNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        return new PlacesViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.x_card, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NotNull final PlaceAdapter.PlacesViewHolder placesViewHolder, int position) {

        final Place place = places.get(position);

        placesViewHolder.placeTitle.setText(place.getPlaceTitle());
        placesViewHolder.placeImg.setImageResource(place.getPlaceImageId());
        placesViewHolder.placeRating.setText(String.valueOf(place.getPlaceRating()));
        placesViewHolder.placeType.setText(place.getPlaceType());


        placesViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, place, placesViewHolder.placeImg);
            }
        });
    }


    @Override
    public int getItemCount() {
        return places.size();
    }

    public static class PlacesViewHolder extends RecyclerView.ViewHolder {


        final ImageView placeImg;
        final TextView placeTitle;
        final TextView placeType;
        final TextView placeRating;
        final ConstraintLayout constraintLayout;

        PlacesViewHolder(@NotNull View itemView) {
            super(itemView);

            placeImg = itemView.findViewById(R.id.card_image);
            placeTitle = itemView.findViewById(R.id.card_name);
            placeType = itemView.findViewById(R.id.card_type);
            placeRating = itemView.findViewById(R.id.rating_txt);
            constraintLayout = itemView.findViewById(R.id.parent_x);
        }
    }

    public void setFilter(List<Place> filterdNames) {
        this.places = filterdNames;
        notifyDataSetChanged();
    }
}