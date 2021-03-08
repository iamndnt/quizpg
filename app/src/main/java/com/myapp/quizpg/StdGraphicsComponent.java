package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Bitmap;
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
    private ArrayList<HinhHoc> controls;
    private String topic;
    private Triangle[] triangles;
    private myTracNghiem tracNghiem;
    private Bitmap bgBitmap;

    @Override
    public void setBitmap(Bitmap bitmap) {
        bgBitmap = bitmap;
    }

    @Override
    public void setText(String text) {

    }

    @Override
    public void initialize(Context context,
                           ObjectSpec spec){

        mRect = spec.getRects();
        numRect = spec.getNumRects();
        triangles = spec.getTriangles();
        color = spec.getColor();
        controls = spec.getControl();
        tracNghiem = spec.getTN();
        topic = spec.getSubject();
        //mTextFormatting = spec.getTextFormatting();
        color = spec.getColor();
        bgBitmap = spec.getBgBitmap();

    }

    @Override
    public void draw(Canvas canvas, Paint paint, GameEngine ge) {

        checkBGBitmap(ge);

        /* draw background bitmap */
        if(bgBitmap != null){
            canvas.drawBitmap(bgBitmap,0,0,null);
        }else{
            canvas.drawColor(color);
        }

        if(tracNghiem!=null){
            tracNghiem.drawTracNghiem(canvas,paint);
        }

        if(triangles != null) {
            /* draw triangle */
            for (int i = 0; i < triangles.length; i++) {
                triangles[i].drawTriangle(canvas);
            }
        }

        /* draw Rect  */
        for(int i=0;i<numRect;i++){
            mRect[i].myDrawRect(canvas,paint);
        }
    }



    private void checkBGBitmap(GameEngine ge) {
        if(topic.equals("caunoihay")){
            bgBitmap = ge.bitmapBG.get(5);
        }else if(topic.equals("hinhphat")){
            bgBitmap = ge.bitmapBG.get(1);
        }else if(topic.equals("main")){
            bgBitmap = ge.bitmapBG.get(0);
        }else if(topic.equals("tracnghiem1")){
            bgBitmap = ge.bitmapBG.get(2);
        }else if(topic.equals("tracnghiem2")){
            bgBitmap = ge.bitmapBG.get(3);
        }else if(topic.equals("tronghoasen")){
            bgBitmap = ge.bitmapBG.get(4);
        }
    }



    @Override
    public ArrayList<HinhHoc> getControl() {
        return controls;
    }

}
