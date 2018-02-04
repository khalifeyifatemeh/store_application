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
    public LinearLayoutManager layoutManager;
    public FurnituresAdapter adapter;
    public List<FURNITURE> Furnitures_recycle_list;
    public static ArrayList<addfurniture> furnitures;
    public FURNITURE furniture_in_recycle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_products);
//        ImageView img=(ImageView)findViewById(R.id.imageView);
        db = new DatabaseHelper(getApplicationContext());
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);




        if (MainActivity.comfort) {
            try {
                furnitures = new ArrayList<addfurniture>();
                addfurniture fr = new addfurniture();
                db.getfurnitureWithType("comfort");
                furnitures = db.getfurnitureWithType("comfort");

                if (furnitures != null)
                    Toast.makeText(getApplicationContext(), "عملیات موفق", Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(getApplicationContext(), "عملیات نا موفق", Toast.LENGTH_LONG).show();
                    return;
                }

                Furnitures_recycle_list = new ArrayList<FURNITURE>();
                for(int i=0;i<furnitures.size();i++)
                {
                    furniture_in_recycle = new FURNITURE();
                    furniture_in_recycle.setTitle(furnitures.get(i).fname);
                    furniture_in_recycle.setPrice(furnitures.get(i).fprice);
                    furniture_in_recycle.setImgid(R.drawable.ic_comfort);
                    Furnitures_recycle_list.add(furniture_in_recycle);
                }

//                Toast.makeText(getApplicationContext(), "بیرون فور", Toast.LENGTH_LONG).show();
//                adapter = new FurnituresAdapter(Furnitures_recycle_list, getApplication());
//                recyclerView.setAdapter(adapter);

                recyclerView.setLayoutManager(layoutManager);
                adapter = new FurnituresAdapter(Furnitures_recycle_list, getApplication());
                recyclerView.setAdapter(adapter);


            } catch (SQLException e) {
//                Toast.makeText(getApplicationContext(), "عملیات ناموفق", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();

            }
        }
        db.closeDB();
    }



//    private void setListValues(int n, ArrayList<addfurniture> adfff){
//        arraylist = new ArrayList<FURNITURE>();
//        for(int i=0;i<n;i++) {
//            String s=adfff.get(i).getFname();
//            String p=adfff.get(i).getFprice();
//            String x=adfff.get(i).getFimage();
//            int xx=Integer.parseInt(adfff.get(i).fimage);
//            FURNITURE fff=new FURNITURE(s,p,(Integer.parseInt(x)));
//            arraylist.add(fff);
//            arraylist.add(new FURNITURE(s,p,xx));
//        }
//        adapter = new FurnituresAdapter(Furnitures);
//        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(adapter);
//
//    }
}