package com.myapp.quizphatgiao;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;

public class ViewStartGame extends View {

    private LayerDrawable drawables;
    private Rect rect1,rect2;
    private startnewview startview;
    private Paint paint;
    private Point size;
    private Bitmap space;
    public ViewStartGame(Context context, Bitmap spaceBitmap,  Point size, startnewview startview) {
        super(context);
        space = spaceBitmap;
        this.size = size;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(space,0,0,null);

    }
}
