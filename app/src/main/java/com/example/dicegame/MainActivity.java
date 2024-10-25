package com.example.dicegame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView titleTV, numTV1, numTV2, numTV3, numTV4, numTV5, thisResultTV, gameResultTV, numToss;
    private Button tossBtn, resetBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        titleTV = findViewById(R.id.titleTV);
        numTV1 = findViewById(R.id.numTV1);
        numTV2 = findViewById(R.id.numTV2);
        numTV3 = findViewById(R.id.numTV3);
        numTV4 = findViewById(R.id.numTV4);
        numTV5 = findViewById(R.id.numTV5);
        thisResultTV = findViewById(R.id.thisResultTV);
        gameResultTV = findViewById(R.id.gameResultTV);
        numToss = findViewById(R.id.numToss);
        tossBtn = findViewById(R.id.tossBtn);
        resetBtn = findViewById(R.id.resetBtn);

        tossBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                rollDice();
            }
        });

    }

    public void rollDice(){
        int resultThis = 0;
        int resultGame = 0;
        Random r = new Random();
        int[] tvNum = new int[5];
        for(int i = 0; i < 5; i++){
            tvNum[i] = r.nextInt(6);
        }
        numTV1.setText(tvNum[0]);
        numTV2.setText(tvNum[1]);
        numTV3.setText(tvNum[2]);
        numTV4.setText(tvNum[3]);
        numTV5.setText(tvNum[4]);


        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(tvNum[i] == tvNum[j]){
                    resultThis += tvNum[j];
                }
            }
        }
        thisResultTV.setText(resultThis);

    }
}