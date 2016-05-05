package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Directions extends AppCompatActivity {

    public void Problems(View v){
        Compete.QList = new ArrayList<Question>();
        long seed = System.nanoTime();
        if(Compete.tempQList != null) {
            int i = 1;
            Collections.shuffle(Compete.tempQList, new Random(seed));
            Iterator<Question> itr = Compete.tempQList.iterator();
            while(itr.hasNext() && i < 8) {
                Compete.QList.add(itr.next());
                i++;
            }
            Compete.quizScore = 0;
            Intent intent = new Intent(this, Exercise.class);
            startActivity(intent);
        }
    }

    public void cancelClicked(View v) {
        Intent i = new Intent(this, Compete.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);
    }
}
