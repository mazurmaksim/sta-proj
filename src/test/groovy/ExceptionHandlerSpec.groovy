import net.students.accounting.controller.MainController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
        value = "WebEnvironment.MOCK"
        )
@AutoConfigureMockMvc
class ExceptionHandlerSpec extends Specification {

    @Autowired
    MockMvc mvc

    def "Must to throw user not found exception" () {
        expect: "Status is 400 and the response is 'Group not found'"
        mvc.perform(get("/students/someGroupName"))
        .andExpect(status().isBadRequest())
        .andReturn()
        .response
        .contentAsString == "Group not found"
    }
}
