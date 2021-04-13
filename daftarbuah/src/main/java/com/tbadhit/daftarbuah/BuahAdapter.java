package com.tbadhit.daftarbuah;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

// # tambahkan "extends RecyclerView.Adapter<BuahAdapter.MyViewHolder>" kalo merah alt enter aja pokoknya sampe ga merah
public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.MyViewHolder> {

    // 1. create constructor
    // Properti
    String [] namaBuah;
    int [] gambarBuah;
    int [] musicBuah;

    // Buat Constructor
    public BuahAdapter(String[] namaBuah, int[] gambarBuah, int [] musicBuah) {
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
        this.musicBuah = musicBuah;
    }
    //-------------------------------------------------------------

    // 2.
    @NonNull
    @Override
    public BuahAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_buah, parent, false);
        return new MyViewHolder(view);
    }

    // 4. show data
    @Override
    public void onBindViewHolder(@NonNull BuahAdapter.MyViewHolder holder, int position) {
        holder.imgGambarBuah.setImageResource(gambarBuah[position]);
        holder.tvNamaBuah.setText(namaBuah[position]);

        // 1.
        // Setelah membuat options
        Context context = holder.itemView.getContext();

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Anda memilih" + namaBuah[position], Toast.LENGTH_SHORT).show();

            playMusic(context, musicBuah[position]);
            // setelah pasang ini pergi ke "MainActivity" -> (ditambahkan)
        });
        //-------------------
        //Setelah bikin code di atas, bikin folder raw di dalam res, lalu paste mp3 buahnya dalam folder raw
        // Setelah masukin mp3nya bikin method "playMusic" dibawah

    }

    // 5. Menampilkan jumlah list
    // setelah step 5 ke layout activity main tambahkan recyclerView (panggil)
    @Override
    public int getItemCount() {
        return namaBuah.length;
    }

    // 3. call widget
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaBuah;
        ImageView imgGambarBuah;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaBuah = itemView.findViewById(R.id.item_text);
            imgGambarBuah = itemView.findViewById(R.id.item_image);
        }
    }

    // Method musik
    private void playMusic(Context context, int musicBuah) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        Uri uri = Uri.parse("android.resource://" + getClass().getPackage().getName() + "/" + musicBuah);

        try {
            mediaPlayer.setDataSource(context, uri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    // Setelah buat ini tambahkan constructor musikBuah di atas dan pasang method playMusicnya ke holder itemviewnya
}
