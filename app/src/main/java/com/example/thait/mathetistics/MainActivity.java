package com.example.thait.mathetistics;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.firebase.client.Firebase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static Database database = new Database();
//    Button login;
//    EditText email, passwords;
    private static String loginUser;
    private static double userScore;
    private Firebase mRef;
    private String mUserId;


    public void register(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public boolean read() {

        BufferedReader br = null;

        try {

            String sCurrentLine;
            InputStream iS = this.getResources().getAssets().open("Alg1.txt");
            br = new BufferedReader(new InputStreamReader(iS));
            String[] qArray = new String[6];
            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) {

                qArray[i] = sCurrentLine;
                i++;
                if (i == 6) {
                    Question tempQ = new Question(qArray[0], qArray[1], qArray[2],
                            qArray[3], qArray[4], qArray[5]);
                    database.addQ(tempQ);
                    i = 0;
                }

            }
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!read()) {
            System.exit(-1);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (database.getUList().size() == 0) {
            database.examples();
        }

        // Check authentication
        mRef = new Firebase(Constants.FIREBASE_URL);
        if (mRef.getAuth() == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

//            login = (Button) findViewById(R.id.Login);
//            email = (EditText) findViewById(R.id.username);
//            passwords = (EditText) findViewById(R.id.password);
//
//            //final Firebase ref = new Firebase(Constants.FIREBASE_URL);
//
////            if (database.getUList().size() == 0) {
////                database.examples();
////            }
//            login.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String emailAddress = email.getText().toString();
//                    String pass = passwords.getText().toString();
//
//                    emailAddress = emailAddress.trim();
//                    pass = pass.trim();
//
//                    if (emailAddress.isEmpty() || pass.isEmpty()) {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                        builder.setMessage("Please make sure you enter an email address and password!")
//                                .setTitle("Error!")
//                                .setPositiveButton(android.R.string.ok, null);
//                        AlertDialog dialog = builder.create();
//                        dialog.show();
//                    }
//
//                    else {
//                        logIn(emailAddress, pass);
//                        Intent log = new Intent(MainActivity.this, Choice.class);
//                        log.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        log.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        startActivity(log);
//
//                        final String email = emailAddress;
//                        //Login with an username/password combination
//                        ref.authWithPassword(email, pass, new Firebase.AuthResultHandler() {
//                            @Override
//                            public void onAuthenticated(AuthData authData) {
//                                Map<String, Object> map = new HashMap<String, Object>();
//                                map.put("Email", email);
//                                ref.child("users").child(authData.getUid()).setValue(map);
//
//                                Intent log = new Intent(MainActivity.this, Choice.class);
//                                log.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                log.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                startActivity(log);
//                            }
//
//                            @Override
//                            public void onAuthenticationError(FirebaseError firebaseError) {
//                                // Authenticated failed with error firebaseError
//                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                                builder.setMessage(firebaseError.getMessage())
//                                        .setTitle(R.string.login_error_title)
//                                        .setPositiveButton(android.R.string.ok, null);
//                                AlertDialog dialog = builder.create();
//                                dialog.show();
//                            }
//                        });
//
//                        User myUser = database.getUser(name);
//                        if (myUser != null) {
//                            if (myUser.getPassword().equals(pass)) {
//                                loginUser = myUser.getUsername();
//                                userScore = myUser.getScore();
//                                startActivity(log);
//                            } else {
//                                Toast.makeText(getApplicationContext(), "Incorrect Password",
//                                        Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Incorrect Username",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//
//                }
//            });
        }

        try {
            mUserId = mRef.getAuth().getUid();
        } catch (Exception e) {
            loadLoginView();
        }

        Intent intent = new Intent(MainActivity.this, Choice.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }



    private void loadLoginView() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public static String getLoginUser() {
        return loginUser;
    }

    public static double getUserScore() {
        return userScore;
    }

    public static void setUserScore(double value) {
        userScore = value;
    }

}
