package net.students.accounting.service;

import net.students.accounting.dao.GrantsRepository;
import net.students.accounting.entity.StudentGrants;
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
        return grantsRepository.getStudentGrantsByStudentId(id);
    }

    @Override
    public StudentGrants getStudentGrantsByGrants(Double grant) {
        return grantsRepository.getStudentGrantsByGrants(grant);
    }
}
