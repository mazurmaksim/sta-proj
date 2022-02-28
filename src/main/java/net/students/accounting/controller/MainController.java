package net.students.accounting.controller;

import net.students.accounting.entity.Student;
import net.students.accounting.exception.GroupNotFoundException;
import net.students.accounting.exception.UserNotFoundException;
import net.students.accounting.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    private static final Logger LOGGER = LogManager.getLogger(MainController.class);

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

    @GetMapping("/students/{groupName}")
    public List<Student> getStudentsByGroupName(@PathVariable String groupName) throws GroupNotFoundException {
        List<Student> student = studentService.getStudentByGroupName(groupName);
        if (student.isEmpty()) {
            LOGGER.error("Group {} - not found ", groupName);
            throw new GroupNotFoundException("Group not found");
        }
        return student;
    }


    @GetMapping("/students/studentid/{inn}")
    public Student getStudentByIdentical(@PathVariable(value = "inn") String inn) {
        return studentService.getStudentByInn(inn);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student with id " + id + " succesful deleted";
    }
}
