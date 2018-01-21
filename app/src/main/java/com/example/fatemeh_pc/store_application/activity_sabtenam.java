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

        EditText edituname          = (EditText) findViewById(R.id.id_editText_firstname);
        EditText editulastname      = (EditText) findViewById(R.id.id_editText_lastname);
        EditText edituid            = (EditText) findViewById(R.id.id_editText_id);
        EditText edituemail         = (EditText) findViewById(R.id.id_editText_email);
        EditText edituphone         = (EditText) findViewById(R.id.id_editText_phone);
        EditText editupassword      = (EditText) findViewById(R.id.id_editText_password);
        EditText editupostalcode    = (EditText) findViewById(R.id.id_editText_postalcode);
        EditText edituaddress       = (EditText) findViewById(R.id.id_editText_address);
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
