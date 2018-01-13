package br.unicamp.primeirossocorros.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import br.unicamp.primeirossocorros.QuestionLayout;
import br.unicamp.primeirossocorros.R;
import br.unicamp.primeirossocorros.util.Constants;
import br.unicamp.primeirossocorros.util.StoryType;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizzActivity extends BaseActivity {

    @BindView(R.id.q1)
    QuestionLayout question1;

    @BindView(R.id.q2)
    QuestionLayout question2;

    @BindView(R.id.q3)
    QuestionLayout question3;

    @BindView(R.id.quizz_layout)
    ScrollView quizzLayout;

    @BindView(R.id.send_quizz)
    Button sendButton;

    @BindView(R.id.back_to_menu)
    Button backMenuButton;

    @BindView(R.id.next_story)
    Button nextStoryButton;

    private StoryType storyType;
    private StoryType nextStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        ButterKnife.bind(this);

        storyType = (StoryType) getIntent().getSerializableExtra(Constants.STORY_TYPE);

        setQuestion(1, question1);
        setQuestion(2, question2);
        setQuestion(3, question3);

        setNextStoryButton();
    }

    private void setQuestion(int questioIdx, QuestionLayout question) {
        String questionLabel = getQuestionLabel(questioIdx);
        String opt1 = getOptLabel(questioIdx, 1);
        String opt2 = getOptLabel(questioIdx, 2);
        String opt3 = getOptLabel(questioIdx, 3);
        String opt4 = getOptLabel(questioIdx, 4);

        int correctAnswer = getCorrectAnswer(questioIdx);

        question.setInfo(questionLabel, opt1, opt2, opt3, opt4, correctAnswer);
    }

    private String getQuestionLabel(int questioNumber) {
        Resources resources = getResources();
        String resourceName = "q" + questioNumber + this.storyType.getDescription();

        return resources.getString(resources.getIdentifier(resourceName,
                "string", getPackageName()));
    }

    private String getOptLabel(int questioNumber, int optNumber) {
        Resources resources = getResources();
        String resourceName = "q" + questioNumber + "opt" + optNumber + this.storyType.getDescription();

        return resources.getString(resources.getIdentifier(resourceName,
                "string", getPackageName()));
    }

    private int getCorrectAnswer(int questionNumber) {
        try {
            Field st = Constants.class.getField("Q" + questionNumber + "_" + this.storyType.getDescription().toUpperCase() + "_CORRECT_ANSWER");
            int correctAnswer = st.getInt(null);
            return correctAnswer;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private void setNextStoryButton() {
        StoryType[] storyArray = EnumSet.allOf(StoryType.class).toArray(new StoryType[StoryType.values().length]);
        List<StoryType> storyTypes = Arrays.asList(storyArray);
        int storyIdx = storyTypes.indexOf(storyType);

        if (isLastStory(storyTypes, storyIdx)) {
            nextStoryButton.setVisibility(View.GONE);
        } else {
            nextStory = storyTypes.get(storyIdx + 1);

            Resources resources = getResources();
            String storyLabel = resources.getString(resources.getIdentifier(nextStory.getDescription(), "string", getPackageName()));

            nextStoryButton.setText(getString(R.string.nextStoryLabel, storyLabel));
        }
    }

    private boolean isLastStory(List<StoryType> storyTypes, int storyIdx) {
        return storyIdx == storyTypes.size() - 1;
    }

    @OnClick(R.id.send_quizz)
    public void sendQuizz() {
        question1.setFeedback();
        question2.setFeedback();
        question3.setFeedback();

        quizzLayout.fullScroll(ScrollView.FOCUS_UP);

        sendButton.setVisibility(View.GONE);
        backMenuButton.setVisibility(View.VISIBLE);
        nextStoryButton.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.back_to_menu)
    public void backToMenuClick() {
        super.backToMenuClearTop();
    }

    @OnClick(R.id.next_story)
    public void nextQuizz() {
        Intent storyIntent = new Intent(this, StoryActivity.class);
        storyIntent.putExtra(Constants.STORY_TYPE, nextStory);
        startActivity(storyIntent);
        this.finish();
    }
}
