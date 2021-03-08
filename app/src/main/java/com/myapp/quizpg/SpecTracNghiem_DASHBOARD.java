package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;

import java.util.ArrayList;

public class SpecTracNghiem_DASHBOARD extends ObjectSpec{

    private static final String[] components = new String [] {
            "StdGraphicsComponent",
            "InputTracNghiemDASHBOARD"};

    static int COBAN = 0;
    static int TRUNGCAP = 1;
    static int NANGCAO = 2;
    static int EXIT = 3;

    SpecTracNghiem_DASHBOARD(PointF mScreenSize, GameEngine ge) {
        super(components, mScreenSize);

        rects = new myRect[4];
        int x = (int)mScreenSize.x;
        int y = (int)mScreenSize.y;
        int padding_x = x/50;
        int padding_y = y/50;
        color = Color.rgb(0,227,0);
        topic = "tracnghiem1";

        rects[0] = new myRect("CƠ BẢN",x/4,0,(3*x)/4,y/4,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,ge,null,topic);

        rects[1] = new myRect("TRUNG CẤP",x/4,y/4,(3*x)/4,y/2,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,ge,null,topic);

        rects[2] = new myRect("ĐẠI HỌC",x/4,y/2,(3*x)/4,3*y/4,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,ge,null,topic);

        rects[3] = new myRect("EXIT",x/4,3*y/4,3*x/4,y,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/50,
                padding_x, padding_y,ge,null,topic);

        this.mScreenSize = mScreenSize;
        controls = new ArrayList<>();
        controls.add(COBAN,rects[0]);
        controls.add(TRUNGCAP,rects[1]);
        controls.add(NANGCAO, rects[2]);
        controls.add(EXIT, rects[3]);
    }
}
