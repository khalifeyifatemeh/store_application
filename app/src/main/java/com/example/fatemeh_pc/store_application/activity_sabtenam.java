package com.example.fatemeh_pc.store_application;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.EditText;
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


public class activity_sabtenam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabtenam);

        EditText editcname          = (EditText) findViewById(R.id.id_editText_firstname);
        EditText editclastname      = (EditText) findViewById(R.id.id_editText_lastname);
        EditText editcid            = (EditText) findViewById(R.id.id_editText_id);
        EditText editcemail         = (EditText) findViewById(R.id.id_editText_email);
        EditText editcphone         = (EditText) findViewById(R.id.id_editText_phone);
        EditText editcpassword      = (EditText) findViewById(R.id.id_editText_password);
        EditText editcpostalcode    = (EditText) findViewById(R.id.id_editText_postalcode);
        EditText editcaddress       = (EditText) findViewById(R.id.id_editText_address);
        Button   btnsignup          = (Button)   findViewById(R.id.id_btn_signup);

        btnsignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                /*****
                 * insert to database
                *****/

                Intent next = new Intent(activity_sabtenam.this, MainActivity.class);
                startActivity(next);
            }
        });



    }
}
