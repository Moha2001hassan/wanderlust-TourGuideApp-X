package com.rohit.examples.android.bhopaldarshan.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;

import com.rohit.examples.android.bhopaldarshan.Activity.DetailActivity;
import com.rohit.examples.android.bhopaldarshan.Activity.MainActivity;
import com.rohit.examples.android.bhopaldarshan.Model.Hotel;
import com.rohit.examples.android.bhopaldarshan.Model.Place;
import com.rohit.examples.android.bhopaldarshan.Model.Restaurant;
import com.rohit.examples.android.bhopaldarshan.Model.Shop;
import com.rohit.examples.android.bhopaldarshan.R;

import java.util.Objects;

import static com.rohit.examples.android.bhopaldarshan.Activity.DetailActivity.INTENT_EXTRA;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

public class Utils {

    public static void detailIntent(Context context, Object object, ImageView imageView) {
        Intent intent = new Intent(context, DetailActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((MainActivity) context,
                imageView, Objects.requireNonNull(ViewCompat.getTransitionName(imageView)));

        if (object instanceof Hotel) {
            Hotel hotel = (Hotel) object;
            intent.putExtra(INTENT_EXTRA, hotel);
        }
        else if (object instanceof Place) {
            Place place = (Place) object;
            intent.putExtra(INTENT_EXTRA, place);
        }
        else if (object instanceof Shop) {
            Shop shop = (Shop) object;
            intent.putExtra(INTENT_EXTRA, shop);
        }
        else if (object instanceof Restaurant) {
            Restaurant restaurant = (Restaurant) object;
            intent.putExtra(INTENT_EXTRA, restaurant);
        }
        context.startActivity(intent, options.toBundle());
    }

    public static void directionsIntent(Context context, String location) {
        if (location.length() <= 0) {
            Toast.makeText(context, R.string.no_location, Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
        intent.setPackage("com.google.android.apps.maps");
        context.startActivity(intent);
    }


    public static void phoneIntent(Context context, String phone) {
        if (phone.length() <= 0) {
            Toast.makeText(context, R.string.no_phone, Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        context.startActivity(intent);
    }
}