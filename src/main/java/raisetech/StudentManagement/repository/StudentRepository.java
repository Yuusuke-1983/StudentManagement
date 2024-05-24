package raisetech.StudentManagement.repository;

import org.apache.ibatis.annotations.*;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("SELECT * FROM students")
    List<Student> search();

    @Select("SELECT * FROM students_courses")
    List<StudentCourses> searchStudentCourse();

    @Insert("INSERT INTO students(id, name, kana_name, nickname, email, area, age, sex, remark, is_deleted) " +
            "VALUES(#{studentDetail.student.id}, #{studentDetail.student.name}, #{studentDetail.student.kanaName}, #{studentDetail.student.nickname}, #{studentDetail.student.email}, #{studentDetail.student.area}, #{studentDetail.student.age}, #{studentDetail.student.sex}, #{studentDetail.student.remark}, false)")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(@Param("studentDetail") StudentDetail studentDetail);
}
