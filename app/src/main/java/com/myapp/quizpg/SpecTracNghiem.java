package com.myapp.quizpg;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.ArrayList;

public class SpecTracNghiem extends ObjectSpec{

    private static final String[] components = new String [] {
            "StdGraphicsComponent",
            "InputTracNghiem"};

    static int EXIT = 0;
    static int QUESTION = 1;
    static int OPTION1 = 2;
    static int OPTION2 = 3;
    static int OPTION3 = 4;
    static int OPTION4 = 5;
    static int NEXTQUESTION = 6;

    SpecTracNghiem(PointF mScreenSize) {
        super(components);
        topic = "TRAC NGHIEM" ;

        rects = new myRect[7];
        rects[0] = new myRect("EXIT",300,300,400,400);
        rects[1] = new myRect("QUESTION",500,500,700,700);
        rects[2] = new myRect("OPTION1",600,600,800,800);
        rects[3] = new myRect("OPTION1",600,600,800,800);
        rects[4] = new myRect("OPTION2",600,600,800,800);
        rects[5] = new myRect("OPTION3",600,600,800,800);
        rects[6] = new myRect("NEXT QUESTION",600,600,800,800);

        this.mScreenSize = mScreenSize;
        controls = new ArrayList<>();
        controls.add(EXIT,rects[0]);
        controls.add(QUESTION,rects[1]);
        controls.add(OPTION1, rects[2]);
        controls.add(OPTION2, rects[3]);
        controls.add(OPTION3, rects[4]);
        controls.add(OPTION4, rects[5]);
        controls.add(NEXTQUESTION, rects[6]);

    }



    @Override
    public int getColor() {
        return Color.argb(100,255,255,255);
    }


}
