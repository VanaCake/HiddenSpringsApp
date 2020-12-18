package com.example.hiddenspringsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class EventsList extends AppCompatActivity {
    private static final String SHARED_PREFERENCES_KEY = "shared_preferences";
    private static final String EVENT_LIST_JSON = "event_list_key";

    RecyclerView eventsListRV;
    RecyclerView.Adapter eventsAdapter;
    RecyclerView.LayoutManager eventsLayoutManager;
    ArrayList<EventsListItem> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);

        loadEvents();

        eventsListRV = (RecyclerView) findViewById(R.id.eventsListRV);
        eventsListRV.setHasFixedSize(true);

        eventsLayoutManager = new LinearLayoutManager(this);
        eventsAdapter = new EventsListAdaptor(events, this);

        eventsListRV.setLayoutManager(eventsLayoutManager);
        eventsListRV.setAdapter(eventsAdapter);

        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, LinearLayout.VERTICAL);
        eventsListRV.addItemDecoration(decoration);
    }

    public void loadEvents(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE);
        String eventListJson = sharedPreferences.getString(EVENT_LIST_JSON, null);
        Type type = new TypeToken<ArrayList<EventsListItem>>(){}.getType();
        Gson gson = new Gson();
        events = gson.fromJson(eventListJson, type);
        if(events == null) events = new ArrayList<EventsListItem>();
    }

    @Override
    protected void onPause() {super.onPause();}

    public void addEvents(View v){
        EditText eventsListNameET = (EditText) findViewById(R.id.eventNameET);
        EditText eventsListDateET = (EditText) findViewById(R.id.dateET);
        String date = eventsListDateET.getText().toString();
        String eventName = eventsListNameET.getText().toString();
        events.add(new EventsListItem(date, eventName));
        eventsAdapter.notifyDataSetChanged();
        saveEvents();
    }

    public void saveEvents(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String eventListJson = gson.toJson(events);
        editor.putString(EVENT_LIST_JSON, eventListJson);
        editor.apply();
    }

    public void removeEvent(int position){
        eventsAdapter.notifyItemRemoved(position);
        events.remove(position);
        saveEvents();
    }

    public void setEvent(int position, String name, String date){
        events.set(position, new EventsListItem(name, date));
    }
}