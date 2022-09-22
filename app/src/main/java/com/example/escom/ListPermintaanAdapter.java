package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListPermintaanAdapter extends RecyclerView.Adapter<ListPermintaanAdapter.ListViewHolder> {
    private ArrayList<Permintaan> listPermintaan;
    public ListPermintaanAdapter(ArrayList<Permintaan> list) {
        this.listPermintaan = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_permintaan, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Permintaan permintaan = listPermintaan.get(position);
        holder.imgPhoto.setImageResource(permintaan.getPhoto());
        holder.permintaanName.setText(permintaan.getName());
    }

    @Override
    public int getItemCount() {
        return listPermintaan.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView permintaanName;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            permintaanName = itemView.findViewById(R.id.tv_item_name);
        }
    }
}