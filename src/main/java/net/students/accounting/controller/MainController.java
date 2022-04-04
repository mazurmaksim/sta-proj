package net.students.accounting.controller;

import net.students.accounting.entity.Student;
import net.students.accounting.exception.group.GroupNotFoundException;
import net.students.accounting.exception.student.StudentNotFoundException;
import net.students.accounting.mapper.StudentDataMapper;
import net.students.accounting.mapper.StudentListDataMapper;
import net.students.accounting.processor.XlSProcess;
import net.students.accounting.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private static final Logger LOGGER = LogManager.getLogger(MainController.class);

    StudentService studentService;

    XlSProcess xlSProcess;

    @GetMapping("/students")
    public List<Student> getStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public Student addNewStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @PostMapping("/students/all")
    public List<Student> addAllStudents(@RequestBody List<Student> students) {
        studentService.saveAllStudents(students);
        return students;
    }

    @PutMapping("/students/update")
    public Student updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return student;
    }

    @GetMapping("/students/groups/{groupName}")
    public List<Student> getStudentsByGroupName(@PathVariable String groupName) throws GroupNotFoundException {
        List<Student> student = studentService.getStudentByGroupName(groupName);
        if (student.isEmpty()) {
            LOGGER.error("Group {} - not found ", groupName);
            throw new GroupNotFoundException("Group not found");
        }
        return student;
    }


    @GetMapping("/students/studentid/{inn}")
    public Student getStudentByIdentical(@PathVariable(value = "inn") String inn) throws StudentNotFoundException {
        Student student = studentService.getStudentByInn(inn);
        if (student == null) {
            LOGGER.error("Student with inn {} - not found ", inn);
            throw new StudentNotFoundException("Student not found in database");
        }
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student with id " + id + " successful deleted";
    }

    @GetMapping(value = "/statistics/single/xlsx")
    public HttpEntity<ByteArrayResource> createExcelWithSingleStudent(@RequestBody Student student) {
        StudentDataMapper mapper = new StudentDataMapper(student);
        byte[] excelContent = xlSProcess.process(mapper.studentMapper());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "force-download"));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=single_student_statistic.xlsx");

        return new HttpEntity<>(new ByteArrayResource(excelContent), header);
    }

    @GetMapping(value = "/statistics/list/xlsx")
    public HttpEntity<ByteArrayResource> createExcelWithStudentList(@RequestBody List<Student> studentsList) {
        StudentListDataMapper mapper = new StudentListDataMapper(studentsList);
        byte[] excelContent = xlSProcess.process(mapper.studentMapper());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "force-download"));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=list_student_statistic.xlsx");

        return new HttpEntity<>(new ByteArrayResource(excelContent), header);
    }

    @Resource(name = "studentServiceImpl")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Resource(name = "xlsxProcessorService")
    public void setXlSProcess(XlSProcess xlSProcess) {
        this.xlSProcess = xlSProcess;
    }
}
