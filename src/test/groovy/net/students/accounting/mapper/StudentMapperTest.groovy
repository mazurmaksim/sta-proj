package net.students.accounting.mapper

import net.students.accounting.dao.StudentTestHelper
import spock.lang.Specification

class StudentMapperTest extends Specification {
    
    def "Fill mapper from student entity" () {
        given:
        StudentTestHelper student = new StudentTestHelper()
        StudentDataMapper mapper = new StudentDataMapper(student.createStudent())
        when:
        def result = mapper.studentMapper()
        then:
        result.get("Name") == "Maks"
        result.get("Last Name") == "Mazur"
        result.get("Middle Name") == "Aleksandrovich"
        result.get("Group") == "B-46"
        result.get("Inn") == "1452652541"
        result.get("Grant") == 500.3
        result.get("Phone Number") == "+380956563258"
    }
    
}
