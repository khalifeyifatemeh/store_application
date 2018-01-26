package com.example.fatemeh_pc.store_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.util.List;

public class test_of_db extends AppCompatActivity {

    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_of_db);

        Button btn_user             = (Button) findViewById(R.id.btn_user);
        //Button btn_furniture      = (Button) findViewById(R.id.btn_furniture);
        //Button btn_invoice        = (Button) findViewById(R.id.btn_invoice);
        //Button btn_ufi            = (Button) findViewById(R.id.btn_ufi);
        final TextView viewtest     = (TextView) findViewById(R.id.textview_test);
        db = new DatabaseHelper(getApplicationContext());

        btn_user.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                List<adduser> allusers = db.getAllUsers();
                if (allusers.size() > 0) {
                    for (adduser user : allusers) {
                        String s = user.getUname() + " " + user.getUlastname() + " " + user.getUemail() + " " + user.getUid() + " " + user.getUtype();
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        db.closeDB();
    }
}
