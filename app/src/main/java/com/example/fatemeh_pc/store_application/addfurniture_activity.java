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
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;

public class addfurniture_activity extends AppCompatActivity {


    private static int IMG_RESULT = 1;
    String ImageDecode;
    ImageView imageViewLoad;
    Button LoadImage;
    Intent intent;
    String[] FILE;
    DatabaseHelper db;
    ImageView imageview;
    EditText editfimageaddress;

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
        editfimageaddress      = (EditText) findViewById(R.id.id_edittex_imageaddress);
        Button btnaddimage              =(Button)   findViewById(R.id.id_btn_addimage);
        Button btnaddfurniture              =(Button)   findViewById(R.id.id_btn_addfurniture);
        Button btneditfurniture         =(Button)   findViewById(R.id.id_btn_editfurniture);
        Button btndeletfurniture         =(Button)  findViewById(R.id.id_btn_deletefurniture);
        imageview = (ImageView) findViewById(R.id.id_imageview);


        btnaddimage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                /*****
                 * insert image folder address to database
                 *****/
                intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, IMG_RESULT);

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
                    fr.setFcolor(editffabric.getText().toString());
                    fr.setFwood(editfwood.getText().toString());
                    fr.setFcount(editfcount.getText().toString());
                    fr.setFkosan(editfkosan.getText().toString());
                    fr.setFexist(editfexist.getText().toString());
                    fr.setFimageaddress(editfimageaddress.getText().toString());

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

///////codefor pick img from gallery
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == IMG_RESULT && resultCode == RESULT_OK && null != data) {


                String realPath;
                if (Build.VERSION.SDK_INT < 11)
                    realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(this, data.getData());

                    // SDK >= 11 && SDK < 19
                else if (Build.VERSION.SDK_INT < 19)
                    realPath = RealPathUtil.getRealPathFromURI_API11to18(this, data.getData());

                    // SDK > 19 (Android 4.4)
                else
                    realPath = RealPathUtil.getRealPathFromURI_API19(this, data.getData());

                Uri URI = data.getData();
                String[] FILE = {MediaStore.Images.Media.DATA};


                Cursor cursor = getContentResolver().query(URI, FILE, null, null, null);

                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(FILE[0]);
                ImageDecode = cursor.getString(columnIndex);
                cursor.close();

                imageViewLoad.setImageBitmap(BitmapFactory
                        .decodeFile(ImageDecode));

            }
        } catch (Exception e) {
            Toast.makeText(this, "Please try again", Toast.LENGTH_LONG).show();
        }
    }


    private void setTextViews(int sdk, String uriPath,String realPath){

//        this.txtSDK.setText("Build.VERSION.SDK_INT: "+sdk);
//        this.txtUriPath.setText("URI Path: "+uriPath);
        editfimageaddress.setText("realPath");
        Uri uriFromPath = Uri.fromFile(new File(realPath));

        // you have two ways to display selected image

        // ( 1 ) imageView.setImageURI(uriFromPath);

        // ( 2 ) imageView.setImageBitmap(bitmap);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uriFromPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.imageview.setImageBitmap(bitmap);

        Log.d("HMKCODE", "Build.VERSION.SDK_INT:"+sdk);
        Log.d("HMKCODE", "URI Path:"+uriPath);
        Log.d("HMKCODE", "Real Path: "+realPath);
    }

}

