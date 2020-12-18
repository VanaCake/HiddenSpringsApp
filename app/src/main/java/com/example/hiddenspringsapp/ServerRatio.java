package com.example.hiddenspringsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ServerRatio extends AppCompatActivity {
    public static final String SHARED_PREFERENCES = "shared_preferences";
    public static final String ONLINE = "online_key";
    public static final String IRL = "irl_key";

    TextView serverRatioTV, irlTV, onlineTV;
    EditText irlFriendsET, onlineFriendsET;
    Button updateRatioB;

    int irlVal;
    int onlineVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_ratio);

        irlFriendsET = (EditText) findViewById(R.id.irlNumET);
        onlineFriendsET = (EditText) findViewById(R.id.onlineNumET);
        updateRatioB = (Button) findViewById(R.id.serverRatioSaveB);
        serverRatioTV = (TextView) findViewById(R.id.serverRatioTV2);
        irlTV = (TextView) findViewById(R.id.metIrlTV2);
        onlineTV = (TextView) findViewById(R.id.metOnlineTV2);

        loadData();


        updateRatioB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irlVal = Integer.parseInt(irlFriendsET.getText().toString());
                onlineVal = Integer.parseInt(onlineFriendsET.getText().toString());
                serverRatioTV.setText(getServerRatio());
                irlTV.setText(irlVal + "");
                onlineTV.setText(onlineVal + "");
                saveData();
            }
        });
    }

    public String getServerRatio() {
        int maxVal = 0;
        if(onlineVal >= irlVal){maxVal = onlineVal;}
        if(irlVal >= onlineVal){maxVal = irlVal;}

        for(int i = maxVal; i >= 1; i--) {
            if (((irlVal % i) == 0) && ((onlineVal % i) == 0)) {
                int temp1 = (irlVal / i);
                int temp2 = (onlineVal / i);
                return " " + temp1 + " irl/ " + temp2 + " online";
            }
        }
        return " " + irlVal + " irl/ " + onlineVal + " online";
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(IRL, irlVal);
        editor.putInt(ONLINE, onlineVal);
        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        irlVal = sharedPreferences.getInt(IRL, 0);
        onlineVal = sharedPreferences.getInt(ONLINE, 0);
        serverRatioTV.setText(getServerRatio());
        irlTV.setText(irlVal + "");
        onlineTV.setText(onlineVal + "");
    }
}
