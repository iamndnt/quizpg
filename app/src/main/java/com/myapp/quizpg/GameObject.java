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
                     ObjectSpec spec, PointF objectSize) {
        graphicsComponent = g;
        g.initialize(c, spec, objectSize);
    }

    void draw(Canvas canvas, Paint paint) {
        graphicsComponent.draw(canvas, paint);
    }

}
