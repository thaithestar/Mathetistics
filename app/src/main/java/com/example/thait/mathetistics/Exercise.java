package com.example.thait.mathetistics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Exercise extends AppCompatActivity {

    TextView q,ans1,ans2,ans3,ans4,cAns;
    TextView rightViewTime,leftViewTime;
    TextView lastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        q = (TextView) findViewById(R.id.textq);
        ans1 = (TextView) findViewById(R.id.ans1);
        ans2 = (TextView) findViewById(R.id.ans2);
        ans3 = (TextView) findViewById(R.id.ans3);
        ans4 = (TextView) findViewById(R.id.ans4);
        lastTime = (TextView)findViewById(R.id.curTime);
        rightViewTime = (TextView)findViewById(R.id.rightTime);
        leftViewTime = (TextView)findViewById(R.id.leftTime);
        rightViewTime.setText("15");
        leftViewTime.setText("15");
        final CounterClass timer = new CounterClass(15000,1000);
        timer.start();
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
                    try {
                        timer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lastTime.setText(timer.toString());
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
                    try {
                        timer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lastTime.setText(timer.toString());
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
                    try {
                        timer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (randQ.correct(randQ.getAns3())) {
                        Compete.quizScore += 1.0;
                    }
                    lastTime.setText(timer.toString());
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ans4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        timer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lastTime.setText(timer.toString());
                    lastTime.setText(timer.toString());
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


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub
            long millis = millisUntilFinished;
            String hms = String.format("%02d",TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            rightViewTime.setText(hms);
            leftViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            Compete.QList.remove(0);
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }



    }
}


