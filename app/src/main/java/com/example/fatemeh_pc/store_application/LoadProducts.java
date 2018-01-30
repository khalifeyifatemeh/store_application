package com.example.fatemeh_pc.store_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fatemeh_pc.store_application.Adapter.FurnituresAdapter;
import com.example.fatemeh_pc.store_application.Model.FURNITURE;

import java.util.ArrayList;
import java.util.List;

public class LoadProducts extends AppCompatActivity {

    private List<FURNITURE> furnitures=new ArrayList<>();
    private RecyclerView recyclerView;
    public FurnituresAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_products);

        recyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        adapter =new FurnituresAdapter(furnitures);
        recyclerView.setLayoutManager(new LinearLayoutManager(LoadProducts.this));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setData();
    }

    private List<FURNITURE> setData()
    {

          furnitures.add(new FURNITURE("belona","3000",R.drawable.c1));
          furnitures.add(new FURNITURE("belona","1000",R.drawable.c2));
          furnitures.add(new FURNITURE("belona","2000",R.drawable.c3));
          adapter.notifyDataSetChanged();
          return furnitures;

    }
}
