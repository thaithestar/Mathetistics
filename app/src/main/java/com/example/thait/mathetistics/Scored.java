package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

public class Scored extends AppCompatActivity {
    double userScored = Compete.quizScore;
    TextView username,score,congrat;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scored);
        username = (TextView)findViewById(R.id.theName);
        congrat = (TextView)findViewById(R.id.gratz);
        score = (TextView)findViewById(R.id.theScore);
        finish = (Button)findViewById(R.id.doneB);
        final double[] userScore = new double[1];
        final Firebase ref = new Firebase(Constants.FIREBASE_URL);
        Firebase refName = ref.child("users").child(ref.getAuth().getUid()).child("username");
        Firebase refScore = ref.child("users").child(ref.getAuth().getUid()).child("score");
        refScore.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String stringScore = dataSnapshot.getValue(String.class);
                double oldS = Double.parseDouble(stringScore);
                userScore[0] = oldS;
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

        final double newScore = Compete.quizScore;
        score.setText("Score: " + newScore + "/" + (15.0*7.0));
        if(newScore > userScore[0]){
            congrat.setText("NEW HIGH SCORE!!!\nCONGRATS");
        }
        else{
            congrat.setText("");
        }

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userScore[0] < newScore){
                    String userLogin = MainActivity.getLoginUser();
                    MainActivity.database.updateScore(userLogin,newScore);
                    MainActivity.setUserScore(newScore);
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            User myUser = dataSnapshot.getValue(User.class);
                            User tempUser = myUser;
                            tempUser.setScore(newScore);
                            ref.setValue(tempUser);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }
                Intent intent = new Intent(Scored.this,Compete.class);
                startActivity(intent);
            }
        });

    }
}
