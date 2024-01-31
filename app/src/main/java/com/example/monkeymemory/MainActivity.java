package com.example.monkeymemory;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    int[] input = new int[100];
    int loc = 0;
    boolean startRound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRound) {
                    input[loc] = 1;
                    loc++;
                    monkeyMemory();
                }
            }
        });
        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRound) {
                    input[loc] = 2;
                    loc++;
                    monkeyMemory();
                }
            }
        });
        final Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRound) {
                    input[loc] = 3;
                    loc++;
                    monkeyMemory();
                }

            }
        });
        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRound) {
                    input[loc] = 4;
                    loc++;
                    monkeyMemory();
                }

            }
        });
        final Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRound) {
                    input[loc] = 5;
                    loc++;
                    monkeyMemory();
                }

            }
        });
        final Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRound) {
                    input[loc] = 6;
                    loc++;
                    monkeyMemory();
                }

            }
        });
        final Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRound) {
                    input[loc] = 7;
                    loc++;
                    monkeyMemory();
                }

            }
        });
        final Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRound) {
                    input[loc] = 8;
                    loc++;
                    monkeyMemory();
                }

            }
        });
        final Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRound) {
                    input[loc] = 9;
                    loc++;
                    monkeyMemory();
                }

            }
        });
        final Button remember = findViewById(R.id.remember);
        remember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(failed){
                    reset();
                }
                else{
                    startRound();
                }
            }
        });
        startRound = false;
        monkeyMemory();
    }

    private void updateText(String s) {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView combo = findViewById(R.id.combo);
                combo.setText(s);
            }
        });
    }

    private void updateScore(String s) {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView score = findViewById(R.id.score);
                score.setText("Score: "+s);
            }
        });
    }

    public void startRound(){
        startRound = true;
        updateText("");
    }
    public void reset(){
        cont = true;
        failed = false;
        counter = 0;
        ans = new int[100];
        startRound = false;
        loc = 0;
        input = new int[100];
        score = 0;
        monkeyMemory();
    }
    int score = 0;
    int maxNum = 100;
    boolean cont = true;
    boolean failed = false;
    int counter = 0;
    int[] ans = new int[maxNum];
    public void monkeyMemory() {
        if (!failed && !cont) {
            for (int i = 0; i < loc; i++) {
                if (ans[i] != input[i]) {
                    failed = true;
                    updateText("Failed. Click I Remember to start again");
                    break;
                }
                if (loc == counter) {
                    cont = true;
                    startRound = false;
                }
            }
        }

        if (!(counter > maxNum) && cont && !failed) {
            updateScore(Integer.toString(score++));
            input = new int[100];
            loc = 0;
            ans[counter] = (int) (1 + Math.random() * 9);
            counter++;
            cont = false;
            String ansString = "";
            for (int i = 0; i < counter; i++) {
                ansString = ansString + ans[i];
            }
            updateText(ansString);
        }
    }

}