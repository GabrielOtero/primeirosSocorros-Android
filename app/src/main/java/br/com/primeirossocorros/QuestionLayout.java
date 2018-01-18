package br.com.primeirossocorros;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.widget.RadioGroup;
import android.widget.TextView;

import br.com.primeirossocorros.util.StoryType;

public class QuestionLayout extends ConstraintLayout {

    public String RIGHT = "CORRETO!";
    public String WRONG = "ERRADO";
    private StoryType storyType;
    private int questionNumber;
    private String questionLabel;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private int correctOptId;
    private TextView labelOpt1;
    private TextView labelOpt2;
    private TextView labelOpt3;
    private TextView labelOpt4;

    public QuestionLayout(Context context) {
        super(context);
    }

    public QuestionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QuestionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setInfo(String questionLabel, String opt1, String opt2, String opt3, String opt4,
                        int correctOpt) {
        this.questionLabel = questionLabel;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.correctOptId = correctOpt;

        setQuestionLabel();
        setQuestionOptions();

        RIGHT = getResources().getString(R.string.quizz_right);
        WRONG = getResources().getString(R.string.quizz_wrong);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private void setQuestionOptions() {
        labelOpt1 = (TextView) findViewById(R.id.opt1_check);
        labelOpt1.setText(opt1);

        labelOpt2 = (TextView) findViewById(R.id.opt2_check);
        labelOpt2.setText(opt2);

        labelOpt3 = (TextView) findViewById(R.id.opt3_check);
        labelOpt3.setText(opt3);

        labelOpt4 = (TextView) findViewById(R.id.opt4_check);
        labelOpt4.setText(opt4);
    }

    private void setQuestionLabel() {
        TextView labelQuestion = (TextView) findViewById(R.id.label_question);
        labelQuestion.setText(questionLabel);
    }

    public void setFeedback() {
        TextView labelFeedback = (TextView) findViewById(R.id.feedback_text);
        labelFeedback.setVisibility(VISIBLE);

        labelOpt1.setVisibility(GONE);
        labelOpt2.setVisibility(GONE);
        labelOpt3.setVisibility(GONE);
        labelOpt4.setVisibility(GONE);

        int selectedAnswer = getSelectedAnswer();

        TextView correctOpt = (TextView) findViewById(correctOptId);
        TextView selectedOpt = (TextView) findViewById(selectedAnswer);

        correctOpt.setVisibility(VISIBLE);
        selectedOpt.setVisibility(VISIBLE);

        int green = ResourcesCompat.getColor(getResources(), R.color.green, null);
        int red = ResourcesCompat.getColor(getResources(), R.color.firstAidRed, null);

        selectedOpt.setTextColor(red);
        correctOpt.setTextColor(green);

        if (correctOptId == selectedAnswer) {
            labelFeedback.setText(RIGHT);
            labelFeedback.setTextColor(green);
        } else {
            labelFeedback.setText(WRONG);
            labelFeedback.setTextColor(red);
        }

    }

    private int getSelectedAnswer() {
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        return radioGroup.getCheckedRadioButtonId();
    }

    public boolean isAnswered() {
        return getSelectedAnswer() != -1;
    }
}
