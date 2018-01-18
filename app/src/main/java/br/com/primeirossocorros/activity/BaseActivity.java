package br.com.primeirossocorros.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import br.com.primeirossocorros.util.LocaleHelper;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class BaseActivity extends FragmentActivity{
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(LocaleHelper.onAttach(newBase)));
    }

    protected void backToMenuClearTop() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
