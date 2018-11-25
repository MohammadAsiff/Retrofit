package com.example.sys.retrofit2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ReclerAdapter extends RecyclerView.Adapter<ReclerAdapter.HolderClass>{

    Context context;
    ArrayList<DashboardResp.Details> details;
    public ReclerAdapter(SecondScreen secondScreen, ArrayList<DashboardResp.Details> details) {
        context = secondScreen;
        this.details = details;
    }

    @NonNull
    @Override
    public ReclerAdapter.HolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new HolderClass(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderClass holder, int position) {

        Picasso.get().load(details.get(position).getImage()).into(holder.image);
        holder.name.setText(details.get(position).getName());
        holder.lat.setText(details.get(position).getLat());
        holder.lon.setText(details.get(position).getLon());
    }



    @Override
    public int getItemCount() {
        return details.size();
    }

    public class HolderClass extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, lat, lon;

        public HolderClass(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            lat = itemView.findViewById(R.id.lat);
            lon = itemView.findViewById(R.id.lon);
        }


    }
}
