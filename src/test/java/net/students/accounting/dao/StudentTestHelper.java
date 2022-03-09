package net.students.accounting.dao;

import net.students.accounting.entity.Finance;
import net.students.accounting.entity.Groups;
import net.students.accounting.entity.Student;
import net.students.accounting.entity.StudentGrants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        setGrantsToStudent(student);
        return student;
    }

    public void setGrantsToStudent(Student student) {
        List<StudentGrants> grants = new ArrayList<>();
        StudentGrants stGr = new StudentGrants();
        stGr.setMonths(LocalDate.of(2020, 5, 5));
        stGr.setStudent(student);
        stGr.setGrants(895.7);
        grants.add(stGr);

        StudentGrants stGr1 = new StudentGrants();
        stGr1.setMonths(LocalDate.of(2020, 6, 5));
        stGr1.setStudent(student);
        stGr1.setGrants(918.7);
        grants.add(stGr1);

        StudentGrants stGr2 = new StudentGrants();
        stGr2.setMonths(LocalDate.of(2020, 7, 5));
        stGr2.setStudent(student);
        stGr2.setGrants(1000.7);
        grants.add(stGr2);

        StudentGrants stGr3 = new StudentGrants();
        stGr3.setMonths(LocalDate.of(2020, 8, 5));
        stGr3.setStudent(student);
        stGr3.setGrants(1010.7);
        grants.add(stGr3);

        StudentGrants stGr4 = new StudentGrants();
        stGr4.setMonths(LocalDate.of(2020, 9, 5));
        stGr4.setStudent(student);
        stGr4.setGrants(1010.7);
        grants.add(stGr4);

        StudentGrants stGr5 = new StudentGrants();
        stGr5.setMonths(LocalDate.of(2020, 10, 5));
        stGr5.setStudent(student);
        stGr5.setGrants(900.7);
        grants.add(stGr5);

        student.setGrantsList(grants);
    }

    public void setGrantsToStudent1(Student student) {
        List<StudentGrants> grants = new ArrayList<>();
        StudentGrants stGr = new StudentGrants();
        stGr.setMonths(LocalDate.of(2020, 5, 5));
        stGr.setStudent(student);
        stGr.setGrants(900.7);
        grants.add(stGr);

        StudentGrants stGr1 = new StudentGrants();
        stGr1.setMonths(LocalDate.of(2020, 6, 5));
        stGr1.setStudent(student);
        stGr1.setGrants(5000.7);
        grants.add(stGr1);

        StudentGrants stGr2 = new StudentGrants();
        stGr2.setMonths(LocalDate.of(2020, 7, 5));
        stGr2.setStudent(student);
        stGr2.setGrants(3000.7);
        grants.add(stGr2);

        StudentGrants stGr3 = new StudentGrants();
        stGr3.setMonths(LocalDate.of(2020, 8, 5));
        stGr3.setStudent(student);
        stGr3.setGrants(3652.7);
        grants.add(stGr3);

        StudentGrants stGr4 = new StudentGrants();
        stGr4.setMonths(LocalDate.of(2020, 9, 5));
        stGr4.setStudent(student);
        stGr4.setGrants(2365.7);
        grants.add(stGr4);

        StudentGrants stGr5 = new StudentGrants();
        stGr5.setMonths(LocalDate.of(2020, 10, 5));
        stGr5.setStudent(student);
        stGr5.setGrants(7412.7);
        grants.add(stGr5);

        student.setGrantsList(grants);
    }

    public List<Student> createStudentList() {

        List<Student> st = new ArrayList<>();

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

        setGrantsToStudent(student);

        Finance finance1 = new Finance();
        Groups groups1 = new Groups();
        groups1.setGroupName("B-46");

        finance1.setInn("888888888888");

        Student student1 = new Student();
        student1.setStGroup(groups1);
        student1.setName("Valentin");
        student1.setLastName("Melnik");
        student1.setMiddleName("Victorovich");
        student1.setPhone("+380956563125");
        student1.setUserPic("localHost");
        student1.setFinance(finance1);

        setGrantsToStudent1(student1);

        st.add(student1);
        st.add(student);
        return st;
    }
}
