import net.students.accounting.entity.Finance;
import net.students.accounting.entity.Groups;
import net.students.accounting.entity.Student;
import net.students.accounting.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    }

    @Test
    public void findOneStudent() {
        studentService.saveStudent(student);
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
