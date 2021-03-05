package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.io.Serializable;
import java.util.ArrayList;

class GameEngine extends SurfaceView
        implements Runnable,
        GameEngineBroadcaster {

    private Thread mThread = null;
    private Thread mThread2 = null;
    private Thread mThread3 = null;
    private Thread mThread4 = null;


    private ArrayList<ObserverInput> inputObservers = new ArrayList();

    private GameState mGameState;
   // private SoundEngine mSoundEngine;
    Renderer mRenderer;
    //ParticleSystem mParticleSystem;
    //PhysicsEngine mPhysicsEngine;
    Level mLevel;
    public ArrayList<Bitmap> bitmapBG;
    public ArrayList<Bitmap> bitmap;
    public ArrayList<Question> questions;

    private Context context;
    private Point size;
    //private long frameStartTime;


    public GameEngine(Context context, Point size) {
        super(context);
        this.context = context;
        this.size = size;
        bitmap = new ArrayList<>();
        bitmapBG = new ArrayList<>();
        questions = new ArrayList<>();
        //frameStartTime = System.currentTimeMillis();
        mGameState = new GameState();
      //  mSoundEngine = new SoundEngine(context);
        mRenderer = new Renderer(this);
       // mPhysicsEngine = new PhysicsEngine();
      //  mParticleSystem = new ParticleSystem();
      //  mParticleSystem.init(1000);
        bitmapBG.add(0,null);
        bitmapBG.add(1,null);
        bitmapBG.add(2,null);
        bitmapBG.add(3,null);
        bitmapBG.add(4,null);
        bitmapBG.add(5,null);
        bitmapBG.add(6,null);
        bitmapBG.add(7,null);
    }

    GameEngine getInstance(){
        return this;
    }


    private void setupQuestion() {
        ArrayList<String> question = getQuestionOutSide();
       // questions = new Question[3][10];
        questions.add(initializeQuestion(question.get(0)));
        questions.add(initializeQuestion(question.get(1)));
        questions.add(initializeQuestion(question.get(2)));
        questions.add(initializeQuestion(question.get(3)));
        questions.add(initializeQuestion(question.get(4)));
        questions.add(initializeQuestion(question.get(5)));
        questions.add(initializeQuestion(question.get(6)));
        questions.add(initializeQuestion(question.get(7)));
        questions.add(initializeQuestion(question.get(8)));
        questions.add(initializeQuestion(question.get(9)));

        questions.add(initializeQuestion(question.get(10)));
        questions.add(initializeQuestion(question.get(11)));
        questions.add(initializeQuestion(question.get(12)));
        questions.add(initializeQuestion(question.get(13)));
        questions.add(initializeQuestion(question.get(14)));
        questions.add(initializeQuestion(question.get(15)));
        questions.add(initializeQuestion(question.get(16)));
        questions.add(initializeQuestion(question.get(17)));
        questions.add(initializeQuestion(question.get(18)));
        questions.add(initializeQuestion(question.get(19)));

        questions.add(initializeQuestion(question.get(20)));
        questions.add(initializeQuestion(question.get(21)));
        questions.add(initializeQuestion(question.get(22)));
        questions.add(initializeQuestion(question.get(23)));
        questions.add(initializeQuestion(question.get(24)));
        questions.add(initializeQuestion(question.get(25)));
        questions.add(initializeQuestion(question.get(26)));
        questions.add(initializeQuestion(question.get(27)));
        questions.add(initializeQuestion(question.get(28)));
        questions.add(initializeQuestion(question.get(29)));
        /*for(int j = 0; j < 3; j++) {
            for (int i = 0; i < 10; i++) {

            }
        }*/
    }

    private Question initializeQuestion(String str) {
        Question ques = new Question();
        // str --> ques~op1~op2~op3~op4~1
        String[] arr = str.split("~");
        ques.question = arr[0];
        ques.option1 = arr[1];
        ques.option2 = arr[2];
        ques.option3 = arr[3];
        ques.option4 = arr[4];
        ques.ans = arr[5];
        return ques;
    }

    private ArrayList<String> getQuestionOutSide() {
        ArrayList<String> str = new ArrayList<>();

        /* CO BAN */
        str.add("ques1~A1~B1~C1~D1~1");
        str.add("ques2~A2~B2~C2~D2~1");
        str.add("ques3~A3~B3~C3~D3~1");
        str.add("ques4~A4~B4~C4~D4~1");
        str.add("ques5~A3~B3~C3~D3~1");
        str.add("ques6~A3~B3~C3~D3~1");
        str.add( "ques7~A3~B3~C3~D3~1");
        str.add( "ques8~A3~B3~C3~D3~1");
        str.add( "ques9~A3~B3~C3~D3~1");
        str.add( "ques10~A3~B3~C3~D3~1");

        /* TRUNG CAP */
        str.add( "ques11~A1~B1~C1~D1~1");
        str.add( "ques12~A2~B2~C2~D2~1");
        str.add( "ques13~A3~B3~C3~D3~1");
        str.add("ques14~A3~B3~C3~D3~1");
        str.add( "ques15~A3~B3~C3~D3~1");
        str.add( "ques16~A3~B3~C3~D3~1");
        str.add( "ques17~A3~B3~C3~D3~1");
        str.add( "ques18~A3~B3~C3~D3~1");
        str.add( "ques19~A3~B3~C3~D3~1");
        str.add("ques20~A3~B3~C3~D3~1");

        /* CAO CAP */
        str.add("ques21~A1~B1~C1~D1~1");
        str.add( "ques22~A2~B2~C2~D2~1");
        str.add( "ques23~A3~B3~C3~D3~1");
        str.add( "ques24~A3~B3~C3~D3~1");
        str.add( "ques25~A3~B3~C3~D3~1");
        str.add( "ques26~A3~B3~C3~D3~1");
        str.add( "ques27~A3~B3~C3~D3~1");
        str.add( "ques28~A3~B3~C3~D3~1");
        str.add( "ques29~A3~B3~C3~D3~1");
        str.add( "ques30~A3~B3~C3~D3~1");

        return str;
    }



    Bitmap initializeBitmap(String NameBitmap, Context context,Point size) {
        Bitmap bitmap;// = new Bitmap();
        // Make a resource id out of the string of the file name
        int resID = context.getResources()
                .getIdentifier(NameBitmap,
                        "drawable",
                        context.getPackageName());

        // Load the bitmap using the id
        bitmap = BitmapFactory.decodeResource(
                context.getResources(), resID);

        // Resize the bitmap
        bitmap = Bitmap
                .createScaledBitmap(bitmap,
                        size.x,
                        size.y,
                        false);

        return bitmap;
    }
    public void addObserver(ObserverInput o) {
        inputObservers.add(o);
    }

    @Override
    public void run() {
        while (mGameState.getThreadRunning()) {

            if(mGameState.getgd() != GameState.GD_PRERATION) {
                ArrayList<GameObject> objects = mLevel.getGameObjects();
                // Draw all the game objects here in a new way
                mRenderer.draw(objects, mGameState,this);
            }else{
                mRenderer.drawBeginning(size);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        mGameState.setKey(true);
        for (ObserverInput o : inputObservers) {
            o.handleInput(motionEvent, mGameState,this);
        }
        return true;
    }

    public void stopThread() {
        try {
            mThread.join();
        } catch (InterruptedException e) {
            Log.e("Exception","stopThread()" + e.getMessage());
        }
    }

    public void startThread() {
        mGameState.startThread();
        mThread = new Thread(this);

        mThread2 = new Thread(() -> {
            GameEngine ge = getInstance();
            setupQuestion();
            mLevel = new Level(context, new PointF(size.x, size.y), ge);
        });

        mThread3 = new Thread(() -> {

            setUpBitmapHinhPhat(context,size);
        });
        mThread4 = new Thread(() -> {

            setUpBackground(context,size);
        });

        mThread.start();
        mThread2.start();
        mThread3.start();
        mThread4.start();

    }



    private void setUpBackground(Context context,Point size) {

        bitmapBG.add(0,initializeBitmap("background_main",context,size));
       // bitmapBG.add(6,initializeBitmap("hinhbandau",context,size));
       // bitmapBG.add(7,initializeBitmap("caunoihaybandau",context,size));

        bitmapBG.add(1,initializeBitmap("background_hinhphat",context,size));
        bitmapBG.add(2,initializeBitmap("background_tracnghiem",context,size));
        mGameState.setgd(GameState.GD_MAIN);
        bitmapBG.add(3,initializeBitmap("background_tracnghiem",context,size));
        bitmapBG.add(4,initializeBitmap("background_tronghoasen",context,size));
        bitmapBG.add(5,initializeBitmap("background_hinhphat",context,size));

    }

    private void setUpBitmapHinhPhat(Context context, Point size) {
        String[] NameBitmap = new String[10];

        NameBitmap[0] = "hinhphat1";
        NameBitmap[1] = "hinhphat2";
        NameBitmap[2] = "hinhphat3";
        NameBitmap[3] = "hinhphat4";
        NameBitmap[4] = "hinhphat5";
        NameBitmap[5] = "hinhphat6";
        NameBitmap[6] = "hinhphat7";
        NameBitmap[7] = "hinhphat8";
        NameBitmap[8] = "hinhphat9";
        NameBitmap[9] = "hinhphat10";

        for(int i=0;i<10;i++){
            bitmap.add(initializeBitmap(NameBitmap[i],context,size));
        }
    }


}
