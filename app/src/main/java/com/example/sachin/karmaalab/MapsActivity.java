package com.example.sachin.karmaalab;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng GIS = new LatLng(12.9626252,77.6467603 );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GIS, 8));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.addMarker(new MarkerOptions().position(GIS).title("Marker in Global Incubation Services")
                .snippet("Hello sir"));
        CameraPosition camera = new CameraPosition.Builder()
                .target(GIS)
                .zoom(13)  //limite ->21
                .bearing(90) // 0 - 365
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera), 2000, null);
            mMap.addCircle(new CircleOptions()
                .center(GIS)
                .radius(1000)
                .strokeColor(Color.BLUE)
                .fillColor(Color.WHITE));


        LatLng DB = new LatLng(12.9609046,77.6337317 );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DB,8));
        mMap.addMarker(new MarkerOptions().position(DB).title("Marker Domlur Post Office")
                .snippet("Hello sir"));
        camera = new CameraPosition.Builder()
                .target(DB)
                .zoom(13)  //limite ->21
                .bearing(90) // 0 - 365
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera), 2000, null);
        mMap.addCircle(new CircleOptions()
                .center(DB)
                .radius(1000)
                .strokeColor(Color.RED)
                .fillColor(Color.WHITE));


        LatLng GC = new LatLng(12.964815,77.6406303 );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GC,8));
        mMap.addMarker(new MarkerOptions().position(GC).title("Marker in Starbucks Coffee Indiranagar")
                .snippet("Hello sir"));
        camera = new CameraPosition.Builder()
                .target(GC)
                .zoom(13)  //limite ->21
                .bearing(90) // 0 - 365
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera), 2000, null);
        mMap.addCircle(new CircleOptions()
                .center(GC)
                .radius(1000)
                .strokeColor(Color.BLACK)
                .fillColor(Color.TRANSPARENT));

    }
}
