package net.students.accounting.service;

import net.students.accounting.dao.GrantsRepository;
import net.students.accounting.entity.StudentGrants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "grantsService")
public class GrantServiceImpl implements GrantsService {

    @Autowired
    GrantsRepository grantsRepository;

    @Override
    public void saveGrant(StudentGrants grants) {
        grantsRepository.save(grants);
    }
}
