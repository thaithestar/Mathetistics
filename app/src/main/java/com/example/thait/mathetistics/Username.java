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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Username extends AppCompatActivity {

    EditText name;
    Button confirm;

    private List<String> listOfUsedNames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
        name = (EditText)findViewById(R.id.theName);
        confirm = (Button)findViewById(R.id.btn_confirm);
        final Firebase ref = new Firebase(Constants.FIREBASE_URL);
        final Firebase userRef = ref.child("users").child(ref.getAuth().getUid());
        final Firebase usedRef = ref.child("usednames");


        usedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,Object> theNames = dataSnapshot.getValue(Map.class);
                if(theNames != null){
                    for (Map.Entry<String, Object> entry : theNames.entrySet()) {
                        listOfUsedNames.add(entry.getKey());
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                userName = userName.trim();
                userName = userName.replaceAll("\\s+","");

                if(userName.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Make sure to Enter a username",
                            Toast.LENGTH_SHORT).show();
                }
                else if(usedName(userName)){
                    Toast.makeText(getApplicationContext(), "Used Name\nPlease Enter another username",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    final String finalUserName = userName;

                    usedRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Map<String,Object> map = dataSnapshot.getValue(Map.class);
                            map.put(finalUserName,finalUserName);
                            usedRef.updateChildren(map);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });

                    userRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            Map<String,Object> map = dataSnapshot.getValue(Map.class);
                            map.put("username", finalUserName);
                            userRef.updateChildren(map);
                            startActivity(new Intent(Username.this,MainActivity.class));

                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });

                }
            }
        });

    }

    private boolean usedName(String theName){
        Iterator<String> itr = listOfUsedNames.iterator();
        while(itr.hasNext()){
            if(itr.next().equalsIgnoreCase(theName)){
                return true;
            }
        }
        return false;
    }
}
