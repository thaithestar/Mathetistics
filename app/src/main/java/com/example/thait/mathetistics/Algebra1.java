package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Algebra1 extends AppCompatActivity {

    public void back2(View view) {
        Intent intent = new Intent(this, TopicSelection.class);
        startActivity(intent);
    }

    public void linear(View view) {
        Intent intent = new Intent(this, LinearEquation.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algebra1);
    }
}
