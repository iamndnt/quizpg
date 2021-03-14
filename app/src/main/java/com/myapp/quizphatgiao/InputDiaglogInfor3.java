package com.myapp.quizphatgiao;

import android.view.MotionEvent;

import java.util.ArrayList;

public class InputDiaglogInfor3 implements ComponentInput, ObserverInput{
    private ArrayList<HinhHoc> controls;

    InputDiaglogInfor3(GameEngine ger) {
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

        myRect NEXTQUESTION = (myRect)controls.get(SpecDiaglogInfor3.NEXTQUEST);

        int eventType = event.getAction() & MotionEvent.ACTION_MASK;

        if(gameState.getKey()) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
                if (NEXTQUESTION.rect.contains(x, y)) {
                    if ((gameState.getgd() == gameState.GD_TRACNGHIEMC_COBAN ||
                            gameState.getgd() == gameState.GD_TRACNGHIEM_TRUNGCAP||
                            gameState.getgd() == gameState.GD_TRACNGHIEM_CAOCAP)
                            && gameState.getDiaglog3()
                    ) {
                        ge.checkQues();
                        gameState.clearDiaglog3();
                        gameState.clearKey();
                    }
                }
            }
        }
    }

}
