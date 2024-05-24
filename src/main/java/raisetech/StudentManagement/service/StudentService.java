package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> searchStudentList(){
        return repository.search();
    }

    public List<StudentCourses> searchStudentCourseList(){
        return repository.searchStudentCourse();
    }

    @Transactional
    public void insertStudent(StudentDetail studentDetail){
        repository.insert(studentDetail);
    }
}
