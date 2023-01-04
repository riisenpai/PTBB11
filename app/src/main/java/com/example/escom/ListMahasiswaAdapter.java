package com.example.escom;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escom.datamodels.DetailResponse;
import com.example.escom.datamodels.SeminarsItem;
import com.example.escom.datamodels.ThesesItem;

import java.util.ArrayList;
import java.util.List;

public class ListMahasiswaAdapter extends RecyclerView.Adapter<ListMahasiswaAdapter.ListViewHolder> {

    private List<ThesesItem> itemList =  new ArrayList<>();

    public void setItemList(List<ThesesItem> itemList){
        this.itemList = itemList;
        notifyDataSetChanged();
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

    public List<DetailResponse> list = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final ThesesItem mahasiswa = itemList.get(position);

        holder.mahasiswaName.setText(mahasiswa.getStudentName());
        holder.tvDescription.setText(mahasiswa.getStudentNim());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("ID", mahasiswa.getStudentId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
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