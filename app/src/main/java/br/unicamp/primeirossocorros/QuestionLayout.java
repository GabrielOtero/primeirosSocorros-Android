package br.unicamp.primeirossocorros;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.TextView;

public class QuestionLayout extends ConstraintLayout {

    public QuestionLayout(Context context) {
        super(context);
    }

    public QuestionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QuestionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setText(String questionLabel) {
        TextView labelQuestion = (TextView) findViewById(R.id.label_question);
        labelQuestion.setText(questionLabel);
    }
}
