package com.example.thait.mathetistics;

/**
 * Created by thait on 4/13/2016.
 */
public class User {
    private String username;
    private double score;

    public User(String username,double score) {
        this.username = username;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public String getUsername() {
        return username;
    }

    public int compareTo(User u){
        if(this.score > u.getScore()){
            return 1;
        }
        else if(this.score < u.getScore()){
            return -1;
        }
        return 0;
    }
}
