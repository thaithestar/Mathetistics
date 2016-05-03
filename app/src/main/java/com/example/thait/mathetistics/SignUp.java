package com.example.thait.mathetistics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    protected EditText password, email, confpw;
    String pass_str, confpw_str, email_str;
    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup = (Button) findViewById(R.id.btn_sign_up);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        confpw = (EditText) findViewById(R.id.confpw);

        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        confpw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);


        final Firebase ref = new Firebase(Constants.FIREBASE_URL);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                email_str = email.getText().toString();
                pass_str = password.getText().toString();
                confpw_str = confpw.getText().toString();


                email_str = email_str.trim();
                pass_str = pass_str.trim();
                confpw_str = confpw_str.trim();

                if (pass_str.isEmpty() || email_str.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                    builder.setMessage("Please make sure you enter a username, email address, and password!")
                            .setTitle(R.string.signup_error_title)
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {

                        if (!(pass_str.equals(confpw_str))) {
                            Toast.makeText(getApplicationContext(), "Passwords do not match!",
                                    Toast.LENGTH_SHORT).show();
                        }else {
                            // Create a new user
                            ref.createUser(email_str, pass_str, new Firebase.ResultHandler() {
                                @Override
                                public void onSuccess() {

                                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                                    builder.setMessage(R.string.signup_success)
                                            .setPositiveButton(R.string.login_button_label,
                                                    new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Intent intent = new Intent(SignUp.this, MainActivity.class);
                                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                            startActivity(intent);
                                                        }
                                                    });
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }

                                @Override
                                public void onError(FirebaseError firebaseError) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                                    builder.setMessage(firebaseError.getMessage())
                                            .setTitle(R.string.signup_error_title)
                                            .setPositiveButton(android.R.string.ok, null);
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }
                            });
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

