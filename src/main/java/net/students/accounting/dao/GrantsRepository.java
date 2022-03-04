package net.students.accounting.dao;

import net.students.accounting.entity.StudentGrants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "grantsRepository")
public interface GrantsRepository extends JpaRepository<StudentGrants, Integer> {
    //todo write select by Grant
}
