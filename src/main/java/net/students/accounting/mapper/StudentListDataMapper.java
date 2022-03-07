package net.students.accounting.mapper;

import net.students.accounting.entity.Student;
import net.students.accounting.entity.StudentGrants;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StudentListDataMapper {

    private final List<Student> studentList;

    public StudentListDataMapper(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Map<String, Object[]> studentMapper() {
        Map<String, Object[]> dataMap = new HashMap<>();
        studentList.forEach(student -> dataMap.put("1", titles(student.getGrantsList())));
        studentList.forEach(student -> dataMap.put("2",
                data(student.getGrantsList())));
        return dataMap;
    }

    static <T> T[] concatWithStream(T[] array1, T[] array2) {
        return Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
                .toArray(size -> (T[]) Array.newInstance(array1.getClass().getComponentType(), size));
    }

    public Object[] data(List<StudentGrants> grants) {
        List<Object[]> fieldsArr = studentList.stream().map(student -> new Object[] {
                student.getName(),
                student.getLastName(),
                student.getMiddleName(),
                student.getStGroup().getGroupName(),
                student.getPhone(),
                student.getFinance().getInn()
        }).collect(Collectors.toList());
        List<Object> fields = append(fieldsArr);
        Object[] values = grants.stream().map(StudentGrants::getGrants).toArray(Object[]::new);
        return concatWithStream(fields.stream().toArray(Object[]::new), values);
    }

    public Object[] titles(List<StudentGrants> grants) {
        Object[] title = new Object[]{
                "Name", "Last Name",
                "Middle Name", "Group",
                "Phone Number", "Inn"
        };
        Object[] titleValues = grants.stream().map(months -> months.getMonths().getMonth().toString()).toArray(Object[]::new);
        return concatWithStream(title, titleValues);
    }

    public static<T> List<T> append (List<T[]> input) {
        List<T> res = new ArrayList<T>();
        for(T[] subarr : input) {
            if(subarr != null) {
                int n = subarr.length;
                for(int i = 0; i < n; i++) {
                    res.add(subarr[i]);
                }
            }
        }
        return res;
    }
}