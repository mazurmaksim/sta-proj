package net.students.accounting.service;

import net.students.accounting.dao.StudentRepository;
import net.students.accounting.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }
}
