package com.myapp.quizphatgiao;

import androidx.annotation.Nullable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private static final int REQUEST_CODE_QUIZ = 1;
    //private InterstitialAd interstitialAd;
   // MyInterstitialAd admod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  admod = new MyInterstitialAd("07CC7E40850ABA2DF210A2D2564CAD76",
                "ca-app-pub-8404443559572571/3715462075",
                this);*/


        Button nextLevelButton = findViewById(R.id.Main);
        nextLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show the interstitial if it is ready. Otherwise, proceed to the next level
                // without ever showing it.

                //setAds();

                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivityForResult(intent,REQUEST_CODE_QUIZ);

                //setAds();
            }
        });

    }


    void setAds(){
       // admod.load_ad(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_QUIZ){
           // if(resultCode == RESULT_OK){
                //int score = data.getIntExtra(GameActivity.EXTRA_SCORE,0);
                Log.d("cuong","onhere4");
                setAds();
           // }
        }
    }
}