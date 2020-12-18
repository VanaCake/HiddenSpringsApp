package com.example.hiddenspringsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventsListAdaptor extends RecyclerView.Adapter<EventsListAdaptor.EventsViewHolder> {
    private ArrayList<EventsListItem> eventsList;
    private Context context;

    public EventsListAdaptor(ArrayList<EventsListItem> eventsList, Context context) {
        this.eventsList = eventsList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventslist_item, parent, false);
        return new EventsListAdaptor.EventsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, final int position) {
        EventsListItem currentItem = eventsList.get(position);
        holder.dateTextView.setText(currentItem.getEventDate());
        holder.nameTextView.setText(currentItem.getEventName());

        holder.deleteButton.setOnClickListener(view -> {
            ((EventsList) context).removeEvent(position);
        });
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    public static class EventsViewHolder extends RecyclerView.ViewHolder {
        View view;
        public TextView dateTextView;
        public TextView nameTextView;
        ImageView deleteButton;

        public EventsViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            dateTextView = itemView.findViewById(R.id.eventsDateTV);
            nameTextView = itemView.findViewById(R.id.eventsNameTV);
            deleteButton = itemView.findViewById(R.id.eventsDeleteB);
        }
    }
}
