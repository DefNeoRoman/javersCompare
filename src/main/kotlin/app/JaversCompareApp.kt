package app


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration




@SpringBootApplication
@Configuration
@EnableAutoConfiguration

@ComponentScan("app.*")
@EntityScan
open class EnversCompareApp



fun main(args: Array<String>) {
    SpringApplication.run(EnversCompareApp::class.java, *args)
}