package com.myapp.quizpg;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.ArrayList;

public class SpecTrongHoaSenGame extends ObjectSpec{

    private static final String[] components = new String [] {
            "StdGraphicsComponent",
            "InputTrongHoaSen"};

    static int EXIT = 0;
    static int CUAHANG = 1;
    static int OTRONG1 = 2;
    static int OTRONG2 = 3;
    static int OTRONG3 = 4;
    static int OTRONG4 = 5;
    static int OTRONG5 = 6;
    static int OTRONG6 = 7;
    static int OTRONG7 = 8;
    static int OTRONG8 = 9;
    static int OTRONG9 = 10;
    static int OTRONG10 = 11;
    static int OTRONG11 = 12;
    static int OTRONG12 = 13;
    static int OTRONG13 = 14;

    SpecTrongHoaSenGame(PointF mScreenSize) {
        super(components);
        topic = "TRONG HOA SEN" ;

        rects = new myRect[15];
        rects[0] = new myRect("EXIT",300,300,400,400);
        rects[1] = new myRect("CUA HANG",500,500,700,700);
        this.mScreenSize = mScreenSize;
        rects[2] = new myRect("POS3",600,600,800,800);
        rects[3] = new myRect("POS4",600,600,800,800);
        rects[4] = new myRect("POS5",600,600,800,800);
        rects[5] = new myRect("POS6",600,600,800,800);
        rects[6] = new myRect("POS7",600,600,800,800);
        rects[7] = new myRect("POS8",600,600,800,800);
        rects[8] = new myRect("POS9",600,600,800,800);
        rects[9] = new myRect("POS10",600,600,800,800);
        rects[10] = new myRect("POS11",600,600,800,800);
        rects[11] = new myRect("POS12",600,600,800,800);
        rects[12] = new myRect("POS13",600,600,800,800);
        rects[13] = new myRect("POS14",600,600,800,800);
        rects[14] = new myRect("POS15",600,600,800,800);

        controls = new ArrayList<>();
        controls.add(EXIT,rects[0]);
        controls.add(CUAHANG,rects[1]);

        controls.add(OTRONG1, rects[2]);
        controls.add(OTRONG2, rects[3]);
        controls.add(OTRONG3, rects[4]);
        controls.add(OTRONG4, rects[5]);
        controls.add(OTRONG5, rects[6]);
        controls.add(OTRONG6, rects[7]);
        controls.add(OTRONG7, rects[8]);
        controls.add(OTRONG8, rects[9]);
        controls.add(OTRONG9, rects[10]);
        controls.add(OTRONG10, rects[11]);
        controls.add(OTRONG11, rects[12]);
        controls.add(OTRONG12, rects[13]);
        controls.add(OTRONG13, rects[14]);

    }



    @Override
    public int getColor() {
        return Color.argb(100,255,255,255);
    }


}
