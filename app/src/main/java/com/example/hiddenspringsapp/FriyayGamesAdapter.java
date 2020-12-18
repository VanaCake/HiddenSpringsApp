package com.example.hiddenspringsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriyayGamesAdapter extends RecyclerView.Adapter<FriyayGamesAdapter.FriyayGamesViewHolder> {
    private ArrayList<FriyayGamesItem> gamesArrayList;

    public static class FriyayGamesViewHolder extends RecyclerView.ViewHolder {
        public TextView gameName;
        public TextView numPlayers;

        public FriyayGamesViewHolder(@NonNull View itemView) {
            super(itemView);
            gameName = itemView.findViewById(R.id.friyayGamesTV1);
            numPlayers = itemView.findViewById(R.id.friyayGamesTV2);
        }
    }

    public FriyayGamesAdapter(ArrayList<FriyayGamesItem> gamesList) {
        gamesArrayList = gamesList;
    }

    @NonNull
    @Override
    public FriyayGamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.friyaygames_item, parent, false);
        FriyayGamesViewHolder fgViewHolder = new FriyayGamesViewHolder(v);
        return fgViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriyayGamesViewHolder holder, int position) {
        FriyayGamesItem currentItem = gamesArrayList.get(position);

        holder.gameName.setText(currentItem.getGame());
        holder.numPlayers.setText(currentItem.getPlayers());
    }

    @Override
    public int getItemCount() {
        return gamesArrayList.size();
    }
}
