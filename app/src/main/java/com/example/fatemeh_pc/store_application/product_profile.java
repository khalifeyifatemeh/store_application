package com.example.fatemeh_pc.store_application;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fatemeh_pc.store_application.Adapter.FurnituresAdapter;
import com.example.fatemeh_pc.store_application.Model.FURNITURE;

import java.util.ArrayList;

public class product_profile extends AppCompatActivity {

    int f_id;
    DatabaseHelper db;
    int[] intimage = new int[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_profile);
        f_id=Integer.parseInt(FurnituresAdapter.furniture_Id);
        db = new DatabaseHelper(getApplicationContext());
        ImageView imgv=(ImageView)findViewById(R.id.id_imgview_profile);
        TextView txtname=(TextView)findViewById(R.id.id_txtname);
        TextView txtcode=(TextView)findViewById(R.id.id_txtcode);
        TextView txttype=(TextView)findViewById(R.id.id_txttype);
        TextView txtprice=(TextView)findViewById(R.id.id_txtprice);
        TextView txtcolor=(TextView)findViewById(R.id.id_txtcolor);
        TextView txtfabric=(TextView)findViewById(R.id.id_txtfabric);
        TextView txtwood=(TextView)findViewById(R.id.id_txtwood);
        TextView txtcount=(TextView)findViewById(R.id.id_txtcount);
        TextView txtkosan=(TextView)findViewById(R.id.id_txtkosan);
        TextView txtexist=(TextView)findViewById(R.id.id_txtexixt);

        intimage[0] = R.drawable._1_;
        intimage[1] = R.drawable._1_;
        intimage[2] = R.drawable._2_;
        intimage[3] = R.drawable._3_;
        intimage[4] = R.drawable._4_;
        intimage[5] = R.drawable._5_;
        intimage[6] = R.drawable._6_;
        intimage[7] = R.drawable._7_;
        intimage[8] = R.drawable._8_;



        try {
            addfurniture fr = new addfurniture();
            fr= db.getfurniture(f_id);
            Toast.makeText(getApplicationContext(), "عملیات موفق", Toast.LENGTH_LONG).show();
            if(fr!=null) {
                imgv.setImageResource(intimage[fr.getFid()]);
                txtname.setText(fr.getFname());
                txtcode.setText(fr.getFid());
                txttype.setText(fr.getFtype());
                txtprice.setText(fr.getFprice());
                txtcolor.setText(fr.getFcolor());
                txtfabric.setText(fr.getFfabric());
                txtwood.setText(fr.getFwood());
                txtcount.setText(fr.getFcount());
                txtkosan.setText(fr.getFkosan());
                txtexist.setText(fr.getFexist());

            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), "عملیات ناموفق", Toast.LENGTH_LONG).show();
        }



        db.closeDB();


    }
}
