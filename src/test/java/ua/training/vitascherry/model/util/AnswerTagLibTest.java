package ua.training.vitascherry.model.util;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import ua.training.vitascherry.model.entity.Answer;
import ua.training.vitascherry.model.entity.Question;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class AnswerTagLibTest {
    @Test
    public void containsAnswer() throws Exception {
        List<Answer> answers = Arrays.asList(
                Answer.builder().setId(1).build(),
                Answer.builder().setId(2).build(),
                Answer.builder().setId(3).build(),
                Answer.builder().setId(4).build()
        );
        Answer existingAnswer = Answer.builder().setId(3).build();
        Answer missingAnswer = Answer.builder().setId(5).build();
        assertTrue(AnswerTagLib.containsAnswer(answers, existingAnswer));
        assertFalse(AnswerTagLib.containsAnswer(answers, missingAnswer));
    }

    @Test
    public void getAnswersOrEmpty() throws Exception {
        Answer id1 = Answer.builder().setId(1).build();
        Answer id2 = Answer.builder().setId(2).build();
        Answer id3 = Answer.builder().setId(3).build();
        Answer id4 = Answer.builder().setId(4).build();
        List<Answer> list = Arrays.asList(id1, id2, id3);
        List<Question> questions = Arrays.asList(
                Question.builder().setId(1).setAnswers(list).build(),
                Question.builder().setId(2).setAnswers(null).build()
        );
        // Test size
        assertThat(list, hasSize(3));

        //Test equals
        assertThat(list, is(AnswerTagLib.getAnswersOrEmpty(questions, 0)));

        // Test has not item
        assertThat(AnswerTagLib.getAnswersOrEmpty(questions, 0), not(hasItem(id4)));

        //Check for empty list
        assertThat(AnswerTagLib.getAnswersOrEmpty(questions, 0), not(Collections.EMPTY_LIST));
        assertThat(AnswerTagLib.getAnswersOrEmpty(questions, 1), IsEmptyCollection.empty());
    }

}