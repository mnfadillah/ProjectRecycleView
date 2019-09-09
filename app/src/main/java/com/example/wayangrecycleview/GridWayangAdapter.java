package com.example.wayangrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridWayangAdapter extends RecyclerView.Adapter<GridWayangAdapter.GridViewHolder> {
    private ArrayList<Wayang> listWayang;

    public GridWayangAdapter(ArrayList<Wayang> list) {
        this.listWayang = list;
    }
    private ListWayangAdapter.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(ListWayangAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_wayang, viewGroup, false);
        return new GridViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listWayang.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listWayang.size();
    }
    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

         GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }

}