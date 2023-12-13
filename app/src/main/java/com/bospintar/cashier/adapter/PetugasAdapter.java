package com.bospintar.cashier.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bospintar.cashier.R;
import com.bospintar.cashier.model.Mpetugas;

import java.util.ArrayList;

public class PetugasAdapter extends RecyclerView.Adapter<PetugasAdapter.MyViewHolder> {
    private ArrayList<Mpetugas> arrayJenis;
    private Context mContext;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_nm, txt_hrg;
        LinearLayout btpindah;



        MyViewHolder(View view) {
            super(view);
            txt_nm = view.findViewById(R.id.txt_namapegawai);
            txt_hrg = view.findViewById(R.id.txt_level);
            btpindah = view.findViewById(R.id.btpindah);

        }
    }

    public PetugasAdapter(ArrayList<Mpetugas> arrayJenis, Context context) {
        this.arrayJenis = arrayJenis;
        this.mContext = context;
    }

    @NonNull
    @Override
    public PetugasAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_petugas_item, parent, false);
        return new PetugasAdapter.MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final PetugasAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txt_nm.setText(arrayJenis.get(position).getNama());
        holder.txt_hrg.setText(arrayJenis.get(position).getLevel());

        holder.btpindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayJenis.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}