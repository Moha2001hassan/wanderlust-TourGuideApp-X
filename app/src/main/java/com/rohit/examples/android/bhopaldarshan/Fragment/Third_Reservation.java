package com.rohit.examples.android.bhopaldarshan.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohit.examples.android.bhopaldarshan.Activity.MainActivity;
import com.rohit.examples.android.bhopaldarshan.R;

public class Third_Reservation extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third_reservation, container, false);

        // Create a new handler
        Handler handler = new Handler();

        // Delay the transition for 2 seconds (2000 milliseconds)
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create a new instance of the fragment to navigate to
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        }, 2000);

        return view;
    }
}