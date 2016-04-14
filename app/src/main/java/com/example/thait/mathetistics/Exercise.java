package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Exercise extends AppCompatActivity {

    TextView q,ans1,ans2,ans3,ans4,cAns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        q = (TextView) findViewById(R.id.textq);
        ans1 = (TextView) findViewById(R.id.ans1);
        ans2 = (TextView) findViewById(R.id.ans2);
        ans3 = (TextView) findViewById(R.id.ans3);
        ans4 = (TextView) findViewById(R.id.ans4);
        if (Compete.QList.size() > 0) {
            final Question randQ = Compete.QList.get(0);
            q.setText(randQ.getQuestion());
            ans1.setText(randQ.getAns1());
            ans2.setText(randQ.getAns2());
            ans3.setText(randQ.getAns3());
            ans4.setText(randQ.getAns4());

            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (randQ.correct(randQ.getAns1())) {
                        Compete.quizScore += 1.0;
                    }
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (randQ.correct(randQ.getAns2())) {
                        Compete.quizScore += 1.0;
                    }
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ans3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (randQ.correct(randQ.getAns3())) {
                        Compete.quizScore += 1.0;
                    }
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ans4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (randQ.correct(randQ.getAns4())) {
                        Compete.quizScore += 1.0;
                    }
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });
        }else{
            Intent intent = new Intent(this,Scored.class);
            startActivity(intent);
        }
    }
}
