package com.example.fatemeh_pc.store_application.Adapter;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.app.Activity;
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
import android.widget.ViewFlipper;
import java.util.ArrayList;
import com.example.fatemeh_pc.store_application.LoadProducts;
import com.example.fatemeh_pc.store_application.MainActivity;
import com.example.fatemeh_pc.store_application.Model.FURNITURE;
import com.example.fatemeh_pc.store_application.R;
import com.example.fatemeh_pc.store_application.product_profile;
//import com.example.fatemeh_pc.store_application.R;
import java.util.List;
import android.content.res.Resources;
import android.widget.Toast;


public class FurnituresAdapter extends  RecyclerView.Adapter<FurnituresAdapter.FurnitureViewHolder>
{
    Context mcontex;
    List<FURNITURE> furnitures;
    public static  String furniture_Id;

    public FurnituresAdapter(List<FURNITURE> furnitures, Context mcontex) {
        this.furnitures = furnitures;
        this.mcontex = mcontex;
    }

    public FurnituresAdapter(List<FURNITURE> furnitures, Application application) {
        this.furnitures = furnitures;
    }


    ////connection of furnitureListrow and furnitureAdapter
    @Override
    public FurnitureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.furniture_list_row,parent,false);
        return new FurnitureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FurnitureViewHolder holder, final int position) {
        final FURNITURE furn=furnitures.get(position);
        holder.txt_title.setText(furn.getTitle());
        holder.txt_Id.setText(furn.getId());
        holder.imageview.setImageResource(furn.getImgid());

        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                furniture_Id=furn.getId();
                Toast.makeText(mcontex,position+"",Toast.LENGTH_LONG).show();
                final Intent next = new Intent(mcontex, product_profile.class);
                mcontex.startActivity(next);
            }


        });


    }


    @Override
    public int getItemCount() {

        return furnitures.size();
    }
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//    }

//    // Insert a new item to the RecyclerView on a predefined position
//    public void insert(int position, Data data) {
//        list.add(position, data);
//        notifyItemInserted(position);
//    }
//// Remove a RecyclerView item containing a specified Data object
//            public void remove(Data data) {
//                 int position = list.indexOf(data);
//                list.remove(position);
//                notifyItemRemoved(position);
//}


    public  class FurnitureViewHolder extends RecyclerView.ViewHolder
    {
        public CardView cv;
        public TextView txt_title;
        public TextView txt_Id;
        public ImageView imageview;
        public RelativeLayout relative;


        public FurnitureViewHolder(View itemView) {
            super(itemView);
            mcontex = itemView.getContext();
            cv=(CardView)itemView.findViewById(R.id.id_cardView);
            txt_title=(TextView)itemView.findViewById(R.id.id_txt1);
            txt_Id=(TextView)itemView.findViewById(R.id.id_txt2);
            imageview=(ImageView)itemView.findViewById(R.id.imageView);
            relative=(RelativeLayout)itemView.findViewById(R.id.id_rltv);

        }
    }
}
