package com.example.hiddenspringsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Type;

public class Counters extends AppCompatActivity {

    private static final String SHARED_PREFERENCES_KEY = "shared_preferences";
    private static final String VAL1 = "val1_key";
    private static final String VAL2 = "val2_key";
    private static final String VAL3 = "val3_key";

    ImageView c1Subtract, c1Add, c2Subtract, c2Add, c3Subtract, c3Add;
    TextView c1Num, c2Num, c3Num;
    int valC1;
    int valC2;
    int valC3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counters);

        c1Subtract = (ImageView) findViewById(R.id.c1SubtractButton);
        c1Add = (ImageView) findViewById(R.id.c1AddButton);
        c2Subtract = (ImageView) findViewById(R.id.c2SubtractButton);
        c2Add = (ImageView) findViewById(R.id.c2AddButton);
        c3Subtract = (ImageView) findViewById(R.id.c3SubtractButton);
        c3Add = (ImageView) findViewById(R.id.c3AddButton);
        c1Num = (TextView) findViewById(R.id.c1NumTV);
        c2Num = (TextView) findViewById(R.id.c2NumTV);
        c3Num = (TextView) findViewById(R.id.c3NumTV);

        loadData();


        c1Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valC1 > 0){valC1 -= 1;}
                setValC1();
                saveData();
            }
        });

        c1Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valC1 += 1;
                setValC1();
                saveData();
            }
        });

        c2Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valC2 > 0){valC2 -= 1;}
                setValC2();
                saveData();
            }
        });

        c2Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valC2 += 1;
                setValC2();
                saveData();
            }
        });

        c3Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valC3 > 0){valC3 -= 1;}
                setValC3();
                saveData();
            }
        });

        c3Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valC3 += 1;
                setValC3();
                saveData();
            }
        });
    }


    public void setValC1() {c1Num.setText("" + valC1);}
    public void setValC2() {c2Num.setText("" + valC2);}
    public void setValC3() {c3Num.setText("" + valC3);}

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(VAL1, valC1);
        editor.putInt(VAL2, valC2);
        editor.putInt(VAL3, valC3);
        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE);
        valC1 = sharedPreferences.getInt(VAL1, 0);
        valC2 = sharedPreferences.getInt(VAL2, 0);
        valC3 = sharedPreferences.getInt(VAL3, 0);
        setValC1();
        setValC2();
        setValC3();
    }
}