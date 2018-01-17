package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;

public interface SolutionService {

    boolean createStudentSolution(User student, Quiz quiz);
}
