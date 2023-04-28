package com.rohit.examples.android.bhopaldarshan.Model;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private final int restaurantImageId;
    private final String restaurantTitle;
    private final String restaurantRating;
    private final String restaurantType;
    private final String restaurantPhone;
    private final String restaurantTime;
    private final String restaurantLocation;

    public Restaurant(int imageId, String title, String rating, String type, String phone, String time, String location) {
        this.restaurantImageId = imageId;
        this.restaurantTitle = title;
        this.restaurantRating = rating;
        this.restaurantType = type;
        this.restaurantPhone = phone;
        this.restaurantTime = time;
        this.restaurantLocation = location;
    }

    public int getRestaurantImageId() {
        return restaurantImageId;
    }

    public String getRestaurantTitle() {
        return restaurantTitle;
    }

    public String getRestaurantRating() {
        return restaurantRating;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public String getRestaurantTime() {
        return restaurantTime;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

}