package com.example.biboy.googlemapexample;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EditText lon,lat;
    private double dlat, dlon;
    Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);
        lon = (EditText) findViewById(R.id.editText);
        lat = (EditText) findViewById(R.id.editText2);
        btnSet = (Button) findViewById(R.id.button);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        btnSet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlat = Double.parseDouble(lat.getText().toString());
                        dlon = Double.parseDouble(lon.getText().toString());
                        // Add a marker in Sydney and move the camera
                        LatLng mark = new LatLng(dlon, dlat);
                        mMap.clear();
                        mMap.addMarker(new MarkerOptions().position(mark).title("you set this point"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(mark));

                    }
                }
        );



    }
}
