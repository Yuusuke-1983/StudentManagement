package raisetech.StudentManagement.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("SELECT * FROM students")
    List<Student> search();

    @Select("SELECT * FROM student_courses")
    List<StudentCourse> searchStudentCourse();
}
