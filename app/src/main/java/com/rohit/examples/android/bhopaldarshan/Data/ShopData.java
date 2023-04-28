package com.rohit.examples.android.bhopaldarshan.Data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.rohit.examples.android.bhopaldarshan.Model.Shop;
import com.rohit.examples.android.bhopaldarshan.R;

import java.util.ArrayList;

public class ShopData {

    //Method to fetch values from resources bundle
    public  ArrayList<Shop> fetchShopData(Context context) {

        ArrayList<Shop> shops = new ArrayList<>();
        Resources resources = context.getResources();

        //Logic to fetch and store Shops Drawable
        TypedArray typedArray = resources.obtainTypedArray(R.array.shopImgId);
        int[] shopImgId = new int[typedArray.length()];
        for (int index = 0; index < shopImgId.length; index++) {
            shopImgId[index] = typedArray.getResourceId(index, 0);
        }

        typedArray.recycle();

        String[] name = resources.getStringArray(R.array.shopName);
        String[] rating = resources.getStringArray(R.array.shopRating);
        String[] place = resources.getStringArray(R.array.shopPlace);
        String[] time = resources.getStringArray(R.array.shopTime);
        String[] phone = resources.getStringArray(R.array.shopPhone);
        String[] address = resources.getStringArray(R.array.shopAddress);

        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < shopImgId.length; i++) {
            Shop shop = new Shop(shopImgId[i], name[i],
                    rating[i], phone[i], place[i], time[i], address[i]);
            shops.add(shop);
        }
        return shops;
    }
}