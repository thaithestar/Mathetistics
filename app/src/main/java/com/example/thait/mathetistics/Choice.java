package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Choice extends AppCompatActivity {

    public void logout(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void compete(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void learn(View v){
        Intent intent = new Intent(this,TopicSelection.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }
}
