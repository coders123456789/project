package com.project.hawkeye.voting_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class datainsertion extends AppCompatActivity implements View.OnClickListener {


    DatabaseHelper myDb;

    private EditText voter;
    private EditText aadhar;
    private EditText nameid;
    private EditText dob;
    private EditText sex;
    private EditText casted;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datainsertion);

        myDb = new DatabaseHelper(this);

        voter = (EditText) findViewById(R.id.voter);
        aadhar = (EditText) findViewById(R.id.aadhar);
        nameid = (EditText) findViewById(R.id.nameid);
        dob = (EditText) findViewById(R.id.dob);
        sex = (EditText) findViewById(R.id.sexid);
        casted = (EditText) findViewById(R.id.caste);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view == submit) {

                boolean isInserted = myDb.insertData(voter.getText().toString(),
                        aadhar.getText().toString(), nameid.getText().toString(), dob.getText().toString(), sex.getText().toString(), casted.getText().toString()
                );
                if (isInserted) {
                    Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(this, "Data not Inserted", Toast.LENGTH_LONG).show();


        }
    }
}
