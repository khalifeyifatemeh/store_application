package com.example.fatemeh_pc.store_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addfurniture_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfurniture_activity);

        EditText editfid        = (EditText) findViewById(R.id.id_editText_fid);
        EditText editfname      = (EditText) findViewById(R.id.id_editText_fname);
        EditText editftype      = (EditText) findViewById(R.id.id_editText_ftype);
        EditText editfpirce     = (EditText) findViewById(R.id.id_editText_fprice);
        EditText editfcolor     = (EditText) findViewById(R.id.id_editText_fcolor);
        EditText editffabric    = (EditText) findViewById(R.id.id_editText_ffabric);
        EditText editfwood      = (EditText) findViewById(R.id.id_editText_fwood);
        EditText editfcount     = (EditText) findViewById(R.id.id_editText_fcount);
        EditText editfkosan     = (EditText) findViewById(R.id.id_editText_fkosan);
        EditText editfexist     = (EditText) findViewById(R.id.id_editText_fexist);
        EditText editfimage     = (EditText) findViewById(R.id.id_editText_fimage);
        Button btnaddfurniture  = (Button)   findViewById(R.id.id_btn_addfurniture);

        btnaddfurniture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                /*****
                 * insert to database
                 *****/
            }
        });

    }
}
