
import app.JaversCompareApp
import app.dao.Person
import app.dao.PersonRepository
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = [JaversCompareApp::class])
class TestContainers {

    @Autowired
    private lateinit var repository: PersonRepository

    @Test
    fun testRepo() {
        repository.save(Person(age= 67,name = "dfdf"))
    }
}