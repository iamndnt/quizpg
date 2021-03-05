package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;

public class myRect extends HinhHoc{

    public Rect rect;
    public String text;

    private int left;
    private int right;
    private int top;
    private int bottom;
    public Bitmap Rectbitmap;
    private int mTextFormatting;
    private int colorRect;
    private int colorTextRect;

    private GameEngine ge;

    myRect(String text, int l, int t, int r, int b,
           int colorRect, int colorTextRect,
           int textsize,
           int paddingX, int paddingY,GameEngine ge, Bitmap bitmap){

        this.text = text;
        this.ge = ge;
        left = l+paddingX;
        top = t+paddingY;
        right = r-paddingX;
        bottom = b-paddingY;
        rect = new Rect(left,top,right,bottom);
        this.colorRect = colorRect;
        this.colorTextRect = colorTextRect;
        this.mTextFormatting = textsize;
        Rectbitmap = bitmap;
    }
    public void setText(String text) {
        this.text = text;
    }
    void checkBitmap(int index){
        if(ge.bitmap.get(index) != null){
            Rectbitmap = ge.bitmap.get(index);
        }
    }


    public int getColorRect() {
        return colorRect;
    }

    public int getColorTextRect() {
        return colorTextRect;
    }

    public float getTextSize() {
        return mTextFormatting;
    }

    public String getWriteText() {
        return text;
    }

    public Bitmap getBGBitmap(){
        return Rectbitmap;
    }



}
