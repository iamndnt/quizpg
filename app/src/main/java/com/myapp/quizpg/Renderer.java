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
                    if(gs.getDiaglog5()){
                        objects.get(Level.DIAGLOG_WIN).draw(mCanvas, mPaint,ge);
                    }
                } else if (gs.getgd() == gs.GD_CAUNOIHAY ) {
                    objects.get(Level.CAUNOIHAY).draw(mCanvas, mPaint,ge);
                } else if (gs.getgd() == gs.GD_HINHPHAT ) {
                    objects.get(Level.HINHPHAT).draw(mCanvas, mPaint,ge);
                } else if (gs.getgd() == gs.GD_TRONGHOASEN ) {

                    objects.get(Level.TRONGHOASEN).draw(mCanvas, mPaint,ge);

                    gs.setDiaglog4();
                    if(gs.getDiaglog4()){
                        objects.get(Level.DIAGLOG_TRONGHOASEN).draw(mCanvas, mPaint,ge);
                    }

                } else if (gs.getgd() == gs.GD_TRACNGHIEM_DASHBOARD) {

                    objects.get(Level.TRACNGHIEM_DASHBOARD).draw(mCanvas, mPaint,ge);

                    if(gs.getDiaglog0()){
                        objects.get(Level.DIAGLOG_TRUNGCAP).draw(mCanvas, mPaint,ge);
                    }
                    if(gs.getDiaglog6()){
                        objects.get(Level.DIAGLOG_CAOCAP).draw(mCanvas, mPaint,ge);
                    }
                }else if (gs.getgd() == gs.GD_TRACNGHIEMC_COBAN) {

                    objects.get(Level.TRACNGHIEM_COBAN).draw(mCanvas, mPaint,ge);
                    if(gs.getDiaglog1()){
                        objects.get(Level.DIAGLOG_INFOR).draw(mCanvas, mPaint,ge);
                    }else if(gs.getDiaglog2()){
                        objects.get(Level.DIAGLOG_INFOR2).draw(mCanvas, mPaint,ge);
                    }else if(gs.getDiaglog3()){
                        objects.get(Level.DIAGLOG_INFOR3).draw(mCanvas, mPaint,ge);
                    }else if(gs.getDiaglog7()){
                        objects.get(Level.DIAGLOG_KEY).draw(mCanvas, mPaint,ge);
                    }

                }else if (gs.getgd() == gs.GD_TRACNGHIEM_TRUNGCAP) {



                        objects.get(Level.TRACNGHIEM_TRUNGCAP).draw(mCanvas, mPaint,ge);
                        if(gs.getDiaglog1()){
                            objects.get(Level.DIAGLOG_INFOR).draw(mCanvas, mPaint,ge);
                        }else if(gs.getDiaglog2()){
                            objects.get(Level.DIAGLOG_INFOR2).draw(mCanvas, mPaint,ge);
                        }else if(gs.getDiaglog3()){
                            objects.get(Level.DIAGLOG_INFOR3).draw(mCanvas, mPaint,ge);
                        }else if(gs.getDiaglog7()){
                            objects.get(Level.DIAGLOG_KEY).draw(mCanvas, mPaint,ge);
                        }



                }else if (gs.getgd() == gs.GD_TRACNGHIEM_CAOCAP) {



                        objects.get(Level.TRACNGHIEM_CAOCAP).draw(mCanvas, mPaint,ge);
                        if(gs.getDiaglog1()){
                            objects.get(Level.DIAGLOG_INFOR).draw(mCanvas, mPaint,ge);
                        }else if(gs.getDiaglog2()){
                            objects.get(Level.DIAGLOG_INFOR2).draw(mCanvas, mPaint,ge);
                        }else if(gs.getDiaglog3()){
                            objects.get(Level.DIAGLOG_INFOR3).draw(mCanvas, mPaint,ge);
                        }


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
