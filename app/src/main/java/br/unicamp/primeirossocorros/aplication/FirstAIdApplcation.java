package br.unicamp.primeirossocorros.aplication;

import android.app.Application;

import br.unicamp.primeirossocorros.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class FirstAIdApplcation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/SFSlapstickComic.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
