package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListPermintaanAdapter extends RecyclerView.Adapter<ListPermintaanAdapter.ListViewHolder>{

    private ArrayList<Permintaan> listPermintaan;

    public ListPermintaanAdapter(ArrayList<Permintaan> list) {
        this.listPermintaan = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListPermintaanAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_permintaan, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Permintaan permintaan = listPermintaan.get(position);
        holder.imgPhoto.setImageResource(permintaan.getPhoto());
        holder.tvName.setText(permintaan.getName());
        holder.tvDescription.setText(permintaan.getDescription());

        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listPermintaan.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listPermintaan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Permintaan data);
    }

}
