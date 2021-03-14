package com.myapp.quizphatgiao;

final class GameState {

    public static final int GD_MAIN = 0;
    public static final int GD_HINHPHAT = 1;
    public static final int GD_TRACNGHIEM_DASHBOARD = 2;
    public static final int GD_TRACNGHIEMC_COBAN= 3;
    public static final int GD_TRACNGHIEM_TRUNGCAP= 4;
    public static final int GD_TRACNGHIEM_CAOCAP= 5;
    public static final int GD_TRONGHOASEN = 6;
    public static final int GD_CAUNOIHAY = 7;
    public static final int GD_PRERATION = 8;

    GameState(){
        this.setgd(GD_PRERATION);
    }

    private static volatile boolean mThreadRunning = false;
    private static volatile int gd = 0;
    private static volatile boolean key = false;
    private static volatile boolean diaglog0 = false;
    private static volatile boolean diaglog1 = false;
    private static volatile boolean diaglog2 = false;
    private static volatile boolean diaglog3 = false;
    private static volatile boolean diaglog4 = false;
    private static volatile boolean diaglog5 = false;
    private static volatile boolean diaglog6 = false;
    private static volatile boolean diaglog7 = false;
    boolean getThreadRunning(){
        return mThreadRunning;
    }

    void startThread(){
        mThreadRunning = true;
    }

    void stopThread(){
        mThreadRunning = false;
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

    public boolean getDiaglog0() {
        return diaglog0;
    }
    public void setDiaglog0(){
        diaglog0 = true;
    }
    public void clearDiaglog0() {
        diaglog0 = false;
    }

    public boolean getDiaglog1() {
        return diaglog1;
    }
    public void setDiaglog1(){
        diaglog1 = true;
    }
    public void clearDiaglog1() {
        diaglog1 = false;
    }

    public boolean getDiaglog2() {
        return diaglog2;
    }
    public void setDiaglog2(){
        diaglog2 = true;
    }
    public void clearDiaglog2() {
        diaglog2 = false;
    }

    public boolean getDiaglog3() {
        return diaglog3;
    }
    public void setDiaglog3(){
        diaglog3 = true;
    }
    public void clearDiaglog3() {
        diaglog3 = false;
    }

    public boolean getDiaglog4() {
        return diaglog4;
    }
    public void setDiaglog4(){
        diaglog4 = true;
    }
    public void clearDiaglog4() {
        diaglog4 = false;
    }

    public boolean getDiaglog5() {
        return diaglog5;
    }
    public void setDiaglog5(){
        diaglog5 = true;
    }
    public void clearDiaglog5() {
        diaglog5 = false;
    }

    public boolean getDiaglog6() {
        return diaglog6;
    }
    public void setDiaglog6(){
        diaglog6 = true;
    }
    public void clearDiaglog6() {
        diaglog6 = false;
    }

    public boolean getDiaglog7() {
        return diaglog7;
    }
    public void setDiaglog7(){
        diaglog7 = true;
    }
    public void clearDiaglog7() {
        diaglog7 = false;
    }


}
