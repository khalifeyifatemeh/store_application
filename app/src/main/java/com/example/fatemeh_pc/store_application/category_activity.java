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
import android.widget.ImageButton;
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

import static com.example.fatemeh_pc.store_application.R.id.id_imgbtncomfort;

public class category_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activity);

        ImageButton comfortbtn= (ImageButton) findViewById(R.id.id_imgbtncomfort);
        ImageButton buffbtn   = (ImageButton) findViewById(R.id.id_imgbtnbuff);
        ImageButton royalbtn  = (ImageButton) findViewById(R.id.id_imgbtnroyal);
        TextView textViewcomfort  = (TextView) findViewById(R.id.id_textviewcomfort);
        TextView textViewbuff   = (TextView) findViewById(R.id.id_textviewbuff);
        TextView textViewroyal   = (TextView) findViewById(R.id.id_textviewroyal);

        comfortbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next = new Intent(category_activity.this, product_activity.class);
                startActivity(next);
            }
        });

        buffbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next = new Intent(category_activity.this, product_activity.class);
                startActivity(next);
            }
        });

        royalbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next = new Intent(category_activity.this, product_activity.class);
                startActivity(next);
            }
        });

        textViewbuff.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next = new Intent(category_activity.this, product_activity.class);
                startActivity(next);
            }
        });

        textViewcomfort.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next = new Intent(category_activity.this, product_activity.class);
                startActivity(next);
            }
        });

        textViewroyal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next = new Intent(category_activity.this, product_activity.class);
                startActivity(next);
            }
        });


    }
}
