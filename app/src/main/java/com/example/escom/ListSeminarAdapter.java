package com.example.escom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListSeminarAdapter extends RecyclerView.Adapter<ListSeminarAdapter.ListViewHolder> {
    private ArrayList<Seminar> listSeminar;
    public ListSeminarAdapter(ArrayList<Seminar> list) {
        this.listSeminar = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_seminar, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Seminar seminar = listSeminar.get(position);
        holder.imgPhoto.setImageResource(seminar.getPhoto());
        holder.seminarName.setText(seminar.getName());
        holder.seminarDescription.setText(seminar.getDescription());
    }

    @Override
    public int getItemCount() {
        return listSeminar.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView seminarName, seminarDescription;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            seminarName = itemView.findViewById(R.id.tv_item_name);
            seminarDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}