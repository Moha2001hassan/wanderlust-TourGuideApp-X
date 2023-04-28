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
import com.rohit.examples.android.bhopaldarshan.Data.PlaceData;
import com.rohit.examples.android.bhopaldarshan.Model.Place;
import com.rohit.examples.android.bhopaldarshan.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PlaceFragment extends Fragment {

    private EditText search_bar;
    private List<Place> placeList;
    private RecyclerView recyclerView;
    private PlaceAdapter adapter;

    public PlaceFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.x_place_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.place_rv);
        search_bar = view.findViewById(R.id.search_bar);

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
            placeList = PlaceData.fetchPlaceData(getContext());
            adapter = new PlaceAdapter(placeList,getContext());
            recyclerView.setAdapter(adapter);
        }
    }

    public void filterQuery(String text) {
        ArrayList<Place> filteredNames = new ArrayList<>();
        for (Place s : this.placeList) {
            if (s.getPlaceTitle().toLowerCase().contains(text) || s.getPlaceTitle().toLowerCase().contains(text)) {
                filteredNames.add(s);
            }
        }
        this.adapter.setFilter(filteredNames);
    }
}