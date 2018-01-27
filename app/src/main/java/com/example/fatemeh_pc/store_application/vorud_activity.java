package com.example.fatemeh_pc.store_application;

import android.database.SQLException;
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
import android.widget.ImageView;
import android.app.ActionBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.view.Gravity;
import android.graphics.Color;
import android.widget.LinearLayout;


public class vorud_activity extends AppCompatActivity {

    DatabaseHelper db;

    DatabaseHelper databasehelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vorud_activity);

        db = new DatabaseHelper(getApplicationContext());

        Button btnsignin        = (Button) findViewById(R.id.id_btn_signin);
        Button btngotosignup    = (Button) findViewById(R.id.id_btn_gotosignup);
        final EditText editusername   = (EditText) findViewById(R.id.id_editText_phone);
        final EditText editpassword   = (EditText) findViewById(R.id.id_editText_password);

        ///////onclick function for button of sighnin////////
        btnsignin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    adduser user = db.getUser(editusername.getText().toString(),editpassword.getText().toString());
                    if(user != null) {
                        Toast.makeText(getApplicationContext(), user.getUname() + " خوش آمدید " , Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "نام کاربری یا کلمه عبور اشتباه است", Toast.LENGTH_LONG).show();
                    }
                } catch (SQLException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }

        });

        //////onclick function for button of go to sighnup/////////
        btngotosignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next = new Intent(vorud_activity.this, activity_sabtenam.class);
                startActivity(next);
            }
        });


        db.closeDB();
    }
}
