import net.students.accounting.entity.Finance;
import net.students.accounting.entity.Groups;
import net.students.accounting.entity.Student;
import net.students.accounting.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:student-integrationtest.properties")
@ContextConfiguration("classpath:spring/test-context.xml")
@DataJpaTest
public class StudentRepositoryIntegrationTest {

    @Autowired
    StudentService studentService;

    Student student;

    @Before
    public void setUp() {
        student = createStudent();
        studentService.saveStudent(student);
    }

    @Test
    public void findOneStudent() {
        assertThat(studentService.getStudent(1).getName())
                .isEqualTo("Maks");
        assertThat(studentService.getStudent(1).getLastName())
                .isEqualTo("Mazur");
        assertThat(studentService.getStudent(1).getMiddleName())
                .isEqualTo("Aleksandrovich");
        assertThat(studentService.getStudent(1).getStGroup().getGroupName())
                .isEqualTo("Б-46");
        assertThat(studentService.getStudent(1).getPhone())
                .isEqualTo("+380965156858");
        assertThat(studentService.getStudent(1).getUserPic())
                .isEqualTo("localHost");
        assertThat(studentService.getStudent(1).getFinance().getInn())
                .isEqualTo("1452652541");
    }

    @Test
    @DirtiesContext
    public void findAllStudents() {
        List<Student> students = studentService.getAllStudents();
        assertThat(students.size()).isGreaterThan(0);
        assertThat(students.get(0).getName()).isEqualTo("Maks");
    }

    @Test
    @DirtiesContext
    public void updateStudent() {
        Finance updateFinance = new Finance();
        Groups groups = new Groups();
        groups.setGroupName("Б-41");

        student.setName("Valentin");
        updateFinance.setInn("742589214");

        student.setFinance(updateFinance);
        student.setStGroup(groups);
        studentService.updateStudent(student);

        Student studentFromDB = studentService.getStudent(1);
        assertThat(studentFromDB.getName()).isEqualTo("Valentin");
        assertThat(studentFromDB.getFinance().getInn()).isEqualTo("742589214");
        assertThat(studentFromDB.getStGroup().getGroupName()).isEqualTo("Б-41");
    }

    @Test
    public void getStudentByInn(){
        Student studentByInn = studentService.getStudentByInn("1452652541");
        assertThat(studentByInn.getName()).isEqualTo("Maks");
    }

    @Test
    public void getStudentsByGroupName(){
        List<Student> studentByGroupName = studentService.getStudentByGroupName("Б-46");
        assertThat(studentByGroupName.contains(student)).isTrue();
    }

    private Student createStudent() {
        Finance finance = new Finance();
        Groups groups = new Groups();
        groups.setGroupName("Б-46");

        finance.setGrants(500.3);
        finance.setInn("1452652541");

        Student student = new Student();
        student.setStGroup(groups);
        student.setName("Maks");
        student.setLastName("Mazur");
        student.setMiddleName("Aleksandrovich");
        student.setPhone("+380965156858");
        student.setUserPic("localHost");

        student.setFinance(finance);
        return student;
    }
}
