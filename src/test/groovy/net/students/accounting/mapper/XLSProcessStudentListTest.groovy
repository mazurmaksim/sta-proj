package net.students.accounting.mapper

import net.students.accounting.dao.StudentTestHelper
import net.students.accounting.entity.Student
import net.students.accounting.processor.XlSProcess
import org.apache.commons.io.FileUtils
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class XLSProcessStudentListTest extends Specification {


    @Rule
    public TemporaryFolder folder= new TemporaryFolder();
    StudentTestHelper helper = new StudentTestHelper()
    List<Student> stList = new ArrayList<>()

    def setup() {
        stList = helper.createStudentList()
    }

    def "Have to get a byteArray[] with XLS data from one student data" () {
        given : "selected student from UI"
        StudentListDataMapper mapper = new StudentListDataMapper(stList)
        Map<String, Object[]> map = mapper.studentMapper()
        XlSProcess xlSProcess = new XlSProcess();
        when:
        def result= xlSProcess.process(map)
        then:
        result != null
    }

    def "Have to write XLS file with one student data to destination no exeption thrown" () {
        given : "selected student from UI"
        StudentListDataMapper mapper = new StudentListDataMapper(stList)
        Map<String, Object[]> map = mapper.studentMapper()
        XlSProcess xlSProcess = new XlSProcess()
        when:
        xlSProcess.process(map)
        xlSProcess.saveXls("src/test/resources/xls/student_list.xls")
        then: "When write file should not be exceptions"
        noExceptionThrown()
    }
}
