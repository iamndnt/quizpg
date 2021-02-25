package com.myapp.quizpg;

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

    SpecMain(PointF mScreenSize) {

        super(components);
        int x = (int)mScreenSize.x;
        int y = (int)mScreenSize.y;
        int padding_x = x/20;
        int padding_y = y/20;
        topic = "MAIN" ;
        rects = new myRect[4];
        this.mScreenSize = mScreenSize;

        rects[0] = new myRect(
                "ĐỐ VUI PHẬT GIÁO",
                0+padding_x,
                (y/2)+padding_y,
                (x/2)-padding_x,
                (y/2)+(y/4)-padding_y
        );
        Rect r = new Rect(1,2,3,4);
        rects[1] = new myRect(
                "HÌNH PHẬT",
                (x/2)+padding_x,
                (y/2)+padding_y,
                x-padding_x,
                (y/2)+(y/4)-padding_y
        );

        rects[2] = new myRect(
                "TRỒNG HOA SEN",
                0+padding_x,
                (y/2)+(y/4)+padding_y,
                (x/2)-padding_x,
                y-padding_y
        );

        rects[3] = new myRect(
                "LỜI PHẬT DẠY",
                (x/2)+padding_x,
                (y/2)+(y/4)+padding_y,
                x-padding_x,
                y-padding_y
        );


        controls = new ArrayList<>();
        controls.add(TRACNGHIEM,rects[0]);
        controls.add(HINHPHAT,rects[1]);
        controls.add(TRONGHOASEN, rects[2]);
        controls.add(CAUNOIHAY, rects[3]);

    }

    @Override
    public int getColor() {
        return Color.argb(100,255,255,255);
    }


}
