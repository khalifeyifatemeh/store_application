package com.example.fatemeh_pc.store_application;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatemeh_pc.store_application.Adapter.FurnituresAdapter;
import com.example.fatemeh_pc.store_application.Model.FURNITURE;

import java.util.ArrayList;
import java.util.List;

public class search_activity extends AppCompatActivity {

   public static String search_text;
    public static boolean searchflag=false;

    EditText searchedittext;
    Button searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);

        searchedittext=(EditText)findViewById(R.id.id_edittext_search);
        searchbtn=(Button)findViewById(R.id.id_btnsearch);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchflag=true;
                MainActivity.comfort=false;
                MainActivity.royal=false;
                MainActivity.buff=false;
                search_text=searchedittext.getText().toString();
                Intent next = new Intent(search_activity.this, LoadProducts.class);
                startActivity(next);


            }
        });
    }
}
