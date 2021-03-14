package com.myapp.quizphatgiao;

import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

interface ObserverInput {
    void handleInput(MotionEvent event, GameState gs, GameEngine ge);
}
