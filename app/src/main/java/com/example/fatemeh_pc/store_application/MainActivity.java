package com.example.fatemeh_pc.store_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View ;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_vorud) {
            return true;
        }
        if (id == R.id.id_home) {
            return true;
        }
        if (id == R.id.id_about) {
            return true;
        }
        if (id == R.id.id_category) {
            return true;
        }
        if (id == R.id.id_sabad) {
            return true;
        }
        if (id == R.id.id_vizheh) {
            return true;
        }
        if (id == R.id.id_soal) {
            return true;
        }
        if (id == R.id.id_search) {
            return true;
        }
        if (id == R.id.id_sabad2) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}

