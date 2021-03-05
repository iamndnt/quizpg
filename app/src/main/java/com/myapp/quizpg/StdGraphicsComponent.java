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
            myTracNghiem.drawTracNghiem(canvas,tracNghiem,paint);
        }

        if(triangles != null) {
            /* draw triangle */
            for (int i = 0; i < triangles.length; i++) {
                Triangle.drawTriangle(canvas, triangles[i]);
            }
        }

        /* draw Rect  */
        for(int i=0;i<numRect;i++){
            /* draw background bitmap */
            if(mRect[i].getBGBitmap() != null){
                canvas.drawBitmap(mRect[i].Rectbitmap,null,mRect[i].rect,null);
            }else{
                paint.setColor(mRect[i].getColorRect());
                canvas.drawRect(mRect[i].rect, paint);
            }

            /* draw text bitmap */
            if(mRect[i].getWriteText() != null ) {
                paint.setColor(mRect[i].getColorTextRect());
                paint.setTextSize(mRect[i].getTextSize());
                int len_x = (int) paint.measureText(mRect[i].text);
                Rect bounds = new Rect();
                paint.getTextBounds(mRect[i].text, 0, mRect[i].text.length(), bounds);
                int len_y = bounds.height();
                int x = setPosX(mRect[i].rect.left, mRect[i].rect.width(), len_x);
                int y = setPosY(mRect[i].rect.top, mRect[i].rect.height(), len_y);
                canvas.drawText(mRect[i].text, x, y, paint);
            }
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

    private int setPosY(int top, int h, int len) {
        int t = h - len;
        return top + (t/2)+len;
    }

    private int setPosX(int left, int w,int len) {
        int t = w - len;
        return left+(t/2);
    }

    @Override
    public ArrayList<HinhHoc> getControl() {
        return controls;
    }

}
