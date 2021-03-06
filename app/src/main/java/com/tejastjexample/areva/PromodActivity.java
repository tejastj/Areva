package com.tejastjexample.areva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class PromodActivity extends AppCompatActivity {
    TextView lat,log,places;
    private Firebase mRef,nRef,pRef;
    public String latitude,longitude,place;
    Button inMaps ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promod);
        lat= (TextView)findViewById(R.id.lat);
        log= (TextView)findViewById(R.id.log);
        places = (TextView)findViewById(R.id.place);
        inMaps = (Button)findViewById(R.id.inmaps);

        mRef = new Firebase("https://myfirebaseauthapp-ae0c6.firebaseio.com/NYzRl8AaoZRPdZnr3GbbPztgFgI2/Promod/latitude");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                latitude = dataSnapshot.getValue(String.class);
                lat.setText(latitude);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        nRef = new Firebase("https://myfirebaseauthapp-ae0c6.firebaseio.com/NYzRl8AaoZRPdZnr3GbbPztgFgI2/Promod/longitude");
        nRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                longitude = dataSnapshot.getValue(String.class);
                log.setText(longitude);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        pRef = new Firebase("https://myfirebaseauthapp-ae0c6.firebaseio.com/NYzRl8AaoZRPdZnr3GbbPztgFgI2/Promod/place");
        pRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                place = dataSnapshot.getValue(String.class);
                places.setText(place);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        inMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PromodActivity.this ,PromodMapsActivity.class);
                intent.putExtra("lat",latitude);
                intent.putExtra("lon",longitude);
                startActivity(intent);
            }
        });


    }
}
