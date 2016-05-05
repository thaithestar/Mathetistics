package com.example.thait.mathetistics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
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
    int timeLeft;

    //TODO: add cancel button to game

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        q = (TextView) findViewById(R.id.textq);
        ans1 = (TextView) findViewById(R.id.ans1);
        ans2 = (TextView) findViewById(R.id.ans2);
        ans3 = (TextView) findViewById(R.id.ans3);
        ans4 = (TextView) findViewById(R.id.ans4);
        rightViewTime = (TextView)findViewById(R.id.rightTime);
        leftViewTime = (TextView)findViewById(R.id.leftTime);
        rightViewTime.setText("15");
        leftViewTime.setText("15");
        final CounterClass timer = new CounterClass(16000,1000);
        timer.start();
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        final Correct frag1 = new Correct();


        if (Compete.QList.size() > 0) {
            final Question randQ = Compete.QList.get(0);
            q.setText(randQ.getQuestion());
            ans1.setText(randQ.getAns1());
            ans2.setText(randQ.getAns2());
            ans3.setText(randQ.getAns3());
            ans4.setText(randQ.getAns4());

            final boolean firstC = randQ.correct(randQ.getAns1());
            final boolean secondC = randQ.correct(randQ.getAns2());
            final boolean thirdC = randQ.correct(randQ.getAns3());
            final boolean fourthC = randQ.correct(randQ.getAns4());

            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeLeft = Integer.parseInt(leftViewTime.getText().toString());
                    timer.cancel();
                    if (firstC) {
                        Compete.quizScore += 1.0 * timeLeft;
                        fragmentTransaction.add(R.id.top,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                    else if(secondC){
                        fragmentTransaction.add(R.id.middle1,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(thirdC){
                        fragmentTransaction.add(R.id.middle2,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(fourthC){
                        fragmentTransaction.add(R.id.last,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                    delayTime();
                    //fragmentTransaction.remove(frag1);
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeLeft = Integer.parseInt(leftViewTime.getText().toString());
                    timer.cancel();
                    if (secondC) {
                        Compete.quizScore += 1.0 * timeLeft;
                        fragmentTransaction.add(R.id.middle1,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(firstC){
                        fragmentTransaction.add(R.id.top,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }else if(thirdC){
                        fragmentTransaction.add(R.id.middle2,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }else if(fourthC){
                        fragmentTransaction.add(R.id.last,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                    delayTime();
                    //fragmentTransaction.remove(frag1);
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ans3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeLeft = Integer.parseInt(leftViewTime.getText().toString());
                    timer.cancel();
                    if (thirdC) {
                        Compete.quizScore += 1.0 * timeLeft;
                        fragmentTransaction.add(R.id.middle2,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(secondC){
                        fragmentTransaction.add(R.id.middle1,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(firstC){
                        fragmentTransaction.add(R.id.top,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(fourthC){
                        fragmentTransaction.add(R.id.last,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                    delayTime();
                    //fragmentTransaction.remove(frag1);
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ans4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeLeft = Integer.parseInt(leftViewTime.getText().toString());
                    timer.cancel();
                    if (fourthC) {
                        Compete.quizScore += 1.0 * timeLeft;
                        fragmentTransaction.add(R.id.last,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }else if(firstC){
                        fragmentTransaction.add(R.id.top,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(secondC){
                        fragmentTransaction.add(R.id.middle1,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(thirdC){
                        fragmentTransaction.add(R.id.middle2,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                    delayTime();
                    //fragmentTransaction.remove(frag1);
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });
        }else{
            timer.cancel();
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
            //System.out.println(hms);
            rightViewTime.setText(hms);
            leftViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            if(Compete.QList.size() > 0) {
                Compete.QList.remove(0);
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        }



    }

    private void delayTime(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },1000);
    }
}


