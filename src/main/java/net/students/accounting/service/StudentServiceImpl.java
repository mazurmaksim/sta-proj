package net.students.accounting.service;

import net.students.accounting.dao.StudentRepository;
import net.students.accounting.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public void saveStudent(Student student) {
          studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentByInn(String inn) {
        return studentRepository.getStudentByIdentical(inn);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentByGroupName(String groupName) {
        return studentRepository.getStudentByGroupName(groupName);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }
}
