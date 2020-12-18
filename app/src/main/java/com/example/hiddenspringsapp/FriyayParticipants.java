package com.example.hiddenspringsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class FriyayParticipants extends AppCompatActivity {
    private static final String SHARED_PREFERENCES_KEY = "shared_preferences";
    private static final String FRIYAY_PARTICIPANTS_JSON = "friyay_participants_key";
    RecyclerView fpRV;
    RecyclerView.Adapter fpAdapter;
    RecyclerView.LayoutManager fpLayoutManager;
    ArrayList<FriyayParticipantsItem> participants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friyay_participants);

        loadEvents();

        fpRV = (RecyclerView) findViewById(R.id.friyayParticRV);
        fpRV.setHasFixedSize(true);

        fpLayoutManager = new LinearLayoutManager(this);
        fpRV.setLayoutManager(fpLayoutManager);

        fpAdapter = new FriyayParticipantsAdapter(participants, this);
        fpRV.setAdapter(fpAdapter);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, LinearLayout.VERTICAL);
        fpRV.addItemDecoration(decoration);
    }

    private void loadEvents() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
        String friyayParticJson = sharedPreferences.getString(FRIYAY_PARTICIPANTS_JSON, null);
        Type type = new TypeToken<ArrayList<FriyayParticipantsItem>>(){}.getType();
        Gson gson = new Gson();
        participants = gson.fromJson(friyayParticJson, type);
        if(participants == null) participants = new ArrayList<FriyayParticipantsItem>();
    }

    @Override
    protected void onPause() {super.onPause();}

    public void addEvent(View view){
        EditText nameEditText = (EditText) findViewById(R.id.friyayParticNameET);
        String name = nameEditText.getText().toString();
        participants.add(new FriyayParticipantsItem(name));
        fpAdapter.notifyDataSetChanged();
        saveEvents();
    }

    private void saveEvents() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String friyayParticJson = gson.toJson(participants);
        editor.putString(FRIYAY_PARTICIPANTS_JSON, friyayParticJson);
        editor.apply();
    }

    public void removeEvent(int position){
        fpAdapter.notifyItemRemoved(position);
        participants.remove(position);
        saveEvents();
    }
}