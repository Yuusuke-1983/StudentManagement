package raisetech.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    private final StudentService service;
    private final StudentConverter converter;

    @Autowired
    public StudentController(StudentService service, StudentConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/studentList")
    public String getStudentList(Model model){
        List<Student> students = service.searchStudentList();
        List<StudentCourses> studentCourses = service.searchStudentCourseList();

        model.addAttribute("studentList", converter.covertStudentDetails(students, studentCourses));
        return "studentList";
    }

    @GetMapping("/studentCourseList")
    public List<StudentCourses> getStudentCourseList(){
        return service.searchStudentCourseList();
    }

    @GetMapping("/newStudent")
    public String newStudent(Model model){
//        StudentDetail studentDetail = new StudentDetail();
//        studentDetail.setStudentCourses(Arrays.asList(new StudentCourses()));
        model.addAttribute("studentDetail", new StudentDetail());
        return "registerStudent";
    }

    @PostMapping("/registerStudent")
    public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {
        if(result.hasErrors()){
            return "registerStudent";
        }
        service.insertStudent(studentDetail);
        return "redirect:/studentList";
    }
}
