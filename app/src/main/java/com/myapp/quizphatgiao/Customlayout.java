package com.myapp.quizphatgiao;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Customlayout extends ViewGroup {
    private Point size;
    private int x,y,rate,loai,count,level,ilevel;
    private View[] child;
    private View diaglog,cautiep_win,cautiep_lose_1,cautiep_lose_2,win;
    private startnewview startnewview;
    private Rect rect1,rect2,rect3,rect4,rect_dialog_chacchan,rect_dialog_kchacchan,rect_negative,rect_cautiep,rect_quayve,rect_thoat;
    private int check;
    private boolean ans;
    private ArrayList<Drawable> icon;
    private Drawable myIcon;
    public Customlayout(Context context, Point size, startnewview startnewview, int loai, int count, ArrayList<Drawable> icon, int level) {
        super(context);
        this.size = size;
        this.x = size.x;
        this.y = size.y;
        rate = 10;
        check = 0;
        ilevel = 0;
        this.level = level;
        this.icon = icon;
        this.count = count;
        child = new View[17];
        ans = false;
        this.loai = loai;
        this.startnewview = startnewview;
        rect1 = new Rect((x*1)/rate,(y*5)/rate,(x*4)/rate,(y*7)/rate);
        rect2 = new Rect((x*4)/rate,(y*5)/rate,(x*7)/rate,(y*7)/rate);
        rect3 = new Rect((x*1)/rate,(y*7)/rate,(x*4)/rate,(y*9)/rate);
        rect4 = new Rect((x*4)/rate,(y*7)/rate,(x*7)/rate,(y*9)/rate);
        rect_dialog_chacchan = new Rect((this.x*2)/rate,(this.y*5)/rate,(this.x*4)/rate,(this.y*7)/rate);
        rect_dialog_kchacchan = new Rect((this.x*4)/rate,(this.y*5)/rate,(this.x*7)/rate,(this.y*7)/rate);
        rect_negative = new Rect(-1000,-1000,-2000,-2000);
        myIcon = getResources().getDrawable(R.drawable.button_pink);
        rect_cautiep = new Rect((this.x*4)/rate,(this.y*5)/rate,(this.x*7)/rate,(this.y*7)/rate);
        rect_quayve = new Rect((this.x*4)/rate,(this.y*5)/rate,(this.x*7)/rate,(this.y*7)/rate);
        rect_thoat = new Rect((x*6)/rate,0,(x*7)/rate,(y*1)/rate);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;
        if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {


            if(check == 0) {
                if (rect1.contains(x, y)) {
                    setView1(diaglog,(this.x*2)/rate,(this.y*3)/rate,(this.x*7)/rate,(this.y*7)/rate);
                    check = 1;
                    ans = startnewview.checkAns("A");
                }
                if (rect2.contains(x, y)) {
                    setView1(diaglog,(this.x*2)/rate,(this.y*3)/rate,(this.x*7)/rate,(this.y*7)/rate);
                    check = 1;
                    ans = startnewview.checkAns("B");
                }
                if (rect3.contains(x, y)) {
                    setView1(diaglog,(this.x*2)/rate,(this.y*3)/rate,(this.x*7)/rate,(this.y*7)/rate);
                    check = 1;
                    ans = startnewview.checkAns("C");
                }
                if (rect4.contains(x, y)) {
                    setView1(diaglog,(this.x*2)/rate,(this.y*3)/rate,(this.x*7)/rate,(this.y*7)/rate);
                    check = 1;
                    ans = startnewview.checkAns("D");
                }
            }else if(check == 1){
                // continue and check
                if (rect_dialog_chacchan.contains(x, y)) {
                    setView1(diaglog,rect_negative);

                    if(ans){
                        startnewview.setPoint(1);
                        ilevel++;
                        if(ilevel==5){
                            setView1(win, (this.x*2)/rate,(this.y*3)/rate,(this.x*7)/rate,(this.y*7)/rate);
                            check = 4;
                        }else {
                            setView1(cautiep_win, (this.x * 2) / rate, (this.y * 3) / rate, (this.x * 7) / rate, (this.y * 7) / rate);
                            //set color level
                            myIcon = getResources().getDrawable(R.drawable.button_green);
                            icon.set(count - 1, myIcon);
                            //child[count].setBackground(myIcon);
                            check = 2;
                        }
                    }else{
                        loai--;
                        if(loai==0){
                            setView1(cautiep_lose_2, (this.x*2)/rate,(this.y*3)/rate,(this.x*7)/rate,(this.y*7)/rate);
                            check = 3;
                        }else {
                            setView1(cautiep_lose_1, (this.x*2)/rate,(this.y*3)/rate,(this.x*7)/rate,(this.y*7)/rate);
                            check=2;
                            myIcon = getResources().getDrawable(R.drawable.button_red);
                            icon.set(count-1,myIcon);
                        }
                    }
                }
                // quay ve trang thai ban dau
                if (rect_dialog_kchacchan.contains(x, y)) {
                    setView1(diaglog,-1000,-1000,-1200,-1200);
                    check  = 0;
                }
            }else if(check ==2){
                if (rect_cautiep.contains(x, y)) {
                    setView1(cautiep_win,rect_negative);
                    setView1(cautiep_lose_1,rect_negative);
                    setView1(cautiep_lose_2,rect_negative);
                    //set color level
                    child[count].setBackground(myIcon);
                    check =0;
                    Question q = startnewview.checkQues();
                    count++;
                    startnewview.startview_layout(loai,q,count,icon,level);
                }
            }else if(check ==3){
                if (rect_quayve.contains(x, y)) {
                    check =0;
                    startnewview.setAds();
                    startnewview.startview0();
                }

            }else if(check ==4 ){
                if (rect_quayve.contains(x, y)) {
                    Drawable myIcon1 = getResources().getDrawable(R.drawable.button_pink);
                    ArrayList<Drawable> dr = new ArrayList<>();
                    for (int i1 = 0; i1 < 8; i1++) {
                        dr.add(myIcon1);
                    }
                    check = 0;
                    Question ques = startnewview.checkQues();
                    level++;
                    startnewview.startview_layout(3, ques, 1, dr, level);
                }
            }
        }


        if(rect_thoat.contains(x,y)){
            startnewview.setAds();
            startnewview.startview0();
        }

        return true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        child[0] = getChildAt(0);
        setView1(child[0],l,t,r,b);

        for(int i=1;i<17;i++) {
            child[i] = getChildAt(i);
        }

        diaglog = getChildAt(17);
        cautiep_win = getChildAt(18);
        cautiep_lose_1 = getChildAt(19);
        cautiep_lose_2 = getChildAt(20);
        win = getChildAt(21);

        setView1(child[1],(8*x)/rate,(y*1)/rate,x,(y*2)/rate);
        setView1(child[2],(8*x)/rate,(y*2)/rate,x,(y*3)/rate);
        setView1(child[3],(8*x)/rate,(y*3)/rate,x,(y*4)/rate);
        setView1(child[4],(8*x)/rate,(y*4)/rate,x,(y*5)/rate);
        setView1(child[5],(8*x)/rate,(y*5)/rate,x,(y*6)/rate);
        setView1(child[6],(8*x)/rate,(y*6)/rate,x,(y*7)/rate);
        setView1(child[7],(8*x)/rate,(y*7)/rate,x,(y*8)/rate);
        setView1(child[8],(8*x)/rate,(y*8)/rate,x,(y*9)/rate);

        setView1(child[9],(x*1)/rate,0,(x*2)/rate,(y*1)/rate);
        //debug
        setView1(child[10],(x*2)/rate,0,(x*4)/rate,(y*1)/rate);
        setView1(child[16],(x*6)/rate,0,(x*7)/rate,(y*1)/rate);
        // question
        setView1(child[11],(x*1)/rate,(y*2)/rate,(x*7)/rate,(y*5)/rate);

        // option1 ~ A
        setView1(child[12],(x*1)/rate,(y*5)/rate,(x*4)/rate,(y*7)/rate);
        // option2 ~ B
        setView1(child[13],(x*4)/rate,(y*5)/rate,(x*7)/rate,(y*7)/rate);
        // option3 ~ C
        setView1(child[14],(x*1)/rate,(y*7)/rate,(x*4)/rate,(y*9)/rate);
        // option4 ~ D
        setView1(child[15],(x*4)/rate,(y*7)/rate,(x*7)/rate,(y*9)/rate);


    }
    private void setView1(View child,int l, int t, int r, int b) {
        child.layout(l,t,r,b);
    }

    private void setView1(View child,Rect rect) {
        child.layout(rect.left,rect.top,rect.right,rect.bottom);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(size.x,size.y);
    }
}
