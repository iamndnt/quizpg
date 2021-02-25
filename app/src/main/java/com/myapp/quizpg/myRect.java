package com.myapp.quizpg;

import android.graphics.Rect;

public class myRect {

    public Rect rect;
    public String text;
    private int left;
    private int right;
    private int top;
    private int bottom;

    myRect(String text, int l, int t, int r, int b){
        this.text = text;
        left = l;
        top = t;
        right = r;
        bottom = b;
        rect = new Rect(l,t,r,b);
    }
}
