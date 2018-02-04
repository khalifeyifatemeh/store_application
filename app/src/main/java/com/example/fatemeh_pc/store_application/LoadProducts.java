package com.example.fatemeh_pc.store_application;

import android.content.Intent;
import android.database.SQLException;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.fatemeh_pc.store_application.Adapter.FurnituresAdapter;
import com.example.fatemeh_pc.store_application.Model.FURNITURE;
import java.util.ArrayList;
import java.util.List;

public class LoadProducts extends AppCompatActivity {

    DatabaseHelper db;
    public RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    public FurnituresAdapter adapter;
    //ArrayList<FURNITURE> arraylist;
    public static List<addfurniture> addfurnitures;///use for database
    List<FURNITURE> Furnitures;
    public static ArrayList<addfurniture> furnitures;
    public FURNITURE f;
    String s;
    //public ArrayList<Integer> images = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_products);


//        images.add(R.drawable._1_);
//        images.add(R.drawable._2_);
//        images.add(R.drawable._3_);
//        images.add(R.drawable._4_);
//        images.add(R.drawable._5_);
//        images.add(R.drawable._6_);
//        images.add(R.drawable._7_);
//        images.add(R.drawable._8_);

        ImageView img = (ImageView) findViewById(R.id.imageView);

        db = new DatabaseHelper(getApplicationContext());
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(LoadProducts.this);

        if (MainActivity.comfort) {
            try {
                furnitures = new ArrayList<>();
                addfurniture fr = new addfurniture();
                db.getfurnitureWithType("comfort");
                furnitures = db.getfurnitureWithType("comfort");
                //long result = fr.getFid();
                Toast.makeText(getApplicationContext(), "عملیات موفق", Toast.LENGTH_LONG).show();
                int n = furnitures.size();

            } catch (SQLException e) {
                Toast.makeText(getApplicationContext(), "عملیات ناموفق", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }

            Furnitures = new ArrayList<>();
            for (int i = 0; i < furnitures.size(); i++) {
                f = new FURNITURE();
                f.setTitle(furnitures.get(i).fname);
                f.setId(furnitures.get(i).fid);
                int n = furnitures.get(i).fid;
                f.setImgid(R.drawable._1_);

                Furnitures.add(f);
            }
            Toast.makeText(getApplicationContext(), "بیرون فور", Toast.LENGTH_LONG).show();

            adapter = new FurnituresAdapter(Furnitures, getApplication());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        } else if (MainActivity.royal) {
            try {
                furnitures = new ArrayList<>();
                addfurniture fr = new addfurniture();
                db.getfurnitureWithType("royal");
                furnitures = db.getfurnitureWithType("royal");
                //long result = fr.getFid();
                Toast.makeText(getApplicationContext(), "عملیات موفق", Toast.LENGTH_LONG).show();
                int n = furnitures.size();
//                       if(furnitures.size()>0)
//                       Toast.makeText(getApplicationContext(),n + " نال نیست" , Toast.LENGTH_LONG).show();

            } catch (SQLException e) {
                Toast.makeText(getApplicationContext(), "عملیات ناموفق", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }

            Furnitures = new ArrayList<>();
            for (int i = 0; i < furnitures.size(); i++) {
                f = new FURNITURE();
                f.setTitle(furnitures.get(i).fname);
                f.setId(furnitures.get(i).fid);
                int n = furnitures.get(i).fid;
                f.setImgid(R.drawable._7_);


                Furnitures.add(f);
            }
            Toast.makeText(getApplicationContext(), "بیرون فور", Toast.LENGTH_LONG).show();

            adapter = new FurnituresAdapter(Furnitures, getApplication());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else if (MainActivity.buff) {
            try {
                furnitures = new ArrayList<>();
                addfurniture fr = new addfurniture();
                db.getfurnitureWithType("buff");
                furnitures = db.getfurnitureWithType("buff");
                Toast.makeText(getApplicationContext(), "عملیات موفق", Toast.LENGTH_LONG).show();
                int n = furnitures.size();
//                       Toast.makeText(getApplicationContext(),n + " نال نیست" , Toast.LENGTH_LONG).show();

            } catch (SQLException e) {
                Toast.makeText(getApplicationContext(), "عملیات ناموفق", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }

            Furnitures = new ArrayList<>();
            for (int i = 0; i < furnitures.size(); i++) {
                f = new FURNITURE();
                f.setTitle(furnitures.get(i).fname);
                f.setTitle(furnitures.get(i).fname);
                f.setId(furnitures.get(i).fid);
                int n = furnitures.get(i).fid;
                f.setImgid(R.drawable._8_);
                Furnitures.add(f);
            }
            Toast.makeText(getApplicationContext(), "بیرون فور", Toast.LENGTH_LONG).show();

            adapter = new FurnituresAdapter(Furnitures, getApplication());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));


        }


        else if(search_activity.searchflag)
        {

            try {
                furnitures = new ArrayList<>();
                addfurniture fr = new addfurniture();
                db.getfurnitureWithname(search_activity.search_text);
                furnitures = db.getfurnitureWithname(search_activity.search_text);
                Toast.makeText(getApplicationContext(), "عملیات موفق", Toast.LENGTH_LONG).show();
                int n = furnitures.size();

            } catch (SQLException e) {
                Toast.makeText(getApplicationContext(), "عملیات ناموفق", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }

            Furnitures = new ArrayList<>();
            for (int i = 0; i < furnitures.size(); i++) {
                f = new FURNITURE();
                f.setTitle(furnitures.get(i).fname);
                f.setId(furnitures.get(i).fid);
                int n = furnitures.get(i).fid;
                f.setImgid(R.drawable._1_);
                Furnitures.add(f);
            }
            Toast.makeText(getApplicationContext(), "بیرون فور", Toast.LENGTH_LONG).show();
            adapter = new FurnituresAdapter(Furnitures, getApplication());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        db.closeDB();

    }


}