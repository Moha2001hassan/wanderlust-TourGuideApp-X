package com.rohit.examples.android.bhopaldarshan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rohit.examples.android.bhopaldarshan.Model.Hotel;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.Utils.Utils;

import static com.rohit.examples.android.bhopaldarshan.Activity.DetailActivity.INTENT_EXTRA;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HotelDetailFragment extends Fragment implements View.OnClickListener {

    private Hotel hotel;

    public static HotelDetailFragment newInstance(Hotel hotel) {
        HotelDetailFragment hotelDetailFragment = new HotelDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(INTENT_EXTRA, hotel);
        hotelDetailFragment.setArguments(bundle);
        return hotelDetailFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Hotel hotel = (Hotel) getArguments().getSerializable(INTENT_EXTRA);

            if (hotel != null) {
                this.hotel = hotel;
            }
        }
    }


    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.x_hotel_detail, container, false);
    }


    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView hotelImg = view.findViewById(R.id.shop_Image);
        TextView hotelTitle = view.findViewById(R.id.title);
        TextView hotelRating = view.findViewById(R.id.rating);
        TextView hotelPhone = view.findViewById(R.id.phone);
        TextView hotelDirections = view.findViewById(R.id.directions);
        Button reserve_btn = view.findViewById(R.id.reserve_btn);
        TextView hotelPrice = view.findViewById(R.id.hotel_price_txt);

        hotelPhone.setOnClickListener(this);
        hotelDirections.setOnClickListener(this);

        //Setting the data to appropriate item position
        hotelImg.setImageResource(hotel.getHotelImageId());
        hotelTitle.setText(hotel.getHotelTitle());
        hotelRating.setText(String.valueOf(hotel.getHotelRating()));
        hotelPhone.setText(hotel.getHotelPhone());
        hotelDirections.setText(hotel.getHotelLocation());
        hotelPrice.setText(hotel.getHotelPrice());


        reserve_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new First_Reservation();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (getContext() != null) {
            switch (view.getId()) {
                case R.id.phone:
                    Utils.phoneIntent(getContext(), hotel.getHotelPhone());
                    break;
                case R.id.directions:
                    Utils.directionsIntent(getContext(), hotel.getHotelLocation());
                    break;
                case R.id.reserve_btn:
                    Toast.makeText(getContext(), "Reservation completed successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}