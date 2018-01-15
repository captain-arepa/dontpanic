package com.h2g2.dontpanic.activities.main;

import android.os.Handler;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.h2g2.dontpanic.R;
import com.h2g2.dontpanic.activities.base.BaseActivity;
import com.h2g2.dontpanic.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity {

    private Handler splashFadeIn = null;
    private Runnable splashFadeRun = null;
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    private void setSplashTouchEvent(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("EVENTO!");
                return true;
            }
        });
    }

    private void splashLogoAnimation() {
        splashFadeIn = new Handler();
        splashFadeRun=new Runnable() {
            @Override
            public void run() {
                YoYo.with(Techniques.FadeInLeft).duration(2000).playOn(binding.splashInitText);
                System.out.println("splashLogoAnimation");
                splashFadeIn.postDelayed(this,3000);
            }
        };
        splashFadeIn.post(splashFadeRun);
    }

    private void showDelay() {
        int secondsDelayed = 3;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                navigateToActivity(MainActivity.class);
                SplashActivity.this.finish();
            }
        }, secondsDelayed * 1000);
    }
}
