# quizpg

+ one activity will have 1 (view)  
+ (view) can be (imageview), (surfaceview)  
+ (groupview) take care to positioned (view)  
+ (view) is different with (surfaceview), (view) is parent of (surfaceview)  
  - if we want to animate (view) use (invalidate)   
  - (surfaceview) use (thread) to draw its will exactly on milisecond  

+ "lovetest233" - show how (animator) translate object <imageview> from x0 -> x1 horizontal
+ "caro" - show how animator animate as (frame) according to time

package com.example.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class myView extends View {
    private Rect rect1;
    private Rect rect2;

    private Paint paint;
    private Bitmap bitmap1;
    private Bitmap bitmap2;

    public myView(Context context) {
        super(context);
        rect1 = new Rect(300,300,600,900);
        rect2 = new Rect(900,300,1200,900);
        paint = new Paint();
        int resID = context.getResources()
                .getIdentifier("poker1",
                        "drawable",
                        context.getPackageName());
        bitmap1 = BitmapFactory.decodeResource(
                context.getResources(), resID);

        int resID2 = context.getResources().getIdentifier("poker2","drawable",context.getPackageName());
        bitmap2 = BitmapFactory.decodeResource(context.getResources(),resID2);

     /*   bitmap1 = Bitmap
                .createScaledBitmap(bitmap1,
                        300, 600,
                        false);

        bitmap2 = Bitmap
                .createScaledBitmap(bitmap2,
                        300, 600,
                        false);*/


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawRect(rect1,paint);
        canvas.drawRect(rect2,paint);
        canvas.drawBitmap(bitmap1,null,rect1,paint);
        canvas.drawBitmap(bitmap2,null,rect2,paint);

    }
}
