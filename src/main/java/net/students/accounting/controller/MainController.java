package net.students.accounting.controller;

import net.students.accounting.entity.Student;
import net.students.accounting.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public Student addNewStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student with id " + id + " succesful deleted";
    }
}
