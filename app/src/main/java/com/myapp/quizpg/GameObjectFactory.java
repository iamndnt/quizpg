package com.myapp.quizpg;

import android.content.Context;
import android.graphics.PointF;

class GameObjectFactory {
    private Context mContext;
    private PointF mScreenSize;
    private GameEngine mGameEngineReference;

    GameObjectFactory(Context c, PointF screenSize,
                      GameEngine gameEngine) {
        this.mContext = c;
        this.mScreenSize = screenSize;
        mGameEngineReference = gameEngine;
    }

    GameObject create(ObjectSpec spec) {
        GameObject object = new GameObject();

        int mNumComponents = spec.getComponents().length;
        PointF objectSize = new PointF(mScreenSize.x , mScreenSize.y );

        for (int i = 0; i < mNumComponents; i++) {
            switch (spec.getComponents()[i]) {
                case "InputMain":
                    object.setInput(new InputMain
                            (mGameEngineReference));
                    break;
                case "InputTracNghiem":
                    object.setInput(new InputTracNghiem
                            (mGameEngineReference));
                    break;
                case "InputCauNoiHay":
                    object.setInput(new InputCauNoiHay
                            (mGameEngineReference));
                    break;
                case "InputHinhPhat":
                    object.setInput(new InputHinhPhat
                            (mGameEngineReference));
                    break;
                case "InputTrongHoaSen":
                    object.setInput(new InputTrongHoaSen
                            (mGameEngineReference));
                    break;
                case "StdGraphicsComponent":
                    object.setGraphics(new StdGraphicsComponent(), mContext, spec, objectSize);
                    break;
                default:
                    break;
            }
        }
        return object;
    }
}
