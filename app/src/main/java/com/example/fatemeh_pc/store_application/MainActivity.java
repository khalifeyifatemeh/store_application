package com.example.fatemeh_pc.store_application;

import android.content.ClipData;
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
import android.widget.ViewFlipper;


public class MainActivity extends AppCompatActivity {

    public static  boolean flag=false;//main activity is run
    public static String uphone = null;
    public static  boolean vorudopening=false;// vorud_activity not open
    public static Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Button btn_management=(Button) findViewById(R.id.id_managment);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        if(uphone != null) {
            MenuItem m = menu.findItem(R.id.id_vorud);
            m.setTitle(uphone);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_vorud) {
            Intent intent = new Intent(this, vorud_activity.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.id_home) {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.id_about) {
            Intent intent = new Intent(this, about_activity.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.id_category) {
            Intent intent = new Intent(this, category_activity.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.id_sabad) {
            Intent intent = new Intent(this, sabad_activity.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.id_vizheh) {
            Intent intent = new Intent(this, vizheh_activity.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.id_soal) {
            Intent intent = new Intent(this, soal_activity.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.id_search) {
            Intent intent = new Intent(this, search_activity.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.id_sabad2) {
            Intent intent = new Intent(this, sabad_activity.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.id_logout) {
            Intent intent = new Intent(this, sabad_activity.class);
            this.startActivity(intent);
            return true;
        }

        if (id == R.id.id_managment) {
            Intent intent = new Intent(this, addfurniture_activity.class);
            this.startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }






}

