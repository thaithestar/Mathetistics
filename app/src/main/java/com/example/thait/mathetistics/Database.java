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
        User Thai = new User("Thai","thai","tthao6@wisc.edu");
        User Eek = new User("Eek","algor1","al@gmail.com");
        Eek.addScore(10.0);
        Thai.setScore(7.0);
        John.setScore(8.0);
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

    public boolean findName(String name){
        Iterator<User> itr = users.iterator();
        while(itr.hasNext()){
            User temp = itr.next();
            if(temp.getUsername().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public boolean findEmail(String ename){
        Iterator<User> itr = users.iterator();
        while(itr.hasNext()){
            User temp = itr.next();
            if(temp.getEmail().equalsIgnoreCase(ename)){
                return true;
            }
        }
        return false;
    }

    public void updateScore(String username, double score){
        for(int i = 0; i <users.size(); i++){
            if(users.get(i).getUsername().equalsIgnoreCase(username)){
                users.get(i).setScore(score);
                sort();
                break;
            }
        }
    }

    public List<User> getUList(){
        return users;
    }

    public void addScore(int value, User in){
        in.addScore(value);
        sort();
    }

    public void sort(){
        for(int i = 0; i < users.size()-1;i++){
            if(users.get(i).getScore() < users.get(i+1).getScore()){
                User temp = users.get(i+1);
                users.remove(users.get(i+1));
                users.add(i,temp);
                i= -1;
            }
        }
    }

    public String[] getRankName(){
        String [] names = new String[10];
        for(int i =0; i < 10; i++){
            if(i < users.size()) {
                names[i] = users.get(i).getUsername() + "\t\t" + users.get(i).getScore();
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
