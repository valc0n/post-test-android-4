package com.example.dontwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.time.Clock;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int detik = 0;
    private boolean isBerjalan;
    TextView textTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTime = findViewById(R.id.textTime);


        if(savedInstanceState !=null){
            detik = savedInstanceState.getInt("detik");
            isBerjalan = savedInstanceState.getBoolean("isBerjalan");
        }
        jalaninWaktu();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("detik",detik);
        outState.putBoolean("isBerjalan",isBerjalan);
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ini stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ini start");
        textTime.setText("sedang melanjutkan");
    }

    public void onClickMulai(View view) {
        isBerjalan=true;
    }

    public void onClickBerhenti(View view) {
        isBerjalan=false;
    }

    public void onClickReset(View view) {
        isBerjalan=false;
        detik=0;
    }

    private void jalaninWaktu(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int jam = detik / 3600;
                int menit = (detik%3600)/60;
                int dtk = detik % 60;
                String waktu = String.format(Locale.getDefault(),"%02d:%02d:%02d",jam,menit,dtk);
                textTime.setText(waktu);
                if(isBerjalan){
                    detik++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}