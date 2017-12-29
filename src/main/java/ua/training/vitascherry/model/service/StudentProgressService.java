package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.StudentProgressDao;
import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.List;

public class StudentProgressService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static volatile StudentProgressService studentProgressService;

    private StudentProgressService() {}

    public static StudentProgressService getInstance(){
        if( studentProgressService == null ){
            synchronized (StudentProgressService.class){
                if( studentProgressService == null ){
                    studentProgressService = new StudentProgressService();
                }
            }
        }
        return studentProgressService;
    }

    public List<StudentProgress> getAllStudentProgress() {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findAll();
        }
    }

    public List<StudentProgress> getProgressByStudentId(int id) {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findByStudentId(id);
        }
    }
}
