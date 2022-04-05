package net.students.accounting.system.preference;

import net.students.accounting.dao.StudentTestHelper;
import net.students.accounting.entity.*;
import net.students.accounting.exception.preference.UserPicRootFolderNotFoundException;
import net.students.accounting.service.GrantsService;
import net.students.accounting.service.StudentService;
import net.students.accounting.service.SystemPreferenceService;
import net.students.accounting.system.preferences.CommonPreferences;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@ContextConfiguration("classpath:spring/test-context.xml")
@Transactional()
public class SystemPreferenceTest {

    @Autowired
    SystemPreferenceService service;

    @Autowired
    CommonPreferences commonPreferences;

    SystemPreference preference;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldBeWritingPreferenceTOtable(){
        preference = new SystemPreference();
        preference.setKey("user.pic.root.folder");
        preference.setValue("someValue");
        preference.setDescription("someDescription");

        service.setSystemPreference(preference);

        assertThat(commonPreferences.getUserPicRootFolder()).isEqualTo("someValue");
    }

    @Test
    public void ifValueIsEmptyThenExceptionThrown() {
        preference = new SystemPreference();
        preference.setKey("user.pic.root.folder");
        preference.setDescription("someDescription");

        service.setSystemPreference(preference);
        Exception exception = assertThrows(UserPicRootFolderNotFoundException.class, () -> {
            commonPreferences.getUserPicRootFolder();
        });

        String expectedMessage = "User picture folder nod defined in SYSTEM_PREFERENCE";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
