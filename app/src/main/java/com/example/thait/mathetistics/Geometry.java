package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Geometry extends AppCompatActivity {

    @Override public void onBackPressed(){
        startActivity(new Intent(this,TopicSelection.class));
    }

    public void pt(View v){
        startActivity(new Intent(this,Pt.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometry);
    }
}
