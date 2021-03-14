package com.myapp.quizphatgiao;

import android.view.MotionEvent;

import java.util.ArrayList;

class InputMain implements ComponentInput, ObserverInput {

    private ArrayList<HinhHoc> controls;

    InputMain(GameEngine ger) {
        ger.addObserver(this);
    }

    @Override
    public void setControl(ArrayList<HinhHoc> control) {
        controls = control;
    }

    @Override
    public void handleInput(MotionEvent event, GameState gameState,GameEngine ge) {

        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

        myRect Tracnghiem = (myRect)controls.get(SpecMain.TRACNGHIEM);
        myRect Hinhphat = (myRect)controls.get(SpecMain.HINHPHAT);
        myRect Caunoihay = (myRect)controls.get(SpecMain.CAUNOIHAY);
        myRect Tronghoasen = (myRect)controls.get(SpecMain.TRONGHOASEN);

        int eventType = event.getAction() & MotionEvent.ACTION_MASK;

        if(gameState.getKey()) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {

                if (Tracnghiem.rect.contains(x, y)) {
                    if (gameState.getgd() == GameState.GD_MAIN) {



                        if(ge.chiakhoa == 3){
                            gameState.setDiaglog5();
                        }else{
                            gameState.setgd(GameState.GD_TRACNGHIEM_DASHBOARD);
                        }

                        gameState.clearKey();
                    }
                } else if (Hinhphat.rect.contains(x, y)) {
                    if (gameState.getgd() == GameState.GD_MAIN) {
                        gameState.setgd(GameState.GD_HINHPHAT);
                        gameState.clearKey();
                    }
                } else if (Caunoihay.rect.contains(x, y)) {
                    if (gameState.getgd() == GameState.GD_MAIN) {
                        gameState.setgd(GameState.GD_CAUNOIHAY);
                        gameState.clearKey();
                    }
                } else if (Tronghoasen.rect.contains(x, y)) {
                    if (gameState.getgd() == GameState.GD_MAIN) {
                        gameState.setgd(GameState.GD_TRONGHOASEN);
                        gameState.clearKey();
                    }
                }
            }
        }
    }
}
