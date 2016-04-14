package com.example.thait.mathetistics;

/**
 * Created by thait on 4/13/2016.
 */
public class Question {
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String correctAns;

    public Question(String question, String ans1, String ans2, String ans3, String ans4,String correctAns) {
        this.correctAns = correctAns;
        this.ans4 = ans4;
        this.ans3 = ans3;
        this.ans2 = ans2;
        this.ans1 = ans1;
        this.question = question;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public String getAns4() {
        return ans4;
    }

    public String getAns3() {
        return ans3;
    }

    public String getAns2() {
        return ans2;
    }

    public String getAns1() {
        return ans1;
    }

    public String getQuestion() {
        return question;
    }

    boolean correct(String ans){
        return ans.equalsIgnoreCase(correctAns);
    }


}
