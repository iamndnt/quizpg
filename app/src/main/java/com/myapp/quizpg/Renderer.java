package com.myapp.quizpg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
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

    void draw(ArrayList<GameObject> objects, GameState gs, GameEngine ge) {
        if (mSurfaceHolder.getSurface().isValid()) {
            mCanvas = mSurfaceHolder.lockCanvas();

                if (gs.getgd() == gs.GD_MAIN) {
                    objects.get(Level.MAIN).draw(mCanvas, mPaint,ge);
                } else if (gs.getgd() == gs.GD_CAUNOIHAY ) {
                    objects.get(Level.CAUNOIHAY).draw(mCanvas, mPaint,ge);
                } else if (gs.getgd() == gs.GD_HINHPHAT ) {
                    objects.get(Level.HINHPHAT).draw(mCanvas, mPaint,ge);
                } else if (gs.getgd() == gs.GD_TRONGHOASEN ) {
                    objects.get(Level.TRONGHOASEN).draw(mCanvas, mPaint,ge);
                } else if (gs.getgd() == gs.GD_TRACNGHIEM1) {
                    objects.get(Level.TRACNGHIEM1).draw(mCanvas, mPaint,ge);
                }else if (gs.getgd() == gs.GD_TRACNGHIEM2) {
                    objects.get(Level.TRACNGHIEM2).draw(mCanvas, mPaint,ge);
                }else if (gs.getgd() == gs.GD_TRACNGHIEM3) {
                    objects.get(Level.TRACNGHIEM3).draw(mCanvas, mPaint,ge);
                }else if (gs.getgd() == gs.GD_TRACNGHIEM4) {
                    objects.get(Level.TRACNGHIEM4).draw(mCanvas, mPaint,ge);
                }

            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }

    public void drawBeginning(Point size) {
        if (mSurfaceHolder.getSurface().isValid()) {
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawColor(Color.rgb(39, 180, 117));
            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }


}
