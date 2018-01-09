package br.unicamp.primeirossocorros.activity;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import br.unicamp.primeirossocorros.util.LocaleHelper;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class BaseActivity extends FragmentActivity{
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(LocaleHelper.onAttach(newBase)));
    }
}
