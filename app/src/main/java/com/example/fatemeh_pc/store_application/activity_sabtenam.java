package com.example.fatemeh_pc.store_application;

import android.database.SQLException;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
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

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabtenam);

        db = new DatabaseHelper(getApplicationContext());

        final EditText edituname = (EditText) findViewById(R.id.id_editText_firstname);
        final EditText editulastname = (EditText) findViewById(R.id.id_editText_lastname);
        final EditText edituemail = (EditText) findViewById(R.id.id_editText_email);
        final EditText edituphone = (EditText) findViewById(R.id.id_editText_phone);
        final EditText editupassword = (EditText) findViewById(R.id.id_editText_password);
        final EditText editupostalcode = (EditText) findViewById(R.id.id_editText_postalcode);
        final EditText edituaddress = (EditText) findViewById(R.id.id_editText_address);
        Button btnsignup = (Button) findViewById(R.id.id_btn_signup);
        Button btn_testtest = (Button) findViewById(R.id.id_btn_testtest);


/////////////////////////////////
        btnsignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    adduser user = new adduser();
                    user.setUname(edituname.getText().toString());
                    user.setUlastname(editulastname.getText().toString());
                    user.setUemail(edituemail.getText().toString());
                    user.setUphone(edituphone.getText().toString());
                    user.setUpassword(editupassword.getText().toString());
                    user.setUpostalcode(editupostalcode.getText().toString());
                    user.setUaddress(edituaddress.getText().toString());

                    db.createUser(user);
                    Toast.makeText(getApplicationContext(), "عملیات موفق", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });

        btn_testtest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next = new Intent(activity_sabtenam.this, test_of_db.class);
                startActivity(next);
            }
        });

        db.closeDB();
    }
}
