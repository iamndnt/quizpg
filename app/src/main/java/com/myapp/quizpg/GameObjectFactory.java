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
                case "InputTracNghiemDASHBOARD":
                    object.setInput(new InputTracNghiem_DASHBOARD
                            (mGameEngineReference));
                    break;
                case "InputTracNghiemCOBAN":
                    object.setInput(new InputTracNghiem_TN_COBAN
                            (mGameEngineReference));
                    break;
                case "InputTracNghiemTRUNGCAP":
                    object.setInput(new InputTracNghiem_TN_TRUNGCAP
                            (mGameEngineReference));
                    break;
                case "InputTracNghiemCAOCAP":
                    object.setInput(new InputTracNghiem_TN_CAOCAP
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
                case "InputDiaglogTRONGHOASEN":
                    object.setInput(new InputDiaglogTracNghiemHoaSen
                            (mGameEngineReference));
                    break;
                case "InputDiaglogTRUNGCAP":
                    object.setInput(new InputDiaglogTrungCap
                            (mGameEngineReference));
                    break;
                case "InputDiaglogCAOCAP":
                    object.setInput(new InputDiaglogCaoCap
                            (mGameEngineReference));
                    break;
                case "InputDiaglogInfor":
                    object.setInput(new InputDiaglogInfor1
                            (mGameEngineReference));
                    break;
                case "InputDiaglogInfor2":
                    object.setInput(new InputDiaglogInfor2
                            (mGameEngineReference));
                    break;
                case "InputDiaglogInfor3":
                    object.setInput(new InputDiaglogInfor3
                            (mGameEngineReference));
                    break;
                case "InputDiaglogInfor4":
                    object.setInput(new InputDiaglogInfor4
                            (mGameEngineReference));
                    break;
                case "InputDiaglogWin":
                    object.setInput(new InputDiaglogWin
                            (mGameEngineReference));
                    break;
                case "StdGraphicsComponent":
                    object.setGraphics(new StdGraphicsComponent(), mContext, spec);
                    break;

                default:
                    break;
            }
        }
        return object;
    }
}
