package com.myapp.quizpg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

class Renderer {

    private Canvas mCanvas;
    private SurfaceHolder mSurfaceHolder;
    private Paint mPaint;

    Renderer(SurfaceView sh){
        mSurfaceHolder = sh.getHolder();
        mPaint = new Paint();
    }

    void draw(ArrayList<GameObject> objects, GameState gs, ParticleSystem ps) {
        if (mSurfaceHolder.getSurface().isValid()) {
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawColor(Color.argb(255, 0, 0, 0));

            if(gs.getgd() == gs.GD_MAIN){
                objects.get(Level.MAIN).draw(mCanvas,mPaint);
            }else if(gs.getgd() == gs.GD_CAUNOIHAY){
                objects.get(Level.CAUNOIHAY).draw(mCanvas,mPaint);
            }else if(gs.getgd() == gs.GD_HINHPHAT){
                objects.get(Level.HINHPHAT).draw(mCanvas,mPaint);
            }else if(gs.getgd() == gs.GD_TRONGHOASEN){
                objects.get(Level.TRONGHOASEN).draw(mCanvas,mPaint);
            }else if(gs.getgd() == gs.GD_TRACNGHIEM){
                objects.get(Level.TRACNGHIEM).draw(mCanvas,mPaint);
            }

            // Draw a particle system explosion here
            if(ps.mIsRunning){
                ps.draw(mCanvas, mPaint);
            }

            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }
}
