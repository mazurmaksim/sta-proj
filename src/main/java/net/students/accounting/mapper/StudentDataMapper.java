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
//todo add fields with moths from january to december, fix fields and tests
        dataMap.put("1", new Object[]{
                "Name", "Last Name",
                "Middle Name", "Group", "Phone Number",
                "Inn", "January", "February",
                "March", "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December",
                });
        dataMap.put("2", new Object[]{
                student.getName(),
                student.getLastName(),
                student.getMiddleName(),
                student.getStGroup().getGroupName(),
                student.getFinance().getInn(),
                500.3,
                student.getPhone()});
        return dataMap;
    }
}
