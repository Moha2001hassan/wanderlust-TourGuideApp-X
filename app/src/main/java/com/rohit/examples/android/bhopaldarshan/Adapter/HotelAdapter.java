package com.rohit.examples.android.bhopaldarshan.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohit.examples.android.bhopaldarshan.Model.Hotel;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.Utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private List<Hotel> hotels;
//    private List<Hotel> hotelsFull;
    private final Context context;

    public HotelAdapter(List<Hotel> hotels, Context context) {
        this.hotels = hotels;
//        this.hotelsFull = new ArrayList<>(hotels);
        this.context = context;
    }

    @NotNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        return new HotelViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.x_card, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NotNull final HotelAdapter.HotelViewHolder hotelViewHolder, int position) {
        //Storing the stable ID for the item at position
        final Hotel hotel = hotels.get(position);

        hotelViewHolder.hotelImage.setImageResource(hotel.getHotelImageId());
        hotelViewHolder.hotelTitle.setText(hotel.getHotelTitle());
        hotelViewHolder.hotelRating.setText(String.valueOf(hotel.getHotelRating()));
        hotelViewHolder.hotelType.setText(hotel.getHotelType());

        hotelViewHolder.constraintLayout.setOnClickListener(view ->
                Utils.detailIntent(context, hotel, hotelViewHolder.hotelImage));
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }


    public static class HotelViewHolder extends RecyclerView.ViewHolder {

        final ImageView hotelImage;
        final TextView hotelTitle;
        final TextView hotelRating;
        final TextView hotelType;

        final ConstraintLayout constraintLayout;

        HotelViewHolder(@NotNull View itemView) {
            super(itemView);

            hotelImage = itemView.findViewById(R.id.card_image);
            hotelTitle = itemView.findViewById(R.id.card_name);
            hotelType = itemView.findViewById(R.id.card_type);
            hotelRating = itemView.findViewById(R.id.rating_txt);
            constraintLayout = itemView.findViewById(R.id.parent_x);

        }
    }

    public void setFilter(List<Hotel> filterdNames) {
        this.hotels = filterdNames;
        notifyDataSetChanged();
    }

}