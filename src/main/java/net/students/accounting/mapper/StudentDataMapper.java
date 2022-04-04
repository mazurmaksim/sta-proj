package net.students.accounting.mapper;

import net.students.accounting.entity.Student;
import net.students.accounting.entity.StudentGrants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDataMapper extends AbstractDataMapper{

    private final Student student;

    public StudentDataMapper(Student student) {
        this.student = student;
    }

    @Override
    public Map<String, Object[]> studentMapper() {
        Map<String, Object[]> dataMap = new HashMap<>();
        List<StudentGrants> grants = student.getGrantsList();
        dataMap.put("1", titles(grants));
        dataMap.put("2", data(student));
        return dataMap;
    }
}