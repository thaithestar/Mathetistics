package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class QRegistration extends AppCompatActivity {

    Button confirm;
    EditText question,ans1,ans2,ans3,ans4,corans;

    public void clickCancel(View view) {
        Intent intent = new Intent(this, Compete.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qregistration);
        final Firebase ref = new Firebase(Constants.FIREBASE_URL);
        confirm = (Button)findViewById(R.id.btn_confirm);
        question = (EditText)findViewById(R.id.question);
        ans1 = (EditText)findViewById(R.id.ans1);
        ans2 = (EditText)findViewById(R.id.ans2);
        ans3 = (EditText)findViewById(R.id.ans3);
        ans4 = (EditText)findViewById(R.id.ans4);
        corans = (EditText)findViewById(R.id.Cans);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String theQ = question.getText().toString();
                final String firstC = ans1.getText().toString();
                final String secondC = ans2.getText().toString();
                final String thirdC = ans3.getText().toString();
                final String fourthC = ans4.getText().toString();
                final String correctC = corans.getText().toString();
                boolean blank1 = firstC.equals("");
                boolean blank2 = secondC.equals("");
                boolean blank3 = thirdC.equals("");
                boolean blank4 = fourthC.equals("");
                boolean blank5 = correctC.equals("");
                boolean blank6 = theQ.equals("");
                boolean firstAns = correctC.equals(firstC);
                boolean sAns = correctC.equals(secondC);
                boolean tAns = correctC.equals(thirdC);
                boolean fourthAns = correctC.equals(fourthC);
                boolean same1 = firstC.equalsIgnoreCase(secondC) || firstC.equalsIgnoreCase(thirdC)
                        || firstC.equalsIgnoreCase(fourthC);
                boolean same2 = secondC.equalsIgnoreCase(thirdC) || secondC.equalsIgnoreCase(fourthC);
                boolean same3 = thirdC.equalsIgnoreCase(fourthC);
                if(blank1 || blank2 || blank3 || blank4 || blank5 || blank6) {
                    Toast.makeText(getApplicationContext(), "Input is empty",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    if (firstAns || sAns || tAns || fourthAns) {
                        if (same1 || same2 || same3) {
                            Toast.makeText(getApplicationContext(), "Answers must be different",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            final Firebase qRef = ref.child("Questions");
                            qRef.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    Map<String,Object> map1 = dataSnapshot.getValue(Map.class);
                                    if(map1 != null){
                                        String name = naming(map1);
                                        Map<String,Object> map2 = new HashMap<String, Object>();
                                        map2.put("ans1",firstC);
                                        map2.put("ans2",secondC);
                                        map2.put("ans3",thirdC);
                                        map2.put("ans4",fourthC);
                                        map2.put("correctAns",correctC);
                                        map2.put("theQuestion",theQ);
                                        qRef.child(name).updateChildren(map2);

                                        Toast.makeText(getApplicationContext(), "Success! Your " +
                                                        "question has been submitted for review.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                    qRef.removeEventListener(this);
                                }

                                @Override
                                public void onCancelled(FirebaseError firebaseError) {

                                }
                            });
                            startActivity(new Intent(QRegistration.this, Compete.class));
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Correct Answer",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private String naming(Map<String,Object> map){
        int i = 1;
        if(map != null){
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                i++;
            }
        }
        return "question" + i;
    }
}
