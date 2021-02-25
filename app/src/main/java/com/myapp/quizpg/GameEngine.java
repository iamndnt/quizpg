package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;

class GameEngine extends SurfaceView
        implements Runnable,
        GameEngineBroadcaster{

    private Thread mThread = null;
    private long mFPS;

    private ArrayList<ObserverInput> inputObservers = new ArrayList();
    //UIController mUIController;

    private GameState mGameState;
    private SoundEngine mSoundEngine;
    Renderer mRenderer;
    ParticleSystem mParticleSystem;
    PhysicsEngine mPhysicsEngine;
    Level mLevel;

    public GameEngine(Context context, Point size) {
        super(context);
        //mUIController = new UIController(this);
        mGameState = new GameState();
        mSoundEngine = new SoundEngine(context);
        mRenderer = new Renderer(this);
        mPhysicsEngine = new PhysicsEngine();
        mParticleSystem = new ParticleSystem();
        mParticleSystem.init(1000);
        mLevel = new Level(context, new PointF(size.x, size.y), this);

    }

    public void addObserver(ObserverInput o) {
        inputObservers.add(o);
    }

    @Override
    public void run() {
        while (mGameState.getThreadRunning()) {
            long frameStartTime = System.currentTimeMillis();
            ArrayList<GameObject> objects = mLevel.getGameObjects();

            // Draw all the game objects here in a new way
            mRenderer.draw(objects, mGameState, mParticleSystem);

            // Measure the frames per second in the usual way
            long timeThisFrame = System.currentTimeMillis()
                    - frameStartTime;
            if (timeThisFrame >= 1) {
                final int MILLIS_IN_SECOND = 1000;
                mFPS = MILLIS_IN_SECOND / timeThisFrame;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        for (ObserverInput o : inputObservers) {
            o.handleInput(motionEvent, mGameState);
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
        mThread.start();
    }
}
