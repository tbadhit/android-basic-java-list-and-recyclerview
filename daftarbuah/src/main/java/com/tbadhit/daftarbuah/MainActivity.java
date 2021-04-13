package com.tbadhit.daftarbuah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

// Masukin gambar dlu ke drawable
// Bikin layout "item_row_buah" ->
// Bikin class Adapter "BuahAdapter" ->
public class MainActivity extends AppCompatActivity {

    private RecyclerView rvBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Atur recyclerView
        rvBuah = findViewById(R.id.rv_buah);
        rvBuah.setHasFixedSize(true);
        // LinearLayoutManager = yang bikin menyusuin ke bawah
        rvBuah.setLayoutManager(new LinearLayoutManager(this));

        // Atur data
        String[] namaBuah = {"Alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Strawberry"};
        int[] gambarBuah = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};
        // (Ditambahin)
        int[] musicBuah = {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambu_air, R.raw.manggis, R.raw.strawberry};


        BuahAdapter buahAdapter = new BuahAdapter(namaBuah, gambarBuah, musicBuah);
        rvBuah.setAdapter(buahAdapter);
        // Setelah bikin kode di atas, bikin Option menu
        // Bikin folder resource pilih yang menu ->
        // Bikin file resource di dalam folder menu resource kasi nama "menu_main_activity"


    }

    //Setelah bikin layout menu
    // Panggil layout menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_list) {
            rvBuah.setLayoutManager(new LinearLayoutManager(this));
        }
        if (item.getItemId() == R.id.menu_grid) {
            rvBuah.setLayoutManager(new GridLayoutManager(this, 2));
        }
        return super.onOptionsItemSelected(item);
    }
    //-----------------------------------------------
    // Setalha buat option skrng pergi ke BuahAdapater -> cek yang (1.)
}