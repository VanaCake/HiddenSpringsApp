package com.example.hiddenspringsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriyayParticipantsAdapter extends RecyclerView.Adapter<FriyayParticipantsAdapter.ViewHolder> {
    private ArrayList<FriyayParticipantsItem> particList;
    private Context context;

    public FriyayParticipantsAdapter(ArrayList<FriyayParticipantsItem> particList, Context context) {
        this.particList = particList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.friyayparticipants_item, parent, false);
        ViewHolder evh = new ViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FriyayParticipantsItem currentItem = particList.get(position);
        holder.nameTV.setText(currentItem.getName());

        holder.editButton.setOnClickListener(view -> {
            ((FriyayParticipants) context).removeEvent(position);
        });
    }

    @Override
    public int getItemCount() {
        return particList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        public TextView nameTV;
        public ImageView editButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            nameTV = itemView.findViewById(R.id.friyayParticNameTV);
            editButton = itemView.findViewById(R.id.friyayParticDeleteB);
        }
    }
}
