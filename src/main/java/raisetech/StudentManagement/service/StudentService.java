package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> searchStudentList(){
        // 検索処理
        List<Student> list = repository.search();

        // 絞り込みをする。年齢が30代の人の見を抽出する。
        // 抽出したリストをコントローラーに返す
        List<Student> returnList = new ArrayList<Student>();
        for (Student student : list) {
            if (student.getAge() >= 30 && student.getAge() <= 39) {
                returnList.add(student);
            }
        }

        return returnList;
    }

    public List<StudentCourse> searchStudentCourseList(){
        // 絞り込み検索で「Javaコース」のコース情報のみ抽出する。
        // 抽出したリストをコントローラーに返す。
        return repository.searchStudentCourse();
    }
}
