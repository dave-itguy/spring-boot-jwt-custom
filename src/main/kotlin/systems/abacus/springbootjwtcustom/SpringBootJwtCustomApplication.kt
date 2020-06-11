package systems.abacus.springbootjwtcustom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import systems.abacus.springbootjwtcustom.config.JwtConfig

@SpringBootApplication
@EnableConfigurationProperties(JwtConfig::class)
class SpringBootJwtCustomApplication

fun main(args: Array<String>) {
    runApplication<SpringBootJwtCustomApplication>(*args)
}