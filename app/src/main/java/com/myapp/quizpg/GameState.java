package com.myapp.quizpg;

final class GameState {

    public static final int GD_MAIN = 0;
    public static final int GD_TRACNGHIEM = 1;
    public static final int GD_HINHPHAT = 2;
    public static final int GD_TRONGHOASEN = 3;
    public static final int GD_CAUNOIHAY = 4;

    GameState(){
        this.setgd(GD_MAIN);
    }

    private static volatile boolean mThreadRunning = false;
    private static volatile int gd = 0;

    boolean getThreadRunning(){
        return mThreadRunning;
    }

    void startThread(){
        mThreadRunning = true;
    }

    public void setgd(int mgd) {
        gd = mgd;
    }

    public int getgd() {
        return gd;
    }
}
