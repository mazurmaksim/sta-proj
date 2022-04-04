package net.students.accounting.mapper;

import net.students.accounting.entity.Student;
import net.students.accounting.entity.StudentGrants;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public abstract class AbstractDataMapper {

    static <T> T[] concatWithStream(T[] array1, T[] array2) {
        return Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
                .toArray(size -> (T[]) Array.newInstance(array1.getClass().getComponentType(), size));
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

    public abstract Map<String, Object[]> studentMapper();

    public Object[] data(Student student) {
        Object[] fields = new Object[]{
                student.getName(),
                student.getLastName(),
                student.getMiddleName(),
                student.getStGroup().getGroupName(),
                student.getPhone(),
                student.getFinance().getInn()
        };
        Object[] values = student.getGrantsList().stream().map(StudentGrants::getGrants).toArray(Object[]::new);
        return concatWithStream(fields, values);
    }
}
