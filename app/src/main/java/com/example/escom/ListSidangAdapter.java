package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListSidangAdapter extends RecyclerView.Adapter<ListSidangAdapter.ListViewHolder> {
    private ArrayList<Sidang> listSidang;
    public ListSidangAdapter(ArrayList<Sidang> list) {
        this.listSidang = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_sidang, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Sidang sidang = listSidang.get(position);
        holder.imgPhoto.setImageResource(sidang.getPhoto());
        holder.sidangName.setText(sidang.getName());
        holder.sidangDescription.setText(sidang.getDescription());
    }

    @Override
    public int getItemCount() {
        return listSidang.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView sidangName, sidangDescription;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            sidangName = itemView.findViewById(R.id.tv_item_name);
            sidangDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}