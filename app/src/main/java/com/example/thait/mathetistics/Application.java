package com.example.thait.mathetistics;

import com.firebase.client.Firebase;

/**
 * Created by John on 4/29/2016.
 */
public class Application extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
