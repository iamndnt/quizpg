package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.ArrayList;

public class SpecMain extends ObjectSpec{

    private static final String[] components = new String [] {
            "StdGraphicsComponent",
            "InputMain"};

    static int TRACNGHIEM = 0;
    static int HINHPHAT = 1;
    static int TRONGHOASEN = 2;
    static int CAUNOIHAY = 3;

    SpecMain(PointF mScreenSize, GameEngine ge) {

        super(components,mScreenSize);
        topic = "main";
        int x = (int)mScreenSize.x;
        int y = (int)mScreenSize.y;
        int padding_x = x/20;
        int padding_y = y/20;
        rects = new myRect[4];
        this.mScreenSize = mScreenSize;
        //mTextFormatting = (int)mScreenSize.x/30;
        color = Color.rgb(0,227,0);


        rects[0] = new myRect(
                "ĐỐ VUI PHẬT GIÁO",
                0,
                (y/2),
                (x/2),
                (y/2)+(y/4),
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/35,
                padding_x, padding_y,ge,null
        );

        rects[1] = new myRect(
                "HÌNH PHẬT",
                (x/2),
                (y/2),
                x,
                (y/2)+(y/4),
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/35,
                padding_x, padding_y,ge,null
        );

        rects[2] = new myRect(
                "TRỒNG HOA SEN",
                0,
                (y/2)+(y/4),
                (x/2),
                y,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/35,
                padding_x, padding_y,ge,null
        );

        rects[3] = new myRect(
                "LỜI PHẬT DẠY",
                (x/2),
                (y/2)+(y/4),
                x,
                y,
                Color.argb(100,255,255,255),
                Color.rgb(0,0,0),
                (int)mScreenSize.x/35,
                padding_x, padding_y,ge,null
        );

        controls = new ArrayList<>();
        controls.add(TRACNGHIEM,rects[0]);
        controls.add(HINHPHAT,rects[1]);
        controls.add(TRONGHOASEN, rects[2]);
        controls.add(CAUNOIHAY, rects[3]);
    }


}
