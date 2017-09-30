package com.tejastjexample.areva;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class PromodMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public String latitude,longitude;
    public double lati,longi;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promod_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

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
    public void buttonclicked(View v) {
        switch (v.getId()) {
            case R.id.nor:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.sat:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.mar:
                LatLng COLLEGE = new LatLng(lati, longi);
                Marker college = mMap.addMarker(new MarkerOptions().position(COLLEGE));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(COLLEGE));
                mMap.animateCamera(CameraUpdateFactory.newLatLng(COLLEGE));

                CircleOptions circleOptions = new CircleOptions();
                circleOptions.center(COLLEGE);
                circleOptions.radius(500);
                mMap.addCircle(circleOptions);
                break;
            case R.id.gps:
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                mMap.setMyLocationEnabled(true);

        }

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        latitude = getIntent().getStringExtra("lat");//getting data from other activity
        longitude = getIntent().getStringExtra("lon");
        //lati = Double.valueOf(latitude).doubleValue();//converting string to double
        //longi = Double.valueOf(longitude).doubleValue();
        try {
            lati = Double.parseDouble(latitude);
            longi = Double.parseDouble(longitude);
        }catch (NumberFormatException e){
            System.out.println(e);
        }
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lati, longi);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Promod"));//placing marker
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(sydney));

        CircleOptions circleOptions = new CircleOptions();//placing circle
        circleOptions.center(sydney);
        circleOptions.radius(500);
        mMap.addCircle(circleOptions);

    }

}
