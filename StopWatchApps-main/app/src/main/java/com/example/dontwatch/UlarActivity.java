package com.example.dontwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UlarActivity extends AppCompatActivity {

    CardView[][] penampung = new CardView[4][6];
    Button btnAtas,btnBawah,btnKiri,btnKanan;

    int x=0;
    int y=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ular);
        btnAtas = findViewById(R.id.btnAtas);
        btnBawah = findViewById(R.id.btnBawah);
        btnKiri = findViewById(R.id.btnKiri);
        btnKanan = findViewById(R.id.btnKanan);

        for (int i = 0; i<4;i++){
            for (int j = 0; j<6;j++){
                String nama = "card"+i+j;
                penampung[i][j] = findViewById(getResources().getIdentifier(nama,"id",getPackageName()));
            }
        }

        penampung[0][0].setCardBackgroundColor(Color.BLACK);

        btnBawah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((y<3) && (y>=0)){
                    y=y+1;
                }
                if(penampung[y][x].getCardBackgroundColor().getDefaultColor() == Color.BLACK){
                    penampung[y][x].setCardBackgroundColor(Color.WHITE);
                }else{
                    penampung[y][x].setCardBackgroundColor(Color.BLACK);
                }
            }
        });
        btnKanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((x<5) && (x>=0)){
                    x=x+1;
                }
                if(penampung[y][x].getCardBackgroundColor().getDefaultColor() == Color.BLACK){
                    penampung[y][x].setCardBackgroundColor(Color.WHITE);
                }else{
                    penampung[y][x].setCardBackgroundColor(Color.BLACK);
                }
            }
        });
        btnKiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((x<=5) && (x>0)){
                    x=x-1;
                }
                if(penampung[y][x].getCardBackgroundColor().getDefaultColor() == Color.BLACK){
                    penampung[y][x].setCardBackgroundColor(Color.WHITE);
                }else{
                    penampung[y][x].setCardBackgroundColor(Color.BLACK);
                }
            }
        });
        btnAtas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((y<=3) && (y>0)){
                    y=y-1;
                }
                if(penampung[y][x].getCardBackgroundColor().getDefaultColor() == Color.BLACK){
                    penampung[y][x].setCardBackgroundColor(Color.WHITE);
                }else{
                    penampung[y][x].setCardBackgroundColor(Color.BLACK);
                }
            }
        });
    }
}