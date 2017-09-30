package com.tejastjexample.areva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.shimmer.ShimmerFrameLayout;

public class HomeActivity extends AppCompatActivity {

    Button chethan,ravi,arjith,sohail,vivek,promod,santhosh,sharma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        chethan=(Button)findViewById(R.id.button);
        ravi=(Button)findViewById(R.id.button2);
        arjith=(Button)findViewById(R.id.button3);
        sohail=(Button)findViewById(R.id.button4);
        vivek=(Button)findViewById(R.id.button5);
        promod=(Button)findViewById(R.id.button6);
        santhosh=(Button)findViewById(R.id.button7);
        sharma=(Button)findViewById(R.id.button8);
        chethan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
            }
        });
        ravi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,RaviActivity.class));
            }
        });
        arjith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ArjithActivity.class));
            }
        });
        sohail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SohailActivity.class));
            }
        });
        vivek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,VivekActivity.class));
            }
        });
        promod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,PromodActivity.class));
            }
        });
        santhosh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SanthoshActivity.class));
            }
        });
        sharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SharmaActivity.class));
            }
        });
    }
}
