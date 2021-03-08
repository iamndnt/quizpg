package com.myapp.quizpg;

import android.graphics.Color;
import android.graphics.PointF;

import java.util.ArrayList;

public class SpecTracNghiem_TN_CAOCAP extends ObjectSpec{

    private static final String[] components = new String [] {
            "StdGraphicsComponent",
            "InputTracNghiemCAOCAP"};

    static int KHUNG = 0;
    static int EXIT = 1;
    static int DIEM = 2;
    static int CHIAKHOA = 3;
    static int TN = 4;

    SpecTracNghiem_TN_CAOCAP(PointF mScreenSize, GameEngine ge) {
        super(components,mScreenSize);

        int x = (int)mScreenSize.x;
        int y = (int)mScreenSize.y;
        int padding_x = x/50;
        int padding_y = y/50;
        color = Color.rgb(0,227,0);
        topic = "tracnghiem2";


        myRect[] rects_tn = new myRect[5];

        rects_tn[0] = new myRect("QUESTION",0,0,(3*x)/4,y/2,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null,topic);


        rects_tn[1] = new myRect("OPTION1",0,y/2,3*x/4,5*y/8,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null,topic);

        rects_tn[2] = new myRect("OPTION2",0,5*y/8,3*x/4,3*y/4,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null,topic);

        rects_tn[3] = new myRect("OPTION3",0,3*y/4,3*x/4,7*y/8,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null,topic);

        rects_tn[4] = new myRect("OPTION4",0,7*y/8,3*x/4,y,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null,topic);

        rects = new myRect[4];
        tracNghiem = new myTracNghiem(rects_tn,ge);

        rects[0] = new myRect(null,(3*x)/4,0,x,y,
                Color.argb(100,255,255,255),
                Color.argb(100,255,255,255),
                (int)mScreenSize.x/50,
                0, 0, ge,null,topic);

        rects[1] = new myRect("THOÁT RA",3*x/4,7*y/8,x,y,
                Color.rgb(255,255,255),
                Color.rgb(2,195,6),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null,topic);

        rects[2] = new myRect("ĐIỂM: 0",3*x/4,0,x,y/8,
                Color.rgb(255,255,255),
                Color.rgb(2,195,6),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null,topic);

        rects[3] = new myRect("CHÌA KHÓA: 0",3*x/4,y/8,x,y/4,
                Color.rgb(255,255,255),
                Color.rgb(2,195,6),
                (int)mScreenSize.x/50,
                padding_x, padding_y,
                ge,null,topic);

        this.mScreenSize = mScreenSize;
        controls = new ArrayList<>();
        controls.add(KHUNG,rects[0]);
        controls.add(EXIT, rects[1]);
        controls.add(DIEM, rects[2]);
        controls.add(CHIAKHOA, rects[3]);
        controls.add(TN, tracNghiem);
    }

}
