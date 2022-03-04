package net.students.accounting.mapper;

import net.students.accounting.entity.Student;
import net.students.accounting.entity.StudentGrants;

import java.util.HashMap;
import java.util.Map;

public class StudentDataMapper {

    private final Student student;

    public StudentDataMapper(Student student) {
        this.student = student;
    }

    public Map<String, Object[]> studentMapper() {
        //todo finish mapper
        Map<String, Object[]> dataMap = new HashMap<>();
        StudentGrants grants = student.getGrantsList().get(0);

        dataMap.put("1", new Object[]{
                "Name", "Last Name",
                "Middle Name", "Group", "Phone Number",
                "Inn", "January", "February",
                "March", "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
                });
        dataMap.put("2", new Object[]{
                student.getName(),
                student.getLastName(),
                student.getMiddleName(),
                student.getStGroup().getGroupName(),
                student.getPhone(),
                student.getFinance().getInn(),
                grants.getJanuary(),
                grants.getFebruary(),
                grants.getMarch(),
                grants.getApril(),
                grants.getMay(),
                grants.getJune(),
                grants.getJuly(),
                grants.getAugust(),
                grants.getOctober(),
                grants.getNovember(),
                grants.getDecember()
                });
        return dataMap;
    }
}
