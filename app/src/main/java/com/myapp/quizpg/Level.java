package com.myapp.quizpg;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;

import java.util.ArrayList;

class Level {

    public static final int MAIN = 0;
    public static final int HINHPHAT = 1;
    public static final int TRACNGHIEM = 2;
    public static final int TRONGHOASEN = 3;
    public static final int CAUNOIHAY = 4;
    private PointF mScreenSize;
    private ArrayList<GameObject> objects;

    public Level(Context context,
                 PointF mScreenSize,
                 GameEngine ge){

        objects = new ArrayList<>();
        GameObjectFactory factory = new GameObjectFactory(
                context, mScreenSize, ge);
        this.mScreenSize = mScreenSize;
        buildGameObjects(factory);
    }

    ArrayList<GameObject> buildGameObjects(GameObjectFactory factory){
        objects.clear();
        objects.add(MAIN, factory.create(new SpecMain(mScreenSize)));
        objects.add(HINHPHAT, factory.create(new SpecHinhPhat(mScreenSize)));
        objects.add(TRACNGHIEM, factory.create(new SpecTracNghiem(mScreenSize)));
        objects.add(TRONGHOASEN, factory.create(new SpecTrongHoaSenGame(mScreenSize)));
        objects.add(CAUNOIHAY, factory.create(new SpecCauNoiHay(mScreenSize)));

        return objects;
    }

    ArrayList<GameObject> getGameObjects(){
        return objects;
    }
}
