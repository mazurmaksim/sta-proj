package net.students.accounting.controller;

import net.students.accounting.entity.Student;
import net.students.accounting.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private static final Logger LOGGER =  LogManager.getLogger(MainController.class);

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudent() {
        LOGGER.debug(MessageFormat.format("Getting student from a DB{0}", studentService.getAllStudents()));
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public Student addNewStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @PutMapping("/students/update")
    public Student updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student with id " + id + " succesful deleted";
    }
}
