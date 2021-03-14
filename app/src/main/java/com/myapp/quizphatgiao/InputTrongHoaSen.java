package com.myapp.quizphatgiao;

import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

public class InputTrongHoaSen implements ComponentInput, ObserverInput{
    private ArrayList<HinhHoc> controls;

    InputTrongHoaSen(GameEngine ger) {
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

        myRect Exit = (myRect)controls.get(SpecTrongHoaSenGame.EXIT);
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;

        if(gameState.getKey() == true) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
                if (Exit.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRONGHOASEN) {
                        gameState.setgd(gameState.GD_MAIN);
                        gameState.clearKey();
                    }
                }
            }
        }
    }
}
