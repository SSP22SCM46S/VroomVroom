package com.example.VroomVroom;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.api.Places;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    PlaceAutocompleteFragment placeAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_passenger);

        placeAutoComplete = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete);
        placeAutoComplete.setOnPlaceSelectedListener(new PlaceSelectionListener() {

            @Override
            public void onPlaceSelected(Place place) {

                Log.d("Maps", "Place selected: " + place.getName());
            }

            @Override
            public void onError(Status status) {
                Log.d("Maps", "An error occurred: " + status);
            }

        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

}



