package com.example.hiddenspringsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FriyayGames extends AppCompatActivity {

    RecyclerView gamesListRV;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friyay_games);

        ArrayList<FriyayGamesItem> gameList = new ArrayList<>();
        gameList.add(new FriyayGamesItem("Among Us", "10"));
        gameList.add(new FriyayGamesItem("Apex Legends", "3"));
        gameList.add(new FriyayGamesItem("Dead by Daylight", "5"));
        gameList.add(new FriyayGamesItem("Deceit", "6"));
        gameList.add(new FriyayGamesItem("Garry's Mod", "12"));
        gameList.add(new FriyayGamesItem("Last Year", "6"));
        gameList.add(new FriyayGamesItem("Left 4 Dead 2", "8"));
        gameList.add(new FriyayGamesItem("Minecraft", "12"));
        gameList.add(new FriyayGamesItem("Phasmophobia", "4"));
        gameList.add(new FriyayGamesItem("Skribbl.io", "12"));
        gameList.add(new FriyayGamesItem("Overwatch", "12"));
        gameList.add(new FriyayGamesItem("Uno", "4"));
        gameList.add(new FriyayGamesItem("Valorant", "5"));

        gamesListRV = (RecyclerView) findViewById(R.id.friyayGamesListRV);
        gamesListRV.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new FriyayGamesAdapter(gameList);

        gamesListRV.setLayoutManager(layoutManager);
        gamesListRV.setAdapter(adapter);
    }

}