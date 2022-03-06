package net.students.accounting.dao;

import net.students.accounting.entity.Finance;
import net.students.accounting.entity.Groups;
import net.students.accounting.entity.Student;
import net.students.accounting.entity.StudentGrants;
import net.students.accounting.service.GrantsService;
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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@ContextConfiguration("classpath:spring/test-context.xml")
@Transactional()
public class StudentRepositoryIntegrationTest {

    @Autowired
    StudentService studentService;

    @Autowired
    GrantsService grantsService;

    Student student;
    StudentGrants grants;
    public StudentTestHelper helper = new StudentTestHelper();

    @Before
    public void setUp() {
        student = helper.createStudent();
        studentService.saveStudent(student);
    }

    @Test
    public void findOneStudent() {
        Student student = studentService.getStudentByName("Maks");
        assertThat(student.getName())
                .isEqualTo("Maks");
        assertThat(student.getLastName())
                .isEqualTo("Mazur");
        assertThat(student.getMiddleName())
                .isEqualTo("Aleksandrovich");
        assertThat(student.getStGroup().getGroupName())
                .isEqualTo("B-46");
        assertThat(student.getPhone())
                .isEqualTo("+380956563258");
        assertThat(student.getUserPic())
                .isEqualTo("localHost");
        assertThat(student.getFinance().getInn())
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
    public void getStudentByInn(){
        Student studentByInn = studentService.getStudentByInn("1452652541");
        assertThat(studentByInn.getName()).isEqualTo("Maks");
    }

    @Test
    public void getStudentsByGroupName(){
        List<Student> studentByGroupName = studentService.getStudentByGroupName("B-46");
        assertThat(studentByGroupName.contains(student)).isTrue();
    }

    @Test
    public void grant_should_be_saved_to_current_months() {
        grants = new StudentGrants();
        StudentGrants grants = new StudentGrants();
        grants.setStudent(student);
        grants.setGrants(965.325);
        grantsService.saveGrant(grants);
    }

    @Test
    @DirtiesContext
    public void updateStudent() {
        Finance updateFinance = new Finance();
        Groups groups = new Groups();
        StudentGrants grants = new StudentGrants();
        groups.setGroupName("Б-41");

        student.setName("Valentin");
        updateFinance.setInn("742589214");
        grants.setGrants(800.87);
        List<StudentGrants> grantsList = new ArrayList<>();
        grantsList.add(grants);
        student.setFinance(updateFinance);
        student.setGrantsList(grantsList);
        student.setStGroup(groups);
        studentService.updateStudent(student);

        Student studentFromDB = studentService.getStudentByName("Valentin");
        assertThat(studentFromDB.getName()).isEqualTo("Valentin");
        assertThat(studentFromDB.getFinance().getInn()).isEqualTo("742589214");
        assertThat(studentFromDB.getStGroup().getGroupName()).isEqualTo("Б-41");
    }
}
