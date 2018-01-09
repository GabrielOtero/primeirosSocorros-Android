package br.unicamp.primeirossocorros.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import br.unicamp.primeirossocorros.util.Constants;
import br.unicamp.primeirossocorros.util.LocaleHelper;
import br.unicamp.primeirossocorros.R;
import br.unicamp.primeirossocorros.util.StoryType;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends BaseActivity {

    @BindView(R.id.what_label)
    TextView whatLabel;

    @BindView(R.id.trauma_label)
    TextView traumaLabel;

    @BindView(R.id.choking_label)
    TextView chokingLabel;

    @BindView(R.id.seizure_label)
    TextView seizureLabel;

    @BindView(R.id.fainting_label)
    TextView faintingLabel;

    @BindView(R.id.arrest_label)
    TextView arrestLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        updateLanguage(LocaleHelper.getLanguage(this));
    }

    @OnClick(R.id.pt)
    public void onClickPt() {
        updateLanguage("pt");
    }

    @OnClick(R.id.en)
    public void onClickEn() {
        updateLanguage("en");
    }

    @OnClick(R.id.es)
    public void onClickEs() {
        updateLanguage("es");
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

    private void updateLanguage(String language) {
        Context context = LocaleHelper.setLocale(this, language);
        Resources resources = context.getResources();

        whatLabel.setText(resources.getString(R.string.what));
        traumaLabel.setText(resources.getString(R.string.trauma));
        chokingLabel.setText(resources.getString(R.string.choking));
        seizureLabel.setText(resources.getString(R.string.seizure));
        faintingLabel.setText(resources.getString(R.string.fainting));
        arrestLabel.setText(resources.getString(R.string.arrest));
    }
}