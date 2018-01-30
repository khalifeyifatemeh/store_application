package com.example.fatemeh_pc.store_application.Adapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fatemeh_pc.store_application.Model.FURNITURE;
import com.example.fatemeh_pc.store_application.R;
//import com.example.fatemeh_pc.store_application.R;
import java.util.List;
import android.content.res.Resources;



public class FurnituresAdapter extends  RecyclerView.Adapter<FurnituresAdapter.FurnitureViewHolder>
{

    List<FURNITURE> furnitures;

    public FurnituresAdapter(List<FURNITURE> furnitures) {
        this.furnitures = furnitures;
    }


    ////connection of furnitureListrow and furnitureAdapter
    @Override
    public FurnitureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.furniture_list_row,parent,false);
        return new FurnitureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FurnitureViewHolder holder, int position) {
        FURNITURE furn=furnitures.get(position);
        holder.txt_title.setText(furn.getTitle());
        holder.txt_price.setText(furn.getPrice());


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
        CardView cv;
        TextView txt_title;
        TextView txt_price;
        ImageView imageview;

        public FurnitureViewHolder(View itemView) {
            super(itemView);
            cv=(CardView)itemView.findViewById(R.id.id_cardView);
            txt_title=(TextView)itemView.findViewById(R.id.id_txt1);
            txt_price=(TextView)itemView.findViewById(R.id.id_txt2);
            imageview=(ImageView)itemView.findViewById(R.id.imageView);

        }
    }
}
