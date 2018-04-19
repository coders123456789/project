package com.project.hawkeye.voting_app;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class display extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper myDb;

    private EditText editText_name;
    private EditText editText_dob;
    private EditText editText_aid;
    private Button go;
    private Button go2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        myDb = new DatabaseHelper(this);

        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_dob = (EditText) findViewById(R.id.editText_dob);
        editText_aid = (EditText) findViewById(R.id.editText_aid);
        go = (Button) findViewById(R.id.go);
        go2 = (Button) findViewById(R.id.go2);

        go.setOnClickListener(this);
        go2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

       /* if (view == go) {
            Cursor res = myDb.getAllData();
            if (res.getCount() == 0) {
                // show message
                showMessage("Error", "Nothing found");
                return;
            } else {
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :" + res.getString(0) + "\n");
                    buffer.append("Name :" + res.getString(1) + "\n");
                    buffer.append("Surname :" + res.getString(2) + "\n");
                    buffer.append("Marks :" + res.getString(3) + "\n\n");
                }

            }*/


    }





    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
