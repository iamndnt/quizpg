# quizpg

+ one activity will have 1 (view)  
+ (view) can be (imageview), (surfaceview)  
+ (groupview) take care to positioned (view)  
+ (view) is different with (surfaceview), (view) is parent of (surfaceview)  
  - if we want to animate (view) use (invalidate)   
  - (surfaceview) use (thread) to draw its will exactly on milisecond  

+ "lovetest233" - show how (animator) translate object <imageview> from x0 -> x1 horizontal
+ "caro" - show how animator animate as (frame) according to time


below class help us draw many drawable object on 1 view

public class ViewLayer extends View {

    private LayerDrawable drawables;

    public ViewLayer(Context context, Bitmap bitmap1, Bitmap bitmap2) {
        super(context);
        Drawable space = new BitmapDrawable(context.getResources(), bitmap1);
        Drawable moon = new BitmapDrawable(context.getResources(), bitmap2);
       // space.setBounds(0,0,300,600);
       // moon.setBounds(0,0,900,600);

        Drawable[] bodies = {space,moon};
        drawables = new LayerDrawable(bodies);
        drawables.setLayerInset(0,0,0,300,600);
        drawables.setLayerInset(1,0,0,900,600);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawables.draw(canvas);
    }
}

layerDrawable inset will help us inset drawable inside another drawable

public class ViewDrawable extends LayerDrawable {


	public static ViewDrawable Create(Context context, Bitmap bitmap)
	{

		Drawable space = new BitmapDrawable(context.getResources(), bitmap);
		Drawable space1 = new BitmapDrawable(context.getResources(), bitmap);
		Drawable[] bodies = {space,space1};
		ViewDrawable myOrrery = new ViewDrawable(bodies);

		myOrrery.setLayerInset(
				0,0,0,0,0);
		myOrrery.setLayerInset(
				1,500,500,400,400);
		return myOrrery;
	}



	private ViewDrawable(Drawable[] bodies)
	{
		super(bodies);
	}

}

Bitmap bitmap = takeBitmap(this,size,"ball");
        ViewDrawable o = ViewDrawable.Create(this,bitmap);
        imageView.setImageDrawable(o);
        imageView.setScaleType(ImageView.ScaleType.FIT_START);
        setContentView(imageView);
        


package com.example.main;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

public class FrameAnmation extends View {

    private Drawable drawable;
    private Rect rect;
    private Thread thread;
    private int animation;
    private CountDownTimer countDownTimer;
    private int stage;
    private Context context;
    private Drawable[] drawables;
    private ViewInterface viewInterface;
    private Bitmap[] bitmap;

    private int index;
    public FrameAnmation(Context context, Bitmap[] bitmap,Drawable[] drawables, ViewInterface viewInterface) {
        super(context);
        this.viewInterface = viewInterface;
        this.bitmap = bitmap;
        this.drawables = drawables;
        drawable = new BitmapDrawable(context.getResources(), bitmap[3]);
        rect = new Rect(0,0,300,600);
        drawable.setBounds(rect);
        index = 0;

        countDownTimer =  new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
                if(index<3) {
                    index++;
                    Drawable idrawable = new BitmapDrawable(context.getResources(), bitmap[index]);
                    idrawable.setBounds(rect);
                    drawable = idrawable;
                    invalidate();
                }
            }

            public void onFinish() {
                //drawable.setBounds(300,0,600,600);
                //invalidate();
                //stage = 1;
            }
        };
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;
        if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
            if (rect.contains(x, y)) {
                countDownTimer.start();
            }
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawable.draw(canvas);
    }
}



animation view

package com.example.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

public class animatorDraw extends View implements Runnable{

    private Drawable drawable;
    private Rect rect;
    private Thread thread;
    private int animation;
    private CountDownTimer countDownTimer;
    private int stage;

    public animatorDraw(Context context, Bitmap bitmap1) {
        super(context);
        drawable = new BitmapDrawable(context.getResources(), bitmap1);
        rect = new Rect(0,0,300,600);


        drawable.setBounds(rect);



        thread = new Thread();
        stage = 0;

        countDownTimer =  new CountDownTimer(2000, 10) {

            public void onTick(long millisUntilFinished) {
                rect.set(0+animation,0,300+animation,600);
                drawable.setBounds(rect);
                animation = animation+10;
                invalidate();
            }

            public void onFinish() {
                //drawable.setBounds(300,0,600,600);
                //invalidate();
                stage = 1;
            }
        };
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);
        int eventType = event.getAction() & MotionEvent.ACTION_MASK;
        if (eventType == MotionEvent.ACTION_UP || eventType == MotionEvent.ACTION_POINTER_UP) {
            if (rect.contains(x, y)) {
                /* animation here */
                if(stage==0){
                    countDownTimer.start();
                }else if(stage == 1){
                    /* open cards */

                    rect.set(0,0,300,600);
                    drawable.setBounds(rect);
                    invalidate();
                }else{
                    rect.set(100,0,300,600);
                    drawable.setBounds(rect);
                    invalidate();
                }

            }
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawable.draw(canvas);
    }

    @Override
    public void run() {

    }
}

new 

package com.example.main;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;

public class CustomLayout extends ViewGroup {
    private Point size;
    private int x,y,rate;
    private View[] child;
    public CustomLayout(Context context, Point size) {
        super(context);
        this.size = size;
        this.x = size.x;
        this.y = size.y;
        rate = 10;
        child = new View[16];
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        child[0] = getChildAt(0);
        setView1(child[0],l,t,r,b);

        for(int i=1;i<16;i++) {
            child[i] = getChildAt(i);
        }
        setView1(child[1],(8*x)/rate,(y*1)/rate,x,(y*2)/rate);
        setView1(child[2],(8*x)/rate,(y*2)/rate,x,(y*3)/rate);
        setView1(child[3],(8*x)/rate,(y*3)/rate,x,(y*4)/rate);
        setView1(child[4],(8*x)/rate,(y*4)/rate,x,(y*5)/rate);
        setView1(child[5],(8*x)/rate,(y*5)/rate,x,(y*6)/rate);
        setView1(child[6],(8*x)/rate,(y*6)/rate,x,(y*7)/rate);
        setView1(child[7],(8*x)/rate,(y*7)/rate,x,(y*8)/rate);
        setView1(child[8],(8*x)/rate,(y*8)/rate,x,(y*9)/rate);

        setView1(child[9],(x*1)/rate,0,(x*2)/rate,(y*1)/rate);
        setView1(child[10],(x*3)/rate,0,(x*5)/rate,(y*1)/rate);

        setView1(child[11],(x*1)/rate,(y*2)/rate,(x*8)/rate,(y*5)/rate);

        setView1(child[12],(x*1)/rate,(y*5)/rate,(x*4)/rate,(y*7)/rate);
        setView1(child[13],(x*1)/rate,(y*7)/rate,(x*4)/rate,(y*9)/rate);
        setView1(child[14],(x*4)/rate,(y*5)/rate,(x*8)/rate,(y*7)/rate);
        setView1(child[15],(x*4)/rate,(y*7)/rate,(x*8)/rate,(y*9)/rate);


    }

    private void setView1(View child,int l, int t, int r, int b) {
        child.layout(l,t,r,b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(size.x,size.y);
    }


}


