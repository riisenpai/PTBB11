package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListSemdangAdapter extends RecyclerView.Adapter<ListSemdangAdapter.ListViewHolder> {
    private ArrayList<Semdang> listHero;

    public ListSemdangAdapter(ArrayList<Semdang> list) {

        this.listHero = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_semdang, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Semdang hero = listHero.get(position);
        holder.imgPhoto.setImageResource(hero.getPhoto());
        holder.tvName.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class ListViewHolder  extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.Semdangname);
        }
    }
}