package com.rohit.examples.android.bhopaldarshan.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.rohit.examples.android.bhopaldarshan.Adapter.HotelAdapter;
import com.rohit.examples.android.bhopaldarshan.Data.HotelData;
import com.rohit.examples.android.bhopaldarshan.Model.Hotel;
import com.rohit.examples.android.bhopaldarshan.R;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HotelFragment extends Fragment {

    private EditText search_bar;
    private List<Hotel> hotelList;
    private RecyclerView recyclerView;
    private HotelAdapter adapter;

    public HotelFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.x_hotel_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.hotel_rv);
        search_bar = view.findViewById(R.id.search_bar);

        hotelList = HotelData.fetchHotelData(getContext());

        buildRecyclerView();

        search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filterQuery(s.toString());
            }
        });

    }

    private void buildRecyclerView() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemViewCacheSize(10);

        if (getContext() != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                    LinearLayoutManager.VERTICAL, false));

            adapter = new HotelAdapter(hotelList,getContext());
            recyclerView.setAdapter(adapter);
        }
    }

    //Log Out
    private void logOut(){

    }

    public void filterQuery(String text) {
        ArrayList<Hotel> filterdNames = new ArrayList<>();
        for (Hotel s : this.hotelList) {
            if (s.getHotelTitle().toLowerCase().contains(text) || s.getHotelTitle().toLowerCase().contains(text)) {
                filterdNames.add(s);
            }
        }
        this.adapter.setFilter(filterdNames);
    }
}









