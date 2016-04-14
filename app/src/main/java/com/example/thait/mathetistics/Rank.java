package com.example.thait.mathetistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Rank extends AppCompatActivity {

    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        display = (TextView)findViewById(R.id.display);
        String[] rankList = MainActivity.database.getRankName();
        String stored = "";
        for(int i = 0; i < rankList.length;i++){
            stored += (i+1) + ". " + rankList[i] + "\n";
        }
        display.setText(stored);

    }
}
