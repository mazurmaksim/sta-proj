package net.students.accounting.dao;

import net.students.accounting.entity.Finance;
import net.students.accounting.entity.Groups;
import net.students.accounting.entity.Student;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(locations = "classpath:student-integrationtest.properties")
@ContextConfiguration("classpath:spring/test-context.xml")
public class StudentTestHelper {

    public StudentTestHelper() {
    }

    public Student createStudent() {
        Finance finance = new Finance();
        Groups groups = new Groups();
        groups.setGroupName("B-46");

        finance.setInn("1452652541");

        Student student = new Student();
        student.setStGroup(groups);
        student.setName("Maks");
        student.setLastName("Mazur");
        student.setMiddleName("Aleksandrovich");
        student.setPhone("+380956563258");
        student.setUserPic("localHost");

        student.setFinance(finance);
        return student;
    }
}
