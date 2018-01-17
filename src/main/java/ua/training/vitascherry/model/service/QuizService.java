package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.Quiz;

import java.util.List;

public interface QuizService {

        List<Quiz> getAllQuizzes();

        List<Quiz> getAllPassedByStudent(int id);

        List<Quiz> getAllAvailableForStudent(int id);

        Quiz getQuizById(int id);

        Quiz getQuizSolution(int studentId, int quizId);
}
