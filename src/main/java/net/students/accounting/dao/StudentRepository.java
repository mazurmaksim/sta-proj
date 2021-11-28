package net.students.accounting.dao;

import net.students.accounting.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "studentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Student getStudentByName(String name);
    Student getStudentById(int id);
}
