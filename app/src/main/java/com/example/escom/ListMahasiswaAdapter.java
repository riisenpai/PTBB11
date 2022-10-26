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

public class ListMahasiswaAdapter extends RecyclerView.Adapter<ListMahasiswaAdapter.ListViewHolder> {
    private ArrayList<Mahasiswa> listMahasiswa;

    public ListMahasiswaAdapter(ArrayList<Mahasiswa> list) {
        this.listMahasiswa = list;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswata, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Mahasiswa mahasiswa = listMahasiswa.get(position);
        holder.imgPhoto.setImageResource(mahasiswa.getPhoto());
        holder.mahasiswaName.setText(mahasiswa.getName());
        holder.tvDescription.setText(mahasiswa.getDescription());

        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listMahasiswa.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView mahasiswaName,tvDescription;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            mahasiswaName = itemView.findViewById(R.id.MahasiswaName);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }

    }

    public interface OnItemClickCallback {
        void onItemClicked(Mahasiswa data);
    }
}