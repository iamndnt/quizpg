package com.myapp.quizpg;

import android.view.MotionEvent;

import java.util.ArrayList;

public class InputHinhPhat implements ComponentInput, ObserverInput{

    private ArrayList<HinhHoc> controls;
    private int index;
    @Override
    public void setControl(ArrayList<HinhHoc> control) {
        controls = control;
    }
    InputHinhPhat(GameEngine ger) {
        ger.addObserver(this);
        index = 0;
    }

    @Override
    public void handleInput(MotionEvent event, GameState gameState, GameEngine ge) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

        myRect Exit = (myRect)controls.get(SpecHinhPhat.EXIT);
        myRect KhungHinh = (myRect)controls.get(SpecHinhPhat.KHUNGHINH);
        Triangle Previous = (Triangle)controls.get(SpecHinhPhat.PREVIOUS);
        Triangle Next = (Triangle)controls.get(SpecHinhPhat.NEXT);

        int eventType = event.getAction() & MotionEvent.ACTION_MASK;

        if(gameState.getKey()) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
                if (Exit.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_HINHPHAT) {
                        gameState.setgd(gameState.GD_MAIN);
                        gameState.clearKey();
                    }
                } else if (Previous.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_HINHPHAT) {
                        ge.checkBitmap(-1);
                        gameState.clearKey();
                    }
                } else if (Next.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_HINHPHAT) {
                        ge.checkBitmap(+1);
                        gameState.clearKey();
                    }
                }
            }
        }
    }
}
