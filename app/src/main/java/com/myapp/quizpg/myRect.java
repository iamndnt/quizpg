package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
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
    private String label;
    private GameEngine ge;
    private Bitmap dumpBitmap;
    private String topic;
    myRect(String text, int l, int t, int r, int b,
           int colorRect, int colorTextRect,
           int textsize,
           int paddingX, int paddingY,GameEngine ge, Bitmap bitmap,String topic){

        this.text = text;
        this.label = text;
        this.ge = ge;
        left = l+paddingX;
        top = t+paddingY;
        right = r-paddingX;
        bottom = b-paddingY;
        rect = new Rect(left,top,right,bottom);
        this.colorRect = colorRect;
        this.colorTextRect = colorTextRect;
        this.mTextFormatting = textsize;
        dumpBitmap = bitmap;
        this.topic = topic;
    }
    public void setText(String text) {
        this.text = text;
    }
    void checkBitmap(int index){
        if(ge.bitmap.get(index) != null){
            Rectbitmap = ge.bitmap.get(index);
        }
    }

    void setQuesImage(){
        if(topic.equals("hinhphat")){
            Rectbitmap = ge.currentBitmap;
        }else if(topic.equals("caunoihay")){
            Rectbitmap = ge.currentBitmap1;
        }

    }

    void myDrawRect(Canvas canvas, Paint paint){

        if(dumpBitmap != null){
            setQuesImage();
        }


        if(label!=null) {
            if (this.getLabel().equals("ĐIỂM: 0")) {
                this.text = "Điểm: " + ge.TNpoint;
            } else if (this.getLabel().equals("CHÌA KHÓA: 0")) {
                this.text = "CHÌA KHÓA: " + ge.chiakhoa;
            }
        }
        /* draw background bitmap */
        if(this.getBGBitmap() != null){
            canvas.drawBitmap(this.Rectbitmap,null,this.rect,null);
        }else{
            paint.setColor(this.getColorRect());
            canvas.drawRect(this.rect, paint);
        }

        /* draw text bitmap */
        if(this.getWriteText() != null ) {
            paint.setColor(this.getColorTextRect());
            paint.setTextSize(this.getTextSize());
            int len_x = (int) paint.measureText(this.text);
            Rect bounds = new Rect();
            paint.getTextBounds(this.text, 0, this.text.length(), bounds);
            int len_y = bounds.height();
            int x = setPosX(this.rect.left, this.rect.width(), len_x);
            int y = setPosY(this.rect.top, this.rect.height(), len_y);
            canvas.drawText(this.text, x, y, paint);
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

    public String getLabel(){
        return label;
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
