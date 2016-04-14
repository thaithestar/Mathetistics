package com.example.thait.mathetistics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by thait on 4/13/2016.
 */
public class Database {
    private List<User> users = new ArrayList<User>();
    private List<Question> questions = new ArrayList<Question>();

    Database(){}

    public void examples(){
        User John  = new User("John1","jgasao","gasao@wisc.edu");
        User Thai = new User("Thai","thai9","tthao6@wisc.edu");
        User Eek = new User("Eek","algor1","al@gmail.com");
        Eek.addScore(10);
        insert(John);
        insert(Thai);
        insert(Eek);
    }
    public void insert(User in){
        users.add(in);
        if(in.getScore() > 0)
            sort();
    }

    public User getUser(String name){
        Iterator<User> itr = users.iterator();
        while(itr.hasNext()){
            User temp = itr.next();
            if(temp.getUsername().equalsIgnoreCase(name)){
                return temp;
            }
        }
        return null;
    }

    public List<User> getUList(){
        return users;
    }

    public void addScore(int value, User in){
        in.addScore(value);
        sort();
    }

    public void sort(){
        for(int i = 1; i < users.size();i++){
            if(users.get(i).getScore() > users.get(i-1).getScore()){
                User temp = users.get(i);
                users.remove(users.get(i));
                users.add(i-1,temp);
                i--;
            }
        }
    }

    public String[] getRankName(){
        String [] names = new String[10];
        for(int i =0; i < 10; i++){
            if(i < users.size()) {
                names[i] = users.get(i).getUsername();
            }
        }
        return names;
    }

    public void addQ(Question q){
        questions.add(q);
    }

    public List<Question> getQList(){
        return questions;
    }
}
