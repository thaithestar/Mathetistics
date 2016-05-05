package com.example.thait.mathetistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Rank extends AppCompatActivity {

    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        display = (TextView)findViewById(R.id.display);
        List<User> top = Compete.topUsers;
        String stored = "";
        for(int i = 0; i < top.size();i++){
            stored += (i+1) + ". " + top.get(i).getUsername() + "\t" +
                        top.get(i).getScore() + "\n";
        }
        display.setText(stored);

    }
}
