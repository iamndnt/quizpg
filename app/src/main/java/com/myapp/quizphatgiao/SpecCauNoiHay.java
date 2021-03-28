package com.myapp.quizphatgiao;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.ArrayList;

public class SpecCauNoiHay extends ObjectSpec{
    
    private static final String[] components = new String [] {
            "StdGraphicsComponent",
            "InputCauNoiHay"};

    static int EXIT = 0;
    static int KHUNGHINH = 1;
    static int NEXT = 2;
    static int PREVIOUS = 3;
    private Bitmap bitmap;

    SpecCauNoiHay(PointF mScreenSize, GameEngine ge, Context context) {
        super(components,mScreenSize);
        this.mScreenSize = mScreenSize;

        topic = "caunoihay";
        int x = (int)mScreenSize.x;
        int y = (int)mScreenSize.y;
        int padding_x = x/50;
        int padding_y = y/50;
        int padding_y2 = y/30;
        rects = new myRect[2];
        triangles = new Triangle[2];
        color = Color.rgb(0,227,0);
        bitmap = initializeBitmap("caunoihaybandau",context,new Point(x,y));

        rects[0] = new myRect("THOÁT RA",(3*x)/8 ,(7*y)/8 ,(5*x)/8 ,(y),
                Color.argb(100,255,255,255),
                Color.rgb(30, 34, 233),
                (int)mScreenSize.x/50,
                padding_x, padding_y,ge,null,topic);

        rects[1] = new myRect(null,x/8,y/8,(7*x)/8,(7*y)/8,
                Color.rgb(255,255,255),
                Color.rgb(2,195,6),
                (int)mScreenSize.x/50,
                padding_x, 0,ge,bitmap,topic);

        Point d1 = new Point(7*x/8+padding_x,y/8+padding_y2);
        Point d2 = new Point(7*x/8+padding_x,7*y/8-padding_y2);
        Point d3 = new Point(x-padding_x,y/2);
        triangles[0] = new Triangle(d1,d2,d3,Color.argb(100,255,255,255));

        d1 = new Point(x/8-padding_x,y/8+padding_y2);
        d2 = new Point(x/8-padding_x,7*y/8-padding_y2);
        d3 = new Point(0+padding_x,y/2);
        triangles[1] = new Triangle(d1,d2,d3,Color.argb(100,255,255,255));

        controls = new ArrayList<>();
        controls.add(EXIT,rects[0]);
        controls.add(KHUNGHINH,rects[1]);
        controls.add(NEXT, triangles[0]);
        controls.add(PREVIOUS, triangles[1]);

        /* initialize bitmap here */
    }

    Bitmap initializeBitmap(String NameBitmap, Context context,Point size) {
        Bitmap bitmap;// = new Bitmap();
        // Make a resource id out of the string of the file name
        int resID = context.getResources()
                .getIdentifier(NameBitmap,
                        "drawable",
                        context.getPackageName());

        // Load the bitmap using the id
        bitmap = BitmapFactory.decodeResource(
                context.getResources(), resID);

        // Resize the bitmap
        bitmap = Bitmap
                .createScaledBitmap(bitmap,
                        size.x,
                        size.y,
                        false);

        return bitmap;
    }
}
