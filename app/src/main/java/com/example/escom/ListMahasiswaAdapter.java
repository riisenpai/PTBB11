package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListMahasiswaAdapter extends RecyclerView.Adapter<ListMahasiswaAdapter.ListViewHolder> {
    private ArrayList<Mahasiswa> listMahasiswa;
    ItemmahasiswaClick mahasiswata;

    public ListMahasiswaAdapter(ArrayList<Mahasiswa> list) {

        this.listMahasiswa = list;
    }

    public void setListMahasiswa (ItemmahasiswaClick mahasiswata) {
        this.mahasiswata = mahasiswata;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswata, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Mahasiswa mahasiswa = listMahasiswa.get(position);
        holder.imgPhoto.setImageResource(mahasiswa.getPhoto());
        holder.mahasiswaName.setText(mahasiswa.getName());
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        TextView mahasiswaName;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            mahasiswaName = itemView.findViewById(R.id.tv_item_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Mahasiswa mahasiswa = listMahasiswa.get(getAdapterPosition());
            mahasiswata.onItemMahasiswaClick(mahasiswa);
        }
    }
    public interface ItemmahasiswaClick{
        void onItemMahasiswaClick(Mahasiswa mahasiswa);

    }

}