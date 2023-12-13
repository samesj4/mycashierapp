package com.bospintar.cashier.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bospintar.cashier.R;
import com.bospintar.cashier.app.AppController;
import com.bospintar.cashier.convert.RupiahTextWatcher;
import com.bospintar.cashier.server.URL_SERVER;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Petugas_Add extends AppCompatActivity {
    String xidpetugas,xnama_petugas,xalamat_petugas,xnohp,xlevel,xidtoko,xnama_toko,xalamat_toko,xstatus_toko,xketnota,xnohp_toko;


    private TextView btnTambahPegawai;
    EditText namapegawai,nohppegawai,alamatpegawai,passwordpegawai;
    public static final String TAG_VALUE = "success";
    String tag_json_obj = "json_obj_req";
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petugas_add);
bacaPreferensi();
        namapegawai = findViewById(R.id.edt_namapegawai);
        nohppegawai = findViewById(R.id.edt_nohppegawai);
        alamatpegawai = findViewById(R.id.edt_email);
        passwordpegawai = findViewById(R.id.edt_password);
        btnTambahPegawai = findViewById(R.id.btsimpan);

        // Setup Button Click Listener
        btnTambahPegawai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahData();
//                int selectedRadioButtonId = radioGroupHakAkses.getCheckedRadioButtonId();
//
//                if (selectedRadioButtonId != -1) {
//                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
//                    String selectedAccessLevel = selectedRadioButton.getText().toString();
//
//                    // Perform the necessary actions based on the selected access level
//                    // (e.g., add employee to the database)
//                    Toast.makeText(Petugas_Add.this, "Tambah Petugas dengan Hak Akses: " + selectedAccessLevel, Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(Petugas_Add.this, "Pilih Hak Akses terlebih dahulu", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
    public void tambahData() {
        pDialog = new ProgressDialog(Petugas_Add.this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Loading...");
        pDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.POST, URL_SERVER.CPETUGASADD, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response: ", response.toString());
                try {
                    JSONObject jObj = new JSONObject(response);
                    int value = jObj.getInt(TAG_VALUE);
                    if (value == 1) {
                        Toast.makeText(Petugas_Add.this, "Sukses", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Petugas_Add.this,Produk.class));
                        finish();

                    } else {
                        Toast.makeText(Petugas_Add.this,"Gagal", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Petugas_Add.this,Produk.class));
                        finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                pDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                VolleyLog.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(Petugas_Add.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                pDialog.dismiss();
            }
        }) {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("idtoko",xidtoko);
                params.put("nama", namapegawai.getText().toString());
                params.put("alamat", alamatpegawai.getText().toString());
                params.put("nohp", nohppegawai.getText().toString());
                params.put("password ", passwordpegawai.getText().toString());


                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }
    private void bacaPreferensi() {

        SharedPreferences pref = getSharedPreferences("akun", MODE_PRIVATE);
        xidpetugas = pref.getString("idpetugas", "0");
        xnama_petugas = pref.getString("nama_petugas", "0");
        xalamat_petugas = pref.getString("alamat_petugas", "0");
        xnohp= pref.getString("nohp", "0");
        xlevel= pref.getString("level", "0");
        xidtoko= pref.getString("idtoko", "0");
        xnama_toko= pref.getString("nama_toko", "0");
        xalamat_toko= pref.getString("alamat_toko", "0");
        xstatus_toko= pref.getString("status_toko", "0");
        xketnota= pref.getString("ketnota", "0");
        xnohp_toko=pref.getString("nohp_toko","0");

    }
}