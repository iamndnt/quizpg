package com.myapp.quizphatgiao;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public interface startnewview {

    boolean checkAns(String a) ;
    void startview0();
    void startview1();
    void startview_layout(int loai, Question question, int count, ArrayList<Drawable> iconList,int level);
    Question checkQues();
    void setUpQUestion();
    void setAds();
    void setPoint(int i);
    void stop();
}
