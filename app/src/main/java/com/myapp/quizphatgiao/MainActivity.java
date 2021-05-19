package com.myapp.quizphatgiao;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity implements startnewview{

    private MyInterstitialAd myAds;
    private Bitmap space;
    private Point size;
    private int point,yourlevel;
    private Question question;
    public ArrayList<Question> listQuestion;
    private String guide;
    private int ourRandomNumber;
    private CustomlayoutStart customLayoutStart0;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myAds = new MyInterstitialAd("07CC7E40850ABA2DF210A2D2564CAD76",
                "ca-app-pub-8404443559572571/1438667961",this);
        BitmapStore bs = BitmapStore.getInstance(this);
        listQuestion = CenterProcessQuestion.setupQuestion(this);
        checkQues();
        guide = "";
        point = 1;
        Display display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        space = getBitmap("background_main", size);
        customLayoutStart0 = new CustomlayoutStart(this,size,this);
        Drawable myIcon = getResources().getDrawable( R.drawable.buttonp);
        ViewStartGame bgView = new ViewStartGame(this, space,size,this);
        customLayoutStart0.addView(bgView);
        TextView[] tview = new TextView[2];
        GradientDrawable border = new GradientDrawable();

        for(int i=0;i<tview.length;i++){
            tview[i] = new TextView(this);
            if(i==0){
                tview[i].setText("BẮT ĐẦU");
            }else{
                tview[i].setText("THOÁT RA");
            }
            Typeface face = Typeface.createFromAsset(getAssets(),
                    "victoria.ttf");
            tview[i].setTypeface(face);
            tview[i].setGravity(Gravity.CENTER_HORIZONTAL);
            tview[i].setTextSize(30f);
            border.setColor(Color.argb(100,255,255,255)); //white background
            border.setStroke(1, 0xFF000000); //black border with full opacity
            tview[i].setBackground(myIcon);
            customLayoutStart0.addView(tview[i]);
        }

        // Get the current high score
        SharedPreferences prefs;
        prefs = this.getSharedPreferences("HiScore",
                Context.MODE_PRIVATE);
        // Initialize the mEditor ready
        mEditor = prefs.edit();

        point = prefs.getInt("hi_score", 0);
        yourlevel = prefs.getInt("level", 0);

        setContentView(customLayoutStart0);
    }

    /*@Override
    protected void onPause() {
        mEditor.putInt("hi_score", point);
        mEditor.putInt("level", yourlevel);
        mEditor.commit();
        super.onPause();
        finish();
    }

    protected void onDestroy(){
        mEditor.putInt("hi_score", point);
        mEditor.putInt("level", yourlevel);
        mEditor.commit();
        super.onDestroy();
    }*/

    public void setUpQUestion(){
        listQuestion = CenterProcessQuestion.setupQuestion(this);
    }

    @Override
    public void setPoint(int i) {
        point = point + 1;
    }

    @Override
    public void stop() {
        mEditor.putInt("hi_score", point);
        mEditor.putInt("level", yourlevel);
        mEditor.commit();
        finish();
    }

    public Question checkQues() {
        Random randGenerator = new Random();
        ourRandomNumber = randGenerator.nextInt((listQuestion.size()-1)) + 1;
        if(listQuestion.get(ourRandomNumber) != null){
            question = listQuestion.get(ourRandomNumber);
            listQuestion.remove(ourRandomNumber);
        }
        return question;
    }

    public void startview0() {
        setContentView(customLayoutStart0);
    }
    public Bitmap getBitmap(String image, Point size) {
        BitmapStore.addBitmap(this,
                image,
                new PointF(size.x, size.y),
                1, false);
        Bitmap bitmap = BitmapStore.getBitmap(image);
        return bitmap;
    }

    public void setAds(){
        myAds.load_ad(this);
    }

    @Override
    public boolean checkAns(String ans) {
        if(ans.equals(question.ans)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void startview1() {
        guide = setGuide();
        CustomlayoutGuilde customLayout = new CustomlayoutGuilde(this,size,this,yourlevel);

        Bitmap bitmap = getBitmap("background_main2",size);
        ViewStartGame bgView = new ViewStartGame(this,bitmap,size,this);
        customLayout.addView(bgView);

        TextView[] tview = new TextView[13];
        GradientDrawable border = new GradientDrawable();

        for(int i=0;i<tview.length;i++){
            tview[i] = new TextView(this);

            if(i==8){
                Drawable myIcon = getResources().getDrawable( R.drawable.hoasen);
                tview[i].setBackground(myIcon);
                tview[i].setGravity(Gravity.CENTER_HORIZONTAL);
            }else if(i==11){
                Drawable myIcon = getResources().getDrawable( R.drawable.buttonready);
                tview[i].setBackground(myIcon);
                tview[i].setText("\nSẲN SÀNG ");
                tview[i].setGravity(Gravity.CENTER_HORIZONTAL);
            }else if(i==12){
                Drawable myIcon = getResources().getDrawable( R.drawable.buttonready);
                tview[i].setBackground(myIcon);
                tview[i].setText("\nTHOÁT RA ");
                tview[i].setGravity(Gravity.CENTER_HORIZONTAL);
            }else if(i==10 ){
                border.setColor(Color.argb(100, 255, 255, 255)); //white background
                border.setStroke(1, Color.WHITE); //black border with full opacity

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    tview[i].setBackgroundDrawable(border);
                } else {
                    tview[i].setBackground(border);
                }
                if(i==10) {
                    tview[i].setText("\n" + guide);
                    tview[i].setTextSize(20f);
                    Typeface face = Typeface.createFromAsset(getAssets(),
                            "victoria.ttf");
                    tview[i].setTypeface(face);
                }
                tview[i].setGravity(Gravity.CENTER_HORIZONTAL);
            }else if(i==9){
                tview[i].setText("\nĐỘ KHÓ: "+yourlevel + "     Điểm: "+point);// + " number of ques remaining : "+ (listQuestion.size())+ " random: "+ourRandomNumber);
               // tview[i].setText("\nĐỘ KHÓ: "+level);// + " number of ques remaining : "+ (listQuestion.size())+ " random: "+ourRandomNumber);
                Typeface face = Typeface.createFromAsset(getAssets(),
                        "victoria.ttf");
                tview[i].setTypeface(face);
                tview[i].setTextSize(15f);
                tview[i].setGravity(Gravity.CENTER_VERTICAL);
            }else{
                Drawable myIcon = getResources().getDrawable( R.drawable.button_pink);
                tview[i].setBackground(myIcon);
                if(i==0){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                }else if(i==1){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                }else if(i==2){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                }else if(i==3){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                }else if(i==4){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                }else if(i==5){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                }else if(i==6){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                }else if(i==7){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                }
                tview[i].setGravity(Gravity.CENTER_HORIZONTAL);

            }
            tview[i].setTextColor(Color.BLACK);
            customLayout.addView(tview[i]);
        }
        setContentView(customLayout);
    }

    @Override
    public void startview_layout(int loai, Question ques, int count, ArrayList<Drawable> iconList,int level) {

        Question iquestion = ques;
        yourlevel = level;

        mEditor.putInt("hi_score", point);
        mEditor.putInt("level", yourlevel);
        mEditor.commit();

        Customlayout customLayout = new Customlayout(this,size,this,loai,count,iconList,level);

        Bitmap bitmap = getBitmap("background_main2",size);
        ViewStartGame bgView = new ViewStartGame(this,bitmap,size,this);
        customLayout.addView(bgView);

        TextView[] tview = new TextView[16];
        GradientDrawable border = new GradientDrawable();

        for(int i=0;i<tview.length;i++){
            tview[i] = new TextView(this);
            if(i==8){
                Drawable myIcon = getResources().getDrawable( R.drawable.hoasen);
                tview[i].setBackground(myIcon);
                tview[i].setGravity(Gravity.CENTER_HORIZONTAL);
            }else if(i==10 || i==11||i==12 || i==13||i==14||i==15){
                border.setColor(Color.argb(100, 255, 255, 255)); //white background
                border.setStroke(1, Color.WHITE); //black border with full opacity

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    tview[i].setBackgroundDrawable(border);
                } else {
                    tview[i].setBackground(border);
                }
                if(i==10) {
                    tview[i].setText("\n" + iquestion.question);
                }else if(i==11){
                    tview[i].setText("\n" + iquestion.option1);
                }else if(i==12){
                    tview[i].setText("\n" + iquestion.option2);
                }else if(i==13){
                    tview[i].setText("\n" + iquestion.option3);
                }else if (i==14){
                    tview[i].setText("\n" + iquestion.option4);
                }else if (i==15){
                    tview[i].setText("\nTHOÁT RA");
                }
                tview[i].setGravity(Gravity.CENTER_HORIZONTAL);
            }else if(i==9){
                tview[i].setText("\nĐỘ KHÓ: "+yourlevel + "     ĐIỂM: "+point);// + " number of ques remaining : "+ (listQuestion.size())+ " random: "+ourRandomNumber);
                Typeface face = Typeface.createFromAsset(getAssets(),
                        "victoria.ttf");
                tview[i].setTypeface(face);
                tview[i].setTextSize(15f);
                tview[i].setGravity(Gravity.CENTER_VERTICAL);
            }else{
               // Drawable myIcon = getResources().getDrawable( R.drawable.button_pink);
                if(i==0){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                    tview[i].setBackground(iconList.get(i));
                }else if(i==1){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                    tview[i].setBackground(iconList.get(i));
                }else if(i==2){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                    tview[i].setBackground(iconList.get(i));
                }else if(i==3){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                    tview[i].setBackground(iconList.get(i));
                }else if(i==4){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                    tview[i].setBackground(iconList.get(i));
                }else if(i==5){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                    tview[i].setBackground(iconList.get(i));
                }else if(i==6){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                    tview[i].setBackground(iconList.get(i));
                }else if(i==7){
                    int i1 = i+1;
                    tview[i].setText("\nCÂU " + i1);
                    tview[i].setBackground(iconList.get(i));
                }
                tview[i].setGravity(Gravity.CENTER_HORIZONTAL);

            }
            tview[i].setTextColor(Color.BLACK);
            customLayout.addView(tview[i]);
        }

        Rect iSize = new Rect((size.x*2)/10,(size.y*3)/10,(size.x*7)/10,(size.y*7)/10);
        Point newSize = new Point();
        newSize.x = iSize.right - iSize.left;
        newSize.y = iSize.bottom - iSize.top;

        bitmap = getBitmap("dialog_cute",newSize);
        ViewStartGame childview1 = new ViewStartGame(this,bitmap,newSize,this);
        customLayout.addView(childview1);

        bitmap = getBitmap("dialog_cute1",newSize);
        ViewStartGame childview2 = new ViewStartGame(this,bitmap,newSize,this);
        customLayout.addView(childview2);

        //lose 1
        bitmap = getBitmap("dialog_cute3",newSize);
        ViewStartGame childview3 = new ViewStartGame(this,bitmap,newSize,this);
        customLayout.addView(childview3);

        //lose 2
        bitmap = getBitmap("dialog_cute2",newSize);
        ViewStartGame childview4 = new ViewStartGame(this,bitmap,newSize,this);
        customLayout.addView(childview4);

        //lose 2
        bitmap = getBitmap("dialog_win",newSize);
        ViewStartGame childview5 = new ViewStartGame(this,bitmap,newSize,this);
        customLayout.addView(childview5);

        setContentView(customLayout);
    }


    private String setGuide() {
        String t = "";

        t = "mỗi cấp độ có 8 câu\n " +
                "mỗi câu có 4 lựa chọn \n " +
                "sai 3 câu trong 8 câu bạn phải dừng cuộc chơi \n " +
                "trả lời đúng 5 trong 8 câu bạn sẻ giành quyền đi tới level tiếp theo \n"+
                "mỗi cấp sẻ có độ khó tăng dần \n"+
                "mỗi câu trả lời đúng sẻ có 1 điểm."
        ;

        return t;
    }
}