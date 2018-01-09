package br.unicamp.primeirossocorros.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import br.unicamp.primeirossocorros.Constants;
import br.unicamp.primeirossocorros.R;
import br.unicamp.primeirossocorros.StoryType;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.what)
    public void onClickWhat() {
        Intent storyIntent = new Intent(this, StoryActivity.class);
        storyIntent.putExtra(Constants.STORY_TYPE, StoryType.WHAT);
        startActivity(storyIntent);
    }

    @OnClick(R.id.trauma)
    public void onClickTrauma() {
        Intent storyIntent = new Intent(this, StoryActivity.class);
        storyIntent.putExtra(Constants.STORY_TYPE, StoryType.TRAUMA);
        startActivity(storyIntent);
    }

    @OnClick(R.id.choking)
    public void onClickChoking() {
        Intent storyIntent = new Intent(this, StoryActivity.class);
        storyIntent.putExtra(Constants.STORY_TYPE, StoryType.CHOKING);
        startActivity(storyIntent);
    }

    @OnClick(R.id.seizure)
    public void onClickSeizure() {
        Intent storyIntent = new Intent(this, StoryActivity.class);
        storyIntent.putExtra(Constants.STORY_TYPE, StoryType.SEIZURE);
        startActivity(storyIntent);
    }

    @OnClick(R.id.fainting)
    public void onClickFainting() {
        Intent storyIntent = new Intent(this, StoryActivity.class);
        storyIntent.putExtra(Constants.STORY_TYPE, StoryType.FAINTING);
        startActivity(storyIntent);
    }

    @OnClick(R.id.arrest)
    public void onClickArrest() {
        Intent storyIntent = new Intent(this, StoryActivity.class);
        storyIntent.putExtra(Constants.STORY_TYPE, StoryType.ARREST);
        startActivity(storyIntent);
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }
}
