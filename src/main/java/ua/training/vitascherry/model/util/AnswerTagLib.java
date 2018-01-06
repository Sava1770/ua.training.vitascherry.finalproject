package ua.training.vitascherry.model.util;

import ua.training.vitascherry.model.entity.Answer;
import ua.training.vitascherry.model.entity.Question;

import java.util.Collections;
import java.util.List;

public class AnswerTagLib {

    public static boolean containsAnswer(List<Answer> answers, Answer answer) {
        return answers.contains(answer);
    }

    public static List<Answer> getAnswersOrEmpty(List<Question> questions, int index) {
        return questions.size() > index && questions.get(index).getAnswers() != null ?
                questions.get(index).getAnswers() :
                Collections.EMPTY_LIST;
    }
}
