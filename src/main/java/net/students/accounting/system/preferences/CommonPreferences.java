package net.students.accounting.system.preferences;

import net.students.accounting.dao.SystemPreferenceRepository;
import net.students.accounting.exception.preference.UserPicRootFolderNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service("commonPreferences")
public class CommonPreferences {

    SystemPreferenceRepository repository;

    public String getUserPicRootFolder() {
        return Optional.ofNullable(repository.getSystemPreferenceByKey("user.pic.root.folder")
                .getValue()).orElseThrow(() ->
                new UserPicRootFolderNotFoundException("User picture folder nod defined in SYSTEM_PREFERENCE"));
    }

    @Resource(name = "systemPreferenceRepository")
    public void setRepository(SystemPreferenceRepository repository) {
        this.repository = repository;
    }
}
