package com.myapp.quizpg;

final class GameState {

    public static final int GD_MAIN = 0;
    public static final int GD_HINHPHAT = 1;
    public static final int GD_TRACNGHIEM1 = 2;
    public static final int GD_TRACNGHIEM2= 3;
    public static final int GD_TRACNGHIEM3= 4;
    public static final int GD_TRACNGHIEM4= 5;
    public static final int GD_TRONGHOASEN = 6;
    public static final int GD_CAUNOIHAY = 7;
    public static final int GD_PRERATION = 8;

    GameState(){
        this.setgd(GD_PRERATION);
    }

    private static volatile boolean mThreadRunning = false;
    private static volatile int gd = 0;
    private static volatile boolean key = false;

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

    public boolean getKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public void clearKey() {
        key = false;
    }
}
