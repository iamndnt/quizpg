package com.myapp.quizpg;

import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

public class InputTrongHoaSen implements ComponentInput, ObserverInput{
    private ArrayList<myRect> controls;

    InputTrongHoaSen(GameEngine ger) {
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
            if (controls.get(SpecTrongHoaSenGame.EXIT).rect.contains(x, y)) {
                if(gameState.getgd() == gameState.GD_TRONGHOASEN){
                    gameState.setgd(gameState.GD_MAIN);
                }
            }
        }
    }
}
