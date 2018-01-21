package br.com.primeirossocorros.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import br.com.primeirossocorros.QuestionLayout;
import br.com.primeirossocorros.R;
import br.com.primeirossocorros.listener.QuestionFeedbackListenerImpl;
import br.com.primeirossocorros.util.Constants;
import br.com.primeirossocorros.util.StoryType;
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

    @BindView(R.id.q4)
    QuestionLayout question4;

    @BindView(R.id.q5)
    QuestionLayout question5;

    @BindView(R.id.q6)
    QuestionLayout question6;

    @BindView(R.id.question_layout_holder)
    LinearLayout questionLayoutHolder;

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

        if (storyType == StoryType.ARREST) {
            question4.setVisibility(View.VISIBLE);
            question5.setVisibility(View.VISIBLE);
            question6.setVisibility(View.VISIBLE);

            setQuestion(4, question4);
            setQuestion(5, question5);
            setQuestion(6, question6);
        }

        setNextStoryButton();
    }

    private void setQuestion(int questioIdx, QuestionLayout question) {
        String questionLabel = getQuestionLabel(questioIdx);
        String opt1 = getOptLabel(questioIdx, 1);
        String opt2 = getOptLabel(questioIdx, 2);
        String opt3 = getOptLabel(questioIdx, 3);
        String opt4 = getOptLabel(questioIdx, 4);

        int correctAnswer = getCorrectAnswer(questioIdx);

        QuestionFeedbackListenerImpl listener = new QuestionFeedbackListenerImpl(storyType.getDescription(), questioIdx, this);
        question.setInfo(questionLabel, opt1, opt2, opt3, opt4, correctAnswer, listener);
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

        if (!isLastStory()) {
            nextStory = storyTypes.get(storyIdx + 1);

            Resources resources = getResources();
            String storyLabel = resources.getString(resources.getIdentifier(nextStory.getDescription(), "string", getPackageName()));

            nextStoryButton.setText(getString(R.string.nextStoryLabel, storyLabel));
        }
    }

    private boolean isLastStory() {
        StoryType[] storyArray = EnumSet.allOf(StoryType.class).toArray(new StoryType[StoryType.values().length]);
        List<StoryType> storyTypes = Arrays.asList(storyArray);
        int storyIdx = storyTypes.indexOf(storyType);
        return storyIdx == storyTypes.size() - 1;
    }

    @OnClick(R.id.send_quizz)
    public void sendQuizz() {

        if(!question1.isAnswered() || !question2.isAnswered() || !question3.isAnswered()){
            Toast.makeText(this, getResources().getString(R.string.answerAllQuesitons),
                    Toast.LENGTH_LONG).show();
            return;
        }

        if (storyType == StoryType.ARREST) {
            if(!question4.isAnswered() || !question5.isAnswered() || !question6.isAnswered()){
                Toast.makeText(this, getResources().getString(R.string.answerAllQuesitons),
                        Toast.LENGTH_LONG).show();
                return;
            }
            question4.setFeedback();
            question5.setFeedback();
            question6.setFeedback();
        }

        question1.setFeedback();
        question2.setFeedback();
        question3.setFeedback();

        sendButton.setVisibility(View.GONE);
        backMenuButton.setVisibility(View.VISIBLE);

        if (!isLastStory()) {
            nextStoryButton.setVisibility(View.VISIBLE);
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                quizzLayout.fullScroll(ScrollView.FOCUS_UP);
            }
        }, 10);
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
