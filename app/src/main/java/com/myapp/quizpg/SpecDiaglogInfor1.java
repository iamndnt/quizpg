package com.myapp.quizpg;

import android.graphics.Color;
import android.graphics.PointF;

import java.util.ArrayList;

public class SpecDiaglogInfor1 extends ObjectSpec{
    private static final String[] components = new String [] {
            "StdGraphicsComponent",
            "InputDiaglogInfor"};

    static int CHACROI = 0;
    static int CHUA = 1;
    static int DIAGLOG = 1;

    SpecDiaglogInfor1(PointF mScreenSize, String txt) {
        super(components, mScreenSize);
        this.mScreenSize = mScreenSize;

        topic = "diaglog";
        int x = (int)mScreenSize.x;
        int y = (int)mScreenSize.y;
        int padding_x = x/50;
        int padding_y = y/50;
        rects = new myRect[3];

        rects[0] = new myRect(txt,x/4 ,(y)/4 ,(3*x)/4 ,(3*y)/4,
                Color.rgb(30, 252, 140),
                Color.rgb(30, 34, 233),
                (int)mScreenSize.x/50,
                padding_x, padding_y,null,null);

        rects[1] = new myRect("CHẮC CHẮN",x/4 ,(5*y)/8 ,x/2 ,(3*y)/4,
                Color.rgb(11, 7, 238),
                Color.rgb(11, 247, 4),
                (int)mScreenSize.x/50,
                padding_x*2, padding_y,null,null);

        rects[2] = new myRect("CHƯA",x/2 ,(5*y)/8 ,(3*x)/4 ,(3*y)/4,
                Color.rgb(11, 7, 238),
                Color.rgb(11, 247, 4),
                (int)mScreenSize.x/50,
                padding_x*2, padding_y,null,null);

        controls = new ArrayList<>();
        controls.add(CHACROI,rects[1]);
        controls.add(CHUA,rects[2]);
        controls.add(DIAGLOG,rects[0]);
    }
}
