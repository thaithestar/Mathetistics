package com.example.thait.mathetistics;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    protected EditText emailEditText, passwordEditText;
    protected Button loginButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.Login);
        signUpButton = (Button) findViewById(R.id.goToSignUp);
        emailEditText = (EditText) findViewById(R.id.email);
        passwordEditText = (EditText) findViewById(R.id.password);

        final Firebase ref = new Firebase(Constants.FIREBASE_URL);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = emailEditText.getText().toString();
                String pass = passwordEditText.getText().toString();

                emailAddress = emailAddress.trim();
                pass = pass.trim();

                if (emailAddress.isEmpty() || pass.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage(R.string.login_error_message)
                            .setTitle(R.string.login_error_title)
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

                else {
                    final String email = emailAddress;

                    //Log in with an email/password combination
                    final String finalPass = pass;
                    ref.authWithPassword(email, pass, new Firebase.AuthResultHandler() {
                        @Override
                        public void onAuthenticated(final AuthData authData) {
                            //Authenticated successfully with payload authData
                            Firebase childbase = ref.child("users").child(authData.getUid()).child("username");
                            final String userID = authData.getUid();
                            childbase.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    String uName = dataSnapshot.getValue(String.class);
                                    if(uName == null){
                                        Map<String, Object> map = new HashMap<String, Object>();
                                        map.put("username","user_str");
                                        map.put("password", finalPass);
                                        map.put("email", email);
                                        map.put("score","0.00");
                                        ref.child("users").child(userID).updateChildren(map);
                                    }
                                }

                                @Override
                                public void onCancelled(FirebaseError firebaseError) {

                                }
                            });



                            Intent log = new Intent(LoginActivity.this, Choice.class);
                            log.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            log.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(log);
                        }

                        @Override
                        public void onAuthenticationError(FirebaseError firebaseError) {
                            //Authenticated failed with error firebaseError
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            builder.setMessage(firebaseError.getMessage())
                                    .setTitle(R.string.login_error_title)
                                    .setPositiveButton(android.R.string.ok, null);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    });

//                    logIn(emailAddress, pass);
//                    Intent log = new Intent(LoginActivity.this, Choice.class);
//                    log.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    log.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(log);
                }

            }
        });

    }
}
