package com.myapp.quizpg;

import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

class InputMain implements ComponentInput, ObserverInput {

    private ArrayList<myRect> controls;
    InputMain(GameEngine ger) {
        ger.addObserver(this);
    }

    @Override
    public void setControl(ArrayList<myRect> control) {
        controls = control;
    }

    @Override
    public void handleInput(MotionEvent event, GameState gameState) {

        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

        int eventType = event.getAction() & MotionEvent.ACTION_MASK;

        if(eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
            if (controls.get(SpecMain.TRACNGHIEM).rect.contains(x, y)) {
                if(gameState.getgd() == GameState.GD_MAIN){
                    gameState.setgd(GameState.GD_TRACNGHIEM);
                }
            }
            if (controls.get(SpecMain.HINHPHAT).rect.contains(x, y)) {
                if(gameState.getgd() == GameState.GD_MAIN){
                    gameState.setgd(GameState.GD_HINHPHAT);
                }
            }
            if (controls.get(SpecMain.CAUNOIHAY).rect.contains(x, y)) {
                if(gameState.getgd() == GameState.GD_MAIN){
                    gameState.setgd(GameState.GD_CAUNOIHAY);
                }
            }
            if (controls.get(SpecMain.TRONGHOASEN).rect.contains(x, y)) {
                if(gameState.getgd() == GameState.GD_MAIN){
                    gameState.setgd(GameState.GD_TRONGHOASEN);
                }
            }
        }
    }

}
