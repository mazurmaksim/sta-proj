package net.students.accounting.dao;

import net.students.accounting.entity.StudentGrants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = "grantsRepository")
public interface GrantsRepository extends JpaRepository<StudentGrants, Integer> {
    //todo write select by Grant
    @Query(value = " SELECT * from student_grants as grants" +
            "    where grants.student_id = ?1 ", nativeQuery = true)
    Optional<StudentGrants> getStudentGrantsByStudentId(@Param("studentId") Integer id);
    Optional<StudentGrants> getStudentGrantsByGrants(Double grant);
}
