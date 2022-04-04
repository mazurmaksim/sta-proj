package net.students.accounting.service;

import net.students.accounting.dao.StudentRepository;
import net.students.accounting.entity.Student;
import net.students.accounting.exception.student.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(int id) {
        return studentRepository.getStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException("Can't find student with id" + id));
    }

    @Override
    public void saveStudent(Student student) {
          studentRepository.save(student);
    }

    @Override
    public void saveAllStudents(List<Student> students) {
        studentRepository.saveAll(students);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentByInn(String inn) {
        return studentRepository.getStudentByIdentical(inn)
                .orElseThrow(() -> new StudentNotFoundException("Can't find student with INN" + inn));
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentByGroupName(String groupName) {
        List<Student> studentByGroupName = studentRepository.getStudentByGroupName(groupName);
        return studentByGroupName;
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name)
                .orElseThrow(() -> new StudentNotFoundException("Not found student with name" + name));
    }
}
