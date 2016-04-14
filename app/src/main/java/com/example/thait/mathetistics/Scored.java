package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Scored extends AppCompatActivity {
    double userScored = Compete.quizScore;
    TextView username,score;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scored);
        username = (TextView)findViewById(R.id.theName);
        score = (TextView)findViewById(R.id.theScore);
        finish = (Button)findViewById(R.id.doneB);
        username.setText(MainActivity.getLoginUser());
        score.setText("Score: " + Compete.quizScore);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.getUserScore() < Compete.quizScore){
                    MainActivity.getLoginUser();
                    //MainActivity.database.insert();

                }
                Intent intent = new Intent(Scored.this,Compete.class);
                startActivity(intent);
            }
        });

    }
}
