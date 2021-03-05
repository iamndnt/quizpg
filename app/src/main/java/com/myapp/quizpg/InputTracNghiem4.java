package com.myapp.quizpg;

import android.view.MotionEvent;

import java.util.ArrayList;

class InputTracNghiem4 implements ComponentInput, ObserverInput {

    private ArrayList<HinhHoc> controls;
    private int index;

    InputTracNghiem4(GameEngine ger) {
        ger.addObserver(this);
        index=20;
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

        myRect Exit = (myRect)controls.get(SpecTracNghiem4.EXIT);
        myRect NextQuestion = (myRect)controls.get(SpecTracNghiem4.NEXTQUESTION);
        myTracNghiem tracNghiem = (myTracNghiem)controls.get(SpecTracNghiem4.TN);

        int eventType = event.getAction() & MotionEvent.ACTION_MASK;

        if(gameState.getKey()) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
                if (Exit.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM4 ){
                        gameState.setgd(gameState.GD_TRACNGHIEM1);
                        gameState.clearKey();
                    }
                } else if (NextQuestion.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM4) {
                        tracNghiem.checkQues(index);
                        index++;
                        if(index == 30){
                            index = 20;
                            /* show diaglog */

                            /* back to TRACHNGHIEM1*/
                        }
                        gameState.clearKey();

                    }
                }
            }
        }
    }
}
