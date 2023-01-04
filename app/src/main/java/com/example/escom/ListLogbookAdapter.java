package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.escom.datamodels.LogbooksItem;
import com.example.escom.datamodels.PermintaanItem;

import java.util.ArrayList;
import java.util.List;

public class ListLogbookAdapter  extends RecyclerView.Adapter<ListLogbookAdapter.ListViewHolder>{
    private List<LogbooksItem> logbook = new ArrayList<>();

    public void setListLogbook(List<LogbooksItem> logbook){
        this.logbook = logbook;
        notifyDataSetChanged();

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
//        Logbook logbook = listLogbook.get(position);
//        holder.tvTgl.setText(logbook.getTglLogbook());
//        holder.tvKegiatan.setText(logbook.getKegiatanLogbook());

        LogbooksItem logbookList = logbook.get(position);
        holder.tvTgl.setText(logbookList.getDate());
        holder.tvKegiatan.setText(logbookList.getProgress());

//        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listPermintaan.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {

        return logbook.size();
    }
}
