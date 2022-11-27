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

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_semdang, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Semdang semdang = listSemdang.get(position);
        holder.imgPhoto.setImageResource(semdang.getPhoto());
        holder.tvName.setText(semdang.getName());
        holder.tvDescription.setText(semdang.getDescription());

        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listSemdang.get(holder.getAdapterPosition())));

    }

    @Override
    public int getItemCount() {
        return listSemdang.size();
    }

    public class ListViewHolder  extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvDescription,tvPilihan;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.Semdangname);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Semdang data);
    }
}