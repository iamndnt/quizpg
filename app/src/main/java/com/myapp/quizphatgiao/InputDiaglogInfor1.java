package com.myapp.quizphatgiao;

import android.view.MotionEvent;

import java.util.ArrayList;

public class InputDiaglogInfor1 implements ComponentInput, ObserverInput{
    private ArrayList<HinhHoc> controls;


    private int scored;
    private Question question;
    InputDiaglogInfor1(GameEngine ger) {
        ger.addObserver(this);
        scored=0;
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

        myRect CHACCHAN = (myRect)controls.get(SpecDiaglogInfor1.CHACROI);
        myRect CHUACHAC = (myRect)controls.get(SpecDiaglogInfor1.CHUA);

        int eventType = event.getAction() & MotionEvent.ACTION_MASK;

        if(gameState.getKey()) {
            if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
                if (CHACCHAN.rect.contains(x, y)) {
                    if ((gameState.getgd() == gameState.GD_TRACNGHIEMC_COBAN ||
                            gameState.getgd() == gameState.GD_TRACNGHIEM_TRUNGCAP||
                            gameState.getgd() == gameState.GD_TRACNGHIEM_CAOCAP)
                            && gameState.getDiaglog1()

                    ) {
                        if(ge.checkAns()){
                            ge.TNpoint++;
                            if(ge.TNpoint > 20){
                                ge.chiakhoa++;
                                gameState.setDiaglog7();
                                ge.TNpoint=0;
                            }else{
                                gameState.setDiaglog2();
                            }
                        }else{
                            gameState.setDiaglog3();
                        }

                        // check and update chia khoa


                        gameState.clearDiaglog1();
                        gameState.clearKey();
                    }
                }else if(CHUACHAC.rect.contains(x, y)){
                    if ((gameState.getgd() == gameState.GD_TRACNGHIEMC_COBAN ||
                            gameState.getgd() == gameState.GD_TRACNGHIEM_TRUNGCAP||
                            gameState.getgd() == gameState.GD_TRACNGHIEM_CAOCAP)
                            && gameState.getDiaglog1()

                    ) {
                        gameState.clearDiaglog1();
                        gameState.clearKey();
                    }
                }

            }
        }
    }
}
