package net.students.accounting.service;

import net.students.accounting.dao.SystemPreferenceRepository;
import net.students.accounting.entity.SystemPreference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("systemPreferenceServiceImpl")
public class SystemPreferenceServiceImpl implements SystemPreferenceService {

    SystemPreferenceRepository repository;

    @Override
    public void setSystemPreference(SystemPreference preference) {
        repository.save(preference);
    }

    @Resource(name = "systemPreferenceRepository")
    public void setRepository(SystemPreferenceRepository repository) {
        this.repository = repository;
    }
}
