package com.example.thait.mathetistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Rank extends AppCompatActivity {

    TextView display,score_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        display = (TextView)findViewById(R.id.display);
        score_value = (TextView)findViewById(R.id.score_id);
        List<User> top = Compete.topUsers;
        String storedUsername = "";
        String storedScore = "";
        for(int i = 0; i < top.size();i++){
            storedUsername += (i+1) + ". " + top.get(i).getUsername() + "\n";
            storedScore +=  top.get(i).getScore() + "\n";
        }
        display.setText(storedUsername);
        score_value.setText(storedScore);

    }
}
