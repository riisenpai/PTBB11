package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListPesertaAdapter  extends RecyclerView.Adapter<ListPesertaAdapter.ListViewHolder>{
    private ArrayList<Peserta> listPeserta;

    public ListPesertaAdapter(ArrayList<Peserta> list) {
        this.listPeserta = list;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView tvPeserta;

        ListViewHolder(View itemView) {
            super(itemView);
            tvPeserta = itemView.findViewById(R.id.tv_item_name);
        }
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_peserta, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Peserta peserta = listPeserta.get(position);
        holder.tvPeserta.setText(peserta.getPeserta());
    }

    @Override
    public int getItemCount() {
        return listPeserta.size();
    }
}
