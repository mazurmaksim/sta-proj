package net.students.accounting.dao;

import net.students.accounting.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository(value = "studentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> getStudentByName(String name);
    Optional<Student> getStudentById(int id);

    @Query(value = "SELECT * from students as student" +
            "                  inner join st_groups" +
            "    as groups_st where groups_st.group_name = ?1 and student.group_id = groups_st.id" , nativeQuery= true)
    List<Student> getStudentByGroupName(@Param("groupName") String groupName);

    @Query(value = "SELECT * from students as student" +
            "    inner join finance_info" +
            "        as finance where finance.inn = ?1 and student.finance_id = finance.id" , nativeQuery= true)
    Optional<Student> getStudentByIdentical(@Param("inn") String inn);}
