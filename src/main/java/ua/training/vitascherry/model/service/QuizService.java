package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.Quiz;

import java.util.List;

public interface QuizService {

        int getQuizzesCount();

        Quiz getQuizById(int id);

        List<Quiz> getAllQuizzes();

        List<Quiz> getAllQuizzes(int offset);

        List<Quiz> getAllPassedByStudent(int id);

        List<Quiz> getAllPassedByStudent(int id, int offset);

        Quiz getStudentQuizSolution(int studentId, int quizId);

        List<Quiz> getAllAvailableForStudent(int id);

        List<Quiz> getAllAvailableForStudent(int id, int offset);
}
