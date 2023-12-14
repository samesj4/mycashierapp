package com.bospintar.cashier.adapter;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bospintar.cashier.R; // Replace with your project's R import
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bospintar.cashier.R;
import com.bospintar.cashier.activity.Pengeluaran;
import com.bospintar.cashier.activity.TransaksiDetailActivity;
import com.bospintar.cashier.model.Mpengeluaran;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PengeluaranAdapter extends RecyclerView.Adapter<PengeluaranAdapter.MyViewHolder> {
    private ArrayList<Mpengeluaran> arrayJenis;
    private Context mContext;
    private ArrayList<Mpengeluaran> arraylist;
    private String baru = "";
    private ItemTouchHelper itemTouchHelper;

    static class MyViewHolder extends RecyclerView.ViewHolder {
                TextView txt_tanggal,keterangan,nominal;
        LinearLayout btpindah;



        MyViewHolder(View view) {
            super(view);
                        txt_tanggal = view.findViewById(R.id.txttanggal);
            keterangan = view.findViewById(R.id.txtketerangan);

            nominal = view.findViewById(R.id.txtnominal);
            btpindah = view.findViewById(R.id.btpindah);

        }
    }

    public PengeluaranAdapter(ArrayList<Mpengeluaran> arrayJenis, Context context, RecyclerView recyclerView) {
        this.arrayJenis = arrayJenis;
        this.mContext = context;
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(arrayJenis);

        // Initialize ItemTouchHelper and attach it to your RecyclerView
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();

                // Show confirmation dialog here
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Anda yakin ingin menghapus data ini?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                deleteItem(position,arrayJenis.get(position).getId());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                notifyDataSetChanged(); // Notify to refresh view
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }

            // Override onChildDraw to change text color on swipe
            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                View itemView = viewHolder.itemView;
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    if (dX > 0) {
                        // Swiping to the right (swiping to delete)
                        ((MyViewHolder) viewHolder).keterangan.setTextColor(Color.RED);
                    } else {
                        // Swiping to the left (swiping not to delete)
                        ((MyViewHolder) viewHolder).keterangan.setTextColor(Color.BLACK); // Change text color back to default
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };

        itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView); // Attach ItemTouchHelper to RecyclerView
    }
    public void setItemList(ArrayList<Mpengeluaran> arrayJenis) {
        this.arrayJenis = arrayJenis;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PengeluaranAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_pengeluaran_item, parent, false);
        return new PengeluaranAdapter.MyViewHolder(itemView);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final PengeluaranAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        double amount =Double.parseDouble(arrayJenis.get(position).getNominal());
        DecimalFormat rupiahFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        rupiahFormat.setParseBigDecimal(true);
        rupiahFormat.applyPattern("#,##0");
        String formattedRupiah = rupiahFormat.format(amount);

        holder.txt_tanggal.setText(arrayJenis.get(position).getTanggal());
        holder.keterangan.setText(arrayJenis.get(position).getKeterangan());
        holder.nominal.setText("Rp"+formattedRupiah);

        holder.btpindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        ((Pengeluaran)mContext).onClick(arrayJenis.get(position).getId().toString(),arrayJenis.get(position).getKeterangan().toString(),"Rp"+formattedRupiah);


            }
        });
//        String notes = arrayJenis.get(position).getKeterangan();
//        SpannableStringBuilder sb = new SpannableStringBuilder(notes);
//        Pattern p = Pattern.compile(baru, Pattern.CASE_INSENSITIVE);
//        Matcher m = p.matcher(notes);
//        while (m.find()) {
//            sb.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 0)), m.start(), m.end(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        }
//        holder.keterangan.setText(sb);
    }
    @SuppressLint("SetTextI18n")
//    public void filter(String charText, TextView itemView) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        arrayJenis.clear();
//        if (charText.length() == 0) {
//            arrayJenis.addAll(arraylist);
//            baru = "";
//            itemView.setVisibility(View.GONE);
//        } else {
//            for (Mpengeluaran wp : arraylist) {
//                if (wp.getKeterangan().toLowerCase(Locale.getDefault()).contains(charText)) {
//                    arrayJenis.add(wp);
//                    baru = charText;
//                    itemView.setVisibility(View.GONE);
//                }
//            }
//            if (arrayJenis.isEmpty()) {
//                itemView.setVisibility(View.VISIBLE);
//                itemView.setText("Tidak ada data untuk " + "'" + charText + "'");
//            }
//        }
//        notifyDataSetChanged();
//    }

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
    public void deleteItem(int position,String idpengeluaran) {
        // Remove item at the given position from your data list
        arrayJenis.remove(position);
        // Notify RecyclerView about the item being removed
        notifyItemRemoved(position);
//        Toast.makeText(mContext, idpengeluaran, Toast.LENGTH_SHORT).show();
        ((Pengeluaran)mContext).hapusitem(idpengeluaran);

    }
}