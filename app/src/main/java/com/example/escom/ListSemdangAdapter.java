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
    private ArrayList<Semdang> listSemdang;
    public ListSemdangAdapter(ArrayList<Semdang> list) {
        this.listSemdang = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_semdang, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Semdang semdang = listSemdang.get(position);
        holder.imgPhoto.setImageResource(semdang .getPhoto());
        holder.semdangName.setText(semdang .getName());
    }

    @Override
    public int getItemCount() {
        return listSemdang.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView semdangName;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            semdangName = itemView.findViewById(R.id.tv_item_name);
        }
    }
}