package com.myapp.quizpg;

import android.view.MotionEvent;

import java.util.ArrayList;

public class InputDiaglogWin implements ComponentInput, ObserverInput{
    private ArrayList<HinhHoc> controls;

    InputDiaglogWin(GameEngine ger) {
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

        myRect OK = (myRect)controls.get(SpecDiaglogCAOCAP.OK);
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;

        if(gameState.getKey()) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
                if (OK.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_MAIN
                            && gameState.getDiaglog5()

                    ) {
                        gameState.clearDiaglog5();
                        gameState.clearKey();
                    }
                }
            }
        }
    }
}
