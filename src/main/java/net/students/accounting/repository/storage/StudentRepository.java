package net.students.accounting.repository.storage;

import net.students.accounting.entity.Students;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@RepositoryDefinition(domainClass = Students.class, idClass = Long.class)
public interface StudentRepository extends JpaRepository<Students, Long>{
   // Students findById(Long id);
    List<Students> findAll(Sort sort);
}
