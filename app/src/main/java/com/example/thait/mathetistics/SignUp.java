package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    EditText username, password, email, confpw, confemail;
    String user_str, pass_str, confpw_str, email_str, confemail_str;
    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup = (Button) findViewById(R.id.btn_sign_up);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        confpw = (EditText) findViewById(R.id.confpw);
        confemail = (EditText) findViewById(R.id.confemail);

        signup.setOnClickListener(new View.OnClickListener() {@Override
            public void onClick(View v) {
                user_str = username.getText().toString();
                pass_str = password.getText().toString();
                confpw_str = confpw.getText().toString();
                email_str = email.getText().toString();
                confemail_str = confemail.getText().toString();

                //TODO: check user info is valid

                //TODO: create user object
                User newUser = new User(user_str,pass_str,email_str);
                //TODO: add user to database, then switch views

            }
        });
    }

    //Go to start screen if canceled
    public void cancelClicked(View v) {
        startActivity(new Intent(SignUp.this, MainActivity.class));
    }
}

