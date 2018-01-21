package com.example.fatemeh_pc.store_application;

import android.content.Intent;
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

    String[] furnitur_code = { "1", "2", "3", "4",
            "5", "6", "7", "8" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfurniture_activity);

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

        EditText editfid         = (EditText) findViewById(R.id.id_editText_fid);
        EditText editfname       = (EditText) findViewById(R.id.id_editText_fname);
        EditText editftype       = (EditText) findViewById(R.id.id_editText_ftype);
        EditText editfpirce      = (EditText) findViewById(R.id.id_editText_fprice);
        EditText editfcolor      = (EditText) findViewById(R.id.id_editText_fcolor);
        EditText editffabric     = (EditText) findViewById(R.id.id_editText_ffabric);
        EditText editfwood       = (EditText) findViewById(R.id.id_editText_fwood);
        EditText editfcount      = (EditText) findViewById(R.id.id_editText_fcount);
        EditText editfkosan      = (EditText) findViewById(R.id.id_editText_fkosan);
        EditText editfexist      = (EditText) findViewById(R.id.id_editText_fexist);
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
