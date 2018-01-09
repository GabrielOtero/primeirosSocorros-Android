package br.unicamp.primeirossocorros.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import br.unicamp.primeirossocorros.R;
import br.unicamp.primeirossocorros.util.LocaleHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends BaseActivity {
    @BindView(R.id.splash_image)
    ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);


        //TODO: REFACTOR THIS GARBAGE
        String language = LocaleHelper.getLanguage(this);
        Log.d("LANGUAGE",language);

        if(!language.equals("en") && !language.equals("es") && !language.equals("pt")){
            language = "en";
            LocaleHelper.setLocale(this, language);
        }

        String name = "splash_" + language;

        int id = getResources().getIdentifier(name, "drawable",
                getPackageName());

        splashImage.setImageResource(id);
        ///////////////////////////////

        final SplashScreenActivity splashScreenActivity = this;

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent storyIntent = new Intent(splashScreenActivity, MenuActivity.class);
                startActivity(storyIntent);
                splashScreenActivity.finish();
            }
        }, 2500);

    }
}
