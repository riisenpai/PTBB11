package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListSidangAdapter extends RecyclerView.Adapter<ListSidangAdapter.ListViewHolder>{
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
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int position) {
        Sidang sidang = listSidang.get(position);
        holder.imgPhoto.setImageResource(sidang.getPhoto());
        holder.tvName.setText(sidang.getName());
        holder.tvDescription.setText(sidang.getDescription());
    }
    @Override
    public int getItemCount() {
        return listSidang.size();
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
}
