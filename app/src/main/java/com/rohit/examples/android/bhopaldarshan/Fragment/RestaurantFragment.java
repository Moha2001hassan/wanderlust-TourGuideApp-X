package com.rohit.examples.android.bhopaldarshan.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rohit.examples.android.bhopaldarshan.Adapter.PlaceAdapter;
import com.rohit.examples.android.bhopaldarshan.Adapter.RestaurantAdapter;
import com.rohit.examples.android.bhopaldarshan.Data.PlaceData;
import com.rohit.examples.android.bhopaldarshan.Data.RestaurantData;
import com.rohit.examples.android.bhopaldarshan.Model.Place;
import com.rohit.examples.android.bhopaldarshan.Model.Restaurant;
import com.rohit.examples.android.bhopaldarshan.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFragment extends Fragment {

    private EditText search_bar;
    private List<Restaurant> restaurantList;
    private RecyclerView recyclerView;
    private RestaurantAdapter adapter;

    public RestaurantFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.x_restaurant_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.restaurant_rv);
        search_bar = view.findViewById(R.id.search_bar);

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemViewCacheSize(10);

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
            restaurantList = RestaurantData.fetchRestaurantData(getContext());
            adapter = new RestaurantAdapter(getContext(),restaurantList);
            recyclerView.setAdapter(adapter);
        }
    }

    public void filterQuery(String text) {
        ArrayList<Restaurant> filteredNames = new ArrayList<>();
        for (Restaurant s : this.restaurantList) {
            if (s.getRestaurantTitle().toLowerCase().contains(text) || s.getRestaurantTitle().toLowerCase().contains(text)) {
                filteredNames.add(s);
            }
        }
        this.adapter.setFilter(filteredNames);
    }
}