package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListLogbookAdapter  extends RecyclerView.Adapter<ListLogbookAdapter.ListViewHolder>{
    private ArrayList<Logbook> listLogbook;

    public ListLogbookAdapter(ArrayList<Logbook> list) {
        this.listLogbook = list;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvTgl, tvKegiatan;

        ListViewHolder(View itemView) {
            super(itemView);
            tvTgl = itemView.findViewById(R.id.tv_item_name);
            tvKegiatan = itemView.findViewById(R.id.tv_item_description);
        }
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_logbook, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Logbook logbook = listLogbook.get(position);
        holder.tvTgl.setText(logbook.getTglLogbook());
        holder.tvKegiatan.setText(logbook.getKegiatanLogbook());
    }

    @Override
    public int getItemCount() {
        return listLogbook.size();
    }
}
