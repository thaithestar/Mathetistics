package com.example.thait.mathetistics;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Database database = new Database();
    public void register(View view) {
        Intent intent = new Intent(this, SignUp.class);
    }

    Button login;
    EditText userName,passwords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button)findViewById(R.id.Login);
        userName = (EditText)findViewById(R.id.username);
        passwords = (EditText)findViewById(R.id.password);
        database.examples();
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent log = new Intent(MainActivity.this,Choice.class);
                String name = userName.getText().toString();
                String pass = passwords.getText().toString();
                User myUser = database.getUser(name);
                if(myUser != null){
                    if(myUser.getPassword().equals(pass)){
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
}
