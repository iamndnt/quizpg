package com.myapp.quizphatgiao;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CustomlayoutGuilde extends ViewGroup {
    private Point size;
    private int x,y,rate;
    private View[] child;
    private Rect rect1,rect2;
    private startnewview startnewview;
    private int yourlevel;
    public CustomlayoutGuilde(Context context, Point size, startnewview startnewview, int yourlevel) {
        super(context);
        this.size = size;
        this.x = size.x;
        this.y = size.y;
        this.startnewview = startnewview;
        rate = 10;
        this.yourlevel = yourlevel;
        child = new View[14];
        rect1 = new Rect((2*x)/rate,(y*8)/rate,(4*x)/rate,(y*9)/rate);
        rect2 = new Rect((4*x)/rate,(y*8)/rate,(6*x)/rate,(y*9)/rate);
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
                startnewview.setUpQUestion();
                Drawable myIcon = getResources().getDrawable( R.drawable.button_pink);
                ArrayList<Drawable> dr = new ArrayList<>();
                for(int i1=0;i1<8;i1++){
                    dr.add(myIcon);
                }
                Question ques = startnewview.checkQues();
                startnewview.startview_layout(3,ques,1,dr,yourlevel);
            }
            if (rect2.contains(x, y)) {
                startnewview.setAds();
                startnewview.startview0();
            }
        }
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        child[0] = getChildAt(0);
        setView1(child[0],l,t,r,b);

        for(int i=1;i<14;i++) {
            child[i] = getChildAt(i);
        }
        setView1(child[1],(8*x)/rate,(y*1)/rate,x,(y*2)/rate);
        setView1(child[2],(8*x)/rate,(y*2)/rate,x,(y*3)/rate);
        setView1(child[3],(8*x)/rate,(y*3)/rate,x,(y*4)/rate);
        setView1(child[4],(8*x)/rate,(y*4)/rate,x,(y*5)/rate);
        setView1(child[5],(8*x)/rate,(y*5)/rate,x,(y*6)/rate);
        setView1(child[6],(8*x)/rate,(y*6)/rate,x,(y*7)/rate);
        setView1(child[7],(8*x)/rate,(y*7)/rate,x,(y*8)/rate);
        setView1(child[8],(8*x)/rate,(y*8)/rate,x,(y*9)/rate);
        setView1(child[9],(x*1)/rate,0,(x*2)/rate,(y*1)/rate);

        //debug
        setView1(child[10],(x*2)/rate,0,(x*7)/rate,(y*1)/rate);

        setView1(child[11],(x*1)/rate,(y*2)/rate,(x*7)/rate,(y*7)/rate);

        setView1(child[12],(2*x)/rate,(y*8)/rate,(4*x)/rate,(y*9)/rate);
        setView1(child[13],(4*x)/rate,(y*8)/rate,(6*x)/rate,(y*9)/rate);
    }

    private void setView1(View child,int l, int t, int r, int b) {
        child.layout(l,t,r,b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(size.x,size.y);
    }
}
