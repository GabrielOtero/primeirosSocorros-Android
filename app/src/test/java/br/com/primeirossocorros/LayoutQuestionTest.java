package br.com.primeirossocorros;

import junit.framework.Assert;

import org.junit.Test;

import br.com.primeirossocorros.listener.QuestionFeedbackListenerImpl;
import br.com.primeirossocorros.util.StoryType;

public class LayoutQuestionTest {

    @Test
    public void makeLogEventAnswerStringArrestTest() throws Exception {
        QuestionFeedbackListenerImpl listener = new QuestionFeedbackListenerImpl(StoryType.ARREST.getDescription(), 1, null);
        String logStrRight = listener.makeLogEventAnswerString(true);
        Assert.assertEquals(logStrRight, "arrest_q1_right");

        String logStrWrong = listener.makeLogEventAnswerString(false);
        Assert.assertEquals(logStrWrong, "arrest_q1_wrong");

        listener = new QuestionFeedbackListenerImpl(StoryType.ARREST.getDescription(), 3, null);
        logStrRight = listener.makeLogEventAnswerString(true);
        Assert.assertEquals(logStrRight, "arrest_q3_right");

        logStrWrong = listener.makeLogEventAnswerString(false);
        Assert.assertEquals(logStrWrong, "arrest_q3_wrong");
    }

    @Test
    public void makeLogEventAnswerStringChokingtTest() throws Exception {
        QuestionFeedbackListenerImpl listener = new QuestionFeedbackListenerImpl(StoryType.CHOKING.getDescription(), 1, null);
        String logStrRight = listener.makeLogEventAnswerString(true);
        Assert.assertEquals(logStrRight, "choking_q1_right");

        String logStrWrong = listener.makeLogEventAnswerString(false);
        Assert.assertEquals(logStrWrong, "choking_q1_wrong");

        listener = new QuestionFeedbackListenerImpl(StoryType.CHOKING.getDescription(), 2, null);
        logStrRight = listener.makeLogEventAnswerString(true);
        Assert.assertEquals(logStrRight, "choking_q2_right");

        logStrWrong = listener.makeLogEventAnswerString(false);
        Assert.assertEquals(logStrWrong, "choking_q2_wrong");
    }

    @Test
    public void makeLogEventAnswerStringSeizureTest() throws Exception {
        QuestionFeedbackListenerImpl listener = new QuestionFeedbackListenerImpl(StoryType.SEIZURE.getDescription(), 1, null);
        String logStrRight = listener.makeLogEventAnswerString(true);
        Assert.assertEquals(logStrRight, "seizure_q1_right");

        String logStrWrong = listener.makeLogEventAnswerString(false);
        Assert.assertEquals(logStrWrong, "seizure_q1_wrong");

        listener = new QuestionFeedbackListenerImpl(StoryType.SEIZURE.getDescription(), 4, null);
        logStrRight = listener.makeLogEventAnswerString(true);
        Assert.assertEquals(logStrRight, "seizure_q4_right");

        logStrWrong = listener.makeLogEventAnswerString(false);
        Assert.assertEquals(logStrWrong, "seizure_q4_wrong");
    }


    @Test
    public void makeLogEventAnswerStringFaintingTest() throws Exception {
        QuestionFeedbackListenerImpl listener = new QuestionFeedbackListenerImpl(StoryType.FAINTING.getDescription(), 1, null);
        String logStrRight = listener.makeLogEventAnswerString(true);
        Assert.assertEquals(logStrRight, "fainting_q1_right");

        String logStrWrong = listener.makeLogEventAnswerString(false);
        Assert.assertEquals(logStrWrong, "fainting_q1_wrong");

        listener = new QuestionFeedbackListenerImpl(StoryType.FAINTING.getDescription(), 2, null);
        logStrRight = listener.makeLogEventAnswerString(true);
        Assert.assertEquals(logStrRight, "fainting_q2_right");

        logStrWrong = listener.makeLogEventAnswerString(false);
        Assert.assertEquals(logStrWrong, "fainting_q2_wrong");
    }

    @Test
    public void makeLogEventAnswerStringTraumaTest() throws Exception {
        QuestionFeedbackListenerImpl listener = new QuestionFeedbackListenerImpl(StoryType.TRAUMA.getDescription(), 1, null);
        String logStrRight = listener.makeLogEventAnswerString(true);
        Assert.assertEquals(logStrRight, "trauma_q1_right");

        String logStrWrong = listener.makeLogEventAnswerString(false);
        Assert.assertEquals(logStrWrong, "trauma_q1_wrong");

        listener = new QuestionFeedbackListenerImpl(StoryType.TRAUMA.getDescription(), 3, null);
        logStrRight = listener.makeLogEventAnswerString(true);
        Assert.assertEquals(logStrRight, "trauma_q3_right");

        logStrWrong = listener.makeLogEventAnswerString(false);
        Assert.assertEquals(logStrWrong, "trauma_q3_wrong");
    }
}