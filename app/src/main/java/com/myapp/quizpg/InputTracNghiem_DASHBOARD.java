package com.myapp.quizpg;

import android.view.MotionEvent;

import java.util.ArrayList;

public class InputTracNghiem_DASHBOARD implements ComponentInput, ObserverInput{
    private ArrayList<HinhHoc> controls;
    @Override
    public void setControl(ArrayList<HinhHoc> control) {
        controls = control;
    }

    InputTracNghiem_DASHBOARD(GameEngine ger) {
        ger.addObserver(this);
    }

    @Override
    public void handleInput(MotionEvent event, GameState gameState, GameEngine ge) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

        myRect Exit = (myRect)controls.get(SpecTracNghiem_DASHBOARD.EXIT);
        myRect Coban = (myRect)controls.get(SpecTracNghiem_DASHBOARD.COBAN);
        myRect Trungcap = (myRect)controls.get(SpecTracNghiem_DASHBOARD.TRUNGCAP);
        myRect NangCap = (myRect)controls.get(SpecTracNghiem_DASHBOARD.NANGCAO);

        int eventType = event.getAction() & MotionEvent.ACTION_MASK;
        if(gameState.getKey()) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
                if (Exit.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM_DASHBOARD) {
                        gameState.setgd(gameState.GD_MAIN);
                        gameState.clearKey();
                    }
                } else if (Coban.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM_DASHBOARD) {
                        gameState.setgd(gameState.GD_TRACNGHIEMC_COBAN);
                        gameState.clearKey();
                    }
                } else if (Trungcap.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM_DASHBOARD && !gameState.getDiaglog0()&& !gameState.getDiaglog6()) {

                        if(ge.chiakhoa == 1 || ge.chiakhoa == 2){
                            gameState.setgd(gameState.GD_TRACNGHIEM_TRUNGCAP);
                        }else{
                            gameState.setDiaglog0();
                        }
                        /* show diaglog -> got key or not */
                        gameState.clearKey();
                    }
                } else if (NangCap.rect.contains(x, y)) {
                    if (gameState.getgd() == gameState.GD_TRACNGHIEM_DASHBOARD && !gameState.getDiaglog6()&& !gameState.getDiaglog0()) {

                        if(ge.chiakhoa == 2){
                            gameState.setgd(gameState.GD_TRACNGHIEM_CAOCAP);
                        }else{
                            gameState.setDiaglog6();
                        }
                        /* show diaglog -> got key or not */
                        gameState.clearKey();
                    }
                }
            }
        }
    }
}
