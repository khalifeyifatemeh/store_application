package com.example.fatemeh_pc.store_application;

import android.content.ClipData;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
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
import java.util.ArrayList;
//import com.example.fatemeh_pc.store_application.Adapter.FurnituresAdapter;
//import com.example.fatemeh_pc.store_application.Model.FURNITURE;


public class MainActivity extends AppCompatActivity {


    public static boolean comfort=false;
    public static boolean royal=false;
    public static boolean buff=false;

    //DatabaseHelper db;

    public static boolean flag = false;//main activity is run
    public static String uphone = null;
    public static boolean vorudopening = false;// vorud_activity not open
    //public  static ArrayList<addfurniture> furnitures;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //db = new DatabaseHelper(getApplicationContext());


        Button btn_comfort = (Button) findViewById(R.id.id_btn_comfort);
        Button btn_buff = (Button) findViewById(R.id.id_btn_buff);
        Button btn_royal = (Button) findViewById(R.id.id_btn_royal);



        /////////////codes for load product/////////////

        btn_comfort.setOnClickListener(new OnClickListener() {
               @Override
               public void onClick(View v) {

                   comfort=true;
//                   try {
//                       furnitures = new ArrayList<>();
//                       addfurniture fr = new addfurniture();
//                       db.getfurnitureWithType("comfort");
//                       furnitures = db.getfurnitureWithType("comfort");
//                       //long result = fr.getFid();
//                       Toast.makeText(getApplicationContext(),  "عملیات موفق", Toast.LENGTH_LONG).show();
//                       int n=furnitures.size();
////                       if(furnitures.size()>0)
////                       Toast.makeText(getApplicationContext(),n + " نال نیست" , Toast.LENGTH_LONG).show();
//
//                   } catch (SQLException e) {
//                       Toast.makeText(getApplicationContext(), "عملیات ناموفق", Toast.LENGTH_LONG).show();
//                       //Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
//                   }
                   Intent next = new Intent(MainActivity.this, LoadProducts.class);
                   startActivity(next);
               }
           });
        //db.closeDB();

    }




//    private List<FURNITURE> setData()
//    {
//
//        furnitures.add(new FURNITURE("belona","3000",R.drawable.c1));
//        furnitures.add(new FURNITURE("belona","1000",R.drawable.c2));
//        furnitures.add(new FURNITURE("belona","2000",R.drawable.c3));
//        adapter.notifyDataSetChanged();
//        return furnitures;
//
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        if (uphone != null) {
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
//        if (id == R.id.id_vizheh) {
//            Intent intent = new Intent(this, vizheh_activity.class);
//            this.startActivity(intent);
//            return true;
//
//     }
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

