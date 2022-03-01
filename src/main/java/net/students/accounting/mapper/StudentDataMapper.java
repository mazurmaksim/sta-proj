package net.students.accounting.mapper;

import net.students.accounting.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentDataMapper {

    private final Student student;

    public StudentDataMapper(Student student) {
        this.student = student;
    }

    public Map<String, Object> studentMapper() {
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("Name", student.getName());
        dataMap.put("Last Name", student.getLastName());
        dataMap.put("Middle Name", student.getMiddleName());
        dataMap.put("Group", student.getStGroup().getGroupName());
        dataMap.put("Inn", student.getFinance().getInn());
        dataMap.put("Grant", student.getFinance().getGrants());
        dataMap.put("Phone Number", student.getPhone());

        return dataMap;
    }
}
