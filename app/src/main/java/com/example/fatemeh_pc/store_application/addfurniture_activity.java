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
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class addfurniture_activity extends AppCompatActivity {
    Intent intent;
    DatabaseHelper db;
    EditText editfimage;
    ArrayList<String> listff;
    TextView show;
    String sss;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfurniture_activity);
        db = new DatabaseHelper(getApplicationContext());


        final EditText editfid = (EditText) findViewById(R.id.id_editText_fid);
        final EditText editfname = (EditText) findViewById(R.id.id_editText_fname);
        final EditText editftype = (EditText) findViewById(R.id.id_editText_ftype);
        final EditText editfpirce = (EditText) findViewById(R.id.id_editText_fprice);
        final EditText editfcolor = (EditText) findViewById(R.id.id_editText_fcolor);
        final EditText editffabric = (EditText) findViewById(R.id.id_editText_ffabric);
        final EditText editfwood = (EditText) findViewById(R.id.id_editText_fwood);
        final EditText editfcount = (EditText) findViewById(R.id.id_editText_fcount);
        final EditText editfkosan = (EditText) findViewById(R.id.id_editText_fkosan);
        final EditText editfexist = (EditText) findViewById(R.id.id_editText_fexist);
        editfimage = (EditText) findViewById(R.id.id_editText_image);
        Button btnaddfurniture = (Button) findViewById(R.id.id_btn_addfurniture);
        Button btneditfurniture = (Button) findViewById(R.id.id_btn_editfurniture);
        Button btndeletfurniture = (Button) findViewById(R.id.id_btn_deletefurniture);


        final ArrayList<addfurniture> listf = (ArrayList<addfurniture>) db.getAllFurnitures();
        listff=new ArrayList<String>();
        for(int jj=0;jj<listf.size();jj++)
        {
            String s=Integer.toString(listf.get(jj).getFid());
            listff.add(s);
        }
        sp = (Spinner) findViewById(R.id.id_spinner_furniture);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,listff);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //5
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long id) {
                Toast.makeText(addfurniture_activity.this,"انتخاب شما : " + listff.get(position),Toast.LENGTH_SHORT).show();
                String code=listff.get(position);
                int code2=(int)Integer.parseInt(code);
                addfurniture f=new addfurniture();
                f=db.getfurniture(code2);
                editfid.setText(code);
                editfname.setText(f.fname);
                editftype.setText(f.ftype);
                editfpirce.setText(f.fprice);
                editfcolor.setText(f.fcolor);
                editffabric.setText(f.ffabric);
                editfwood.setText(f.fwood);
                editfkosan.setText(f.fkosan);
                editfcount.setText(f.fcount);
                editfexist.setText(f.fexist);
                editfimage.setText(f.fimage);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });



        btnaddfurniture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /*****
                 * insert furniture to database
                 *****/
                try {
                    addfurniture fr = new addfurniture();
                    int fid = (int) Integer.parseInt(editfid.getText().toString());
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

                    Toast.makeText(getApplicationContext(), result + "عملیات افزودن با موفقیت انجام شد", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });

        btneditfurniture.setOnClickListener(new View.OnClickListener(){
            public void onClick (View arg0) {
                /*****
                 * update furniture in database
                 *****/
                try {
                    addfurniture fr = new addfurniture();
                    addfurniture fr1 = new addfurniture();
                    int f_id = (int) Integer.parseInt(editfid.getText().toString());
                    fr.setFid(f_id);
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
                    db.updatefurniture(fr);
                    long result = fr.getFid();
                    Toast.makeText(getApplicationContext(), result + "عملیات ویرایش با موفقیت انجام شد", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(getApplicationContext(), "عملیات ویرایش ناموفق", Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

///////////////////////////////DELETE////////////////////////////////////
        btndeletfurniture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /*****
                 * delete furniture from database
                 *****/
                try {
                    int fid = (int) Integer.parseInt(editfid.getText().toString());
                    db.deleteFurniture(fid);

                    Toast.makeText(getApplicationContext(), "عملیات حذف با موفقیت انجام شد", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });



                show=(TextView)findViewById(R.id.id_textview);
                sss="";
                Button btn_showfurnitures = (Button) findViewById(R.id.id_btn_showfurnitures);
                db = new DatabaseHelper(getApplicationContext());
                btn_showfurnitures.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<addfurniture> allfurnitures = db.getAllFurnitures();
                        if (allfurnitures.size() > 0) {
                            for (addfurniture furniture : allfurnitures) {
                                String s = furniture.getFid() + " " + furniture.getFname() + " " + furniture.getFcolor();
                                sss+=s+"  -  ";
                                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                                show.setText(sss);



                            }
                        }
                    }
                });

                db.closeDB();
        }

}