package br.unicamp.primeirossocorros;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import butterknife.ButterKnife;

public class SplashScreenActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        final SplashScreenActivity splashScreenActivity = this;

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent storyIntent = new Intent(splashScreenActivity, MainActivity.class);
                startActivity(storyIntent);
                splashScreenActivity.finish();
            }
        }, 2500);

    }
}
