package net.students.accounting.service;

import net.students.accounting.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudent(int id);
    void saveStudent(Student student);
    void deleteStudent(int id);
    Student getStudentByInn(String inn);
    void updateStudent(Student student);
    List<Student> getStudentByGroupName(String groupName);
    Student getStudentByName(String name);
}
