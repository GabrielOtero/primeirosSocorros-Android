package br.unicamp.primeirossocorros;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class BaseActivity extends FragmentActivity{
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
