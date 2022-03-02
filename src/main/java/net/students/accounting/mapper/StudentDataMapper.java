package net.students.accounting.mapper;

import net.students.accounting.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentDataMapper {

    private final Student student;

    public StudentDataMapper(Student student) {
        this.student = student;
    }

    public Map<String, Object[]> studentMapper() {
        Map<String, Object[]> dataMap = new HashMap<>();

        dataMap.put("1", new Object[]{
                "Name", "Last Name",
                "Middle Name", "Group",
                "Inn", "Grant",
                "Phone Number"});
        dataMap.put("2", new Object[]{
                student.getName(),
                student.getLastName(),
                student.getMiddleName(),
                student.getStGroup().getGroupName(),
                student.getFinance().getInn(),
                student.getFinance().getGrants(),
                student.getPhone()});
        return dataMap;
    }
}
