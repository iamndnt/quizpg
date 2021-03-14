package com.myapp.quizphatgiao;

public class Question {
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String ans;
    Question(){
        question = "";
        option1 = "";
        option2 = "";
        option3 = "";
        option4 = "";
        ans = "";
    }
    Question(String question, String option1, String option2, String option3, String option4, String ans){
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.ans = ans;
    }
}
