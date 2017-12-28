package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.StudentDao;
import ua.training.vitascherry.model.entity.Student;

import java.util.List;

public class StudentService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static volatile StudentService studentService;

    private StudentService() {}

    public static StudentService getInstance(){
        if( studentService == null ){
            synchronized (StudentService.class){
                if( studentService == null ){
                    studentService = new StudentService();
                }
            }
        }
        return studentService;
    }

    public List<Student> getAllStudents() {
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findAll();
        }
    }
}
