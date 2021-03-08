package com.myapp.quizpg;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

class GameEngine extends SurfaceView
        implements Runnable,
        GameEngineBroadcaster {

    private static final String TOKEN = "~";
    private Thread mThread = null;
    private Thread mThread2 = null;
    private Thread mThread3 = null;
    private Thread mThread4 = null;
    private Thread mThread5 = null;
    public  String ans;
    public  int chiakhoa;
    public  int TNpoint;
    private int indexBitmap;
    private int indexBitmap1;
    private ArrayList<ObserverInput> inputObservers = new ArrayList();

    private GameState mGameState;
    Renderer mRenderer;
    Level mLevel;
    public ArrayList<Bitmap> bitmapBG;
    public ArrayList<Bitmap> bitmap;
    public ArrayList<Bitmap> bitmap1;
    public ArrayList<Question> questions;
    public Question currentQuestion;
    public Bitmap currentBitmap;
    public Bitmap currentBitmap1;
    private Context context;
    private Point size;
    private SharedPreferences.Editor mEditor;

    public GameEngine(Context context, Point size) {
        super(context);
        this.context = context;
        this.size = size;
        bitmap = new ArrayList<>();
        bitmap1 = new ArrayList<>();
        bitmapBG = new ArrayList<>();
        questions = new ArrayList<>();
        ans = "";
        mGameState = new GameState();
        mRenderer = new Renderer(this);
        indexBitmap = 0;
        indexBitmap1 = 0;
        chiakhoa=0;
        for(int i=0;i<8;i++){
            bitmapBG.add(i,null);
        }
        // Get the current high score
        SharedPreferences prefs;
        prefs = context.getSharedPreferences("HiScore",
                Context.MODE_PRIVATE);
        // Initialize the mEditor ready
        mEditor = prefs.edit();

        TNpoint = prefs.getInt("hi_score", 0);
    }

    public void checkQues() {
        Random randGenerator = new Random();
        int ourRandomNumber = randGenerator.nextInt(619) + 1;
        if(questions.get(ourRandomNumber) != null){
            currentQuestion = questions.get(ourRandomNumber);
        }
    }

    GameEngine getInstance(){
        return this;
    }


    private void setupQuestion() {
        ArrayList<String> Sans = GetAns();
        ArrayList<String> Squestion = GetQuestion();

        ArrayList<String> Squestion2 = combine(Squestion,Sans);
        for(int i=0;i<Squestion2.size();i++) {
            questions.add(initializeQuestion(Squestion2.get(i)));
        }
    }

    private ArrayList<String> combine(ArrayList<String> squestion, ArrayList<String> sans) {
        ArrayList<String> ques = new ArrayList<>();
        for(int i=0;i<squestion.size();i++) {
            ques.add(squestion.get(i) + sans.get(i));
        }
        return ques;
    }

    private Question initializeQuestion(String str) {
        Question ques = new Question();
        String[] arr = str.split("~");
        ques.question = arr[0];
        ques.option1 = arr[1];
        ques.option2 = arr[2];
        ques.option3 = arr[3];
        ques.option4 = arr[4];
        ques.ans = arr[5];
        return ques;
    }

    private ArrayList<String> GetQuestion() {
        AssetManager am = context.getAssets();
        InputStream input;
        try {
            String[] files = am.list("");
            for (String file : files) {
                if (file.equals("ques")) {
                    input = am.open(file);
                    String[] textline = read_text(input);
                    ArrayList<String> question = CheckQues(textline);
                    return question;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<String> GetAns() {
        AssetManager am = context.getAssets();
        InputStream input;
        try {
            String[] files = am.list("");
            for (String file : files) {
                if (file.equals("answer")) {
                    input = am.open(file);
                    String[] textline = read_text(input);
                    ArrayList<String> ans = CheckAns(textline);
                    return ans;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<String> CheckAns(String[] textline) {
        ArrayList<String> m = new ArrayList<String>();
        for(int i=0;i<textline.length ; i++){
            m.add(textline[i]);
        }
        return m;
    }

    private ArrayList<String> CheckQues(String[] textline) {
        String question = "";
        ArrayList<String> m = new ArrayList<String>();
        for(int i=0;i<textline.length ; i++){
            int last = textline[i].length() -1 ;

            if(textline[i].equals("")||textline[i].equals("end")){
              //  question = question;//  + ans.get(i);
                m.add(question);
                question = "";
            }
            else if(textline[i].charAt(last) == '?'|| textline[i].charAt(last) == '.'){
                question = question + textline[i] + TOKEN;
            }else{
            }
        }
        return m;
    }

    private String[] read_text(InputStream input) throws IOException {
        int size = input.available();
        byte[] buffer = new byte[size];
        input.read(buffer);
        input.close();
        String text = new String(buffer);
        return text.split("\\r?\\n");
    }


    Bitmap initializeBitmap(String NameBitmap, Context context,Point size) {
        Bitmap bitmap;// = new Bitmap();
        // Make a resource id out of the string of the file name
        int resID = context.getResources()
                .getIdentifier(NameBitmap,
                        "drawable",
                        context.getPackageName());

        // Load the bitmap using the id
        bitmap = BitmapFactory.decodeResource(
                context.getResources(), resID);

        // Resize the bitmap
        bitmap = Bitmap
                .createScaledBitmap(bitmap,
                        size.x,
                        size.y,
                        false);

        return bitmap;
    }
    public void addObserver(ObserverInput o) {
        inputObservers.add(o);
    }

    @Override
    public void run() {
        while (mGameState.getThreadRunning()) {

            if(mGameState.getgd() != GameState.GD_PRERATION) {
                ArrayList<GameObject> objects = mLevel.getGameObjects();
                // Draw all the game objects here in a new way
                mRenderer.draw(objects, mGameState,this);
            }else{
                mRenderer.drawBeginning(size);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        mGameState.setKey(true);
        for (ObserverInput o : inputObservers) {
            o.handleInput(motionEvent, mGameState,this);
        }
        return true;
    }

    public void stopThread() {

        mEditor.putInt("hi_score", TNpoint);
        mEditor.commit();

        try {
            mThread.join();
        } catch (InterruptedException e) {
            Log.e("Exception","stopThread()" + e.getMessage());
        }
    }

    public void startThread() {
        mGameState.startThread();
        mThread = new Thread(this);

        mThread2 = new Thread(() -> {
            GameEngine ge = getInstance();
            setupQuestion();
            currentQuestion = questions.get(0);
            mLevel = new Level(context, new PointF(size.x, size.y), ge);
        });

        mThread3 = new Thread(() -> {
            setUpBitmapHinhPhat(context,size);
        });
        mThread4 = new Thread(() -> {
            setUpBackground(context,size);
        });
        mThread5 = new Thread(() -> {
            setUpBitmapCauNoiHay(context,size);
        });

        mThread.start();
        mThread2.start();
        mThread3.start();
        mThread4.start();
        mThread5.start();

    }

    private void setUpBitmapCauNoiHay(Context context, Point size) {
        String[] NameBitmap = new String[10];

        NameBitmap[0] = "caunoihay1";
        NameBitmap[1] = "caunoihay2";
        NameBitmap[2] = "caunoihay3";
        NameBitmap[3] = "caunoihay4";
        NameBitmap[4] = "caunoihay5";
        NameBitmap[5] = "caunoihay6";
        NameBitmap[6] = "caunoihay7";
        NameBitmap[7] = "caunoihay8";
        NameBitmap[8] = "caunoihay8";
        NameBitmap[9] = "caunoihay10";

        bitmap1.add(initializeBitmap(NameBitmap[0],context,size));
        currentBitmap1 = bitmap1.get(0);
        for(int i=1;i<10;i++){
            bitmap1.add(initializeBitmap(NameBitmap[i],context,size));
        }
    }


    private void setUpBackground(Context context,Point size) {

        bitmapBG.add(0,initializeBitmap("background_main",context,size));
        bitmapBG.add(1,initializeBitmap("background_hinhphat",context,size));
        bitmapBG.add(2,initializeBitmap("background_tracnghiem",context,size));
        mGameState.setgd(GameState.GD_MAIN);
        bitmapBG.add(3,initializeBitmap("background_tracnghiem",context,size));
        bitmapBG.add(4,initializeBitmap("background_tronghoasen",context,size));
        bitmapBG.add(5,initializeBitmap("background_hinhphat",context,size));

    }

    private void setUpBitmapHinhPhat(Context context, Point size) {
        String[] NameBitmap = new String[10];

        NameBitmap[0] = "hinhphat1";
        NameBitmap[1] = "hinhphat2";
        NameBitmap[2] = "hinhphat3";
        NameBitmap[3] = "hinhphat4";
        NameBitmap[4] = "hinhphat5";
        NameBitmap[5] = "hinhphat6";
        NameBitmap[6] = "hinhphat7";
        NameBitmap[7] = "hinhphat8";
        NameBitmap[8] = "hinhphat9";
        NameBitmap[9] = "hinhphat10";

        bitmap.add(initializeBitmap(NameBitmap[0],context,size));
        currentBitmap = bitmap.get(0);
        for(int i=1;i<10;i++){
            bitmap.add(initializeBitmap(NameBitmap[i],context,size));
        }
    }


    public void setANS(String a) {
        ans = a;
    }

    public boolean checkAns() {
        if(ans.equals(currentQuestion.ans)){
            return true;
        }else{
            return false;
        }
    }

    public void checkBitmap(int i) {
        indexBitmap = indexBitmap+i;
        if(indexBitmap >= bitmap.size() ){
            indexBitmap = 0;
        }else if(indexBitmap < 0){
            indexBitmap = bitmap.size()-1;
        }
        currentBitmap = bitmap.get(indexBitmap);
    }

    public void checkBitmap1(int i) {
        indexBitmap1 = indexBitmap1+i;
        if(indexBitmap1 >= bitmap1.size() ){
            indexBitmap1 = 0;
        }else if(indexBitmap1 < 0){
            indexBitmap1 = bitmap1.size()-1;
        }
        currentBitmap1 = bitmap1.get(indexBitmap1);
    }
}
