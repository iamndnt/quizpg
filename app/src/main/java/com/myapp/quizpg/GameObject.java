package com.myapp.quizpg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

class GameObject {

    private GraphicsComponent graphicsComponent;

    void setInput(ComponentInput s) {
        s.setControl(graphicsComponent.getControl());
    }

    void setGraphics(GraphicsComponent g, Context c,
                     ObjectSpec spec) {
        graphicsComponent = g;
        g.initialize(c, spec);
    }


    void draw(Canvas canvas, Paint paint,GameEngine ge) {
        graphicsComponent.draw(canvas, paint,ge);
    }

    public void setBeginImage() {
    }
}
