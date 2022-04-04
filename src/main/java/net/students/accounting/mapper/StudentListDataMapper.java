package net.students.accounting.mapper;

import net.students.accounting.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentListDataMapper extends AbstractDataMapper{

    private final List<Student> studentList;

    public StudentListDataMapper(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public Map<String, Object[]> studentMapper() {
        Map<String, Object[]> dataMap = new HashMap<>();
        studentList.forEach(student -> dataMap.put("1", titles(student.getGrantsList())));
        int count = 2;
        for (Student lst : studentList) {
            dataMap.put(String.valueOf(count++), data(lst));
        }
        return dataMap;
    }
}