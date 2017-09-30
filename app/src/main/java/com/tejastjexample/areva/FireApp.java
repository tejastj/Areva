package com.tejastjexample.areva;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Tejas T J on 18-09-2017.
 */
public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
