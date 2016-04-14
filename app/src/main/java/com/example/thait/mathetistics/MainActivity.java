package com.example.thait.mathetistics;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public static Database database = new Database();
    Button login;
    EditText userName,passwords;
    private static String loginUser;
    private static double userScore;


    public void register(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public boolean read(){

            BufferedReader br = null;

            try {

                String sCurrentLine;
                InputStream iS = this.getResources().getAssets().open("Alg1.txt");
                br = new BufferedReader(new InputStreamReader(iS));
                String[] qArray = new String[6];
                int i = 0;
                while((sCurrentLine = br.readLine()) != null){

                    qArray[i] = sCurrentLine;
                    i++;
                    if(i == 6 ) {
                        Question tempQ = new Question(qArray[0], qArray[1], qArray[2],
                                qArray[3], qArray[4], qArray[5]);
                        database.addQ(tempQ);
                        i= 0;
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
        if(!read()){
            System.exit(-1);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button)findViewById(R.id.Login);
        userName = (EditText)findViewById(R.id.username);
        passwords = (EditText)findViewById(R.id.password);
        if(database.getUList().size() == 0){
            database.examples();
        }
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent log = new Intent(MainActivity.this,Choice.class);
                String name = userName.getText().toString();
                String pass = passwords.getText().toString();
                User myUser = database.getUser(name);
                if(myUser != null){
                    if(myUser.getPassword().equals(pass)){
                        loginUser = myUser.getUsername();
                        userScore = myUser.getScore();
                        startActivity(log);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Incorrect Password",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Incorrect Username",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public static String getLoginUser() {
        return loginUser;
    }
    public static double getUserScore() {
        return userScore;
    }

}
