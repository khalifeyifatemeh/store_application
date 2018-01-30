package com.example.fatemeh_pc.store_application;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class addfurniture_activity extends AppCompatActivity {


    private static int IMG_RESULT = 1;
    ImageView imageViewLoad;
    Button LoadImage;
    Intent intent;
    DatabaseHelper db;
    ImageView imageview;
    EditText editfimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfurniture_activity);

        imageViewLoad = (ImageView) findViewById(R.id.id_imageview);
        LoadImage = (Button) findViewById(R.id.id_btn_addimage);
        db = new DatabaseHelper(getApplicationContext());

//        //spinners code
//        Spinner sp = (Spinner) findViewById(R.id.id_spinner_furniture);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_dropdown_item_1line,furnitur_code);
//        adapter.setDropDownViewResource(android.R.layout.
//                simple_spinner_dropdown_item);
//
//        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long id) {
//             Toast.makeText(addfurniture_activity.this, "Entekhab shoma: " + furnitur_code[position], Toast.LENGTH_SHORT).show();
//            }

//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//            }
//        });


        final EditText editfid         = (EditText) findViewById(R.id.id_editText_fid);
        final EditText editfname       = (EditText) findViewById(R.id.id_editText_fname);
        final EditText editftype       = (EditText) findViewById(R.id.id_editText_ftype);
        final EditText editfpirce      = (EditText) findViewById(R.id.id_editText_fprice);
        final EditText editfcolor      = (EditText) findViewById(R.id.id_editText_fcolor);
        final EditText editffabric     = (EditText) findViewById(R.id.id_editText_ffabric);
        final EditText editfwood       = (EditText) findViewById(R.id.id_editText_fwood);
        final EditText editfcount      = (EditText) findViewById(R.id.id_editText_fcount);
        final EditText editfkosan      = (EditText) findViewById(R.id.id_editText_fkosan);
        final EditText editfexist      = (EditText) findViewById(R.id.id_editText_fexist);
        editfimage      = (EditText) findViewById(R.id.id_edittex_image);
        Button btnaddimage              =(Button)   findViewById(R.id.id_btn_addimage);
        Button btnaddfurniture              =(Button)   findViewById(R.id.id_btn_addfurniture);
        Button btneditfurniture         =(Button)   findViewById(R.id.id_btn_editfurniture);
        Button btndeletfurniture         =(Button)  findViewById(R.id.id_btn_deletefurniture);


        btnaddimage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                /*****
                 * insert image folder address to database
                 *****/
            }
        });

        btnaddfurniture.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                /*****
                 * insert furniture to database
                 *****/
                try {
                    addfurniture fr = new addfurniture();
                    int fid=(int) Integer.parseInt(editfid.getText().toString());
                    fr.setFid(fid);
                    fr.setFname(editfname.getText().toString());
                    fr.setFtype(editftype.getText().toString());
                    fr.setFprice(editfpirce.getText().toString());
                    fr.setFcolor(editfcolor.getText().toString());
                    fr.setFwood(editfwood.getText().toString());
                    fr.setFfabric(editffabric.getText().toString());
                    fr.setFcount(editfcount.getText().toString());
                    fr.setFkosan(editfkosan.getText().toString());
                    fr.setFexist(editfexist.getText().toString());
                    fr.setFimage(editfimage.getText().toString());

                    long result = db.createFurniture(fr);

                    Toast.makeText(getApplicationContext(), result + "عملیات موفق", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });

//        btneditfurniture.setOnClickListener(new View.OnClickListener(){
//            public void onClick (View arg0){
//                /*****
//                 * update furniture in database
//                 *****/
//            }
//        });
        Button btntest           = (Button) findViewById(R.id.id_btn_editfurniture);
        //Button btn_furniture      = (Button) findViewById(R.id.btn_furniture);
        //Button btn_invoice        = (Button) findViewById(R.id.btn_invoice);
        //Button btn_ufi            = (Button) findViewById(R.id.btn_ufi);
        //final TextView viewtest     = (TextView) findViewById(R.id.textview_test);
        db = new DatabaseHelper(getApplicationContext());

        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<addfurniture> allfurnitures = db.getAllFurnitures();
                if (allfurnitures.size() > 0) {
                    for (addfurniture furniture : allfurnitures) {
                        String s = furniture.getFid() + " " + furniture.getFname() + " " + furniture.getFcolor();
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        db.closeDB();

        btndeletfurniture.setOnClickListener(new View.OnClickListener(){
            public void onClick (View arg0){
                /*****
                 * insert furniture to database
                 *****/
            }
        });
        db.closeDB();

    }

}

