package com.project.hawkeye.voting_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminAuth extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_auth);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignin = (Button) findViewById(R.id.buttonSignin);

        buttonSignin.setOnClickListener(this);


    }
    public void adminlogin() {


        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.equals("ayushmanmishra38@gmail.com")) {
            if (password.equals("123456")) {
                finish();
                startActivity(new Intent(getApplicationContext(), datainsertion.class));

            } else {

                Toast.makeText(this, "Sorry Only App Admin Can Login", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        } else {

            Toast.makeText(this, "Sorry Only App Admin Can Login", Toast.LENGTH_LONG).show();
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }

    @Override
    public void onClick(View view) {
        if(view == buttonSignin){

            adminlogin();


        }

    }
}
