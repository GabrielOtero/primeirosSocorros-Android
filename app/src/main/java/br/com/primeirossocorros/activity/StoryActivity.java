package br.com.primeirossocorros.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.primeirossocorros.util.Constants;
import br.com.primeirossocorros.util.StoryType;
import br.com.primeirossocorros.fragment.NowChoosePageFragment;
import br.com.primeirossocorros.R;
import br.com.primeirossocorros.fragment.SlidePageFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StoryActivity extends BaseActivity {
    private PagerAdapter mPagerAdapter;

    @BindView(R.id.pager)
    ViewPager mPager;

    @BindView(R.id.pageIndicator)
    LinearLayout pageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);

        StoryType storyType = (StoryType) getIntent().getSerializableExtra(Constants.STORY_TYPE);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), storyType);
        mPager.setAdapter(mPagerAdapter);

        setPageIndicators(storyType);
    }

    protected void setPageIndicators(StoryType storyType) {
        for (int i = 0; i < storyType.getStoryLength(); i++){
            TextView txtView = new TextView(this);
            txtView.setBackground(getResources().getDrawable(R.drawable.layout_unselected_gray));

            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            llp.setMargins(0, 0, 20, 0);

            llp.height = 20;
            llp.width = 20;

            txtView.setLayoutParams(llp);

            pageIndicator.addView(txtView);
        }
    }

    protected void setCurrentPageIndicator(){
        int idx = mPager.getCurrentItem();
        Log.d("POS", String.valueOf(idx));
        for(int i = 0; i < pageIndicator.getChildCount(); i++){
            TextView txtView = (TextView) pageIndicator.getChildAt(i);
            if(idx == i){
                txtView.setBackground(getResources().getDrawable(R.drawable.layout_selected_gray));
            }else{
                txtView.setBackground(getResources().getDrawable(R.drawable.layout_unselected_gray));
            }
        }
    }


    @Override
    public void onBackPressed() {
        super.backToMenuClearTop();
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

            if(position == storyType.getStoryLength() - 1){
                NowChoosePageFragment nowChoosePageFragment = new NowChoosePageFragment();
                nowChoosePageFragment.setStoryType(storyType);
                return nowChoosePageFragment;
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
        public void finishUpdate(ViewGroup container) {
            setCurrentPageIndicator();
            super.finishUpdate(container);
        }

        @Override
        public int getCount() {
            return storyType.getStoryLength();
        }
    }
}
