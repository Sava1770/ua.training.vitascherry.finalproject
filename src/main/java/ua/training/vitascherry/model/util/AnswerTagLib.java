package ua.training.vitascherry.model.util;

import ua.training.vitascherry.model.entity.Answer;
import ua.training.vitascherry.model.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class AnswerTagLib {

    public static boolean containsAnswer(List<Answer> answers, Answer answer) {
        return answers.contains(answer);
    }

    public static List<Answer> getAnswers(List<Question> questions, int questionIndex) {
        return questions.size() > questionIndex ?
                questions.get(questionIndex).getAnswers() :
                    new ArrayList<>();
    }
}
