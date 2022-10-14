package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(holder.itemView.getContext(), "Anda memilih " + listSidang.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
        });
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
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            sidangName = itemView.findViewById(R.id.mahasiswaName);
            sidangDescription = itemView.findViewById(R.id.tv_item_nim);
        }
    }
}