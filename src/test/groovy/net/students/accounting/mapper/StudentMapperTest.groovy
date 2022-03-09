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
        result.get("2")[0].toString() == "Maks"
        result.get("2")[1].toString() == "Mazur"
        result.get("2")[2].toString() == "Aleksandrovich"
        result.get("2")[3].toString() == "B-46"
        result.get("2")[4].toString() == "+380956563258"
        result.get("2")[5].toString() == "1452652541"
        result.get("2")[6] == 895.7d
        result.get("2")[7] == 918.7d
        result.get("2")[8] == 1000.7d
        result.get("2")[9] == 1010.7d
        result.get("2")[10] == 1010.7d
        result.get("2")[11] == 900.7d
    }
}
