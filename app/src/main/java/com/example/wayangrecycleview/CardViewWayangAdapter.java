package com.example.wayangrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewWayangAdapter extends RecyclerView.Adapter<CardViewWayangAdapter.CardViewViewHolder>{
    private ArrayList<Wayang> listWayang;

    public CardViewWayangAdapter(ArrayList<Wayang> list){
        this.listWayang = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_wayang, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        Wayang wayang = listWayang.get(position);

        Glide.with(holder.itemView.getContext())
                .load(wayang.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(wayang.getName());
        holder.tvDetail.setText(wayang.getDettail());

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite " +
                        listWayang.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Share " +
                        listWayang.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih" + listWayang.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
        @Override
        public int getItemCount(){
            return listWayang.size();
        }

        class CardViewViewHolder extends RecyclerView.ViewHolder {
            ImageView imgPhoto;
            TextView tvName, tvDetail;
            Button btnFavorite, btnShare;

            CardViewViewHolder(View itemView) {
                super(itemView);
                imgPhoto = itemView.findViewById(R.id.img_item_photo);
                tvName = itemView.findViewById(R.id.tv_item_name);
                tvDetail = itemView.findViewById(R.id.tv_item_detail);
                btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
                btnShare = itemView.findViewById(R.id.btn_set_share);
            }
        }
    }
