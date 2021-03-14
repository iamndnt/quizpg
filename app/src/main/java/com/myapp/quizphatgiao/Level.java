package com.myapp.quizphatgiao;

import android.content.Context;
import android.graphics.PointF;

import java.util.ArrayList;

class Level {

    public static final int MAIN = 0;
    public static final int HINHPHAT = 1;
    public static final int TRACNGHIEM_DASHBOARD = 2;
    public static final int TRACNGHIEM_COBAN = 3;
    public static final int TRACNGHIEM_TRUNGCAP = 4;
    public static final int TRACNGHIEM_CAOCAP = 5;
    public static final int TRONGHOASEN = 6;
    public static final int CAUNOIHAY = 7;
    public static final int DIAGLOG_TRONGHOASEN = 8;
    public static final int DIAGLOG_TRUNGCAP = 9;
    public static final int DIAGLOG_CAOCAP = 10;
    public static final int DIAGLOG_INFOR = 11;
    public static final int DIAGLOG_INFOR2 = 12;
    public static final int DIAGLOG_INFOR3 = 13;
    public static final int DIAGLOG_WIN = 14;
    public static final int DIAGLOG_KEY = 15;
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


        objects.add(MAIN, factory.create(new SpecMain(mScreenSize,ge)));
        objects.add(HINHPHAT, factory.create(new SpecHinhPhat(mScreenSize,ge,context)));
        objects.add(TRACNGHIEM_DASHBOARD, factory.create(new SpecTracNghiem_DASHBOARD(mScreenSize,ge)));

        objects.add(TRACNGHIEM_COBAN, factory.create(new SpecTracNghiem_TN_COBAN(mScreenSize,ge)));
        objects.add(TRACNGHIEM_TRUNGCAP, factory.create(new SpecTracNghiem_TN_TRUNGCAP(mScreenSize,ge)));
        objects.add(TRACNGHIEM_CAOCAP, factory.create(new SpecTracNghiem_TN_CAOCAP(mScreenSize,ge)));

        objects.add(TRONGHOASEN, factory.create(new SpecTrongHoaSenGame(mScreenSize,ge)));
        objects.add(CAUNOIHAY, factory.create(new SpecCauNoiHay(mScreenSize,ge,context)));

        objects.add(DIAGLOG_TRONGHOASEN, factory.create(new SpecDiaglogTracNghiemHoaSen(mScreenSize,"Chức năng đang được phát triển, sẻ cập nhật ngay")));
        objects.add(DIAGLOG_TRUNGCAP, factory.create(new SpecDiaglogTRUNGCAP(mScreenSize,"Bạn cần 1 chìa khóa để mở cánh cửa này")));
        objects.add(DIAGLOG_CAOCAP, factory.create(new SpecDiaglogCAOCAP(mScreenSize,"Bạn cần 2 chìa khóa để mở cánh cửa này")));
        objects.add(DIAGLOG_INFOR, factory.create(new SpecDiaglogInfor1(mScreenSize,"bạn đả chắc chắn về câu trả lời ? ")));
        objects.add(DIAGLOG_INFOR2, factory.create(new SpecDiaglogInfor2(mScreenSize,"chính xác chúc mừng bạn, +1 điểm nè ")));
        objects.add(DIAGLOG_INFOR3, factory.create(new SpecDiaglogInfor3(mScreenSize,"sai rồi, không được cộng điểm rồi ")));
        objects.add(DIAGLOG_WIN, factory.create(new SpecDiaglogWin(mScreenSize,"tuyệt vời bạn là người chiến thắng")));
        objects.add(DIAGLOG_KEY, factory.create(new SpecDiaglogInfor4(mScreenSize,"tuyệt vời, bạn đả có 1 chìa khóa ")));

        return objects;
    }

    ArrayList<GameObject> getGameObjects(){
        return objects;
    }
}
