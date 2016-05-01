package com.example.thait.mathetistics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class SignUp extends AppCompatActivity {
    protected EditText username, password, email, confpw, confemail;
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

        final Firebase ref = new Firebase(Constants.FIREBASE_URL);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                user_str = username.getText().toString();
                pass_str = password.getText().toString();
                confpw_str = confpw.getText().toString();
                email_str = email.getText().toString();
                confemail_str = confemail.getText().toString();

                user_str = user_str.trim();
                pass_str = pass_str.trim();
                confpw_str = confpw_str.trim();
                email_str = email_str.trim();
                confemail_str = confemail_str.trim();

                if (user_str.isEmpty() || pass_str.isEmpty() || email_str.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                    builder.setMessage("Please make sure you enter a username, email address, and password!")
                            .setTitle(R.string.signup_error_title)
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    // Check if info is valid
                    if (user_str != null) {
                        //Check if user info is valid
/*                    if (MainActivity.database.findName(user_str)) {
                        Toast.makeText(getApplicationContext(), "Username already exists!",
                                Toast.LENGTH_SHORT).show();
                    } else if (MainActivity.database.findEmail(email_str)) {
                        Toast.makeText(getApplicationContext(), "Email already exists!",
                                Toast.LENGTH_SHORT).show();
                    } else
*/
                        if (!(pass_str.equals(confpw_str))) {
                            Toast.makeText(getApplicationContext(), "Passwords do not match!",
                                    Toast.LENGTH_SHORT).show();
                        } else if (!(email_str.equals(confemail_str))) {
                            Toast.makeText(getApplicationContext(), "Email addresses do not match!",
                                    Toast.LENGTH_SHORT).show();
                        } else {
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

                            /*
                            //Create user object
                            User newUser = new User(user_str, pass_str, email_str);
                            //Add user to database, then switch views
                            MainActivity.database.insert(newUser);
                            Toast.makeText(getApplicationContext(), "Registration success!",
                                    Toast.LENGTH_SHORT).show();
                            Intent log = new Intent(SignUp.this, MainActivity.class);
                            startActivity(log);
                            */
                        }
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

