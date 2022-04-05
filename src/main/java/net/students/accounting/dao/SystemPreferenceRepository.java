package net.students.accounting.dao;

import net.students.accounting.entity.SystemPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "systemPreferenceRepository")
public interface SystemPreferenceRepository extends JpaRepository<SystemPreference, Integer> {

    SystemPreference getSystemPreferenceByKey(String preference);
}
