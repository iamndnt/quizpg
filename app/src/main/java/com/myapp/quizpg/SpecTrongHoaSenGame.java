package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.ArrayList;

public class SpecTrongHoaSenGame extends ObjectSpec{

    private static final String[] components = new String [] {
            "StdGraphicsComponent",
            "InputTrongHoaSen"};


    static int KHUNG = 0;
    static int OTRONG1 = 1;
    static int OTRONG2 = 2;
    static int OTRONG3 = 3;
    static int OTRONG4 = 4;
    static int OTRONG5 = 5;
    static int OTRONG6 = 6;
    static int OTRONG7 = 7;
    static int OTRONG8 = 8;
    static int OTRONG9 = 9;
    static int OTRONG10 = 10;
    static int OTRONG11 = 11;
    static int OTRONG12 = 12;
    static int CUAHANG = 13;
    static int EXIT = 14;

    SpecTrongHoaSenGame(PointF mScreenSize, GameEngine ge) {
        super(components,mScreenSize);
        rects = new myRect[15];
        int x = (int)mScreenSize.x;
        int y = (int)mScreenSize.y;
        int padingx = x/50;
        int padingy = x/70;
        this.mScreenSize = mScreenSize;
        color = Color.rgb(0,227,0);
        topic = "tronghoasen";
        rects[0] = new myRect("KHUNG HINH",(3*x)/4,0,x,y,
                Color.argb(100,255,255,255),
                Color.argb(100,255,255,255),
                (int)mScreenSize.x/50,
                0,0,ge,null,topic);


        rects[1] = new myRect("POS1",0,0,x/4,y/4,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[2] = new myRect("POS2",x/4,0,x/2,y/4,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[3] = new myRect("POS3",x/2,0,3*x/4,y/4,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[4] = new myRect("POS4",0,y/4,x/4,y/2,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[5] = new myRect("POS5",x/4,y/4,x/2,y/2,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[6] = new myRect("POS6",x/2,y/4,3*x/4,y/2,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);


        rects[7] = new myRect("POS7",0,y/2,x/4,3*y/4,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[8] = new myRect("POS8",x/4,y/2,x/2,3*y/4,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[9] = new myRect("POS9",x/2,y/2,3*x/4,3*y/4,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);


        rects[10] = new myRect("POS10",0,3*y/4,x/4,y,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[11] = new myRect("POS11",x/4,3*y/4,x/2,y,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[12] = new myRect("POS12",x/2,3*y/4,3*x/4,y,
                Color.argb(255,255,255,255),
                Color.argb(255,255,255,255),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[13] = new myRect("CỬA HÀNG",3*x/4,3*y/4,x,7*y/8,
                Color.rgb(255,255,255),
                Color.rgb(2,195,6),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        rects[14] = new myRect("EXIT",3*x/4,7*y/8,x,y,
                Color.rgb(255,255,255),
                Color.rgb(2,195,6),
                (int)mScreenSize.x/50,
                padingx,padingx,ge,null,topic);

        controls = new ArrayList<>();
        controls.add(KHUNG,rects[0]);

        controls.add(OTRONG1, rects[1]);
        controls.add(OTRONG2, rects[2]);
        controls.add(OTRONG3, rects[3]);
        controls.add(OTRONG4, rects[4]);
        controls.add(OTRONG5, rects[5]);
        controls.add(OTRONG6, rects[6]);
        controls.add(OTRONG7, rects[7]);
        controls.add(OTRONG8, rects[8]);
        controls.add(OTRONG9, rects[9]);
        controls.add(OTRONG10, rects[10]);
        controls.add(OTRONG11, rects[11]);
        controls.add(OTRONG12, rects[12]);

        controls.add(CUAHANG,rects[13]);
        controls.add(EXIT,rects[14]);
    }




}
