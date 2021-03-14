package com.myapp.quizphatgiao;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.util.EventListener;
import java.util.Random;

public class GameActivity extends Activity  {

    public static final String EXTRA_SCORE = "result";
    GameEngine mGameEngine;

    Point size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager()
                .getDefaultDisplay();
        size = new Point();
        display.getSize(size);

        mGameEngine = new GameEngine(this, size,this);
        setContentView(mGameEngine);

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        mGameEngine.stopThread();

        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, 1);
        setResult(RESULT_OK, resultIntent);

        finish();
       // Intent i=new Intent(getApplicationContext(),MainActivity.class);
       // startActivity(i);
    }

    public void callMainAc() {
        mGameEngine.stopThread();

        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, 1);
        setResult(RESULT_OK, resultIntent);

        finish();
        //Intent i=new Intent(getApplicationContext(),MainActivity.class);
        //startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGameEngine.startThread();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGameEngine.stopThread();
        finish();
    }

    protected void onDestroy(){
        super.onDestroy();

    }


}