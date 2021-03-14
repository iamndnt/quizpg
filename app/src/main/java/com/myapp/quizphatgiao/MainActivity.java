package com.myapp.quizphatgiao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    private static final int REQUEST_CODE_QUIZ = 1;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> testDeviceIds = Arrays.asList("CD4E30E5F4354920CDD75883A564C997");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);

        // Create a full screen content callback.
        FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
            @Override
            public void onAdDismissedFullScreenContent() {
                interstitialAd = null;
                // Proceed to the next level.
                //goToNextLevel();
            }
        };

        InterstitialAd.load(
                this,
                "ca-app-pub-8404443559572571/3715462075",
                new AdRequest.Builder().build(),
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd ad) {
                        interstitialAd = ad;
                        interstitialAd.setFullScreenContentCallback(fullScreenContentCallback);
                        Log.d("cuong","onhere1");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        // Code to be executed when an ad request fails.
                        Log.d("cuong","onhere2");
                    }
                });


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
        if (interstitialAd != null) {
            interstitialAd.show(MainActivity.this);
            Log.d("cuong","onhere3");
        } else {
            // Proceed to the next level.
            //goToNextLevel();

        }
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