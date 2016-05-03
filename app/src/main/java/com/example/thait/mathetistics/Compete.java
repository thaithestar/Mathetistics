package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Compete extends AppCompatActivity {

    TextView username,score;
    public static List<Question> tempQList = MainActivity.database.getQList();
    public static List<Question> QList;
    public static double quizScore;
    Firebase ref = new Firebase(Constants.FIREBASE_URL);

    public void logoutC(View v){
        ref.unauth();
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
        QList = new ArrayList<Question>();
        long seed = System.nanoTime();
        Collections.shuffle(tempQList, new Random(seed));
        Iterator<Question> itr = tempQList.iterator();
        for(int i =0; i < 7; i++){
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
        Firebase ref = new Firebase(Constants.FIREBASE_URL);
        Firebase refName = ref.child("users").child(ref.getAuth().getUid()).child("username");
        Firebase refScore = ref.child("users").child(ref.getAuth().getUid()).child("score");
        refScore.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String stringScore = dataSnapshot.getValue(String.class);
                score.setText("High Score: " + stringScore);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.print("Error in Scored");
            }
        });

        refName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String theUsername = dataSnapshot.getValue(String.class);
                username.setText(theUsername);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.print("Error in Username");
            }
        });
    }
}
