package com.myapp.quizpg;

import android.view.MotionEvent;

import java.util.ArrayList;

public class InputCauNoiHay implements ComponentInput, ObserverInput{

    private ArrayList<HinhHoc> controls;

    private int index;
    InputCauNoiHay(GameEngine ger) {
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

        myRect Exit = (myRect)controls.get(SpecCauNoiHay.EXIT);
        myRect KhungHinh = (myRect)controls.get(SpecCauNoiHay.KHUNGHINH);
        Triangle Previous = (Triangle)controls.get(SpecCauNoiHay.PREVIOUS);
        Triangle Next = (Triangle)controls.get(SpecCauNoiHay.NEXT);

        int eventType = event.getAction() & MotionEvent.ACTION_MASK;

        if(gameState.getKey()) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {

                if (Exit.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_CAUNOIHAY) {
                        gameState.setgd(gameState.GD_MAIN);
                        gameState.clearKey();
                    }
                }else if (Previous.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_CAUNOIHAY) {
                        ge.checkBitmap1(+1);
                        gameState.clearKey();
                    }
                } else if (Next.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_CAUNOIHAY) {
                        ge.checkBitmap1(-1);
                        gameState.clearKey();
                    }
                }
            }
        }
    }
}
