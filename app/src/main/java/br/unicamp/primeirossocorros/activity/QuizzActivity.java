package br.unicamp.primeirossocorros.activity;

import android.content.res.Resources;
import android.os.Bundle;

import br.unicamp.primeirossocorros.QuestionLayout;
import br.unicamp.primeirossocorros.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizzActivity extends BaseActivity {

    @BindView(R.id.q1)
    QuestionLayout question1;

    @BindView(R.id.q2)
    QuestionLayout question2;

    @BindView(R.id.q3)
    QuestionLayout question3;

    @BindView(R.id.q4)
    QuestionLayout question4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        ButterKnife.bind(this);

        Resources resources = getResources();
        question1.setText(resources.getString(R.string.q1));
    }
}
