package com.example.fatemeh_pc.store_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class product_activity extends AppCompatActivity {


    int[] images={R.drawable.ic_buff,R.drawable.ic_royal,R.drawable.ic_comfort};
    String[] names={"buff","royal","comfort"};
    String[] prices={"200","300","400"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_activity);

        ListView listview=(ListView) findViewById(R.id.id_listviewproduct);
        //CustomAdapter customAdapter=new customAdapter();
        //listview.setAdapter(customAdapter);

        class CustomAdapter extends BaseAdapter{
            @Override
            public int getCount(){
                return images.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                view=getLayoutInflater().inflate(R.layout.custom_layout,null);
                ImageView imageview=(ImageView)view.findViewById(R.id.id_listviewproduct);
                TextView textview_name=(TextView)view.findViewById(R.id.id_textviewname);
                TextView textview_price=(TextView)view.findViewById(R.id.id_textviewprice);

                imageview.setImageResource(images[i]);
                textview_name.setText(names[i]);
                textview_price.setText(prices[i]);

                return view;
            }

        }
    }
}
