package com.example.wayangrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListWayangAdapter extends RecyclerView.Adapter<ListWayangAdapter.ListViewHolder> {

    private ArrayList<Wayang> listWayang;

    public ListWayangAdapter(ArrayList<Wayang> list) {

        this.listWayang = list;
    }
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_wayang, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Wayang wayang = listWayang.get(position);

        Glide.with(holder.itemView.getContext())
                .load(wayang.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.tvName.setText(wayang.getName());
        holder.tvDetail.setText(wayang.getDettail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listWayang.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listWayang.size();
    }




    class ListViewHolder extends RecyclerView.ViewHolder {
            ImageView imgPhoto;
            TextView tvName, tvDetail;

            ListViewHolder(View itemView) {
            super(itemView);
                imgPhoto = itemView.findViewById(R.id.img_item_photo);
                tvName = itemView.findViewById(R.id.tv_item_name);
                tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

    public static class OnItemClickCallback {
        public void onItemClicked(Wayang data) {
        }
    }
}
