package com.example.fatemeh_pc.store_application;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
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


import com.example.fatemeh_pc.store_application.Adapter.FurnituresAdapter;
import com.example.fatemeh_pc.store_application.Model.FURNITURE;

import java.util.ArrayList;

public class product_profile extends AppCompatActivity {

    int f_id;
    DatabaseHelper db;
//    int[] intimage = new int[10];
    public addfurniture fr;
    TextView txtname;
    TextView txtcode;
    TextView txttype;
    TextView txtprice;
    TextView txtcolor;
    TextView txtfabric;
    TextView txtwood;
    TextView txtcount;
    TextView txtkosan;
    TextView txtexist;
    ImageView imgv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_profile);
        f_id=FurnituresAdapter.furniture_Id;
        db = new DatabaseHelper(getApplicationContext());
        imgv=(ImageView)findViewById(R.id.id_imgview_profile);
        txtname=(TextView)findViewById(R.id.id_txtname);
        txtcode=(TextView)findViewById(R.id.id_txtcode);
        txttype=(TextView)findViewById(R.id.id_txttype);
        txtprice=(TextView)findViewById(R.id.id_txtprice);
        txtcolor=(TextView)findViewById(R.id.id_txtcolor);
        txtfabric=(TextView)findViewById(R.id.id_txtfabric);
        txtwood=(TextView)findViewById(R.id.id_txtwood);
        txtcount=(TextView)findViewById(R.id.id_txtcount);
        txtkosan=(TextView)findViewById(R.id.id_txtkosan);
        txtexist=(TextView)findViewById(R.id.id_txtexixt);

//        intimage[0] = R.drawable._1_;
//        intimage[1] = R.drawable._1_;
//        intimage[2] = R.drawable._2_;
//        intimage[3] = R.drawable._3_;
//        intimage[4] = R.drawable._4_;
//        intimage[5] = R.drawable._5_;
//        intimage[6] = R.drawable._6_;
//        intimage[7] = R.drawable._7_;
//        intimage[8] = R.drawable._8_;



        try {
            fr=new addfurniture();
            fr = db.getfurniture(f_id);
            Toast.makeText(getApplicationContext(),"جزئیات محصول", Toast.LENGTH_LONG).show();
            //imgv.setImageResource(R.drawable._5_);
            txtname.setText(fr.fname);
            int n=fr.fid;
            String s=Integer.toString(n);
            txtcode.setText(s);
            txttype.setText(fr.ftype);
            txtprice.setText(fr.fprice);
            txtcolor.setText(fr.fcolor);
            txtfabric.setText(fr.ffabric);
            txtwood.setText(fr.fwood);
            txtcount.setText(fr.fcount);
            txtkosan.setText(fr.fkosan);
            txtexist.setText(fr.fexist);

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), "عملیات ناموفق", Toast.LENGTH_LONG).show();
        }

//
//
        db.closeDB();


    }
}
