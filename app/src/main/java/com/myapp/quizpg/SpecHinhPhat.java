package com.myapp.quizpg;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.ArrayList;

public class SpecHinhPhat extends ObjectSpec{

    private static final String[] components = new String [] {
            "StdGraphicsComponent",
            "InputHinhPhat"};

    static int EXIT = 0;
    static int KHUNGHINH = 1;
    static int NEXT = 2;
    static int PREVIOUS = 3;

    SpecHinhPhat(PointF mScreenSize ) {
        super(components);
        topic = "HINH PHAT" ;
        this.mScreenSize = mScreenSize;

        rects = new myRect[4];
        rects[0] = new myRect("EXIT",300,300,400,400);
        rects[1] = new myRect("KHUNG HINH",500,500,700,700);
        rects[2] = new myRect("NEXT",600,600,800,800);
        rects[3] = new myRect("PREVIOUS",600,600,800,800);

        controls = new ArrayList<>();
        controls.add(EXIT,rects[0]);
        controls.add(KHUNGHINH,rects[1]);
        controls.add(NEXT, rects[2]);
        controls.add(PREVIOUS, rects[3]);

    }


    @Override
    public int getColor() {
        return Color.argb(100,255,255,255);
    }


}
