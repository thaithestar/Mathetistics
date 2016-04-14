package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Compete extends AppCompatActivity {

    TextView username,score;


    public void logoutC(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void ranked(View v){
        Intent intent = new Intent(this,Rank.class);
        startActivity(intent);
    }

    public void Problems(View v){
        Intent intent = new Intent(this,Exercise.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compete);
        username = (TextView)findViewById(R.id.textView2);
        score = (TextView)findViewById(R.id.textView3);
        username.setText(MainActivity.getLoginUser());
        score.setText("High Score: " + MainActivity.getUserScore());
    }
}
