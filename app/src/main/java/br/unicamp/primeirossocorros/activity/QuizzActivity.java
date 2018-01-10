package br.unicamp.primeirossocorros.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import br.unicamp.primeirossocorros.QuestionLayout;
import br.unicamp.primeirossocorros.R;
import br.unicamp.primeirossocorros.util.Constants;
import br.unicamp.primeirossocorros.util.StoryType;
import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizzActivity extends BaseActivity {

    @BindView(R.id.q1)
    QuestionLayout question1;

    @BindView(R.id.q2)
    QuestionLayout question2;

    @BindView(R.id.q3)
    QuestionLayout question3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        ButterKnife.bind(this);

        StoryType storyType = (StoryType) getIntent().getSerializableExtra(Constants.STORY_TYPE);
        String description = storyType.getDescription();

        Resources resources = getResources();
        String q1Label = resources.getString(resources.getIdentifier("q1"+description, "string", getPackageName()));
        question1.setText(q1Label);

        String q2Label = resources.getString(resources.getIdentifier("q2"+description, "string", getPackageName()));
        question2.setText(q2Label);

        String q3Label = resources.getString(resources.getIdentifier("q3"+description, "string", getPackageName()));
        question3.setText(q3Label);
    }
}
