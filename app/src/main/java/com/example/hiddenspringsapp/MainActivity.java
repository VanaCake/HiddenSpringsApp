package com.example.hiddenspringsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button events_listB, friyay_particB, friyay_gamesB, countersB, server_ratioB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        events_listB = (Button) findViewById(R.id.events_list_button);
        friyay_particB = (Button) findViewById(R.id.friyay_partci_button);
        friyay_gamesB = (Button) findViewById(R.id.friyay_games_button);
        countersB = (Button) findViewById(R.id.counter_button);
        server_ratioB = (Button) findViewById(R.id.server_ratio_button);
    }

    public void goEventsList(View view){
        Intent intent = new Intent(MainActivity.this, EventsList.class);
        startActivity(intent);
    }

    public void goFriyayParticipants(View view){
        Intent intent = new Intent(MainActivity.this, FriyayParticipants.class);
        startActivity(intent);
    }

    public void goFriyayGames(View view){
        Intent intent = new Intent(MainActivity.this, FriyayGames.class);
        startActivity(intent);
    }

    public void goCounters(View view){
        Intent intent = new Intent(MainActivity.this, Counters.class);
        startActivity(intent);
    }

    public void goServerRatio(View view){
        Intent intent = new Intent(MainActivity.this, ServerRatio.class);
        startActivity(intent);
    }
}