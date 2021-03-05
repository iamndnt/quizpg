package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.ArrayList;

interface GraphicsComponent {


    void initialize(Context c,
                    ObjectSpec s);

    void draw(Canvas canvas,
              Paint paint,GameEngine ge);

    ArrayList<HinhHoc> getControl();

    void setBitmap(Bitmap bitmap);
}
