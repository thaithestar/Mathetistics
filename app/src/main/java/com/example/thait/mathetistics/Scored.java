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

import java.util.Map;

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
        final Firebase ref2 = ref.child("users").child(ref.getAuth().getUid());

        final double newScore = Compete.quizScore;
        score.setText("Score: " + newScore + "/" + (15.0*7.0));

            ref2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Map<String,Object> map = dataSnapshot.getValue(Map.class);
                    double oldScore = Double.parseDouble((String) map.get("score"));
                    String theUsername = (String)map.get("username");
                    username.setText(theUsername);
                    if(newScore > oldScore){
                        congrat.setText("NEW HIGH SCORE!!!\nCONGRATS");
                        map.put("score", newScore +"" );
                        ref2.updateChildren(map);
                    }
                    else{
                        congrat.setText("");
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });



        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scored.this,Compete.class);
                startActivity(intent);
            }
        });

    }
}
