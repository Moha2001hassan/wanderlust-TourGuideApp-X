package com.rohit.examples.android.bhopaldarshan.Fragment;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rohit.examples.android.bhopaldarshan.Activity.LoginActivity;
import com.rohit.examples.android.bhopaldarshan.R;

public class ProfileFragment extends Fragment {

    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 2;
    ImageView imageView;
    Button logout_btn;
    TextView name_black, name_blue, email_user;
    FirebaseAuth auth;
    FirebaseUser user;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.x_profile_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        updateData(view);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Permission is not granted
                    // Request for the camera permission
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CAMERA},
                            MY_PERMISSIONS_REQUEST_CAMERA);
                }

                captureImage(v);
            }
        });



    }

    public void init(View view){
        imageView = view.findViewById(R.id.imageView);
        logout_btn = view.findViewById(R.id.button);
        name_black = view.findViewById(R.id.name_user);
        name_blue = view.findViewById(R.id.name_user_txt);
        email_user = view.findViewById(R.id.email_user);
    }

    public void updateData(View v) {

        SharedPreferences preferences = getActivity().getSharedPreferences("MY_PREFS", MODE_PRIVATE);
        String name = preferences.getString("NAME_KEY", "");
        String email = preferences.getString("EMAIL_KEY", "");

        name_black.setText(name);
        name_blue.setText(name);
        email_user.setText(email);
    }

    public void captureImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            // Use the URI to display the image in your app
            imageView.setImageURI(uri);
        }
    }

}