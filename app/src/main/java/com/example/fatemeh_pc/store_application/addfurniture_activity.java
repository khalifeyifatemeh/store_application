package com.example.fatemeh_pc.store_application;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class addfurniture_activity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfurniture_activity);

        db = new DatabaseHelper(getApplicationContext());

        //spinners code
        Spinner sp = (Spinner) findViewById(R.id.id_spinner_furniture);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_dropdown_item_1line,furnitur_code);
        adapter.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long id) {
             Toast.makeText(addfurniture_activity.this, "Entekhab shoma: " + furnitur_code[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        final EditText editfid         = (EditText) findViewById(R.id.id_editText_fid);
        final EditText editfname       = (EditText) findViewById(R.id.id_editText_fname);
        final EditText editftype       = (EditText) findViewById(R.id.id_editText_ftype);
        final EditText editfpirce      = (EditText) findViewById(R.id.id_editText_fprice);
        EditText editfcolor      = (EditText) findViewById(R.id.id_editText_fcolor);
        final EditText editffabric     = (EditText) findViewById(R.id.id_editText_ffabric);
        final EditText editfwood       = (EditText) findViewById(R.id.id_editText_fwood);
        final EditText editfcount      = (EditText) findViewById(R.id.id_editText_fcount);
        final EditText editfkosan      = (EditText) findViewById(R.id.id_editText_fkosan);
        final EditText editfexist      = (EditText) findViewById(R.id.id_editText_fexist);
        EditText editfimage      = (EditText) findViewById(R.id.id_editText_fimage);
        Button btnaddimage       = (Button)   findViewById(R.id.id_btn_addimage);
        Button btnaddfurniture   = (Button)   findViewById(R.id.id_btn_addfurniture);
        Button btneditfurniture  = (Button)   findViewById(R.id.id_btn_editfurniture);
        Button btndeletfurniture = (Button)   findViewById(R.id.id_btn_deletefurniture);


        btnaddimage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                /*****
                 * insert image folder address to database
                 *****/
            }
        });

        btnaddfurniture.setOnClickListener(new View.OnClickListener(){
            public void onClick (View arg0){
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
                    fr.setFcolor(editffabric.getText().toString());
                    fr.setFwood(editfwood.getText().toString());
                    fr.setFcount(editfcount.getText().toString());
                    fr.setFkosan(editfkosan.getText().toString());
                    fr.setFexist(editfexist.getText().toString());

                    db.createFurniture(fr);
                    Toast.makeText(getApplicationContext(), "عملیات موفق", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });

        btneditfurniture.setOnClickListener(new View.OnClickListener(){
            public void onClick (View arg0){
                /*****
                 * update furniture in database
                 *****/
            }
        });

        btndeletfurniture.setOnClickListener(new View.OnClickListener(){
            public void onClick (View arg0){
                /*****
                 * insert furniture to database
                 *****/
            }
        });
    }
}
