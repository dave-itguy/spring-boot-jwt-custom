package systems.abacus.springbootjwtcustom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootJwtCustomApplication

fun main(args: Array<String>) {
    runApplication<SpringBootJwtCustomApplication>(*args)
}
