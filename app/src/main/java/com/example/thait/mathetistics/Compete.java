package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Compete extends AppCompatActivity {

    TextView username,score;
    public static List<Question> tempQList = MainActivity.database.getQList();
    public static List<Question> QList = new ArrayList<Question>();
    public static double quizScore;

    public void logoutC(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void ranked(View v){
        Intent intent = new Intent(this,Rank.class);
        startActivity(intent);
    }

    public void addQuestion(View v){
        Intent intent = new Intent(this,QRegistration.class);
        startActivity(intent);
    }

    public void Problems(View v){
        long seed = System.nanoTime();
        Collections.shuffle(tempQList, new Random(seed));
        Iterator<Question> itr = tempQList.iterator();
        for(int i =0; i < 6; i++){
            QList.add(itr.next());
        }
        quizScore = 0;
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
