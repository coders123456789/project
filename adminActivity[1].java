package com.project.hawkeye.voting_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminActivity extends AppCompatActivity implements View.OnClickListener{
    private Button about;
    private Button admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        about = (Button) findViewById(R.id.about);
        admin = (Button) findViewById(R.id.admin);

        about.setOnClickListener(this);
        admin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == about){
            /* about activity */
        }

        if(view == admin){
            finish();
            startActivity(new Intent(getApplicationContext(), datainsertion.class));
        }

    }
}
