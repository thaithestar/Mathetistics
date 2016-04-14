package com.example.thait.mathetistics;

/**
 * Created by thait on 4/13/2016.
 */
public class User {
    private String username,password,email;
    private int score;

    public User(String username, String password,String email) {
        this.email = email;
        this.username = username;
        this.password = password;
        score = 0;
    }

    public void addScore(int value){
        score += value;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
