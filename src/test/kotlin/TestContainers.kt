
import app.JaversCompareApp
import app.dao.Person
import app.dao.PersonRepository
import org.junit.ClassRule
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.testcontainers.containers.PostgreSQLContainer


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = [JaversCompareApp::class])
@ContextConfiguration(initializers = [TestContainers.Initializer::class])
class TestContainers {

    companion object{
        @ClassRule
        val postgreSQLContainer: PostgreSQLContainer<*> = PostgreSQLContainer<Nothing>("postgres:11.1")
            .withDatabaseName("integration-tests-db")

    }

    internal class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
            postgreSQLContainer.withUsername("sa")
            postgreSQLContainer.withPassword("sa")
            TestPropertyValues.of(
                "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.environment)
        }
    }
    @Autowired
    private lateinit var repository: PersonRepository

    @Test
    fun testRepo() {
        repository.save(Person(age= 67,name = "dfdf"))
    }
}