package com.myapp.azure2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class ViewStartGame extends SurfaceView implements Runnable {

    private RectF nv_chinh,traitim, viendan;
    Paint paint1,paint2,paint3;
    private SurfaceHolder mSurfaceHolder;
    Thread mThread;
    private Canvas canvas;
    private Paint mPaint;
    private long mNextFrameTime;
    long v,locationy1,locationy2,locationy3,locationy4,locationy5,locationy6,locationy7,locationy8,location11,location12;
    int below,right;
    boolean up,up2,fire,win;

    public ViewStartGame(Context context,  Point size) {
        super(context);
        nv_chinh = new RectF(100,100,200,200);
        viendan = new RectF(130,130,160,160);
        traitim = new RectF(1200,700,1300,800);
        paint1 = new Paint();
        right = size.x;
        below = size.y;
        up = false;
        up2 = false;
        fire = false;
        win = false;
        location11 = 100;
        location12 = 200;
        locationy1 = 100;
        locationy2 = 200;
        locationy3 = 130;
        locationy4 = 160;
        locationy5 = 130;
        locationy6 = 160;
        locationy7 = 700;
        locationy8 = 800;

        paint1.setColor(Color.YELLOW);
        paint2 = new Paint();
        paint2.setColor(Color.BLACK);
        paint3 = new Paint();
        paint3.setColor(Color.RED);
        mSurfaceHolder = this.getHolder();
        mThread = new Thread(this);
        //mFPS=1;
        v = 5;
        mThread.start();
        paint2.setTextSize(20f);
    }



    @Override
    public void run() {
        while(true) {
            if (mSurfaceHolder.getSurface().isValid()) {


                canvas = mSurfaceHolder.lockCanvas();
                canvas.drawColor(Color.WHITE);
                if (updateRequired()) {
                    update();
                }
                canvas.drawRect(nv_chinh, paint1);
                canvas.drawRect(viendan, paint2);
                canvas.drawRect(traitim, paint3);

                if(win){
                    canvas.drawText("WIN !!!", 500, 500, paint2);
                }else {
                    canvas.drawText("pos: " + locationy2 + " " + right, 500, 500, paint2);
                }

                mSurfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        fire = true;

        return true;
    }

    // Check to see if it is time for an update
    public boolean updateRequired() {

        // Run at 10 frames per second
        final long TARGET_FPS = 24;
        // There are 1000 milliseconds in a second
        final long MILLIS_PER_SECOND = 1000;

        // Are we due to update the frame
        if(mNextFrameTime <= System.currentTimeMillis()){
            // Tenth of a second has passed

            // Setup when the next update will be triggered
            mNextFrameTime =System.currentTimeMillis()
                    + MILLIS_PER_SECOND / TARGET_FPS;

            // Return true so that the update and draw
            // methods are executed
            return true;
        }

        return false;
    }

    private void update() {
        nv_chinh.set(location11,locationy1,location12,locationy2);
        viendan .set(locationy5,locationy3,locationy6,locationy4);
        traitim .set(1200,locationy7,1300,locationy8);

        if(up){
            locationy1 -= 5;
            locationy2 -= 5;
            if(fire){
                locationy5 +=25;
                locationy6 +=25;
            }else{
                locationy3 -=5 ;
                locationy4 -=5 ;
            }

        }else {
            locationy1 += 5;
            locationy2 += 5;
            if(fire){
                locationy5 +=25;
                locationy6 +=25;
            }else{
                locationy3 +=5;
                locationy4 +=5;
            }
        }
        if(up2){
            locationy7 -= 8;
            locationy8 -= 8;
        }else{
            locationy7 += 8;
            locationy8 += 8;
        }
        detectSilicon();
    }

    private void detectSilicon() {
        if(locationy2  > 800){
            up = true;
        }else if(locationy1 < 0){
            up = false;
        }
        if(locationy8  > 800){
            up2 = true;
        }else if(locationy7 < 0){
            up2 = false;
        }
        if((locationy6 > right) || (win)){
            locationy5 = location11+30;
            locationy6 = location12-30;
            locationy3 = locationy1 + 30;
            locationy4 = locationy2 - 30;
            win = false;
            fire = false;
        }
        if(viendan.intersect(traitim)){
            win = true;
        }
    }

}
