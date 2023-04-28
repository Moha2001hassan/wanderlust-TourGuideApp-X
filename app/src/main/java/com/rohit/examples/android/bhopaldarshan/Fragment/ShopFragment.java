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

import com.rohit.examples.android.bhopaldarshan.Adapter.ShopAdapter;
import com.rohit.examples.android.bhopaldarshan.Data.ShopData;
import com.rohit.examples.android.bhopaldarshan.Model.Shop;
import com.rohit.examples.android.bhopaldarshan.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    EditText searchTextEd;
    private List<Shop> shopList;
    ShopAdapter adapter;

    //No argument constructor to prevent accidentally instantiating Class object
    public ShopFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.x_shop_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.shop_rv);
        searchTextEd = view.findViewById(R.id.search_bar);

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemViewCacheSize(10);

        ShopData shopData = new ShopData();
        shopList = shopData.fetchShopData(getContext());

        if (getContext() != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(
                    getContext(), LinearLayoutManager.VERTICAL, false));

            adapter = new ShopAdapter(getContext(), shopList);
            recyclerView.setAdapter(adapter);
        }

        searchTextEd.addTextChangedListener(new TextWatcher() {
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

    public void filterQuery(String text) {
        ArrayList<Shop> filterdNames = new ArrayList<>();
        for (Shop s : this.shopList) {
            if (s.getShopTitle().toLowerCase().contains(text) || s.getShopTitle().toLowerCase().contains(text)) {
                filterdNames.add(s);
            }
        }
        this.adapter.setFilter(filterdNames);
    }
}