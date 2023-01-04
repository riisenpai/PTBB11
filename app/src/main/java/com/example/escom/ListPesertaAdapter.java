package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escom.datamodels.AudiencesItem;

import java.util.ArrayList;
import java.util.List;

public class ListPesertaAdapter  extends RecyclerView.Adapter<ListPesertaAdapter.ListViewHolder>{
    private List<AudiencesItem> itemList = new ArrayList<>();

    public void setItemList(List<AudiencesItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
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
        AudiencesItem peserta = itemList.get(position);
        holder.tvPeserta.setText(peserta.getName());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
