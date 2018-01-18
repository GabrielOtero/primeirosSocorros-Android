package br.com.primeirossocorros.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import br.com.primeirossocorros.util.Constants;
import br.com.primeirossocorros.util.LocaleHelper;
import br.com.primeirossocorros.R;
import br.com.primeirossocorros.util.StoryType;
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
        goTo(StoryType.WHAT);
    }

    @OnClick(R.id.trauma)
    public void onClickTrauma() {
        goTo(StoryType.TRAUMA);
    }

    @OnClick(R.id.choking)
    public void onClickChoking() {
        goTo(StoryType.CHOKING);
    }

    @OnClick(R.id.seizure)
    public void onClickSeizure() {
        goTo(StoryType.SEIZURE);
    }

    @OnClick(R.id.fainting)
    public void onClickFainting() {
        goTo(StoryType.FAINTING);
    }

    @OnClick(R.id.arrest)
    public void onClickArrest() {
        goTo(StoryType.ARREST);
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    private void goTo(StoryType storyType) {
        Intent storyIntent = new Intent(this, StoryActivity.class);
        storyIntent.putExtra(Constants.STORY_TYPE, storyType);
        startActivity(storyIntent);
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
