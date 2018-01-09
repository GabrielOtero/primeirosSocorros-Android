package br.unicamp.primeirossocorros.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import br.unicamp.primeirossocorros.util.Constants;
import br.unicamp.primeirossocorros.util.LocaleHelper;
import br.unicamp.primeirossocorros.util.StoryType;
import br.unicamp.primeirossocorros.fragment.NowChoosePageFragment;
import br.unicamp.primeirossocorros.R;
import br.unicamp.primeirossocorros.fragment.SlidePageFragment;

public class StoryActivity extends BaseActivity {
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        StoryType storyType = (StoryType) getIntent().getSerializableExtra(Constants.STORY_TYPE);

        String language = LocaleHelper.getLanguage(this);
        Log.d("LANGUAGE",language);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), storyType);
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private StoryType storyType;

        public ScreenSlidePagerAdapter(FragmentManager fm, StoryType storyType) {
            super(fm);
            this.storyType = storyType;
        }

        @Override
        public Fragment getItem(int position) {
            if(storyType == StoryType.WHAT){
                return getSlidePageFragment(storyType, position);
            }

            if(position == storyType.length - 1){
                return new NowChoosePageFragment();
            }

            SlidePageFragment slidePageFragment = getSlidePageFragment(storyType, position);
            return slidePageFragment;
        }

        @NonNull
        private SlidePageFragment getSlidePageFragment(StoryType storyType, int position) {
            SlidePageFragment slidePageFragment = new SlidePageFragment();
            slidePageFragment.setStoryType(storyType);
            slidePageFragment.setPosition(position);
            return slidePageFragment;
        }

        @Override
        public int getCount() {
            return storyType.length;
        }
    }
}
