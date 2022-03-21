package net.students.accounting.service;

import net.students.accounting.dao.GrantsRepository;
import net.students.accounting.entity.StudentGrants;
import net.students.accounting.exception.student.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "grantsService")
public class GrantsServiceImpl implements GrantsService {

    @Autowired
    GrantsRepository grantsRepository;

    @Override
    public void saveGrant(StudentGrants grants) {
        grantsRepository.save(grants);
    }

    @Override
    public StudentGrants getStudentGrantsByStudentId(Integer id) {
        return grantsRepository.getStudentGrantsByStudentId(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " not found"));
    }

    @Override
    public StudentGrants getStudentGrantsByGrants(Double grant) {
        return grantsRepository.getStudentGrantsByGrants(grant)
                .orElseThrow(() -> new StudentNotFoundException("Student with grant - " + grant + " not found"));
    }
}
