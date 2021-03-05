package com.myapp.quizpg;

import android.graphics.Color;
import android.graphics.PointF;

import java.util.ArrayList;

public class SpecTracNghiem3 extends ObjectSpec{

    private static final String[] components = new String [] {
            "StdGraphicsComponent",
            "InputTracNghiem3"};

    static int KHUNG = 0;
    static int NEXTQUESTION = 1;
    static int EXIT = 2;
    static int TN = 3;

    SpecTracNghiem3(PointF mScreenSize, GameEngine ge, Question question) {
        super(components,mScreenSize);

        int x = (int)mScreenSize.x;
        int y = (int)mScreenSize.y;
        int padding_x = x/50;
        int padding_y = y/50;
        color = Color.rgb(0,227,0);
        topic = "tracnghiem2";


        myRect[] rects_tn = new myRect[5];


        rects_tn[0] = new myRect("QUESTION",0,y/8,(3*x)/4,(3*y)/4,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null);


        rects_tn[1] = new myRect("OPTION1",0,3*y/4,3*x/8,7*y/8,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null);

        rects_tn[2] = new myRect("OPTION2",3*x/8,3*y/4,3*x/4,7*y/8,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null);

        rects_tn[3] = new myRect("OPTION3",0,7*y/8,3*x/8,y,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null);

        rects_tn[4] = new myRect("OPTION4",3*x/8,7*y/8,3*x/4,y,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null);


        //Question question = new Question("ques1","op1","op2","op3","op4","A");
        rects = new myRect[3];
        tracNghiem = new myTracNghiem(rects_tn,question,ge);

        rects[0] = new myRect(null,(3*x)/4,0,x,y,
                Color.argb(100,255,255,255),
                Color.argb(100,255,255,255),
                (int)mScreenSize.x/50,
                0, 0, ge,null);

        rects[1] = new myRect("NEXT QUESTION",3*x/4,3*y/4,x,7*y/8,
                Color.rgb(255,255,255),
                Color.rgb(2,195,6),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null);

        rects[2] = new myRect("EXIT",3*x/4,7*y/8,x,y,
                Color.rgb(255,255,255),
                Color.rgb(2,195,6),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null);

        this.mScreenSize = mScreenSize;
        controls = new ArrayList<>();
        controls.add(KHUNG,rects[0]);
        controls.add(NEXTQUESTION, rects[1]);
        controls.add(EXIT, rects[2]);
        controls.add(TN, tracNghiem);
    }

}
