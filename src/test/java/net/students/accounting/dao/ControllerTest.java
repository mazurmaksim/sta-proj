package net.students.accounting.dao;

import net.students.accounting.controller.MainController;
import net.students.accounting.entity.Student;
import net.students.accounting.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MainController.class)
@RunWith(SpringRunner.class)
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    StudentService studentService;

    public StudentTestHelper helper = new StudentTestHelper();
    public Student student;

    @Before
    public void setUp() {
        student = helper.createStudent();
        studentService.saveStudent(student);
    }

    @Test
    public void get_student_by_group_expect_error() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/api/students/groups/someGroupName")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(204));
    }

    @Test
    public void get_student_by_inn_expect_error() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/api/students/studentid/someInn")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(204));
    }

}
