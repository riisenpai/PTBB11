package com.example.escom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escom.datamodels.PembimbingResponse;
import com.example.escom.datamodels.ReviewerResponse;
import com.example.escom.datamodels.SeminarsItem;

import java.util.ArrayList;
import java.util.List;

public class ListSemdangAdapter extends RecyclerView.Adapter<ListSemdangAdapter.ListViewHolder> {
    //    private ArrayList<Semdang> listSemdang;
    private List<SeminarsItem> listSemdang = new ArrayList<>();

    public void setListSemdang(List<SeminarsItem> listSemdang) {
        this.listSemdang = listSemdang;
        notifyDataSetChanged();
    }

    public ListSemdangAdapter() {

        this.listSemdang = listSemdang;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_semdang, parent, false);
        return new ListViewHolder(view);
    }

    public List<ReviewerResponse> list = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        SeminarsItem semdang = listSemdang.get(position);

        holder.tvName.setText(semdang.getThesis().getStudent().getName());
        holder.tvDescription.setText(semdang.getThesis().getStudent().getNim());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, SeminarActivity.class);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listSemdang.size();
    }



    public class ListViewHolder  extends RecyclerView.ViewHolder{
        //        ImageView imgPhoto;
        TextView tvName, tvDescription,tvPilihan;

        ListViewHolder(View itemView) {
            super(itemView);
//            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.Semdangname);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Semdang data);
    }
}