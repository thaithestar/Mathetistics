package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TopicSelection extends AppCompatActivity {

    public void backT(View view) {
        Intent intent = new Intent(this, Choice.class);
        startActivity(intent);
    }

    public void quitL(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toAlgebra1(View view) {
        Intent intent = new Intent(this, Algebra1.class);
        startActivity(intent);
    }

    public void toAlgebra2(View view) {
        Intent intent = new Intent(this, Algebra2.class);
        startActivity(intent);
    }

    public void toGeomtry(View view) {
        Intent intent = new Intent(this, Geometry.class);
        startActivity(intent);
    }

    public void toCalculus(View view) {
        Intent intent = new Intent(this, Calculus.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_selection);
    }
}
