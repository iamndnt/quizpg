package com.myapp.quizpg;

import android.graphics.PointF;
import android.graphics.Rect;

import java.util.ArrayList;

abstract class ObjectSpec {

    protected myRect[] rects;
    protected ArrayList<myRect> controls;
    protected String topic;
    private String[] mComponents;
    protected PointF mScreenSize;

    ObjectSpec(String[] components) {
        mComponents = components;
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

    public abstract int getColor();

    public ArrayList<myRect> getControl() {
        return controls;
    }

    public String getSubject( ){return topic;}
}
