package com.myapp.quizphatgiao;

import android.graphics.Bitmap;
import android.graphics.PointF;

import java.util.ArrayList;

abstract class ObjectSpec {

    protected myRect[] rects;
    protected ArrayList<HinhHoc> controls;
    protected myTracNghiem tracNghiem;

    protected String topic;
    private String[] mComponents;
    protected PointF mScreenSize;
    protected Bitmap bgBitmap;
    protected Triangle[] triangles;
    protected int color;

    ObjectSpec(String[] components, PointF mScreenSize) {
        mComponents = components;
        this.mScreenSize = mScreenSize;
    }

    String[] getComponents() {
        return mComponents;
    }

    public int getNumRects() {
        return rects.length;
    }

    public myRect[] getRects() {
        return rects;
    }

    public Triangle[] getTriangles() { return triangles;}

    public int getColor() {
        return color;
    }

    public ArrayList<HinhHoc> getControl() {
        return controls;
    }

    public void setControl(Bitmap bitmap) {
         bgBitmap = bitmap;
    }

    public String getSubject( ){return topic;}

    public Bitmap getBgBitmap(){return bgBitmap;}

    public myTracNghiem getTN(){return tracNghiem;}
}
