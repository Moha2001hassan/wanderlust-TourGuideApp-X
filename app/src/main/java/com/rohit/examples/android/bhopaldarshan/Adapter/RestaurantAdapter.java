package com.rohit.examples.android.bhopaldarshan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohit.examples.android.bhopaldarshan.Model.Place;
import com.rohit.examples.android.bhopaldarshan.Model.Restaurant;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.Utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private final Context context;
    private List<Restaurant> restaurants;

    public RestaurantAdapter(Context context, List<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }


    @NotNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        return new RestaurantViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.x_card, viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NotNull final RestaurantViewHolder restaurantViewHolder, int position) {

        final Restaurant restaurant = restaurants.get(position);

        restaurantViewHolder.restoImg.setImageResource(restaurant.getRestaurantImageId());
        restaurantViewHolder.restoTitle.setText(restaurant.getRestaurantTitle());
        restaurantViewHolder.restoType.setText(restaurant.getRestaurantType());
        restaurantViewHolder.restoRating.setText(String.valueOf(restaurant.getRestaurantRating()));

        restaurantViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, restaurant, restaurantViewHolder.restoImg);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {

        final ImageView restoImg;
        final TextView restoTitle;
        final TextView restoType;
        final TextView restoRating;
        final ConstraintLayout constraintLayout;

        RestaurantViewHolder(@NotNull View itemView) {
            super(itemView);

            restoImg = itemView.findViewById(R.id.card_image);
            restoTitle = itemView.findViewById(R.id.card_name);
            restoType = itemView.findViewById(R.id.card_type);
            restoRating = itemView.findViewById(R.id.rating_txt);
            constraintLayout = itemView.findViewById(R.id.parent_x);
        }
    }

    public void setFilter(List<Restaurant> filterdNames) {
        this.restaurants = filterdNames;
        notifyDataSetChanged();
    }
}