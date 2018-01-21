package br.com.primeirossocorros.listener;


import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;

public class QuestionFeedbackListenerImpl implements QuestionFeedbackListener {

    private FirebaseAnalytics mFirebaseAnalytics;
    private String storyType;
    private int questioIdx;

    public QuestionFeedbackListenerImpl(String storyType, int questioIdx, Context context) {
        this.storyType = storyType;
        this.questioIdx = questioIdx;

        if (context != null) {
            mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
        }
    }

    @Override
    public void onRightAnswer() {
        String logStr = makeLogEventAnswerString(true);
        mFirebaseAnalytics.logEvent(logStr, null);

    }

    @Override
    public void onWrongAnswer() {
        String logStr = makeLogEventAnswerString(false);
        mFirebaseAnalytics.logEvent(logStr, null);
    }

    public String makeLogEventAnswerString(boolean isCorrect) {
        String assertivity = isCorrect ? "right" : "wrong";
        return storyType.concat("_q").concat(String.valueOf(questioIdx))
                .concat("_").concat(assertivity);
    }
}
