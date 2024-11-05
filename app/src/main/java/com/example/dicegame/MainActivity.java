package com.example.dicegame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView numTV1, numTV2, numTV3, numTV4, numTV5, thisResultTV, gameResultTV, numToss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        numTV1 = findViewById(R.id.numTV1);
        numTV2 = findViewById(R.id.numTV2);
        numTV3 = findViewById(R.id.numTV3);
        numTV4 = findViewById(R.id.numTV4);
        numTV5 = findViewById(R.id.numTV5);
        thisResultTV = findViewById(R.id.thisResultTV);
        gameResultTV = findViewById(R.id.gameResultTV);
        numToss = findViewById(R.id.numToss);
        Button tossBtn = findViewById(R.id.tossBtn);
        Button resetBtn = findViewById(R.id.resetBtn);


        tossBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int newScore = rollDice();
                updateScore(newScore);
                updateRollCount();
                displayDiceResults(tvNum);
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                resetGame();
            }
        });

    }

    Random r = new Random();
    int tossNum = 0;
    int score = 0;
    int[] tvNum = new int[6];

    private int rollDice(){
        int resultThis = 0;

        tvNum[5] = 7;
        for(int i = 0; i < 5; i++){
            tvNum[i] = r.nextInt(6);
        }


        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                if (tvNum[i] == tvNum[j+1]) {
                    resultThis += tvNum[i]*2;
                }
            }
        }

        thisResultTV.setText("Wynik tego losowania: " + resultThis);
        return resultThis;
    }

    private void resetGame(){
        numTV1.setText(" ? ");
        numTV2.setText(" ? ");
        numTV3.setText(" ? ");
        numTV4.setText(" ? ");
        numTV5.setText(" ? ");
        thisResultTV.setText("Wynik tego losowania: 0");
        gameResultTV.setText("Wynik gry: 0");
        numToss.setText("Liczba rzutów: 0");
    }

    private void updateScore(int newScore){
        score += newScore;
        gameResultTV.setText("Wynik gry: " + score);
    }

    private void updateRollCount(){
        tossNum++;
        numToss.setText("Liczba rzutów: " + tossNum);
    }

    private void displayDiceResults(int[] diceResults){
        numTV1.setText(" " + diceResults[0] + " ");
        numTV2.setText(" " + diceResults[1] + " ");
        numTV3.setText(" " + diceResults[2] + " ");
        numTV4.setText(" " + diceResults[3] + " ");
        numTV5.setText(" " + diceResults[4] + " ");
    }
}