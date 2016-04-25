package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QRegistration extends AppCompatActivity {

    Button confirm,cancel;
    EditText question,ans1,ans2,ans3,ans4,corans;

    public void clickCancel(View view) {
        Intent intent = new Intent(this, Compete.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qregistration);

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
                String theQ = question.getText().toString();
                String firstC = ans1.getText().toString();
                String secondC = ans2.getText().toString();
                String thirdC = ans3.getText().toString();
                String fourthC = ans4.getText().toString();
                String correctC = corans.getText().toString();
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
                            Toast.makeText(getApplicationContext(), "Repetitive Choices",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Question q = new Question(theQ, firstC, secondC, thirdC, fourthC, correctC);
                            MainActivity.database.addQ(q);
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
}
