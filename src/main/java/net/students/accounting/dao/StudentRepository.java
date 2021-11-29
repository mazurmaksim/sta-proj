package net.students.accounting.dao;

import net.students.accounting.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "studentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Student getStudentByName(String name);
    Student getStudentById(int id);

    @Query(value = "SELECT * from students as student" +
            "                  inner join st_groups" +
            "    as groups_st where groups_st.group_name = ?1 and student.group_id = groups_st.id" , nativeQuery= true)
    List<Student> getStudentByGroupName(@Param("groupName") String groupName);

    @Query(value = "SELECT * from Students as student" +
            "    inner join Finance_info" +
            "        as finance where finance.inn = ?1 and student.finance_id = finance.id" , nativeQuery= true)
    Student getStudentByIdentical(@Param("inn") String inn);}
