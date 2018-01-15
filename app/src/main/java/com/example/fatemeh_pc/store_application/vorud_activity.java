package com.example.fatemeh_pc.store_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.app.Activity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vorud_activity);


        Button b = (Button) findViewById(R.id.id_btn_signup);

        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent next = new Intent(vorud_activity.this, activity_sabtenam.class);
                startActivity(next);
            }
        });
    }
}
