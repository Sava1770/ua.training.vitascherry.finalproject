package ua.training.vitascherry.model.util;

import ua.training.vitascherry.model.entity.Answer;
import ua.training.vitascherry.model.entity.Question;

import java.util.List;

public class TagLib {

    public static boolean containsAnswer(List<Answer> answers, Answer answer) {
        return answers.contains(answer);
    }

    public static List<Answer> getAnswers(List<Question> questions, int index) {
        return questions.get(index).getAnswers();
    }
}
