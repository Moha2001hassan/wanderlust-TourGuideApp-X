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

import com.rohit.examples.android.bhopaldarshan.Model.Shop;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.Utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    private final Context context;
    private List<Shop> shops;
    private List<Shop> shopsFull;

    public ShopAdapter(Context context, List<Shop> shops) {
        this.context = context;
        this.shops = shops;
        this.shopsFull = new ArrayList<>(shops);
    }


    @NotNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        return new ShopViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.x_card, viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NotNull final ShopViewHolder shopViewHolder, int position) {

        //Storing the stable ID for the item at position
        final Shop shop = shops.get(position);

        //Based on item position, storing the data accordingly
        shopViewHolder.shopImg.setImageResource(shop.getShopImageId());
        shopViewHolder.shopTitle.setText(shop.getShopTitle());
        //shopViewHolder.shopPlace.setText(shop.getShopPlace());
        shopViewHolder.shopRating.setText(String.valueOf(shop.getShopRating()));
        //shopViewHolder.shopRatingBar.setRating(shop.getShopRating());

        //Click Listener to open a detail intent, displaying more info about shops
        shopViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, shop, shopViewHolder.shopImg);
            }
        });
    }


    @Override
    public int getItemCount() {
        return shops.size();
    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder {

        // Variable declaration for views available on screen
        final ImageView shopImg;
        final TextView shopTitle;
        final TextView shopRating;
        final ConstraintLayout constraintLayout;
//        final RatingBar shopRatingBar;
//        final TextView shopPlace;
//        final CardView cardView;

        ShopViewHolder(@NotNull View itemView) {
            super(itemView);

            shopImg = itemView.findViewById(R.id.card_image);
            shopTitle = itemView.findViewById(R.id.card_name);
            //restoType = itemView.findViewById(R.id.card_type);
            shopRating = itemView.findViewById(R.id.rating_txt);
            constraintLayout = itemView.findViewById(R.id.parent_x);

//            shopImg = itemView.findViewById(R.id.shop_image);
//            shopTitle = itemView.findViewById(R.id.shop_name);
//            shopRating = itemView.findViewById(R.id.rating);
//            shopRatingBar = itemView.findViewById(R.id.ratingBar);
//            shopPlace = itemView.findViewById(R.id.shop_address);
//            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    public void setFilter(List<Shop> filterdNames) {
        this.shops = filterdNames;
        notifyDataSetChanged();
    }
}