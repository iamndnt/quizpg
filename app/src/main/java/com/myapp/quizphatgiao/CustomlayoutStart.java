package com.myapp.quizphatgiao;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class CustomlayoutStart extends ViewGroup {
    private Point size;
    private int x,y,rate;
    private View[] Button;
    private View space;
    private Rect rect1,rect2;
    private startnewview startnewview;
    public CustomlayoutStart(Context context, Point size,startnewview startnewview) {
        super(context);
        this.size = size;
        this.x = size.x;
        this.y = size.y;
        this.startnewview = startnewview;
        rate = 10;
        Button = new View[2];
        rect1 = new Rect((size.x)/8,(5*size.y)/8,(size.x*4)/8,(6*size.y)/8);
        rect2 = new Rect((size.x)/8,(6*size.y)/8,(size.x*4)/8,(7*size.y)/8);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;
        if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
            if (rect1.contains(x, y)) {
                startnewview.setAds();
                startnewview.startview1();
            }
            if (rect2.contains(x, y)) {
                startnewview.stop();
            }
        }
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        space = getChildAt(0);
        setView1(space,l,t,r,b);
        Button[0] = getChildAt(1);
        Button[1] = getChildAt(2);

        setView1(Button[0],(size.x)/8,(5*size.y)/8,(size.x*4)/8,(6*size.y)/8);
        setView1(Button[1],(size.x)/8,(6*size.y)/8,(size.x*4)/8,(7*size.y)/8);

    }
    private void setView1(View child,int l, int t, int r, int b) {
        child.layout(l,t,r,b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(size.x,size.y);
    }
}
