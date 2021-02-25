package com.myapp.quizpg;

import android.graphics.PointF;
import android.graphics.RectF;

import java.util.ArrayList;

class PhysicsEngine {
    // This signature and much more will change later in the project
    boolean update(long fps, ArrayList<GameObject> objects,
                   GameState gs, SoundEngine se,
                   ParticleSystem ps){

        if(ps.mIsRunning){
            ps.update(fps);
        }

        return false;
    }

}
