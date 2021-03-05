package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;

import java.util.ArrayList;

class Level {

    public static final int MAIN = 0;
    public static final int HINHPHAT = 1;
    public static final int TRACNGHIEM1 = 2;
    public static final int TRACNGHIEM2 = 3;
    public static final int TRACNGHIEM3 = 4;
    public static final int TRACNGHIEM4 = 5;
    public static final int TRONGHOASEN = 6;
    public static final int CAUNOIHAY = 7;

    private PointF mScreenSize;
    private ArrayList<GameObject> objects;

    public Level(Context context,
                 PointF mScreenSize,
                 GameEngine ge){

        objects = new ArrayList<>();
        GameObjectFactory factory = new GameObjectFactory(
                context, mScreenSize, ge);
        this.mScreenSize = mScreenSize;
        buildGameObjects(factory,ge,context);
    }

    ArrayList<GameObject> buildGameObjects(GameObjectFactory factory,GameEngine ge,Context context){
        objects.clear();

        Question question1 = new Question("ques1","op1","op2","op3","op4","A");
        Question question2 = new Question("ques2","op1","op2","op3","op4","A");
        Question question3 = new Question("ques3","op1","op2","op3","op4","A");

        objects.add(MAIN, factory.create(new SpecMain(mScreenSize,ge)));
        objects.add(HINHPHAT, factory.create(new SpecHinhPhat(mScreenSize,ge,context)));
        objects.add(TRACNGHIEM1, factory.create(new SpecTracNghiem1(mScreenSize,ge)));

        objects.add(TRACNGHIEM2, factory.create(new SpecTracNghiem2(mScreenSize,ge,question1)));
        objects.add(TRACNGHIEM3, factory.create(new SpecTracNghiem3(mScreenSize,ge,question2)));
        objects.add(TRACNGHIEM4, factory.create(new SpecTracNghiem4(mScreenSize,ge,question3)));

        objects.add(TRONGHOASEN, factory.create(new SpecTrongHoaSenGame(mScreenSize,ge)));
        objects.add(CAUNOIHAY, factory.create(new SpecCauNoiHay(mScreenSize,ge,context)));

        return objects;
    }

    ArrayList<GameObject> getGameObjects(){
        return objects;
    }
}
