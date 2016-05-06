package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Algebra2 extends AppCompatActivity {

    @Override public void onBackPressed(){
        startActivity(new Intent(this,TopicSelection.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algebra2);
    }
}
