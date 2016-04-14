package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                if (user_str != null) {
                    //Check if user info is valid
                    if (MainActivity.database.findName(user_str) == true) {
                        Toast.makeText(getApplicationContext(), "Username already exists!",
                                Toast.LENGTH_SHORT).show();
                    } else if (MainActivity.database.findEmail(email_str) == true) {
                        Toast.makeText(getApplicationContext(), "Email already exists!",
                                Toast.LENGTH_SHORT).show();
                    } else if ((pass_str.equals(confpw_str)) == false) {
                        Toast.makeText(getApplicationContext(), "Passwords do not match!",
                                Toast.LENGTH_SHORT).show();
                    } else if ((email_str.equals(confemail_str)) == false) {
                        Toast.makeText(getApplicationContext(), "Email addresses do not match!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        //Create user object
                        User newUser = new User(user_str, pass_str, email_str);
                        //Add user to database, then switch views
                        MainActivity.database.insert(newUser);
                        Intent log = new Intent(SignUp.this, Choice.class);
                        startActivity(log);
                    }
                }
            }
        });
    }

    //Go to start screen if canceled
    public void cancelClicked(View v) {
        startActivity(new Intent(SignUp.this, MainActivity.class));
    }
}

