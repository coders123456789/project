package com.project.hawkeye.voting_app;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by HawkEye on 26-03-2018.
 */

public class Fireapp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        if(FirebaseApp.getApps(this).isEmpty())
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        }
    }
}
