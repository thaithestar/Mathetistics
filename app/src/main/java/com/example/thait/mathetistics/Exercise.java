package com.example.thait.mathetistics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Exercise extends AppCompatActivity {

    Button ans1,ans2,ans3,ans4,cAns, ok;
    TextView rightViewTime,qNum, q;
    int timeLeft;

    @Override public void onBackPressed(){
        android.os.Process.killProcess(android.os.Process.myPid());
        startActivity(new Intent(this,Compete.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        qNum = (TextView) findViewById(R.id.qnum_edit);
        q = (TextView) findViewById(R.id.textq);
        ans1 = (Button) findViewById(R.id.ans1);
        ans2 = (Button) findViewById(R.id.ans2);
        ans3 = (Button) findViewById(R.id.ans3);
        ans4 = (Button) findViewById(R.id.ans4);

//        MediaPlayer mp = MediaPlayer.create(Exercise.this,R.raw.tetris);

        rightViewTime = (TextView)findViewById(R.id.rightTime);
//        leftViewTime = (TextView)findViewById(R.id.leftTime);
        rightViewTime.setText("15");
//        leftViewTime.setText("15");

        qNum.setText("Question " + Compete.nextQ() +"/7");
//        if (Compete.QList.size() == Directions.qSize) {
//            mp.start();
//        }
        final CounterClass timer = new CounterClass(16000,1000);
        timer.start();

        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        final Correct frag1 = new Correct();
        final Incorrect frag2 = new Incorrect();

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
                    timeLeft = Integer.parseInt(rightViewTime.getText().toString());
                    timer.cancel();
                    if (firstC) {
                        Compete.quizScore += 1.0 * timeLeft;
                        fragmentTransaction.add(R.id.exerciseView,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                    else if(secondC){
                        fragmentTransaction.add(R.id.exerciseView, frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(thirdC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(fourthC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                    delayTime();
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeLeft = Integer.parseInt(rightViewTime.getText().toString());
                    timer.cancel();
                    if (secondC) {
                        Compete.quizScore += 1.0 * timeLeft;
                        fragmentTransaction.add(R.id.exerciseView,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(firstC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }else if(thirdC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }else if(fourthC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                    delayTime();
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ans3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeLeft = Integer.parseInt(rightViewTime.getText().toString());
                    timer.cancel();
                    if (thirdC) {
                        Compete.quizScore += 1.0 * timeLeft;
                        fragmentTransaction.add(R.id.exerciseView,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(secondC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(firstC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(fourthC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                    delayTime();
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ans4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeLeft = Integer.parseInt(rightViewTime.getText().toString());
                    timer.cancel();
                    if (fourthC) {
                        Compete.quizScore += 1.0 * timeLeft;
                        fragmentTransaction.add(R.id.exerciseView,frag1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }else if(firstC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(secondC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }else if(thirdC){
                        fragmentTransaction.add(R.id.exerciseView,frag2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                    delayTime();
                    Compete.QList.remove(0);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });
        }else{
            timer.cancel();
            Compete.resetQ();
//            mp.stop();
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
//            leftViewTime.setText(hms);
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


