package com.myapp.quizphatgiao;

import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

class InputTracNghiem_TN_CAOCAP implements ComponentInput, ObserverInput {

    private ArrayList<HinhHoc> controls;
    private Rect Option1;
    private Rect Option2;
    private Rect Option3;
    private Rect Option4;
    InputTracNghiem_TN_CAOCAP(GameEngine ger) {
        ger.addObserver(this);
    }

    @Override
    public void setControl(ArrayList<HinhHoc> control) {
        controls = control;
    }

    @Override
    public void handleInput(MotionEvent event, GameState gameState, GameEngine ge) {

        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

        myRect Exit = (myRect)controls.get(SpecTracNghiem_TN_CAOCAP.EXIT);
        myTracNghiem tracNghiem = (myTracNghiem)controls.get(SpecTracNghiem_TN_CAOCAP.TN);
        Option1 = (Rect) tracNghiem.rect[1].rect;
        Option2 = (Rect) tracNghiem.rect[2].rect;
        Option3 = (Rect) tracNghiem.rect[3].rect;
        Option4 = (Rect) tracNghiem.rect[4].rect;
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;

        if(gameState.getKey()) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
                if (Exit.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM_CAOCAP ){
                        gameState.setgd(gameState.GD_TRACNGHIEM_DASHBOARD);
                        gameState.clearKey();
                    }
                }else if(Option1.contains(x,y)){
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM_CAOCAP && !gameState.getDiaglog7()&& !gameState.getDiaglog1() && !gameState.getDiaglog2()&& !gameState.getDiaglog3()) {
                        ge.setANS("A");
                        gameState.setDiaglog1();
                        gameState.clearKey();
                    }
                }else if(Option2.contains(x,y)){
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM_CAOCAP && !gameState.getDiaglog7()&& !gameState.getDiaglog1() && !gameState.getDiaglog2()&& !gameState.getDiaglog3()) {
                        ge.setANS("B");
                        gameState.setDiaglog1();
                        gameState.clearKey();
                    }
                }else if(Option3.contains(x,y)){
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM_CAOCAP && !gameState.getDiaglog7()&& !gameState.getDiaglog1() && !gameState.getDiaglog2()&& !gameState.getDiaglog3()) {
                        ge.setANS("C");
                        gameState.setDiaglog1();
                        gameState.clearKey();
                    }
                }else if(Option4.contains(x,y)){
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM_CAOCAP && !gameState.getDiaglog7()&& !gameState.getDiaglog1() && !gameState.getDiaglog2()&& !gameState.getDiaglog3()) {
                        ge.setANS("D");
                        gameState.setDiaglog1();
                        gameState.clearKey();
                    }
                }
            }
        }
    }
}
