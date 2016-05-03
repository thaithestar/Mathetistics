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

import java.util.Map;

public class Choice extends AppCompatActivity {

    TextView username;
    private Firebase ref = new Firebase(Constants.FIREBASE_URL);

    public void logout(View v){
        ref.unauth();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
//        Intent intent = new Intent(this,MainActivity.class);
//        startActivity(intent);
    }

    public void compete(View v){
        Intent intent = new Intent(this,Compete.class);
        startActivity(intent);
    }

    public void learn(View v){
        Intent intent = new Intent(this,TopicSelection.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        username = (TextView)findViewById(R.id.textView2);
        Firebase ref = new Firebase(Constants.FIREBASE_URL);
        Firebase userRef = ref.child("users").child(ref.getAuth().getUid());
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,Object> map = dataSnapshot.getValue(Map.class);
                String theUsername = (String)map.get("username");
                username.setText("Welcome " + theUsername);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
