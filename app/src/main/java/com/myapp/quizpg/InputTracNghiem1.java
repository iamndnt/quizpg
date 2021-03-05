package com.myapp.quizpg;

import android.view.MotionEvent;

import java.util.ArrayList;

public class InputTracNghiem1 implements ComponentInput, ObserverInput{
    private ArrayList<HinhHoc> controls;
    @Override
    public void setControl(ArrayList<HinhHoc> control) {
        controls = control;
    }

    InputTracNghiem1(GameEngine ger) {
        ger.addObserver(this);
    }

    @Override
    public void handleInput(MotionEvent event, GameState gameState, GameEngine ge) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

        myRect Exit = (myRect)controls.get(SpecTracNghiem1.EXIT);
        myRect Coban = (myRect)controls.get(SpecTracNghiem1.COBAN);
        myRect Trungcap = (myRect)controls.get(SpecTracNghiem1.TRUNGCAP);
        myRect NangCap = (myRect)controls.get(SpecTracNghiem1.NANGCAO);

        int eventType = event.getAction() & MotionEvent.ACTION_MASK;
        if(gameState.getKey()) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
                if (Exit.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM1) {
                        gameState.setgd(gameState.GD_MAIN);
                        gameState.clearKey();
                    }
                } else if (Coban.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM1) {
                        gameState.setgd(gameState.GD_TRACNGHIEM2);
                        gameState.clearKey();
                    }
                } else if (Trungcap.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM1) {
                       // gameState.setgd(gameState.GD_TRACNGHIEM3);

                        /* show diaglog -> got key or not */
                        gameState.clearKey();
                    }
                } else if (NangCap.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM1) {
                      //  gameState.setgd(gameState.GD_TRACNGHIEM4);
                        /* show diaglog -> got key or not */
                        gameState.clearKey();
                    }
                }
            }
        }
    }
}
