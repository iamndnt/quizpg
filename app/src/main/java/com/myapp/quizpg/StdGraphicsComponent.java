package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.ArrayList;

class StdGraphicsComponent implements GraphicsComponent {

    private myRect[] mRect;
    private int numRect;
    private int color;
    private ArrayList<myRect> controls;
    private String this_subject;
    private int mTextFormatting;
    @Override
    public void initialize(Context context,
                           ObjectSpec spec,
                           PointF objectSize){
        mRect = spec.getRects();
        numRect = spec.getNumRects();
        color = spec.getColor();
        controls = spec.getControl();
        this_subject = spec.getSubject();
        mTextFormatting = (int)objectSize.x / 50;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.argb(255,255,255,255));
        paint.setTextSize(mTextFormatting);
        canvas.drawText(this_subject,0,100,paint);

        for(int i=0;i<numRect;i++){
            paint.setColor(color);
            canvas.drawRect(mRect[i].rect,paint);
            paint.setColor(Color.argb(255,255,255,255));
            canvas.drawText(mRect[i].text,mRect[i].rect.left,mRect[i].rect.top,paint);
        }
    }

    @Override
    public ArrayList<myRect> getControl() {
        return controls;
    }
}
